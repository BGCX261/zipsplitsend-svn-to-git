/**
 *
 */
package de.ich_bin_am_wandern_gewesen.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import de.ich_bin_am_wandern_gewesen.ant.DoZip;
import de.ich_bin_am_wandern_gewesen.file.DoSplit;
import de.ich_bin_am_wandern_gewesen.mail.DoMail;

/**
 * @author jaloma
 *
 */
public class Application {

	public static final String RCS_ID = "Version @(#) $id: $";
	public static final long serialVersionUID = 2765;
	public static Properties props = new Properties();
	public static boolean verbose = false;
	public static final String appName = "ZSM";
	public static final String appVersion = "0.3a";

	public Application() {
		// Application.props = new Properties();
		Application.props.setProperty("debug", "treu");
		Application.props.setProperty("subject", "Wanderung");
	}

	protected String strSourceDir = ".";
	protected String strBaseDir = null;
	public String strTempZipFileName = "bilder.zip";
	protected File fileTempZipFile = null;
	protected File SourceDir = null;
	protected File toZipDir = null;
	protected boolean zipDirectory = false;

	public void setZipDir(File newValue) {
		this.toZipDir = newValue;
	}

	public static void setDestFile(String newValue) {
		Application.props.setProperty("destfile", newValue);
	}

	public static String getDestFile() {
		return Application.props.getProperty("destfile", "bilder.zip");
	}

	public static void setSSL(String newValue) {
		Application.props.setProperty("usessl", newValue);
	}

	public static void setSSL(boolean newValue) {
		if (newValue) {
			Application.setSSL("true");
		} else {
			Application.setSSL("false");
		}
	}

	public static boolean getSSL() {
		return Application.props.getProperty("usessl", "false")
				.equalsIgnoreCase("true");
	}

	public static void setMailPort(String newValue) {
		Application.props.setProperty("mailport", newValue);
	}

	public static boolean isSetMailPort() {
		return Application.props.containsKey("mailport");
	}

	public static int getMailPort() {
		String sValue = Application.props.getProperty("mailport", "25");
		if (sValue.length() == 0) {
			sValue = "0";
		}
		Integer iValue = Integer.parseInt(sValue);
		return iValue.intValue();
	}

	public static void setFromAddress(String newValue) {
		Application.props.setProperty("from", newValue);
	}

	public static String getFromAddress() {
		return Application.props.getProperty("from");
	}

	public static void setFromName(String newValue) {
		Application.props.setProperty("fromname", newValue);
	}

	public static String getFromName() {
		return Application.props.getProperty("fromname");
	}

	public static void setMailHost(String newValue) {
		Application.props.setProperty("mailhost", newValue);
	}

	public static String getMailHost() {
		return Application.props.getProperty("mailhost");
	}

	public static boolean isSetPassword() {
		return Application.props.containsKey("password");
	}

	public static void setPassword(String newValue) {
		Application.props.setProperty("password", newValue);
	}

	public static String getPassword() {
		return Application.props.getProperty("password");
	}

	public static boolean isSetUser() {
		return Application.props.containsKey("user");
	}

	public static void setUser(String newValue) {
		Application.props.setProperty("user", newValue);
	}

	public static String getUser() {
		return Application.props.getProperty("user");
	}

	public static void setToAddress(String newValue) {
		Application.props.setProperty("to", newValue);
	}

	public static String getToAddress() {
		return Application.props.getProperty("to");
	}

	public static void setSubject(String newValue) {
		Application.props.setProperty("subject", newValue);
	}

	public static String getSubject() {
		return Application.props.getProperty("subject", "Wanderungen");
	}

	public static void setSplitSize(String newValue) {
		Application.props.setProperty("splitsize", newValue);
	}

	public static int getSplitSize() {
		String sValue = Application.props.getProperty("splitsize", "2");
		if (sValue.length() == 0) {
			sValue = "2";
		}
		Integer iValue = Integer.parseInt(sValue);
		return iValue.intValue();
	}

