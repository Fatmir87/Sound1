import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class ComboBox implements ItemListener {
	// @Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();

		}
	}
}
// public static void main(String[] args) {

//		JComboBox patternList = new JComboBox(Sound);
//		patternList.setEditable(true);
//		patternList.addActionListener();

// }

//}
