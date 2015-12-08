package aula02;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.Date;

public class CadastroII extends CadastroI {

	Dimension d;
	
	TextField nomeTf = new TextField(),
	          endTf  = new TextField(),
	          rgTf   = new TextField(),
	          cpfTf  = new TextField(),
	          mailTf = new TextField(),
	          profTf = new TextField();
	
	Choice dia = new Choice(),
	       mes = new Choice(),
	       ano = new Choice();
	
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox masCb = new Checkbox("Masculino", cbg, false),
	         femCb = new Checkbox("Feminino", cbg, false),
	         indCb = new Checkbox("Indefinido", cbg, false);
	
		
	CadastroII(Frame f){
		setLayout(null); // posicionamento absoluto
		
		d = f.getSize();
		configureLabel(false);
		setBackground(Color.yellow);
			
		linhaUm();
		linhaDois();
		linhaTres();
		linhaQuatro();
		linhaCinco();
		linhaSeis();
		linhaSete();
	}
	
	// construção das "linhas" do painel principal
	private void linhaUm(){
		addComponent(nomeLb, coluna(0), linha(1), 50, 20);
		addComponent(nomeTf, coluna(2), linha(1), 300, 20);
	}
	
	private void linhaDois(){
		addComponent(endLb, coluna(0), linha(2), 70, 20);
		addComponent(endTf, coluna(2), linha(2), 300, 20);
	}
	
	private void linhaTres(){
		cpfLb.setAlignment(Label.RIGHT);
		
		addComponent(rgLb, coluna(0), linha(3), 50, 20);
		addComponent(rgTf, coluna(2), linha(3), 90, 20);
		addComponent(cpfLb, coluna(5), linha(3), 50, 20);
		addComponent(cpfTf, coluna(7), linha(3), 100, 20);
	}
	
	private void linhaQuatro(){
		addComponent(mailLb, coluna(0), linha(4), 70, 20);
		addComponent(mailTf, coluna(2), linha(4), 300, 20);
	}
	
	private void linhaCinco(){
		addComponent(profLb, coluna(0), linha(5), 70, 20);
		addComponent(profTf, coluna(2), linha(5), 300, 20);
	}
	
	private void linhaSeis(){
		addComponent(sexoLb, coluna(0), linha(6), 50, 20);
		addComponent(femCb,  coluna(2), linha(6), 80, 20);
		addComponent(indCb,  coluna(5)-10, linha(6), 80, 20);
		addComponent(masCb,  coluna(8)-20, linha(6), 80, 20);
	}
	
	private void linhaSete(){
		dia.add("dia");
		mes.add("mes");
		ano.add("ano");
		int thisYear = new Date().getYear()+1900;

		configuraChoiceNumerico(dia, 1, 31);
		configuraChoiceNumerico(mes, 1, 12);
		configuraChoiceNumerico(ano, 1969, thisYear);
		
		addComponent(nascLb, coluna(0), linha(7), 120, 20);
		addComponent(dia,    coluna(3), linha(7), 60, 20);
		addComponent(mes,    coluna(5), linha(7), 60, 20);
		addComponent(ano,    coluna(7), linha(7), 60, 20);
	}
	
	
	private void configuraChoiceNumerico(Choice c, int start, int end){
		for (int i = start; i <= end ; i++) {
			c.add(String.valueOf(i));
		}		
	}
	
	private int linha(int num){
		return 30*num + 10;
	}
	
	private int coluna(int num){
		return 40*num + 10;
	}
	
	private void addComponent(Component c, int x, int y, int width, int height){
		c.setSize(width, height);
		c.setLocation(x, y);
		add(c);
	}
	
	public static void main(String[] args) {
		Frame f = new Frame("Aplicação Óbvia II");	
		f.setSize(410, 320);
		CadastroII c = new CadastroII(f);
		Dimension d;

		// centraliza o frame na tela independente das dimensões do monitor
		d = (Toolkit.getDefaultToolkit()).getScreenSize();
		f.setLocation(d.getSize().width/2  - 205, 
				      d.getSize().height/2 - 160);
		
		f.add(c);		
		f.setVisible(true);
	}
}
