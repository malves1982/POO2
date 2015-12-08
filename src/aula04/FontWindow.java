package aula04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Window;


public class FontWindow extends Window {
	Image image;
	Dimension d;
	int w = 460, h = 300;
	
	public FontWindow(Frame owner) {
		super(owner);
		d = Toolkit.getDefaultToolkit().getScreenSize();
		
		loadImage("duke.gif");
		
		setSize(w, h);		
		setLocation((d.width-w)/2, (d.height-h)/2);
		setVisible(true);
	}
	
	private void loadImage(String fileName){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		image = toolkit.getImage(fileName);
		
		MediaTracker mediaTracker = new MediaTracker(this);
		mediaTracker.addImage(image, 0);
		try {
			mediaTracker.waitForID(0);
		}
		catch (InterruptedException ie){}
	}
	
    public void paint(Graphics g) {
        int width, height;  // altura e largura da string.
        int xIme, yIme, xPgj, yPgj, lineHeight; 
        
        String pgj = "Programação Gráfica em Java";
        String ime = "IME - USP   -   Verão 2007";
        
        Font F = new Font("Vrinda", Font.ITALIC + Font.BOLD, 20);
        g.setFont(F);
       
        FontMetrics fm = g.getFontMetrics(F);
                
        height = fm.getAscent();
        lineHeight = fm.getHeight();
        
        width = fm.stringWidth(ime);
        xIme = (getSize().width - width) / 2;                                              
        yIme = (getSize().height + height) / 2 + lineHeight; 
        
        width = fm.stringWidth(pgj);
        xPgj = (getSize().width - width) / 2;                                              
        yPgj = (getSize().height + height) / 2 - lineHeight; 
        
        g.setColor(Color.blue);
        g.drawString(pgj, xPgj, yPgj);
        
        g.setColor(Color.red);
        g.drawString(ime, xIme, yIme);
        
        g.setColor(Color.black);
        g.drawRect(0, 0, getSize().width-1 , getSize().height-1);
        
    	g.drawImage(image, 380, 1, null);
     }

	public static void main(String[] args) {
		Frame f = new Frame();
		new FontWindow(f);
	}
}
