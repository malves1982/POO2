package aula03;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Seleciona aleatoriamente uma palavra positiva em uma lista
 * delas e exibe em um label que foi recebido como argumento
 * no construtor.
 * @author Reginaldo
 */
public class PositiveWords 
implements ActionListener {
	
	Label label;
	
	String[] list = {"saúde", "riqueza", "sucesso", "felicidade", "paz", 
			         "amor", "união", "amizade", "alegria", "cooperação", 
			         "gratidão", "sinceridade", "honestidade", "harmonia", "fé" };
	
	PositiveWords(Label label){
		this.label = label;
	}
	
	private String getWord(){
		int k = (int)((Math.random()*100)%list.length);
		return list[k];
	}

	public void actionPerformed(ActionEvent e) {
		label.setText(getWord());
	}
}
