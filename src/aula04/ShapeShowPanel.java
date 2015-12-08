package aula04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShapeShowPanel extends FramedPanel 
implements MouseListener{

	int w, h, cx, cy, fig = 0, lim = 6;
	
	ShapeShowPanel(int w, int h, int style){
		super(w, h, style);
		this.w = w;
		this.h = h;
		
		cx = w/2;
		cy = h/2;
		
		addMouseListener(this);
	}
	
	private void paintString(Graphics g, String s){
		FontMetrics fm = g.getFontMetrics();
		int num = fm.stringWidth(s);

		g.setColor(Color.red);
		g.drawString(s, cx-num/2, 330);
	}
	
	
	private void paintShape(Graphics g, int key){
		
		switch (key) {
		case 0:
	        g.drawLine(20, 20, w - 20, h - 20);
	        paintString(g, "drawLine( )");			
			break;
			
		case 1:
			g.drawArc(cx-40, cy-40, 80, 80, 90, 135);
	        paintString(g, "drawArc");
	        break;
	        
		case 2:
			  g.drawOval(cx-40, cy-40, 80, 80);
	        paintString(g, "drawOval");
	        break;
	        
		case 3:
	        g.drawRect(cx-40, cy-40, 80, 80);
	        paintString(g, "drawRect");
	        break;
	        
		case 4:
			g.drawRoundRect(cx-40, cy-40, 80, 80, 10, 10);
	        paintString(g, "drawRoundRect( )");
	        break;
	        
		case 5:
	        g.draw3DRect(cx-40, cy-40, 80, 80, true);
	        paintString(g, "draw3DRect( )");
	        break;
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		
		if(++fig == lim ) fig = 0;
		paintShape(g, fig);
	}
	
	/*
	 * Método main que fornece a funcionalida de fechar a janela e centraliza
	 * o frame na tela independente de suas dimensões
	 */
	public static void main(String[] args) {
		int x = 420, y = 400; 
		Dimension d;
		
		Frame f = new Frame();
		f.setLayout(new FlowLayout());
		f.setSize(x, y);
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		d = Toolkit.getDefaultToolkit().getScreenSize();		
		
		// mude esta linha para instanciar a classe que desejar
		f.add(new ShapeShowPanel(x-20, y-50, 2));
		
		f.setLocation((d.width-x)/2, (d.height-y)/2);
		f.setResizable(false);
		f.setVisible(true);
	}
	

	public void mouseClicked(MouseEvent e) {
		//super.mouseClicked(e);
		repaint();
	}
}
