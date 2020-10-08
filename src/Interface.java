
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Interface implements Runnable {

	private JFrame frame;
	static JComboBox dropDown;

	public Interface() {

	}

	@Override
	public void run() {
		frame = new JFrame("Media Player");
		frame.setPreferredSize(new Dimension(300, 200));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);

	}

	private void createComponents(Container container) {

		GridLayout layout = new GridLayout(1, 3);
		container.setLayout(layout);
		dropDown = new JComboBox(new String[] { "Montana", "Say Hello" });

		dropDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		JTextArea textAreaLeft = new JTextArea("");
		JTextArea textAreaRight = new JTextArea();
		JButton copyButton = new JButton("Play");

		ButtonListener play = new ButtonListener(textAreaLeft, textAreaRight);
		copyButton.addActionListener(play);

		container.add(copyButton);
		container.add(dropDown);

	}

	public JFrame getFrame() {
		return frame;
	}

}