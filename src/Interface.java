
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Interface implements Runnable {

	// Variables declaration
	private JFrame frame;
	private static JButton playButton;
	private static JButton stopButton;
	static JComboBox<Object> dropDown;


	// Create and display the frame-form
	@Override
	public void run() {
		frame = new JFrame("Media Player");
		frame.setPreferredSize(new Dimension(300, 200));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	// Method creating components - design of interface
	private void createComponents(Container container) {

		GridLayout layout = new GridLayout(1, 3);
		container.setLayout(layout);
		
		playButton = new JButton("Play");
		stopButton = new JButton("Stop");
		
		// Sound files paths
		String filepath1 = "scarface_montana.wav";
		String filepath2 = "scarface_say_hello.wav";
	        
	    // Setting object for MessageListener for buttons
	    MessageListener musicObject = new MessageListener(filepath1, filepath2);
		playButton.addActionListener(musicObject);
		stopButton.addActionListener(musicObject);
		
		// Drop down list to choose file
		dropDown = new JComboBox<Object>(new String[] { "Montana", "Say Hello" });
		
		// Boolean to check if choosed file is changed
		boolean isChanged = true;
		
		// Setting MessageListener for drop down list
		MessageListener actionDropDown = new MessageListener(isChanged);
		dropDown.addActionListener(actionDropDown);
		
		
		container.add(playButton);
		container.add(stopButton);
		container.add(dropDown);

	}

	public JFrame getFrame() {
		return frame;
	}
	
	public static JButton getButtonPlay() {
		return playButton;
	}
	
	public static JButton getButtonStop() {
		return stopButton;
	}
	

}