/**
 * 
 */
package softwarepulse.app.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import softwarepulse.app.ShipLog;

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
		// TODO Auto-generated method stub
		log.info("Menu event generated: " + arg0.toString());
		if(arg0.getActionCommand().equals("Exit")) {
			log.info("Exit button pressed");
			app.dispose();
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
