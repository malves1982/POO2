package aula05.parametro;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class Parametro extends Applet {
	
	String p1, p2;
	Color  c1, c2;

	public void init() {
		p1 = getParameter("string1");
		p2 = getParameter("string2");
	}
	
	public void paint(Graphics g) {
		g.drawString(p1, 10, 10);
		g.drawString(p2, 10, 30);
	}
}
