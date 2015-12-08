package aula02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

public class ComponentSampleI extends Frame{

	Button b = new Button("Norte");
	TextField tf = new TextField();
	TextArea  ta = new TextArea();
	Label l = new Label("Sul");
	Panel p = new Panel(),
	      x = new Panel();
	
	
	Dimension d;
	
	ComponentSampleI(){
		// analise o uso do método abaixo 
		// tf.setPreferredSize(new Dimension(200,20));
		
		// insere b e tf no painel
		p.add(b);
		p.add(tf);
		
		// insere o painel no norte do frame
		add(p, BorderLayout.NORTH);
		
		// atribui cor ao fundo e às letras na área de texto
		ta.setBackground(Color.cyan);
		ta.setForeground(Color.red);
		ta.setPreferredSize(new Dimension(250,50));
		
		x .setBackground(Color.yellow);
		add(x, BorderLayout.CENTER); // estica o componente em ambas as direções
		
		add(ta, BorderLayout.EAST);  // estica o componente na horizontal
		add(l, BorderLayout.SOUTH);  // estica o componente na vertical
		
		// descobre as dimensões do monitor
    	d = (Toolkit.getDefaultToolkit()).getScreenSize();
    	
    	// calcula e posiciona o frame no centro da tela
    	setLocation((d.width  - this.getSize().width)/2 - 150, 
    			    (d.height - this.getSize().height)/2 - 200);
    	
		setSize(300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		ComponentSampleI cs = new ComponentSampleI();
	}
}
