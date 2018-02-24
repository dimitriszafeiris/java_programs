/**
 * 
 */
package softwarepulse.app.dialog;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import softwarepulse.app.utils.ResourceWrapper;

/**
 * @author John McNeil
 * @copyright Software Pulse 2014
 *
 */
public class About_Dialog extends JDialog {
	
	static Logger log = Logger.getLogger(About_Dialog.class);
	
	private final Label appName = new Label("Ship Log");
	private final Label copyright = new Label("(c) Copyright 2014");
	private final Label author = new Label("John McNeil");
	private final Label version = new Label("version 1.0.1");
	private JLabel iconAbout;
	
	private final Label spacer = new Label("");
	
	private Panel buttonPane = null;
	private Panel contentPane = null;
	private Panel iconPane = null;
	private Panel textPane = null;
	
	private Button okButton = null;
	
	class eventHandler implements java.awt.event.ActionListener {
		public void actionPerformed(ActionEvent e ) {
			log.info("About dialog box event handler called");
			if(e.getActionCommand().equals("OK")) {
				log.info("Close the About dialog box");
				About_Dialog.this.setVisible(false);
				About_Dialog.this.dispose();
			}
		}
	}

	/**
	 * @return the appName
	 */
	public Label getAppName() {
		return appName;
	}

	/**
	 * @return the copyright
	 */
	public Label getCopyright() {
		return copyright;
	}

	/**
	 * @return the author
	 */
	public Label getAuthor() {
		return author;
	}

	/**
	 * @return the version
	 */
	public Label getVersion() {
		return version;
	}

	/**
	 * @return the spacer
	 */
	public Label getSpacer() {
		return spacer;
	}

	/**
	 * @return the buttonPane
	 */
	public Panel getButtonPane() {
		log.info("getButtonPane called");
		if(buttonPane == null) {
			buttonPane = new Panel();
			buttonPane.setName("ButtonPane");
			buttonPane.setLayout(new FlowLayout());
			buttonPane.add(getOkButton());
		}
		return buttonPane;
	}

	/**
	 * @return the contentPane
	 */
	public Panel getMyContentPane() {
		log.info("getMycontentPane called");
		if(contentPane == null) {
			contentPane = new Panel();
			contentPane.setName("ContentPane");
			contentPane.setLayout(new BorderLayout());
			contentPane.add(getButtonPane(), "South");
			contentPane.add(getTextPane(), "Center");
			contentPane.add(getIconPane(), "West");
		}
		return contentPane;
	}

	/**
	 * @return the iconPane
	 */
	public Panel getIconPane() {
		log.info("geticonPane called");
		if(iconPane == null ) {
			ResourceWrapper iconResourceWrapper = new ResourceWrapper("about.jpg", "/softwarepulse/app/dialog");
			iconPane = new Panel();
			BufferedImage picture;
			
			try {
				log.info("Trying to get about icon");
				URL url = this.getClass().getResource(iconResourceWrapper.getAbsoluteName());
				if(url == null ) {
					iconAbout = new JLabel();
					
				} else {
					log.info("Got About icon, converting to picture");
					picture = ImageIO.read(url);
					iconAbout = new JLabel(new ImageIcon(picture.getScaledInstance(110,100, Image.SCALE_SMOOTH)));
				}
				log.info("Add icon to dialog");
				iconPane.add(iconAbout);
			} catch(IOException e) {
				log.error("Unable to read About Dialog box image file");
				e.printStackTrace();
			}
		}
		return iconPane;
	}

	/**
	 * @return the textPane
	 */
	public Panel getTextPane() {
		log.info("getTextPane called");
		if(textPane == null) {
			textPane = new Panel();
			textPane.setName("textPane");
			textPane.setLayout(new GridLayout(5, 1));
			textPane.add(getAppName());
			textPane.add(getVersion());
			textPane.add(getSpacer());
			textPane.add(getCopyright());
			textPane.add(getAuthor());
		}
		return textPane;
	}

	/**
	 * @return the okButton
	 */
	public Button getOkButton() {
		log.info("getOKButton called" );
		if(okButton == null ) {
			okButton = new Button("OK");
			okButton.setName("OK");
			okButton.addActionListener(new eventHandler());
		}
		return okButton;
	}

	public About_Dialog() {
		super();
		log.info("About_Dialog constructor called");
		intialise();
	}

	private void intialise() {
		log.info("initialise called");
		this.setModal(true);
		setName("About Ship Log");
		setLayout(new BorderLayout());
		setBounds(100,100,330,180);
		setTitle("About Ship Log");
		add(getMyContentPane(), "Center");
		log.info("intialise complete");
		
	}
	
	

}
