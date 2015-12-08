package aula03;

/*
 * Um RGBColorChooser mostra tr�s barras de rolagem que o usu�rio pode manipular
 * para determinar os componentes RGB de uma cor.
 * 230 230 210
 */

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class RGBColorChooser extends Applet 
implements AdjustmentListener { 

	private Scrollbar redScroll, 
	greenScroll, blueScroll; // Scroll bars. 

	private Label redLabel, 
	greenLabel, blueLabel; // For displaying RGB values. 

	private Canvas colorCanvas; // �rea de exibi��o das cores. 

	public void init() { 

		/*  
		 * O construtor usado cria "uma barra" com valor inicial 0,
		 * de largura 10 pixels, valor m�ni,o poss�vel 0 e m�ximo 265
		 * como a barra de rolagem tem 10 pixels, seu canto inferior
		 * esquerdo d� pode chegar ate 255 (valor m�ximo em RGB)
		 */ 
		redScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265); 
		greenScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265); 
		blueScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265); 

		/* Create Labels showing current RGB and HSB values. */ 
		redLabel = new Label(" R = 0"); 
		greenLabel = new Label(" G = 0"); 
		blueLabel = new Label(" B = 0"); 

		/* Set background colors for Scrollbars and Labels, so they don't 
   		   inherit the gray background of the applet. 
   		 */ 

		redScroll.setBackground(Color.lightGray); 
		greenScroll.setBackground(Color.lightGray);
		blueScroll.setBackground(Color.lightGray); 

		redLabel.setBackground(Color.white); 
		greenLabel.setBackground(Color.white); 
		blueLabel.setBackground(Color.white); 

		/* Set the applet to listen for changes to the Scrollbars' values */ redScroll.addAdjustmentListener(this); 
		greenScroll.addAdjustmentListener(this); 
		blueScroll.addAdjustmentListener(this); 

		/* Create a canvas whose background color will always be set to the currently selected color. */ colorCanvas = new Canvas(); 
		colorCanvas.setBackground(Color.black); 

		/* Create the applet layout, which consists of a row of three equal-sized regions holding the Scrollbars, the Labels, and the color patch. The background color of the applet is gray, which will show around the edges and between components. */ 

		setLayout(new GridLayout(1,3,3,3)); 
		setBackground(Color.gray); 

		Panel scrolls = new Panel(); 
		Panel labels = new Panel(); 
		add(scrolls); 
		add(labels); 
		add(colorCanvas); 

		/* Add the Scrollbars and the Labels to their respective panels. */ 

		scrolls.setLayout(new GridLayout(3,1,2,2)); 
		scrolls.add(redScroll); 
		scrolls.add(greenScroll); 
		scrolls.add(blueScroll); 


		labels.setLayout(new GridLayout(3,1,2,2)); 
		labels.add(redLabel); 
		labels.add(greenLabel); 
		labels.add(blueLabel); 
		
		setSize(new Dimension(500,100));
		// curiosamente, aqui n�o funcionou setPreferredSize() !!!
	} // end init(); 


	public void adjustmentValueChanged(AdjustmentEvent evt) { 
		// chamado quando o usu�rio modifica o valor de uma das
		// barras de rolagem


		int r = redScroll.getValue(); 
		int g = greenScroll.getValue(); 
		int b = blueScroll.getValue(); 
		redLabel.setText(" R = " + r); 
		greenLabel.setText(" G = " + g); 
		blueLabel.setText(" B = " + b); 
		colorCanvas.setBackground(new Color(r,g,b)); 
		colorCanvas.repaint(); 
		// Redraw the canvas in its new color. 
		
	} // end adjustmentValueChanged 


	public Insets getInsets() { 
		// Determina quanto espa�o ser� deixado entre as margens
		// do conteiner e os cantos dos componentes
		return new Insets(3,3,3,3); 
	} 
} // end class RGBColorChooser 