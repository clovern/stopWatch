package stopwatch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StopWatchPanelMain extends JPanel {
	private JMenuItem quitItem;
	private JCheckBox suspendCheckBox;
	

	public StopWatchPanelMain (JMenuItem quitItem) {
		this.quitItem = quitItem;

		JPanel panel = new JPanel();

		//adds three panels to StopWatch. Each of these panels contains the functionality for 1 StopWatch.
		panel.add(new StopWatchPanel());
		panel.add(new StopWatchPanel());
		panel.add(new StopWatchPanel());

		//adds suspend checkbox to next to the panels
           suspendCheckBox = new JCheckBox("Suspend Timers");
		   suspendCheckBox.setSelected(false);
           panel.add(suspendCheckBox);
           add(panel);

		quitItem.addActionListener(new Mylistener());
		suspendCheckBox.addActionListener(new Mylistener());
	}

	//adds functionality to quit and suspend GUI widgets
	private class Mylistener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == quitItem)
				System.exit(1);

			if(e.getSource() == suspendCheckBox) {
			suspendCheckBox.setSelected((suspendCheckBox.isSelected()) == true);
			StopWatch.setSuspend(suspendCheckBox.isSelected());
			}
		}
	}
}

