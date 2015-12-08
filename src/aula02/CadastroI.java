package aula02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

public class CadastroI extends Panel {

	Label nomeLb = new Label("Nome:"),
	      rgLb   = new Label("R.G.:"),
	      cpfLb  = new Label("C.P.F.:"),
	      endLb  = new Label("Endereço:"),
	      compLb = new Label("Complemento:"),
	      mailLb = new Label("E-mail:"),
	      sexoLb = new Label("Sexo:"),
	      profLb = new Label("Profissão:"),
	      nascLb = new Label("Data de Nascimento:"),
	      idadeLb= new Label();
	
	Label[] listaLabel = {nomeLb, rgLb, endLb, compLb, mailLb, 
			              sexoLb, profLb, nascLb, idadeLb};
	
	
	CadastroI(){
		configureLabel(true);

	}
	
	/**
	 * Se receber b == true fazr com que todos os labels  
	 * da aplicação tenham as mesmas dimensões
	 * @param b
	 */
	void configureLabel(boolean b){
		for (int i = 0; i < listaLabel.length; i++) {
			if(b)
				listaLabel[i].setPreferredSize(new Dimension(125, 20));
			listaLabel[i].setForeground(Color.blue);
			add(listaLabel[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		Frame f = new Frame("Aplicação óbvia");
		CadastroI c = new CadastroI();
		
		f.add(c);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
}
