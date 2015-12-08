package aula03;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Beeper implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
	}
}
