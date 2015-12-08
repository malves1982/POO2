package aula02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIWindow extends Frame
implements ActionListener {
	boolean inAnApplet = true;
	final String FILEDIALOGMENUITEM = "File dialog...";

	public GUIWindow() {
		Panel bottomPanel = new Panel();
		Panel centerPanel = new Panel();


		//Configura a barra de menu.
		MenuBar mb = new MenuBar();
		Menu m = new Menu("Menu");
		m.add(new MenuItem("Menu item 1"));
		m.add(new CheckboxMenuItem("Menu item 2"));
		m.add(new MenuItem("Menu item 3"));
		m.add(new MenuItem("-"));

		MenuItem fileMenuItem = new MenuItem(FILEDIALOGMENUITEM);
		fileMenuItem.addActionListener(this);
		m.add(fileMenuItem);

		mb.add(m);
		setMenuBar(mb);


		//insere os objetos menores no final do frame.
		bottomPanel.add(new TextField("TextField"));
		bottomPanel.add(new Button("Button"));
		bottomPanel.add(new Checkbox("Checkbox"));
		Choice c = new Choice();
		c.add("Choice Item 1");
		c.add("Choice Item 2");
		c.add("Choice Item 3");
		bottomPanel.add(c);
		add("South", bottomPanel);


		//Insere os objetos maiores na parte central da janela
		centerPanel.setLayout(new GridLayout(1,2));


		//Insere um canvas na coluna esquerda da região central
		centerPanel.add(new MyCanvas());


		//Insere um label na coluna direita da região central
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add("North", new Label("Label", Label.CENTER));
		p.add("Center", new TextArea("TextArea", 5, 20));
		centerPanel.add(p);
		add("Center", centerPanel);


		// Insere uma lista no lado direito da janela
		List l = new List(3, false);
		for (int i = 1; i <= 10; i++) {
			l.add("List item " + i);
		}
		add("East", l); 

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (inAnApplet) {
					dispose();
				} else {
					System.exit(0);
				}
			}
		});
	}


	public void actionPerformed(ActionEvent event) {
		// O único evento de ação tratado é a solicitação do
		// usuário por um FileDialog
		FileDialog fd = new FileDialog(this, "FileDialog");
		fd.setVisible(true);
	}


	public static void main(String[] args) {
		GUIWindow window = new GUIWindow();
		window.inAnApplet = false;

		window.setTitle("The AWT Components");
		window.pack();
		window.setVisible(true);
	}

}



//Não podemos apenas isntanciar um Canvas, já que sua implementação
//padrão não nos dá nada interessante para ver ou fazer.   Portanto,
//aqui está uma subclasse de Canvas que é um pouco mais interessante.
class MyCanvas extends Canvas {

	public void paint(Graphics g) {
		int w = getSize().width;
		int h = getSize().height;
		g.drawRect(0, 0, w - 1, h - 1);
		g.drawString("Canvas", (w - g.getFontMetrics().stringWidth("Canvas"))/2,
				10);

		g.setFont(new Font("Helvetica", Font.PLAIN, 8));
		g.drawLine(10,10, 100,100);
		g.fillRect(9,9,3,3);
		g.drawString("(10,10)", 13, 10);
		g.fillRect(49,49,3,3);
		g.drawString("(50,50)", 53, 50);
		g.fillRect(99,99,3,3);
		g.drawString("(100,100)", 103, 100);

		g.setFont(new Font("Helvetica", Font.PLAIN, 10));
		g.setColor(Color.red);
		String ime = "IME - USP";
		g.drawString(ime, (w - g.getFontMetrics().stringWidth(ime))/2, 120);
	}



	// Se não especificamos o tamanho mínimo, o canvas pode não aparecer
	// dependendo do gerenciador de leiaute utilizado
	public Dimension getMinimumSize() {
		return new Dimension(150,130);
	}


	// Se não especificamos o tamanho preferido, o canvas pode não aparecer
	// dependendo do gerenciador de leiaute utilizado
	public Dimension getPreferredSize() {
		return getMinimumSize();
	}
}