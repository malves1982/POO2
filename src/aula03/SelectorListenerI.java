package aula03;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorListenerI 
implements ActionListener {
	
	List origem, destino;
	
	SelectorListenerI(List origem, List destino){
		this.destino = destino;
		this.origem = origem;
	}
	
	private void passName(List listaA, List listaB){
		String item = "";
		try {
			item = listaA.getSelectedItem();
			
			if(item.length() > 0){
				listaB.add(item);			
				listaA.remove(item);
			}
		} catch (Exception e1) {}
	}

	public void actionPerformed(ActionEvent e) {
		passName(origem, destino);
	}
}
