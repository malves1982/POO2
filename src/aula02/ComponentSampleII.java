package aula02;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.Toolkit;

public class ComponentSampleII extends Frame {

	Dimension d;
	Panel nortPanel, centerPanel, 
	      southPanel,  westPanel;
	
	Scrollbar scroll;
	
	CheckboxGroup cbg;
	
	Checkbox check1,
			 check2,
			 check3,
			 check4;
	
	Choice choice;
	List lista;
	
	ComponentSampleII(){
		// criando o painel superior (norte)
		nortPanel = new Panel();
		scroll = new Scrollbar(Scrollbar.HORIZONTAL);
		scroll.setPreferredSize(new Dimension(200, 20));
		nortPanel.add(scroll);
		add(nortPanel, BorderLayout.NORTH);
		
		// criando o painel esquerdo (oeste)
		westPanel = new Panel();
		choice = new Choice();
		choice.addItem("gasolina");
		choice.addItem("álcool");
		choice.addItem("gás");
		choice.addItem("diesel");
		choice.addItem("cerveja");
		westPanel.add(choice);
		add(choice, BorderLayout.WEST);
		
		// criando o painel central
		centerPanel = new Panel();
		lista = new List(5, true);
		lista.add("Vectra");
		lista.add("Omega");
		lista.add("Veyron");
		lista.add("Audi A6");
		lista.add("Rav 4");
		lista.add("Eclipse");
		centerPanel.add(lista);
		add(lista, BorderLayout.CENTER);
		
		// criando o painel inferior
		southPanel = new Panel();
                cbg = new CheckboxGroup();
		check1 = new Checkbox("ar", cbg, false);
		check2 = new Checkbox("vidro");
		check3= new Checkbox("direção");
		check4 = new Checkbox("rodas", cbg, true);	
		southPanel.add(check1);
		southPanel.add(check2);
		southPanel.add(check3);
		southPanel.add(check4);
			
		add(southPanel, BorderLayout.SOUTH);
		
		setSize(300, 400);
		setVisible(true);
		centralizaFrameNaTela();
	}
	
	
	/**
	 * Método que centraliza uma janela na tela. 
	 * Precisa ser chamado DEPOIS que a janela esteja com suas dimensões definidas.
	 */
	private void centralizaFrameNaTela(){
		int x = this.getSize().width/2;  // largura do frame
		int y = this.getSize().height/2; // altura do frame
		
		d = (Toolkit.getDefaultToolkit()).getScreenSize();
		int cx = d.getSize().width/2;   // coordenadas do centro da tela
		int cy = d.getSize().height/2;		
		
		this.setLocation(cx - x, cy - y);
	}
	
	public static void main(String[] args) {
		ComponentSampleII cs2 = new ComponentSampleII();
	}
}
