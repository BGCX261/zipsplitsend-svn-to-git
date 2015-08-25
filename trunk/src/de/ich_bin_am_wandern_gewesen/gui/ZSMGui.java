/**
 *
 */
package de.ich_bin_am_wandern_gewesen.gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;

import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.filechooser.FileFilter;

import de.ich_bin_am_wandern_gewesen.helper.Application;

/**
 * @author jaloma
 *
 */

public class ZSMGui {
	public static final String appName = "ZSMGui";
	public static final String appVersion = "0.3a";

	private JFrame jFrame = null; // @jve:decl-index=0:visual-constraint="10,-48"

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu fileMenu = null;

	private JMenu actionMenu = null;

	private JMenu helpMenu = null;

	private JMenuItem exitMenuItem = null;

	private JMenuItem aboutMenuItem = null;

	private JMenuItem saveMenuItem = null;

	private JDialog aboutDialog = null; // @jve:decl-index=0:visual-constraint="363,-5"

	private JPanel aboutContentPane = null;

	private JTabbedPane jTabbedPane = null;

	private JPanel jPanel = null;

	private JLabel jLabel = null;

	private JTextField tfToAddress = null;

	private JLabel jLabel1 = null;

	private JTextField tfDestFile = null;

	private JLabel jLabel2 = null;

	private JEditorPane epMessageText = null;

	private JMenuItem goDirectoryMenuItem = null;

	private JMenuItem goFilesMenuItem = null;

	private JPanel jPanel1 = null;

	private JLabel jLabel3 = null;

	private JTextField tfVonAdresse = null;

	private JLabel jLabel4 = null;

	private JTextField tfVonName = null;

	private JLabel jLabel5 = null;

	private JTextField tfBetrifft = null;

	private JLabel jLabel6 = null;

	private JTextField tfMailHost = null;

	private JLabel jLabel7 = null;

	private JTextField tfMailPort = null;

	private JLabel jLabel8 = null;

	private JTextField pfPassword = null;

	private JLabel jLabel9 = null;

	private JTextField tfFileSize = null;

	private JLabel SSL = null;

	private JCheckBox cbSSL = null;

	private JLabel jLabel10 = null;

	private JTextField tfUser = null;

	private JLabel jLabel13 = null;

