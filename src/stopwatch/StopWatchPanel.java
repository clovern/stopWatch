package stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Provides visual representation of individual StopWatch
 * 
 * @author Nicole Dudas
 * @version Winter 2021
 */
public class StopWatchPanel extends JPanel{
	
	private StopWatch watch;
    private Timer javaTimer;
	
	private JTextField minField, secField, milliField;
	private JButton stopButton;
	private JButton startButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton addButton;
	private JTextField addField;
	private JButton subtractButton;
	private JTextField subtractField;
	private JButton newButton;
	private JTextField newField;
	private JButton continueButton;
	private JFileChooser fileChooser;

	private JLabel lblTime;

	/***************************************************************************************
     * constructor for StopWatchPanel
     ***************************************************************************************/
	public StopWatchPanel(){ 

		// initialize a watch object to store Time data, and a javaTimer to increment the time
		watch = new StopWatch();
		javaTimer = new Timer(5, new TimerListener());

		setLayout(new GridLayout(10,2));
		setBackground(Color.lightGray);

		//initialize each GUI object
		add(new JLabel("Minutes:"));
		minField = new JTextField("0", 3);
		add(minField);

		add(new JLabel("Seconds:"));
		secField = new JTextField("0", 3);
		add(secField);

		add(new JLabel("Miliseconds:"));
		milliField = new JTextField("0", 3);
		add(milliField);

		stopButton = new JButton("Stop");
		add(stopButton);

		startButton = new JButton("Start");
		add(startButton);

		loadButton = new JButton("Load");
		add(loadButton);

		fileChooser = new JFileChooser();

		saveButton = new JButton("Save");
		add(saveButton);

		addButton = new JButton("Add");
		add(addButton);
		addField = new JTextField("0", 3);
		add(addField);

		subtractButton = new JButton("Subtract");
		add(subtractButton);
		subtractField = new JTextField("0", 3);
		add(subtractField);

		newButton = new JButton("New");
		add(newButton);
		newField = new JTextField("0:0:0", 3);
		add(newField);

		continueButton = new JButton("Continue");
		add(continueButton);

		add (new JLabel(" "));

		add(new JLabel("Time:"));
		lblTime = new JLabel();
		lblTime.setText(watch.toString());
		add(lblTime);

		//add action listeners to GUI objects to give them functionality
		stopButton.addActionListener(new ButtonListener());
		startButton.addActionListener(new ButtonListener());
		loadButton.addActionListener(new ButtonListener());
		saveButton.addActionListener(new ButtonListener());
		addButton.addActionListener(new ButtonListener());
		subtractButton.addActionListener(new ButtonListener());
		newButton.addActionListener(new ButtonListener());
		continueButton.addActionListener(new ButtonListener());

	}

	private class ButtonListener implements ActionListener{

		/***************************************************************************************
		 * Event listener which sets individual functinality to GUI widgets
		 * @param ActionEvent event - GUI widget event which triggered event listener
		 ***************************************************************************************/
		public void actionPerformed(ActionEvent event){

			int mins, sec, milli, p;

			//starts timer from whatever StopWatch's value is
			if (event.getSource() == startButton){
				try{  
					mins = Integer.parseInt(minField.getText());
					sec = Integer.parseInt(secField.getText());
					milli = Integer.parseInt(milliField.getText());
					watch = new StopWatch(mins,sec,milli);
					javaTimer.start();
				}catch(NumberFormatException io){
					JOptionPane.showMessageDialog(null,"Enter an integer in all fields");
				}catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null,"Error in field");
				}
			}

			//stops timer at whatever StopWatch's value is
			if (event.getSource() == stopButton){
				javaTimer.stop();
			}

			//loads or saves a single StopWatch's time to or from a txt file
			if (event.getSource() == loadButton || event.getSource() == saveButton){

				/*uses file chooser to select a file to save to or load from. Sets default
				as "file1" for purposes of saving if one if not added*/
				int fileChoice;
				String useFile = "file1";

				fileChoice = fileChooser.showOpenDialog(fileChooser);

				if (fileChoice == JFileChooser.APPROVE_OPTION) {
					useFile = fileChooser.getSelectedFile().getName();
				}

				if (event.getSource() == saveButton){
					watch.save(useFile);
				}

				if (event.getSource() == loadButton && useFile != "file1"){
					watch.load(useFile);
				}

			}

			//adds time to the StopWatch, either in milliseconds or in minutes:seconds:milliseconds format
			if (event.getSource() == addButton){
				if (addField.getText().contains(":")){
					StopWatch tmp = new StopWatch(addField.getText());
					watch.add(tmp);
				}
				else{
					watch.add(Integer.parseInt(addField.getText()));
				}
			}

			//sutracts time from the Stopwatch, either in milliseconds or in minutes:seconds:milliseconds format
			if (event.getSource() == subtractButton){
				if (subtractField.getText().contains(":")){
					StopWatch tmp = new StopWatch(subtractField.getText());
					watch.sub(tmp);
				}
				else{
					watch.sub(Integer.parseInt(subtractField.getText()));
				}
			}

			//sets stopwatch values back at 0
			if (event.getSource() == newButton){
				if (StopWatch.isSuspended()){
					return;
				}
				if (newField.getText().contains(":")){
					watch = new StopWatch(newField.getText());
				}
				else{
					watch = new StopWatch(Integer.parseInt(newField.getText()));
				}
			}

			//continues StopWatch time from current time. 
			if (event.getSource() == continueButton){
				javaTimer.start();
			}

			lblTime.setText(watch.toString());
		}

	}
	
	private class TimerListener implements ActionListener {

		/***************************************************************************************
		 * Increments timer in 5ms increments.
		 * @param ActionEvent e - event that triggered timer event listener
		 ***************************************************************************************/
        public void actionPerformed(ActionEvent e) {
        	watch.add(1);
			watch.add(1);
			watch.add(1);
			watch.add(1);
			watch.add(1);
        	lblTime.setText(watch.toString());
        }
	}
}
