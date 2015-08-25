/**
 * 
 */
package de.dokutransdata.ant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

import de.ich_bin_am_wandern_gewesen.file.DoSplit;

/**
 * @author jaloma
 * 
 */
public class SplitTask extends Task {
	public static final String RCS_ID = "Version @(#) $Revision: 1.8 $";

	int splitSize;

	private ArrayList<FileSet> files = new ArrayList<FileSet>();

	public void add(FileSet f) {
		files.add(f);
	}

	public List<FileSet> getFiles() {
		return files;
	}

	/**
	 * 
	 */
	public SplitTask() {
		splitSize = 0;
	}

	/**
	 * @return the splitSize
	 */
	protected final int getSplitSize() {
		return splitSize;
	}

	/**
	 * @param splitSize
	 *            the splitSize to set
	 */
	protected final void setSplitSize(int splitSize) {
		this.splitSize = splitSize;
	}

	public final void execute() throws BuildException {
		DoSplit split = new DoSplit(this.splitSize);
		for (int i = 0; i < files.size(); i++) {
			FileSet fs = (FileSet) files.get(i);
			String[] fnames = fs.toString().split(";");
			File localDir = fs.getDir(fs.getProject());
			for (int k = 0; k < fnames.length; k++) {
				if (fnames[k] == null) {
					continue;
				}
				String fname = localDir + File.separator + fnames[k];
				File f = new File(fname);
				try {
					split.doit(f);
				} catch (FileNotFoundException e) {
					throw new BuildException(e.getLocalizedMessage());
				} catch (IOException e) {
					throw new BuildException(e.getLocalizedMessage());
				}
			}
		}
	}
}