	/**
	 * This method initializes jTabbedPane
	 *
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Hauptseite", null, getJPanel(), null);
			jTabbedPane.addTab("MailerOptionen", null, getJPanel1(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.BOTH;
			gridBagConstraints21.gridy = 2;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.gridx = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridy = 2;
			jLabel5 = new JLabel();
			jLabel5.setText("Betrifft");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 3;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints4.gridy = 3;
			jLabel2 = new JLabel();
			jLabel2.setText("Nachricht");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridheight = 1;
			gridBagConstraints3.gridwidth = 100;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("Zieldatei");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("An (EMail)");
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(getTfToAddress(), gridBagConstraints1);
			jPanel.add(jLabel1, gridBagConstraints2);
			jPanel.add(getTfDestFile(), gridBagConstraints3);
			jPanel.add(jLabel5, gridBagConstraints11);
			jPanel.add(getTfBetrifft(), gridBagConstraints21);
			jPanel.add(jLabel2, gridBagConstraints4);
			jPanel.add(getEpMessageText(), gridBagConstraints5);
		}
		return jPanel;
	}

	/**
	 * This method initializes tfToAddress
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfToAddress() {
		if (tfToAddress == null) {
			tfToAddress = new JTextField();
			tfToAddress.setText(Application.getToAddress());
			tfToAddress.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setToAddress(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfToAddress.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setToAddress(t.getText());
				}
			});
		}
		return tfToAddress;
	}

	/**
	 * This method initializes tfDestFile
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfDestFile() {
		if (tfDestFile == null) {
			tfDestFile = new JTextField();
			tfDestFile.setText(Application.getDestFile());
			tfDestFile.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setDestFile(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfDestFile.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setDestFile(t.getText());
				}
			});
		}
		return tfDestFile;
	}

	/**
	 * This method initializes epMessageText
	 *
	 * @return javax.swing.JEditorPane
	 */
	private JEditorPane getEpMessageText() {
		if (epMessageText == null) {
			epMessageText = new JEditorPane();
			epMessageText.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JEditorPane t = (JEditorPane) e.getSource();
					String newValue = t.getText();
					System.err.println(newValue);
					Application.setMessageText(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			epMessageText.setText(Application.getMessageText());
		}
		return epMessageText;
	}

	public String getMessageText() {
		String txt = "";
		if (epMessageText != null) {
			txt = epMessageText.getText();
		}
		return txt;
	}

	/**
	 * This method initializes goDirectoryMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getGoDirectoryMenuItem() {
		if (goDirectoryMenuItem == null) {
			goDirectoryMenuItem = new JMenuItem();
			goDirectoryMenuItem.setMnemonic('G');
			goDirectoryMenuItem.setText("Versende Verzeichnis");
			goDirectoryMenuItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_G, Event.CTRL_MASK, true));
			goDirectoryMenuItem.addActionListener(new goListener(this));
		}
		return goDirectoryMenuItem;
	}

	/**
	 * This method initializes goDirectoryMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getGoFilesMenuItem() {
		if (goFilesMenuItem == null) {
			goFilesMenuItem = new JMenuItem();
			goFilesMenuItem.setMnemonic('D');
			goFilesMenuItem.setText("Versende Dateien");
			goFilesMenuItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F, Event.CTRL_MASK, true));
			goFilesMenuItem.addActionListener(new goListener(this, true));
		}
		return goFilesMenuItem;
	}

	/**
	 * This method initializes jPanel1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.fill = GridBagConstraints.BOTH;
			gridBagConstraints23.gridy = 5;
			gridBagConstraints23.weightx = 1.0;
			gridBagConstraints23.gridx = 1;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 0;
			gridBagConstraints22.anchor = GridBagConstraints.WEST;
			gridBagConstraints22.gridy = 5;
			jLabel10 = new JLabel();
			jLabel10.setText("Benutzername");
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 1;
			gridBagConstraints20.gridy = 8;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 0;
			gridBagConstraints19.anchor = GridBagConstraints.WEST;
			gridBagConstraints19.gridy = 8;
			SSL = new JLabel();
			SSL.setText("SSL?");
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.fill = GridBagConstraints.BOTH;
			gridBagConstraints18.gridy = 6;
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.gridx = 1;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.anchor = GridBagConstraints.WEST;
			gridBagConstraints17.gridy = 6;
			jLabel9 = new JLabel();
			jLabel9.setText("Dateigröße");
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 4;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.gridx = 1;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 0;
			gridBagConstraints15.anchor = GridBagConstraints.WEST;
			gridBagConstraints15.gridy = 4;
			jLabel8 = new JLabel();
			jLabel8.setText("Passwort");
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.BOTH;
			gridBagConstraints14.gridy = 3;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.gridx = 1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.anchor = GridBagConstraints.WEST;
			gridBagConstraints13.gridy = 3;
			jLabel7 = new JLabel();
			jLabel7.setText("Port");
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridy = 2;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.anchor = GridBagConstraints.WEST;
			gridBagConstraints10.gridy = 2;
			jLabel6 = new JLabel();
			jLabel6.setText("Server (SMTP)");
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.BOTH;
			gridBagConstraints9.gridy = 1;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.gridy = 1;
			jLabel4 = new JLabel();
			jLabel4.setText("Ihr Name");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.gridy = 0;
			jLabel3 = new JLabel();
			jLabel3.setText("Von (EMail)");
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(jLabel3, gridBagConstraints6);
			jPanel1.add(getTfVonAdresse(), gridBagConstraints7);
			jPanel1.add(jLabel4, gridBagConstraints8);
			jPanel1.add(getTfVonName(), gridBagConstraints9);
			jPanel1.add(jLabel6, gridBagConstraints10);
			jPanel1.add(getTfMailHost(), gridBagConstraints12);
			jPanel1.add(jLabel7, gridBagConstraints13);
			jPanel1.add(getTfMailPort(), gridBagConstraints14);
			jPanel1.add(jLabel8, gridBagConstraints15);
			jPanel1.add(getPfPassword(), gridBagConstraints16);
			jPanel1.add(jLabel9, gridBagConstraints17);
			jPanel1.add(getTfFileSize(), gridBagConstraints18);
			jPanel1.add(SSL, gridBagConstraints19);
			jPanel1.add(getCbSSL(), gridBagConstraints20);
			jPanel1.add(jLabel10, gridBagConstraints22);
			jPanel1.add(getTfUser(), gridBagConstraints23);
		}
		return jPanel1;
	}

	/**
	 * This method initializes tfVonAdresse
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfVonAdresse() {
		if (tfVonAdresse == null) {
			tfVonAdresse = new JTextField();
			tfVonAdresse.setText(Application.getFromAddress());
			tfVonAdresse.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setFromAddress(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfVonAdresse.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setFromAddress(t.getText());
				}
			});
		}
		return tfVonAdresse;
	}

	/**
	 * This method initializes tfVonName
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfVonName() {
		if (tfVonName == null) {
			tfVonName = new JTextField();
			tfVonName.setText(Application.getFromName());
			tfVonName.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setFromName(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfVonName.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setFromName(t.getText());
				}
			});
		}
		return tfVonName;
	}

	/**
	 * This method initializes tfBetrifft
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfBetrifft() {
		if (tfBetrifft == null) {
			tfBetrifft = new JTextField();
			tfBetrifft.setText(Application.getSubject());
			tfBetrifft.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setSubject(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfBetrifft.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setSubject(t.getText());
				}
			});
		}
		return tfBetrifft;
	}

	/**
	 * This method initializes tfMailHost
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfMailHost() {
		if (tfMailHost == null) {
			tfMailHost = new JTextField();
			tfMailHost.setText(Application.getMailHost());
			tfMailHost.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setMailHost(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfMailHost.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setMailHost(t.getText());
				}
			});
		}
		return tfMailHost;
	}

	/**
	 * This method initializes tfMailPort
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfMailPort() {
		if (tfMailPort == null) {
			tfMailPort = new JTextField();
			tfMailPort.setText("" + Application.getMailPort());
			tfMailPort.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setMailPort(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfMailPort.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setMailPort(t.getText());
				}
			});
		}
		return tfMailPort;
	}

	/**
	 * This method initializes pfPassword
	 *
	 * @return javax.swing.JPasswordField
	 */
	private JTextField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setText(Application.getPassword());
			pfPassword.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setPassword(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			pfPassword.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField p = (JTextField) e.getSource();
					Application.setPassword(p.getText());
				}
			});
		}
		return pfPassword;
	}

	/**
	 * This method initializes tfFileSize
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfFileSize() {
		if (tfFileSize == null) {
			tfFileSize = new JTextField();
			tfFileSize.setText("" + Application.getSplitSize());
			tfFileSize.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setSplitSize(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfFileSize.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setSplitSize(t.getText());
				}
			});
		}
		return tfFileSize;
	}

	/**
	 * This method initializes cbSSL
	 *
	 * @return javax.swing.JCheckBox
	 */
	public static boolean useSSL = false;

	private JCheckBox getCbSSL() {
		if (cbSSL == null) {
			cbSSL = new JCheckBox();
			cbSSL.setEnabled(false);
			cbSSL.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					ZSMGui.useSSL = !ZSMGui.useSSL;
					Application.setSSL(ZSMGui.useSSL);
				}
			});
		}
		return cbSSL;
	}

	/**
	 * This method initializes tfUser
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfUser() {
		if (tfUser == null) {
			tfUser = new JTextField();
			tfUser.setText(Application.getUser());
			tfUser.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					JTextField t = (JTextField) e.getSource();
					String newValue = t.getText();
					Application.setUser(newValue);
				}

				public void focusGained(FocusEvent e) {

				}
			});
			tfUser.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					Application.setUser(t.getText());
				}
			});
		}
		return tfUser;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ZSMGui application = new ZSMGui();
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Application.loadOptions();
				} catch (FileNotFoundException e) {
					System.err.println(e.getLocalizedMessage());
				} catch (IOException e) {
					System.err.println(e.getLocalizedMessage());
				}
				application.getJFrame().setVisible(true);
			}
		});
	}

	/**
	 * This method initializes jFrame
	 *
	 * @return javax.swing.JFrame
	 */
	public JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(600, 250);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("ZipSplitMail");
			jFrame.pack();
			jFrame.setIconImage(new ImageIcon("iconZipSplitMail.gif")
					.getImage());
		}
		return jFrame;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ZSMGui.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar
	 *
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getActionMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("Datei");
			fileMenu.setMnemonic('D');
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getActionMenu() {
		if (actionMenu == null) {
			actionMenu = new JMenu();
			actionMenu.setText("Ausführen");
			actionMenu.setMnemonic('A');
			actionMenu.add(getGoDirectoryMenuItem());
			actionMenu.add(getGoFilesMenuItem());
		}
		return actionMenu;
	}

	/**
	 * This method initializes jMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Hilfe");
			helpMenu.setMnemonic('H');
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Ende");
			exitMenuItem.setMnemonic('E');
			exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
					Event.CTRL_MASK, true));

			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("Über");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog
	 *
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("Über");
			aboutDialog.setSize(new Dimension(177, 93));
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("<html>" + "<p align='center'><b>"
					+ ZSMGui.appName + "</b></p>"
					+ "<p align='center'>Version " + ZSMGui.appVersion + "</p>"
					+ "<p align='center'> jaloma.ac@googlemail.com </p>"
					+ "</html>");
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(jLabel13, BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes jMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Speichern");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
			saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Application.saveOptions();
					} catch (IOException ie) {

					}
				}
			});
		}
		return saveMenuItem;
	}
}

class goListener implements ActionListener {
	ZSMGui parent;
	boolean fileMode = false;

	public goListener(ZSMGui parent) {
		this.parent = parent;
		this.fileMode = false;
	}

	public goListener(ZSMGui parent, boolean fileMode) {
		this.parent = parent;
		this.fileMode = fileMode;
	}

	public void actionPerformed(ActionEvent e) {
		if (Application.getDestFile().length() == 0) {
			showMessage(
					false,
					"<html><p align='center'>Es ist kein Dateiname für die Zieldatei angegeben.</p></html>");
			return;
		} else if (Application.getFromAddress() == null
				|| Application.getFromAddress().length() == 0) {
			showMessage(false,
					"<html><p align='center'>Es ist keine Absendeadresse angegeben.</p></html>");
			return;
		} else if (Application.getMailHost() == null
				|| Application.getMailHost().length() == 0) {
			showMessage(false,
					"<html><p align='center'>Es ist kein MailHost angegeben.</p></html>");
			return;
		} else if (Application.getMailPort() == 0) {
			showMessage(false,
					"<html><p align='center'>Es ist kein MailPort angegeben.</p></html>");
			return;
		} else if (Application.getToAddress() == null
				|| Application.getToAddress().length() == 0) {
			showMessage(false,
					"<html><p align='center'>Es ist keine Zieladresse angegeben.</p></html>");
			return;
		} else if (Application.getUser() != null
				&& Application.getUser().length() > 0
				&& (Application.getPassword() == null || Application
						.getPassword().length() == 0)) {
			showMessage(
					false,
					"<html><p align='center'>Sorry, aber das Passwort muss eingegeben werden...</p></html>");
			return;
		} else if (Application.getPassword() != null
				&& Application.getPassword().length() > 0
				&& (Application.getUser() == null || Application.getUser()
						.length() == 0)) {
			showMessage(
					false,
					"<html><p align='center'>Sorry, aber der Benutzer muss eingegeben werden...</p></html>");
			return;
		}
		// create a file dialog
		JFileChooser chooser = new JFileChooser();
		if (fileMode) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setMultiSelectionEnabled(true);
			chooser.addChoosableFileFilter(new ImageFilter());
			chooser.setAcceptAllFileFilterUsed(false);
		} else {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		int returnVal = chooser.showOpenDialog(parent.getJFrame());
		ArrayList<File> files = new ArrayList<File>();
		Application app = new Application();

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File sFiles[] = null;
			String filename = null;
			File sFile = null;
			if (fileMode) {
				sFiles = chooser.getSelectedFiles();
				if (sFiles.length > 0) {
					sFile = sFiles[0];
					for (int i = 0; i < sFiles.length; i++) {
						files.add(sFiles[i]);
					}
				} else {
					filename = chooser.getSelectedFile().getName();
					sFile = new File(filename);
					files.add(sFile);
				}
			} else {
				filename = chooser.getSelectedFile().getName();
				sFile = new File(filename);
				files.add(sFile);
			}

			if (!sFile.exists()) {
				return;
			}
			app.setZipDirectory(false);
			if (sFile.isDirectory()) {
				app.setZipDirectory(true);
				app.setZipDir(sFile);
			}
			app.setTempZipFile(new File(sFile.getParent(),
					app.strTempZipFileName));
			Application.setMessageText(parent.getMessageText());

			// Application.setDebugMode("true");
			Application.verbose = true;

			boolean done = false;
			String errorText = "";
			try {
				done = app.doit(files, Application.getSplitSize(), Application
						.getDestFile());
			} catch (FileNotFoundException fe) {
				errorText = fe.getLocalizedMessage();
			} catch (IOException fe) {
				errorText = fe.getLocalizedMessage();
			}
			if (done) {
				try {
					Application.saveOptions();
				} catch (IOException fe) {
					errorText = fe.getLocalizedMessage();
				}
			}
			showMessage(done, errorText);
			return;
		}
	}

	private void showMessage(boolean done, String errorText) {
		JFrame f = new JFrame();
		f.setSize(100, 100);
		f.setAlwaysOnTop(true);
		Point loc = parent.getJFrame().getLocation();
		loc.translate(parent.getJFrame().getWidth() / 2 - 100 / 2, parent
				.getJFrame().getHeight() / 2 - 100 / 2);
		f.setLocation(loc);
		f.setTitle("Meldung");
		JLabel contentPane = new JLabel();
		if (done) {
			contentPane.setText("Fertig ;))");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			contentPane
					.setText("<html><p align='center'>Fehler :((</p><p align='center'>"
							+ errorText + "</p></html>");
		}
		f.setContentPane(contentPane);
		f.setVisible(true);
	}
}

/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: -
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. - Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. - Neither the name of Sun Microsystems nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

class Utils {
	public final static String jpeg = "jpeg";
	public final static String jpg = "jpg";
	public final static String gif = "gif";
	public final static String tiff = "tiff";
	public final static String tif = "tif";
	public final static String png = "png";

	/*
	 * Get the extension of a file.
	 */
	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Utils.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}

/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: -
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. - Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. - Neither the name of Sun Microsystems nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

class ImageFilter extends FileFilter {

	// Accept all directories and all gif, jpg, tiff, or png files.
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = Utils.getExtension(f);
		if (extension != null) {
			if (extension.equals(Utils.tiff) || extension.equals(Utils.tif)
					|| extension.equals(Utils.gif)
					|| extension.equals(Utils.jpeg)
					|| extension.equals(Utils.jpg)
					|| extension.equals(Utils.png)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	// The description of this filter
	public String getDescription() {
		return "Bilddateien";
	}
}
