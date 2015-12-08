package aula04;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FramedPanel extends Panel 
implements MouseListener{

	public static final
	int BORDASIMPLES = 0,
	    BORDADUPLA   = 1,
	    BORDARELEVO  = 2;
	
	private int style;
	
	private Color cor1 = Color.black,
	              cor2 = Color.lightGray;
	
	Dimension d = new Dimension(20,20);
	Graphics gr;
	
	public FramedPanel(int style){
		this.style = style;
		addMouseListener(this);
	}
	
	public FramedPanel(int w, int h, int style){
		this(style);
		d = new Dimension(w, h);
		setPreferredSize(d);
	}
	
	public Dimension getMinimumSize(){
		return d;
	}
	
	public Dimension getPreferredSize(){
		return getMinimumSize();
	}
	
	private void paintFrame(Graphics g){
		switch (style) {
		case BORDASIMPLES: desenhaBordaSimples(g);			
			break;
			
		case BORDADUPLA: desenhaBordaDupla(g);			
			break;
			
		case BORDARELEVO: desenhaBordaRelevo(g);			
			break;
		}
	}
	
	
	private void changeColor(){
		Color aux = cor1;
		      cor1 = cor2;
		      cor2 = aux;
	}
	
	private void desenhaBordaSimples(Graphics g){
		g.setColor(cor1);
		g.drawRect(0, 0, this.getSize().width-1, getSize().height-1);
	}
	
	private void desenhaBordaDupla(Graphics g){		
		g.setColor(cor1);
		g.drawRect(0, 0, this.getSize().width-1, getSize().height-1);		
		g.setColor(cor2);
		g.drawRect(2, 2, this.getSize().width-5, getSize().height-5);
	}
	
	private void desenhaBordaRelevo(Graphics g){
		int largura = getSize().width-1;
		int altura  = getSize().height-1;
		
		g.setColor(cor1);
		g.drawLine(0, 0, largura, 0);
		g.drawLine(0, 0, 0, altura);
		
		g.setColor(cor2);
		g.drawLine(2, 2, largura-4, 2);
		g.drawLine(2, 2, 2, altura-4);
		
		g.setColor(cor1);
		g.drawLine(largura-2, 2, largura-2, altura-2);
		g.drawLine(2, altura-2, largura-2, altura-2);		
		
		g.setColor(cor2);
		g.drawLine(0, altura, largura, altura);
		g.drawLine(largura, 0,largura, altura);
	}
	
	public void paint (Graphics g){
		paintFrame(g);
	}
	
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setLayout(new FlowLayout());
		f.setSize(200, 300);
		
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.add(new FramedPanel(60, 120, FramedPanel.BORDARELEVO));
		f.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		Component c = getParent();
		gr = c.getGraphics();
		gr.drawString("Living and learning...", 20, 200);
		
		// why ?!?
		gr = getGraphics();
		gr.drawString("It's great!...", 20, 20);
		repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		changeColor();
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		changeColor();
		repaint();
	}
}
