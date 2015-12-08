package aula03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Verifica implements ActionListener {
	
	// constantes que identificam os tipos de documento que podem
	// ser verificados pelos m�todos dessa class
	final static int RG = 0,
	                CPF = 1,
	               CNPJ = 2;
	
	public static boolean documentoValido(int docType){
		switch (docType) {		
		case RG: //return verificaRG();
			break;
			
		case CPF: //return verificaCPF();
			break;
			
		case CNPJ: //return verificaCNPJ();
			break;
		}
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
