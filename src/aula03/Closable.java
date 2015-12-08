package aula03;

import java.awt.Frame;

public class Closable extends Frame {

	Closer c = new Closer();
	
	Closable(){
		addWindowListener(c);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Closable();
	}
}
