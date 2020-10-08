import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class ButtonListener implements ActionListener {

	public ButtonListener(JTextArea origin, JTextArea destination) {

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Main.PlayAudio();

	}
}