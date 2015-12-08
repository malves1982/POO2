package aula03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Verificador extends Frame 
implements ActionListener{

	Panel northPanel = new Panel();
	Panel centerPanel = new Panel();
	TextField entrada = new NumericField('x');
	Label numLb = new Label("Número do documento");
	Label result = new Label();
	
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox cb1 = new Checkbox("R.G.", cbg, true),
	         cb2 = new Checkbox("C.P.F", cbg, false),
	         cb3 = new Checkbox("C.N.P.J", cbg, false);
	
	Button b = new Button("verificar");
	String s = "";
	
	Verificador(){
		setBackground(Color.yellow);
		northPanel.setPreferredSize(new Dimension(50, 40));
		entrada.setPreferredSize(new Dimension(150, 20));
		numLb.setAlignment(Label.LEFT);				
		northPanel.add(numLb);
		northPanel.add(entrada);
		add(northPanel, BorderLayout.NORTH);
		
		centerPanel.add(cb1);
		centerPanel.add(cb2);
		centerPanel.add(cb3);
		
		result.setAlignment(Label.CENTER);
		result.setForeground(Color.red);
		result.setPreferredSize(new Dimension(390, 20));
		centerPanel.add(result);		
		
		add(centerPanel, BorderLayout.CENTER);
		
		b.addActionListener(this);
		add(b, BorderLayout.SOUTH);
		
		setSize(400, 150);
		setVisible(true);
				
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private boolean verificaRg(String rg){
		int size = rg.length(), soma = 0, digit;
		
		if (size > 9 || size < 8)
			return false;
		
		if(size == 8)
			rg = "0" + rg;
		
		for (int i = 0; i < rg.length() - 1; i++) {
			digit = Integer.parseInt(rg.substring(i, i+1));
			soma += digit*(i + 2);
		}
		if(rg.substring(size-1, size).equals("x"))
			soma += 100;
		else{
			digit = Integer.parseInt(rg.substring(size-1, size));
			soma += 100*digit;
		}
		
		if(soma%11 == 0)
			return true;
		
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		Checkbox c = cbg.getSelectedCheckbox();
		String s = entrada.getText();
		
		if(c == cb1)
			if(verificaRg(s)){
				result.setText("RG válido");
				return;
			}
		
		if(c == cb2)
			if(CPF.CPF(s)){
				result.setText("CPF válido");
				return;
			}
		
		if(c == cb3)
			if(CNPJ.CNPJ(s)){
				result.setText("CNPJ válido");
				return;
			}
		
		
		
		result.setText("Documento inválido");
	}

	
	public static void main(String[] args) {
		new Verificador();
	}
}

/*  Refer�ncias na Web  (29/01/2007)
 *  http://www.javafree.org/javabb/viewtopic.jbb?t=853876
 *  http://www.profcardy.com/artigos/rg.php
 *  http://www.profcardy.com/artigos/cpf.php
 */
