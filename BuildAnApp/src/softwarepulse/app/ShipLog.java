/**
 * 
 */
package softwarepulse.app;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import softwarepulse.app.menu.MainMenu;
import softwarepulse.app.menu.MainMenuActionListener;
import softwarepulse.app.utils.Splashing;

/**
 * @author John McNeil
 * @copyright Software Pulse 2014
 *
 */
public class ShipLog extends JFrame {

	static Logger log = Logger.getLogger(ShipLog.class);
	private WindowEventHandler window_event_handler;
	MainMenuActionListener main_menu_action_listener;
	MainMenu main_menu;
	
	
	public ShipLog() throws HeadlessException {
		super();
		log.info("constructor called");
		this.setTitle("Build Java Applications - Ship Log");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window_event_handler = new WindowEventHandler();
		window_event_handler.setApp(this);
		this.addWindowListener(window_event_handler);
		
		// Add Menu to app
		main_menu_action_listener = new MainMenuActionListener();
		main_menu_action_listener.setApp(this);
		main_menu = new MainMenu(main_menu_action_listener);
		setJMenuBar(main_menu);
		
		setBounds(100, 100, 450, 300);
		log.info("constructor finished");
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		log.info("***** Build An Application - Ship Log started *****");
		
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				
				Splashing.splashInit();
				Splashing.Pause(1000);
				
				Splashing.splashText("Creating application");
				Splashing.splashProgress(33);
				Splashing.Pause(1000);
				
				Splashing.splashText("Initialising application");
				Splashing.splashProgress(66);
				Splashing.Pause(1000);

				ShipLog app = new ShipLog();
				
				Splashing.splashText("Loading data file");
				Splashing.splashProgress(99);
				Splashing.Pause(1000);

				app.setVisible(true);
				
			}
		});
	}

}
