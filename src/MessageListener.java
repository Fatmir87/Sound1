import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class MessageListener implements ActionListener{

	// Setting object "filepath" got from Interface
	String filepath1;
	String filepath2;
	
	public MessageListener(String filepath1, String filepath2) {
		this.filepath1 = filepath1;
		this.filepath2 = filepath2;
	}
	
	// Setting boolean got from Interface
	boolean isChanged;
	public MessageListener(boolean isChanged) {
		this.isChanged = isChanged;
	}

	// Variables declaration
	JButton buttonPlay = Interface.getButtonPlay();
	JButton buttonStop = Interface.getButtonStop();
	static Clip clip;
	
	// Creating boolean isPlaying - if the clip is playing isPlaying = true
	public static boolean isPlaying = false;

	// Handling click events
	@Override
	public void actionPerformed(ActionEvent evt) {	
		// Action for buttons
		Object source = evt.getSource();
		if (source instanceof JButton) {
			JButton button = (JButton) source;
			// If clicked button is button "Play"
			if (button == buttonPlay) {
				// Go to method for button "Play"
				buttonPlayActionPerformed(evt, filepath1, filepath2);
			}
			// If clicked button is button "Stop"
			else if (button == buttonStop) {
				// Go to method for button "Stop"
				buttonStopActionPerformed(evt);
			}
		}
		// Action for drop down list to prevent playing two clips at the same time
		if (isChanged) {
			isPlaying = false;
			clip.stop();
			clip.close();
		}
	}	

	// Method for start playing the sound when the "Play" button is clicked
	public static void buttonPlayActionPerformed(ActionEvent evt, String musicLocation1, String musicLocation2) {
		if (Interface.dropDown.getSelectedItem() == "Montana") {
			PlaySound(musicLocation1);

		} else if (Interface.dropDown.getSelectedItem() == "Say Hello"){
			PlaySound(musicLocation2);
		}
		
	}
	
	// Method to play the sound
	static void PlaySound(String soundLocation) {
		try {
			File fileToPlay = new File(soundLocation);
			if(fileToPlay.exists()) {
				if (!isPlaying) {
					isPlaying = true;
					clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(fileToPlay));
					clip.start();
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			}
			else {
				System.out.println("Can't find file");
			}
		} 		
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// Method for stop playing the sound when the "Stop" button is clicked
    public static void buttonStopActionPerformed(ActionEvent evt) {    	
    	if (isPlaying) {
	    	isPlaying = false;
	    	clip.stop();
	    	clip.close();
    	}
    }             

}
