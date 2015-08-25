/**
 * 
 */
package de.ich_bin_am_wandern_gewesen.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

/**
 * @author jaloma
 * 
 */
public class DoZip {
	public void doit(File sourceDir, File destFile) {
		Project project = new Project();
		project.setBasedir(sourceDir.getParentFile().getAbsolutePath());
		project.setName("ZipSplitSendImages");

		Zip z = new Zip();

		z.setBasedir(sourceDir);
		z.setUpdate(true);
		z.setDestFile(destFile);
		z.setProject(project);
		z.setLevel(9);

		z.execute();

	}

	public void doit(ArrayList<File> files, File destFile) {
		Project project = new Project();
		//project.setBasedir(".");
		project.setName("ZipSplitSendImages");

		Zip z = new Zip();
		Iterator<File> it = files.iterator();
		boolean done = false;
		while (it.hasNext()) {
			File file = it.next();
			if (!file.exists()) {
				continue;
			}
			FileSet set = new FileSet();
			set.setFile(file);
			project.setBaseDir(file.getParentFile());
			z.addFileset(set);
			done = true;
		}
		if (!done) {
			System.err.println("Kann nicht zippen...");
			return;
		}
		z.setDestFile(destFile);
		z.setProject(project);
		z.setLevel(9);

		z.execute();
	}
}
