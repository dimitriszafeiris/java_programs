/**
 * 
 */
package softwarepulse.app.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import softwarepulse.app.ShipLog;
import softwarepulse.app.dialog.About_Dialog;

/**
 * @author John McNeil
 * @copyright Software Pulse 2014
 *
 */
public class MainMenuActionListener implements ActionListener {
	static Logger log = Logger.getLogger(MainMenuActionListener.class);
	private JFrame app;


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		log.info("Menu event generated: " + arg0.toString());
		if(arg0.getActionCommand().equals("Exit")) {
			log.info("Exit button pressed");
			app.dispose();
		}
		if(arg0.getActionCommand().equals("About")) {
			log.info("About button pressed");
			About_Dialog about_Dialog = new About_Dialog();
			about_Dialog.setVisible(true);
		}
	}


	/**
	 * @return the app
	 */
	public JFrame getApp() {
		return app;
	}


	/**
	 * @param app the app to set
	 */
	public void setApp(JFrame app) {
		this.app = app;
	}

}
