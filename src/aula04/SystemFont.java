package aula04;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

/*
 * Existem três tipos de nomes de fonte.   O nome lógico da fonte é o nome usado
 * para construir a fonte e não mais falaremos dele.   O nome da face da fonte é
 * o que indica uma fonte específica... é esse que nos interessa.  Por exemplo,
 * Comic Sans ou Monotype Corsiva.    E o nome da família de fontes, que determina
 * o projeto tipográfico básico de várias fontes, como Helvética, Arial, etc.
 */

public class SystemFont {
	public static void main(String[] args) {
		String[] listaFonte = (Toolkit.getDefaultToolkit()).getFontList();
		
		int k = listaFonte.length;
		
		System.out.println("Total de famílias de fontes do sistema: " + k + "\n");
		
		for (int i = 1; i <= k; i++) {
			System.out.println("Família " + i + ": " + listaFonte[i-1]);
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
