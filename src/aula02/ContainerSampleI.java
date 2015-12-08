package aula02;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Window;

public class ContainerSampleI {

	// instanciação independente
	Frame f = new Frame();
	Panel p = new Panel();
	
	// instanciação dependente... esses caras PRECISAM de
	// um frame pai
	Window w;
	Dialog d;
	FileDialog fd;

	
	ContainerSampleI(){
		// preparando o frame
		f.setSize(400, 300);
		f.setLocation(100, 100);
		f.setTitle("Frame Principal");
		f.setResizable(true);
		f.setVisible(true);
		
		// adicionando o painel ao frame
		// maximize o frame principal e note o efeito da inserção do 
		// painel DEPOIS da chamada a setVisible(); 
		p.setBackground(Color.magenta);
		f.add(p);
		
		// o conteúdo de uma Window precisa ser desenhado
		w = new Window(f);
		w.setSize(150, 150);
		w.setBackground(Color.yellow);
		w.setVisible(true);		
		
		// o conteúdo de um Dialog precisa ser desenhado
		d = new Dialog(f, "Dialog");
		d.setSize(150, 150);
		d.setLocation(300, 200);
		d.setVisible(true);
		
		// o conteúdo de um FileDialog não precisa ser desenhado
		fd = new FileDialog(f, "File Dialog");
		fd.setVisible(true);
		fd.setLocation(50, 400);
	}
	
	
	public static void main(String[] args) {
		ContainerSampleI csi = new ContainerSampleI(); 
	}
}
