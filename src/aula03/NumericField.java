package aula03;

import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;


/**
 * Clase que implementa um campo de texto que aceita apenas valores num�ricos
 * bem como caracteres especiais determinados pelo programador.
 * @author Reginaldo
 *
 */
public class NumericField extends TextField
implements TextListener, KeyListener {
	
	String aceitavel = "1234567890",
	       aux, atual = "";
	
	public NumericField(){
		setEditable(false);
		addKeyListener(this);
		setBackground(Color.white);		
	}
	
	/**
	 * Construtor que faz com que o campo num�rico aceite tamb�m o caracter'c'
	 * @param c
	 */
	public NumericField(char c){
		this();
		aceitavel += String.valueOf(c);
	}
	
	/**
	 * Construtor que faz com que o campo num�rico aceite tamb�m os caracteres
	 * contidos na String s
	 * @param s
	 */
	public NumericField (String s){
		this();
		aceitavel += s;
	}
	
	private boolean caracterAceitavel(char c){
		if(aceitavel.indexOf(c) != -1)
			return true;		
		return false;
	}
	
	private char getLastChar(){
		aux = getText();
		int index = aux.length();
		
		System.out.println("auxSize:" + index);
		
		return aux.charAt(index);
	}
	
	public void textValueChanged(TextEvent e) {		
		char c = getLastChar();
		
		if(caracterAceitavel(c))
			atual += String.valueOf(c);
		
		setText(atual);
	}


	public static void main(String[] args) {
		Frame f = new Frame();
		NumericField nf = new NumericField();
		
		f.add(nf);
		
		f.setSize(100, 80);
		f.setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		char c = e.getKeyChar();
		
		if(key == 8)
			try {
				atual = atual.substring(0, atual.length()-1);
			} catch (Exception e1) {}

		if(key == 127)
			try {
				atual = atual.substring(1, atual.length());
			} catch (Exception e1) {}
		
		if(caracterAceitavel(c))
			atual += String.valueOf(c);
		
		setText(atual);		
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
