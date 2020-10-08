import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		Interface ui = new Interface();
		SwingUtilities.invokeLater(ui);

	}

	public static void PlayAudio() {

		if (Interface.dropDown.getSelectedItem() == "Montana") {
			File Sound = new File("scarface_montana.wav");
			PlaySound(Sound);

		} else {
			File Sound1 = new File("scarface_say_hello.wav");
			PlaySound(Sound1);
		}

	}

	static void PlaySound(File Sound) {

		try {
			File file = new File("Sound");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.setFramePosition(0);
			clip.start();


		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}