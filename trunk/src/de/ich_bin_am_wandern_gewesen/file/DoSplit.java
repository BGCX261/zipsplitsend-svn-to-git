/**
 *
 */
package de.ich_bin_am_wandern_gewesen.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import de.ich_bin_am_wandern_gewesen.helper.Application;

/**
 * @author jaloma
 *
 */
public class DoSplit {
	int len = 1024 * 1000 * 1; // (= 1Mb)

	ArrayList<File> splitFiles;

	/**
	 *
	 */
	public DoSplit() {
	}

	/**
	 * @return the len
	 */
	public final int getLen() {
		return len;
	}

	/**
	 * @param len
	 *            the len to set
	 */
	public final void setLen(int len) {
		this.len = len;
	}

	/**
	 * @param len
	 */
	public DoSplit(int len) {
		this.len = len;
		this.splitFiles = new ArrayList<File>();
	}

	private int copy(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[this.len];

		int read = in.read(buffer);
		out.write(buffer, 0, read);
		return read;
	}

	public void doit(File zipFile) throws FileNotFoundException, IOException {
		System.out.println(this.len);
		if (0 == this.len) {
			this.splitFiles.add(zipFile);
			return;
		}
		FileInputStream fis = new FileInputStream(zipFile);
		String baseDir = zipFile.getParent();
		int cc = 1;
		String baseDest = zipFile.getName().replace('.', '_') + "_";
		while (true) {
			String dest = baseDest + cc;
			File destFile = new File(baseDir, dest);
			if (Application.verbose) {
				System.out.println("Create " + destFile);
			}
			FileOutputStream fos = new FileOutputStream(destFile);
			int done = this.copy(fis, fos);
			fos.close();
			splitFiles.add(destFile);
			cc++;
			if (done != len) {
				break;
			}
		}
		fis.close();
	}

	public String buildCopyString(String destFileName) {
		String fString = "copy /b ";
		Iterator<File> it = splitFiles.iterator();
		while (it.hasNext()) {
			String div = "";
			File f = it.next();
			if (it.hasNext()) {
				div = "+";
			}
			fString += f.getName() + div;
		}
		fString += " " + destFileName;
		return fString;
	}

	/**
	 * @return the splitFiles
	 */
	public final ArrayList<File> getSplitFiles() {
		return splitFiles;
	}
}
