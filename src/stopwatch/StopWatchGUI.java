package stopwatch;

import javax.swing.*;

public class StopWatchGUI {
	public static void main(String arg[]){
		
		JMenu fileMenu;
		JMenuItem quitItem;
		JMenuBar menus;

		//creates a file menu with quit option
		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		menus = new JMenuBar();

		menus.add(fileMenu);

		//creates the window and assigns stop watch to title.
		JFrame gui = new JFrame("Stop Watch");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//adds a panel containing all 3 StopWatch panels to the window
		StopWatchPanelMain panel = new StopWatchPanelMain(quitItem);
		gui.getContentPane().add(panel);

		//sets window size and makes items formatted within window and visible. 
		gui.setSize(600,400);
		gui.setJMenuBar(menus);
		gui.pack();
		gui.setVisible(true);
	}
}
