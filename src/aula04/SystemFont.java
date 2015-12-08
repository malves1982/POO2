package aula04;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

/*
 * Existem tr�s tipos de nomes de fonte.   O nome l�gico da fonte � o nome usado
 * para construir a fonte e n�o mais falaremos dele.   O nome da face da fonte �
 * o que indica uma fonte espec�fica... � esse que nos interessa.  Por exemplo,
 * Comic Sans ou Monotype Corsiva.    E o nome da fam�lia de fontes, que determina
 * o projeto tipogr�fico b�sico de v�rias fontes, como Helv�tica, Arial, etc.
 */

public class SystemFont {
	public static void main(String[] args) {
		String[] listaFonte = (Toolkit.getDefaultToolkit()).getFontList();
		
		int k = listaFonte.length;
		
		System.out.println("Total de fam�lias de fontes do sistema: " + k + "\n");
		
		for (int i = 1; i <= k; i++) {
			System.out.println("Fam�lia " + i + ": " + listaFonte[i-1]);
		}
		
		
		Font listaDeFontes[ ] = GraphicsEnvironment.
		                        getLocalGraphicsEnvironment( ).
		                        getAllFonts();
		
		k = listaDeFontes.length;
		
		
		System.out.println("\n\nTotal de fontes do sistema: " + k + "\n");
		
		for (int i = 1; i <= k; i++) {
			System.out.println("Face " + i + ": " + listaDeFontes[i-1].getFontName());
		}
	}
}
