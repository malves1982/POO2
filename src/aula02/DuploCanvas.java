package aula02;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DuploCanvas extends Frame 
implements MouseListener{

	Graphics g;
	
	Canvas c1 = new Canvas(),
	 	   c2 = new Canvas();
	
	DuploCanvas(){
		setTitle("Exemplo do uso de canvas em Java");
		setBackground(Color.lightGray);
//		addMouseListener(this);
		setResizable(false);
		setSize(500, 300);
		setLayout(null);
		
		c1.setBounds(10, 40, 235, 250);	
		c1.setBackground(Color.white);
		c2.setBounds(255, 40, 235, 250);
		c2.setBackground(Color.white);
		
                c1.addMouseListener(this);
                c2.addMouseListener(this);
                
		add(c1);
		add(c2);
		
		setVisible(true);
	}
	
	private void desenhaC1(){
		for( int i = 0; i < 100; i += 2){
			g.setColor(new Color(155+i, 255-i, 100+i, 255));
			g.drawRect(i, i, i, i);
		}
	}
	
	private void desenhaC2(){
		for( int i = 0; i < 100; i++){
			g.drawOval(i, i, i, i);
		}
	}
	
	public static void main(String[] args) {
		new DuploCanvas();
	}

	public void mouseClicked(MouseEvent e) {
		g = c1.getGraphics();
		desenhaC1();
		
		g = c2.getGraphics();
		desenhaC2();

		repaint();
	}

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
