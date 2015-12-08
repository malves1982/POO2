package aula03;

import java.awt.List;
import java.awt.event.ActionEvent;

public class SelectorListenerII extends SelectorListenerI {
	
	SelectorListenerII(List origem, List destino){
		super(origem, destino);
	}
	
	private void passAllNames(List listaA, List listaB){
		String item = "";
		int numItens = listaA.getItemCount();

		for (int i = 0; i < numItens; i++) {		
			item = listaA.getItem(0);
			listaB.add(item);			
			listaA.remove(item);			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		passAllNames(origem, destino);
	}
}
