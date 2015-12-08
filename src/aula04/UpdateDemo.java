package aula04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateDemo extends Panel 
implements ActionListener{

	int linha = 20, xi = 20, xf = 400;
	
	Button b = new Button("next step");
	
	UpdateDemo(){
		setLayout(new BorderLayout());
		b.setPreferredSize(new Dimension(60,25));
		b.addActionListener(this);
		add(b, BorderLayout.SOUTH);
	}

	private void nextStep(){
		linha += 10;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawLine(xi, linha, xf, linha);
	}
	
	/*
	 * Atualiza mantendo o desenho anterior
	 */
	public void update(Graphics g){
		paint(g);
	}
	
	
	/*
	 * Atualiza apagando o desenho anterior 
	 * 
	public void update(Graphics g){
		g.setColor(getBackground());
		g.fillRect(0,0,getSize().width-1,getSize().height-1);
		g.setColor(Color.red);
		paint(g);
	}*/

	public void actionPerformed(ActionEvent e) {
		nextStep();
		repaint();
	}
	
	public static void main(String[] args) {
		int x = 420, y = 400; 
		Dimension d;
		
		Frame f = new Frame();
		f.setSize(x, y);
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		d = Toolkit.getDefaultToolkit().getScreenSize();		
		
		// mude esta linha para instanciar a classe que desejar
		f.add(new UpdateDemo());
		
		f.setLocation((d.width-x)/2, (d.height-y)/2);
		f.setResizable(false);
		f.setVisible(true);
	}
}
