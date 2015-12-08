package aula03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;

/**
 * Esse exemplo mostra a conveni�ncia de se delegar o tratamento
 * de eventos para classes especializadas... isto � particularmente
 * interessante quando a fonte de eventos � a mesma para mais que
 * um ouvinte
 * @author Reginaldo
 */
public class Botao2 extends Frame{

	// Objeto que far� a gera��o dos eventos de a��o
	Button b = new Button("Clique - me");
	
	// Objeto que ser� afetado pelo evento gerado em b
	Label l = new Label();
	
	// Classes que tratar�o os eventos gerados por b
	PositiveWords pw = new PositiveWords(l);
	Beeper beep = new Beeper();
	
	
	// Construtor que configura e adiciona objetos ao frame
	Botao2(){
		
		b.addActionListener(beep);  // capturando evento de a��o
		b.addActionListener(pw);
		
		add(b);
				
		l.setPreferredSize(new Dimension(50, 100));
		l.setBackground(new Color(234,231,208));
		l.setForeground(Color.magenta);
		l.setAlignment(Label.CENTER);
		add(l, BorderLayout.SOUTH);
		
		showFrame();
	}
	
	private void showFrame(){
		setSize(200, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Botao2();
	}
}