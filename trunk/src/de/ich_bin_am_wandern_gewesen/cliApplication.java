package de.ich_bin_am_wandern_gewesen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import de.ich_bin_am_wandern_gewesen.helper.Application;
import ml.options.OptionData;
import ml.options.OptionSet;
import ml.options.Options;
import ml.options.Options.Multiplicity;
import ml.options.Options.Separator;

public class cliApplication extends Application {

	private static final String appVersion = "0.2";

	private Options opt;

	private boolean initOptions(String[] args) {
		opt = new Options(args, 1, 1000);// _OR_MORE);//0, 99);// , 0, 99);
		opt.getSet().addOption("d", Separator.BLANK, Multiplicity.ONCE);
		opt.getSet().addOption("s", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("f", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("n", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("h", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("p", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("o", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("l", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("u", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("t", Separator.BLANK, Multiplicity.ONCE_OR_MORE);
		opt.getSet().addOption("P", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("g", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("b", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
		opt.getSet().addOption("v", Multiplicity.ZERO_OR_ONE);
		boolean result = opt.check();
		if (!result) {
			System.out.println(opt.getCheckErrors());
		}
		return result;
	}

	public void usage() {
		System.out.println(opt);

		System.out.println(cliApplication.appName + " (v "
				+ cliApplication.appVersion + ") <Usage>:");
		System.out
				.println(cliApplication.appName
						+ " -d <destfile> [-f <from>] [-h <mailhost>] [-p <password>] [-t <to>]+ [-P <propertyfile>] [-g <splitsize>] [-b <betrifft>] Directory|File File File");
		System.out.println("-d <destfile>     : Destinationfile");
		System.out.println("-s <sourcedir>    : Directory of Pictures");
		System.out.println("-f <from>         : From-Address");
		System.out.println("-n <fromname>     : FromName-Address");
		System.out.println("-h <mailhost>     : Mailhost (smtp.web.de)");
		System.out.println("-o <port>         : Mailport (25)");
		System.out.println("-l                : Use SSL");
		System.out.println("-p <password>     : Password to Mail");
		System.out.println("-u <username>     : Username to login");
		System.out.println("-t <to>           : To-Address (multiple)");
		System.out
				.println("-P <propertyfile> : Property-Datei mit Informationen zu MailHost etc.");
		System.out
				.println("-g <splitsize>    : Größe der einzelnen Dateien (Default 2Mb).");
		System.out.println("-b <betrifft>     : Subject");
		System.out.println("-v                : Verbose");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cliApplication app = new cliApplication();
		if (app.initOptions(args)) {
			try {
				app.run(args);
			} catch (Exception e) {
				// System.err.println(e.getLocalizedMessage());
				e.printStackTrace();
			}
		} else {
			app.usage();
		}
	}

	public void run(String[] args) throws Exception {
		OptionSet set = opt.getSet();
		if (set == null) {
			usage();
			return;
		}
		this.strTempZipFileName = "bilder.zip";

		this.strBaseDir = ".";

		// **Erst** die Property-Datei einlesen
		if (set.isSet("P")) {
			String propertyFile = set.getOption("P").getResultValue(0);
			try {
				File pFile = new File(propertyFile);
				if (pFile.exists()) {
					FileInputStream fis = new FileInputStream(pFile);
					props.load(fis);
					fis.close();
				}
			} catch (FileNotFoundException e) {

			} catch (IOException e) {

			}
		}

		// Jetzt koennen die Argumente ausgewertet werden!
		Application.verbose = set.isSet("v");
		if (set.isSet("l")) {
			setSSL("true");
		}
		if (set.isSet("s")) {
			this.strSourceDir = set.getOption("s").getResultValue(0);
			this.SourceDir = new File(this.strSourceDir);
		}
		if (set.isSet("o")) {
			Application.setMailPort(set.getOption("o").getResultValue(0));
		}

		String destFileName = set.getOption("d").getResultValue(0);
		Application.setDestFile(destFileName);
		if (set.isSet("f")) {
			Application.setFromAddress(set.getOption("f").getResultValue(0));
			if (set.isSet("n")) {
				Application.setFromName(set.getOption("n").getResultValue(0));
			} else {
				throw new Exception("Bei -f muss auch -n gesetzt sein!");
			}
		}
		if (set.isSet("h")) {
			Application.setMailHost(set.getOption("h").getResultValue(0));
		}
		if (set.isSet("p")) {
			Application.setPassword(set.getOption("p").getResultValue(0));
			if (set.isSet("u")) {
				Application.setUser(set.getOption("u").getResultValue(0));
			} else {
				throw new Exception("Bei -p muss auch -u gesetzt sein!");
			}
		}

		OptionData od = set.getOption("t");
		String toAddresses = "";
		String div = "";
		for (int i = 0; i < od.getResultCount(); i++) {
			toAddresses += div + od.getResultValue(i);
			div = ",";
		}
		Application.setToAddress(toAddresses);

		if (set.isSet("b")) {
			Application.setSubject(set.getOption("b").getResultValue(0));
		}

		int splitSize = 2;
		if (set.isSet("g")) {
			Application.setSplitSize(set.getOption("g").getResultValue(0));
		}
		splitSize = Application.getSplitSize();

		ArrayList<File> files = this.sammelFiles(set);

		this.doit(files, splitSize, destFileName);

		System.out.println("Done.");
	}

	protected ArrayList<File> sammelFiles(OptionSet set) {
		ArrayList<File> files = new ArrayList<File>();
		if (this.strSourceDir.equalsIgnoreCase(".")) {
			for (String s : set.getData()) {
				if (Application.verbose) {
					System.out.println("Data: " + s);
				}
				File f = new File(s);
				if (f.exists()) {
					this.strBaseDir = f.getParent();
					if (f.isDirectory()) {
						this.fileTempZipFile = new File(this.strBaseDir,
								this.strTempZipFileName);
						this.zipDirectory = true;
						this.toZipDir = f;
						// zip.doit(f, DestFile);
						break;
					} else {
						files.add(f);
					}
				}
			}
			if (files.size() > 0) {
				this.fileTempZipFile = new File(this.strBaseDir,
						this.strTempZipFileName);
				this.zipDirectory = false;
			}
		} else {
			this.fileTempZipFile = new File(this.SourceDir.getParent(),
					this.strTempZipFileName);
			this.toZipDir = this.SourceDir;
		}
		return files;
	}

}
