/**
 * 
 */
package softwarepulse.app.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author John McNeil
 * @copyright Software Pulse 2014
 *
 */
public class MainMenu extends JMenuBar {
	
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuView;
	private JMenu menuHelp;

	private JMenuItem menuitemNew;
	private JMenuItem menuitemOpen;
	private JMenuItem menuitemSave;
	private JMenuItem menuitemSaveAs;
	private JMenuItem menuitemExit;
	private JMenuItem menuitemEditFleetName;
	private JMenuItem menuitemGroupByClass;
	private JMenuItem menuitemGroupByType;
	private JMenuItem menuitemAbout;

	public MainMenu(MainMenuActionListener main_menu_action_listener) {
		super();
		menuFile = new JMenu("File");
		menuFile.setMnemonic('F');
		this.add(menuFile);
		
		menuitemNew = new JMenuItem("New");
		menuitemNew.setMnemonic('N');
		menuitemNew.addActionListener(main_menu_action_listener);
		menuFile.add(menuitemNew);
		
		menuitemOpen = new JMenuItem("Open");
		menuitemOpen.setMnemonic('O');
		menuitemOpen.addActionListener(main_menu_action_listener);
		menuFile.add(menuitemOpen);
		menuFile.addSeparator();
		
		menuitemSave = new JMenuItem("Save");
		menuitemSave.setMnemonic('S');
		menuitemSave.addActionListener(main_menu_action_listener);
		menuFile.add(menuitemSave);

		menuitemSaveAs = new JMenuItem("Save As");
		menuitemSaveAs.setMnemonic('A');
		menuitemSaveAs.addActionListener(main_menu_action_listener);
		menuFile.add(menuitemSaveAs);
		menuFile.addSeparator();
		
		menuitemExit = new JMenuItem("Exit");
		menuitemExit.setMnemonic('x');
		menuitemExit.addActionListener(main_menu_action_listener);
		menuFile.add(menuitemExit);
		
		menuEdit = new JMenu("Edit");
		menuEdit.setMnemonic('E');
		this.add(menuEdit);

		menuitemEditFleetName = new JMenuItem("Edit Fleet by Name");
		menuitemEditFleetName.setMnemonic('F');
		menuitemEditFleetName.addActionListener(main_menu_action_listener);
		menuEdit.add(menuitemEditFleetName);
				
		
		menuView = new JMenu("View");
		menuView.setMnemonic('V');
		this.add(menuView);
		menuitemGroupByClass = new JMenuItem("Group by Class");
		menuitemGroupByClass.setMnemonic('l');
		menuitemGroupByClass.addActionListener(main_menu_action_listener);
		menuitemGroupByType = new JMenuItem("Group by Type");
		menuitemGroupByType.setMnemonic('y');
		menuitemGroupByType.addActionListener(main_menu_action_listener);
		menuView.add(menuitemGroupByClass);
		menuView.add(menuitemGroupByType);
		
		menuHelp = new JMenu("Help");
		menuHelp.setMnemonic('H');
		this.add(menuHelp);
		menuitemAbout = new JMenuItem("About");
		menuitemAbout.setMnemonic('b');
		menuitemAbout.addActionListener(main_menu_action_listener);
		menuHelp.add(menuitemAbout);
}

	
	
}
