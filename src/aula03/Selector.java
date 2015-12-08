package aula03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Selector extends Frame {
	
	String[] nomes = {"Zé", "João", "Pedro", "Maria", "Cida", "Hellen",
			          "Paulo", "Victor", "Isadora", "Eric", "Bárbara", "Márcia"};
	
	List leftList,  rightList;
	
	Button b1, b2, b3, b4;
	
	Label esqLb, dirLb;
	
	Panel eastPanel, westPanel, centerPanel, 
	      northPanel, southPanel;
	
	Dimension d;
	Graphics g;
	
	Selector(){
		// gaps entre components
		setLayout(new BorderLayout(10, 20));
		d = new Dimension(250, 100);

		configureNorthPanel();
		configureSouthPanel();
		configureWestPanel();
		configureEastPanel();
		configureCenterPanel();
		setSize(560,380);
		setVisible(true);

		
            WindowListener fecha = new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            };
            addWindowListener(fecha);
	}
	
	//painel inferior
	private void configureSouthPanel(){
		southPanel = new Panel();
		southPanel.setPreferredSize(d);
		
		//g = southPanel.getGraphics();
		//g.drawString("Bom demais da conta tch�!", 10, 10);
		
		add(southPanel, BorderLayout.SOUTH);
	}
	
	
	// painel com os bot�es
	private void configureCenterPanel(){
		centerPanel = new Panel(new GridLayout(4, 1));
		
		b1 = new Button(">");
		b1.addActionListener(new SelectorListenerI(leftList, rightList));
		
	    b2 = new Button("<");
	    b2.addActionListener(new SelectorListenerI(rightList, leftList));
	    
	    b3 = new Button(">>");
	    b3.addActionListener(new SelectorListenerII(leftList, rightList));
	    
	    b4 = new Button("<<");
	    b4.addActionListener(new SelectorListenerII(rightList, leftList));
	    
	    centerPanel.add(b1);
	    centerPanel.add(b2);
	    centerPanel.add(b3);
	    centerPanel.add(b4);
	    
	    add(centerPanel);
	}
	
	
	// painel com a lista de funcion�rios dispon�veis
	private void configureWestPanel(){
		westPanel = new Panel(new BorderLayout());
		westPanel.setPreferredSize(d);
		westPanel.setBackground(Color.yellow);
		
		leftList = new List(8, true);
		for (int i = 0; i < nomes.length; i++) {
			leftList.add(nomes[i]);
		}

		westPanel.add(leftList);
		add(westPanel, BorderLayout.WEST);
	}
	
	// painel com a lista de funcion�rios alocados ao projeto
	private void configureEastPanel(){
		eastPanel = new Panel(new BorderLayout());	
		eastPanel.setPreferredSize(d);
		rightList = new List(8, true);		
		eastPanel.add(rightList);
		
		add(eastPanel, BorderLayout.EAST);
	}
	
	// painel com os labels
	private void configureNorthPanel(){
		northPanel = new Panel(new BorderLayout());
				
		esqLb = new Label("Funcionários disponíveis");
		northPanel.add(esqLb, BorderLayout.WEST);
		
		dirLb = new Label("Funcionários alocados no projeto");
		northPanel.add(dirLb, BorderLayout.EAST);		
		
		add(northPanel, BorderLayout.NORTH);
		getInsets();
	}
	
	/**
	 * Determina os "insets", ou seja, os limites para a inser��o de componentes
	 * a esse container.  Em outras palavras, um objeto Insets determina as 
	 * dimens�es da "moldura" ( o espa�o livre nas bordas) desse container.
	 */
	public Insets getInsets() {  
		return new Insets(40,10,10,10); 
	}

	public static void main(String[] args) {
		new Selector();
	}
}
