package aula03;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botao1 extends Frame 
implements ActionListener {  // passo 1

	// Objeto que far� a gera��o dos eventos de a��o
	Button b = new Button("Clique - me");
	
	// Construtor que configura e adiciona o bot�o ao frame
	Botao1(){
		b.addActionListener(this); // passo 2
		add(b);
		
		showFrame();
	}
	
	// M�todo da interface ActionListener que faz o tratamento dos
	// eventos gerados por esse listener;   note que, assim que uma 
	// classe implementa uma interface listener ela pr�pria se torna
	// um listener.
	public void actionPerformed(ActionEvent e) { // passo 3
		Toolkit.getDefaultToolkit().beep();
		System.out.println("Fui clicado !!!");
	}
	

	// Delegando parte do(e por qu� n�o todo o) trabalho que
	// deve ser realizado pelo construtor a um m�todo... essa �
	// uma maneira interessante de tornar o construtor mais leg�vel
	// e de f�cil manuten��o
	private void showFrame(){
		setSize(200, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Botao1();
	}
}

/*
 * Note a exist�ncia dos tr�s passos b�sicos para o tratamento de eventos:
 * 1. implementa��o da interface listener apropriada
 * 2. c�digo que registra o tratador de eventos ao objeto fonte de eventos
 *    (nesse caso, a fonte � o bot�o 'b' e o ouvinte � a classe Botao1 )
 * 3. implementa��o do(s) m�todo(s) da interface listener utilizada
 */