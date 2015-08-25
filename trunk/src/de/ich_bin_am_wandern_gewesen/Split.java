/**
 * 
 */
package de.ich_bin_am_wandern_gewesen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import de.ich_bin_am_wandern_gewesen.file.DoSplit;
import ml.options.OptionSet;
import ml.options.Options;
import ml.options.Options.Multiplicity;
import ml.options.Options.Separator;

/**
 * @author jaloma
 * 
 */
public class Split {

	private static final String appName = "Split";
	private static final String appVersion = "0.1";
	public static boolean verbose = false;

	private Options opt;
	private int splitSize;

	private boolean initOptions(String[] args) {
		opt = new Options(args, 1);
		opt.getSet().addOption("b", Separator.BLANK, Multiplicity.ONCE);
		opt.getSet().addOption("v", Multiplicity.ZERO_OR_ONE);
		boolean result = opt.check();
		if (!result) {
			System.out.println(opt.getCheckErrors());
		}
		return result;
	}

	public Split() {
		splitSize = 2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Split split = new Split();
		if (split.initOptions(args)) {
			split.run();
		} else {
			split.usage();
		}
	}

	public void run() {
		OptionSet set = opt.getSet();
		if (set == null) {
			usage();
			return;
		}
		Split.verbose = set.isSet("v");
		String  sValue = set.getOption("b").getResultValue(0);
		Integer iValue = Integer.parseInt(sValue);
		this.splitSize = iValue.intValue();
		DoSplit split = new DoSplit(1024 * 1000 * this.splitSize);// (kb *
																	// 1000 *
		// x = xMb)
		for (String s : set.getData()) {
			if (Split.verbose) {
				System.out.println("Data: " + s);
			}
			File f = new File(s);
			if (f.exists()) {
				try {
					if (Split.verbose) {
						System.out.println("Split: "+f.getName());
					}
					split.doit(f);
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				}
			}
		}
		if (Split.verbose) {
			System.out.println("Done.");
		}
	}

	public void usage() {
		System.out.println(Split.appName + " (v " + Split.appVersion
				+ ") <Usage>:");
		System.out.println(Split.appName + " [-b <splitsize>] File");
		System.out
		.println("-b <splitsize>    : Größe der einzelnen Dateien (Default 2Mb).");
		System.out.println("-v                : Verbose");
	}

	/**
	 * @return the verbose
	 */
	public static final boolean isVerbose() {
		return verbose;
	}

	/**
	 * @param verbose the verbose to set
	 */
	public static final void setVerbose(boolean verbose) {
		Split.verbose = verbose;
	}

	/**
	 * @return the splitSize
	 */
	public final int getSplitSize() {
		return splitSize;
	}

	/**
	 * @param splitSize the splitSize to set
	 */
	public final void setSplitSize(int splitSize) {
		this.splitSize = splitSize;
	}
}