	public static void setMessageText(String newValue) {
		Application.props.setProperty("messagetext", newValue);
	}

	public static String getMessageText() {
		return Application.props
				.getProperty("messagetext",
						"Hallo Jürgen,\n\rhier sind deine gewünschten Bilder.\n\rGruss Arny\n\r");
	}

	public static void setDebugMode(String newValue) {
		Application.props.setProperty("debug", newValue);
	}

	public static boolean getDebugMode() {
		return Application.props.getProperty("debug").equalsIgnoreCase("true");
	}

	public static void saveOptions() throws IOException {
		String comments = "Versenden von Bildern als ZIP";
		FileOutputStream fos = new FileOutputStream("zsm.ini");
		String oldPassword = Application.getPassword();
		Application.setPassword("");
		props.store(fos, comments);
		fos.close();
		Application.setPassword(oldPassword);
	}

	public static void loadOptions() throws FileNotFoundException, IOException {
		String propertyFile = "zsm.ini";
		File pFile = new File(propertyFile);
		if (pFile.exists()) {
			FileInputStream fis = new FileInputStream(pFile);
			props.load(fis);
			fis.close();
		}
	}

	public void setTempZipFile(File newValue) {
		this.fileTempZipFile = newValue;
	}

	public void setZipDirectory(boolean newValue) {
		this.zipDirectory = newValue;
	}

	private boolean doZip(ArrayList<File> files) {
		// {{{ Ab hier "einpacken"
		DoZip zip = new DoZip();
		if (this.zipDirectory) {
			zip.doit(this.toZipDir, this.fileTempZipFile);
		} else {
			zip.doit(files, this.fileTempZipFile);
		}
		if (this.fileTempZipFile == null) {
			return false;
		}
		// }}}
		return true;
	}

	private DoSplit split = null;

	private boolean doSplit(int splitSize) throws FileNotFoundException,
			IOException {
		// {{{ Ab hier "splitten"
		this.split = new DoSplit(1024 * 1000 * splitSize);// (kb * 1000 *
		// x = xMb)
		// Wenn splitSize==0 ist wird das ZipFile so eingetragen.
		this.split.doit(this.fileTempZipFile);
		// }}}
		return true;
	}

	File joinFile = null;

	private boolean doMail(String destFileName) {
		String copyText = null;
		if (this.split.getLen() > 0) {
			this.joinFile = new File(this.strBaseDir, "join.jal");
			copyText = this.split.buildCopyString(destFileName);
		}
		// {{{ Ab hier "mailen"
		DoMail mail = new DoMail();
		String destFile = null;
		if (this.joinFile != null) {
			destFile = joinFile.getAbsolutePath();
		}
		mail.doit(destFile, copyText, props
				.getProperty("subject"), this.split.getSplitFiles());
		// }}}
		return true;
	}

	public boolean doit(ArrayList<File> files, int splitSize,
			String destFileName) throws FileNotFoundException, IOException {
		if (this.doZip(files) == false) {
			return false;
		}
		// In split.doit() wird entschieden ob wirklich gesplittet werden soll
		this.doSplit(splitSize);

		if (this.doMail(destFileName)) {
			this.doDelete();
		}
		return true;
	}

	private void doDelete() {
		ArrayList<File> splitFiles = this.split.getSplitFiles();
		Iterator<File> it = splitFiles.iterator();
		while (it.hasNext()) {
			File f = it.next();
			this.int_doDelete(f);
		}
		if (this.joinFile != null) {
			this.int_doDelete(this.joinFile);
		}
		if (this.fileTempZipFile != null) {
			this.int_doDelete(this.fileTempZipFile);
		}
	}

	private void int_doDelete(File aFile) {
		if (Application.verbose) {
			System.out.print("Delete " + aFile.getAbsolutePath());
		}
		if (aFile.exists()) {
		boolean ok = aFile.delete();
		if (Application.verbose) {
			if (ok) {
				System.out.println(" done!");
			} else {
				System.out.println(" fail!");
			}
		}
		} else {
			System.out.println(" is away!");
		}
	}
}
