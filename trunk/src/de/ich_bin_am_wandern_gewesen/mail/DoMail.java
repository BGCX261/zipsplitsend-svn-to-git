/**
 *
 */
package de.ich_bin_am_wandern_gewesen.mail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Echo;
import org.apache.tools.ant.taskdefs.email.EmailAddress;
import org.apache.tools.ant.taskdefs.email.EmailTask;

import de.ich_bin_am_wandern_gewesen.helper.Application;

/**
 * @author jaloma
 *
 */
public class DoMail {

	public void doit(String batchFileName, String copyText, String subject,
			ArrayList<File> splitFiles) {
		Project project = new Project();

		project.setBasedir(".");
		project.setName("SendImages");
		EmailTask m = new EmailTask();
		m.setProject(project);

		m.setMessage(Application.getMessageText());
		String mailhost = Application.getMailHost();
		if (Application.verbose) {
			System.out.println("Set mailhost: " + mailhost);
		}
		m.setMailhost(mailhost);
		m.setSSL(Application.getSSL());

		if (Application.isSetMailPort()) {
			m.setMailport(Application.getMailPort());
		}
		if (Application.isSetPassword()) {
			String password = Application.getPassword();
			if (Application.verbose) {
				System.out.println("Set password: -" + password + "+");
			}
			m.setPassword(password);
			if (Application.isSetUser()) {
				String user = Application.getUser();
				if (Application.verbose) {
					System.out.println("Set user: " + user);
				}
				m.setUser(user);
			} else {
				throw new BuildException(
						"Wenn password gesetzt ist, muss auch der user gesetzt sein.");
			}
		}
		String from = Application.getFromAddress();
		if (Application.verbose) {
			System.out.println("Set from: " + from);
		}
		String fromName = Application.getFromName();
		if (Application.verbose) {
			System.out.println("Set from name: " + fromName);
		}
		m.setFrom(fromName + " <" + from + ">");

		String to[] = Application.getToAddress().split(",");
		for (int i = 0; i < to.length; i++) {
			EmailAddress toAddress = new EmailAddress();

			toAddress.setAddress(to[i]);
			if (Application.getDebugMode() || Application.verbose) {
				System.out.println("Set to: " + toAddress);
			}
			m.addTo(toAddress);
		}

		// Wenn nicht gesplittet wurde, muss auch die Join-Datei nicht dabei sein.
		if (batchFileName != null) {
		sendBatch(batchFileName, copyText, subject, m);
		}
		sendFiles(splitFiles, subject, m);
	}

	private void sendFiles(ArrayList<File> splitFiles, String mainSubject,
			EmailTask mail) {
		Iterator<File> it = splitFiles.iterator();
		int len = splitFiles.size();
		int cc = 1;
		while (it.hasNext()) {
			try {
				File f = it.next();
				EmailTask lMail = (EmailTask) mail.clone();
				lMail
						.setSubject(mainSubject + " (File " + cc + "/" + len
								+ ")");
				//Wegen Leerzeichen im Pfad, muss ich hier das Basisverzeichnis umsetzen, ansonsten kollabiert Ant...
				lMail.getProject().setBaseDir(f.getParentFile());
				String canonPath = f.getName();
				if (canonPath.indexOf(" ") > 0) {
					lMail.setFiles('"' + canonPath + '"');
				} else {
					lMail.setFiles(canonPath);
				}
				if (Application.verbose) {
					System.out.println("Send: " + mainSubject + " (File " + cc
							+ "/" + len + ")");
				}
				if (!Application.getDebugMode()) {
					lMail.execute();
				}
				cc++;
			} catch (CloneNotSupportedException c) {
				System.err.println(c.getLocalizedMessage());
			}
		}
	}

	private void sendBatch(String copyBatch, String copyText,
			String mainSubject, EmailTask mail) {
		Echo e = new Echo();
		if (Application.verbose) {
			System.out.println("Set batch: " + copyBatch);
			System.out.println("Set  text: " + copyText);
		}
		File f = new File(copyBatch);
		e.setFile(f);
		e.setMessage(copyText);
		e.execute();
		if (!f.exists()) {
			throw new BuildException("Batchdatei " + copyBatch
					+ " konnte nicht erstellt werden!");
		}
		try {
			EmailTask lMail = (EmailTask) mail.clone();
			lMail.setSubject(mainSubject + " (Start)");
			lMail.setFiles(f.getCanonicalPath());
			if (Application.verbose) {
				System.out.println("Send: Batch-Mail");
			}
			if (!Application.getDebugMode()) {
				lMail.execute();
			}
		} catch (IOException ee) {
			System.err.println(ee.getLocalizedMessage());
		} catch (CloneNotSupportedException c) {
			System.err.println(c.getLocalizedMessage());
		}
	}
}
