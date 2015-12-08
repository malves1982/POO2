/*
 * Este programa demonstra v�rios gerenciadores de leiaute.  O frame que o cont�m
 * usa borderLayaout com um painel no centro, um choice no norte e um label no sul.
 * O painel do centro usa cardLayout.   Cada "cart�o" do cardLayout cont�m alguns
 * bot�es e usa um gerenciador de leiaute diferente.   O choice � usado para selecionar
 * entre os v�rios cart�es.   O label exibe o evento ocorrido.
 */
package aula05.layout;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LayoutDemo extends Applet 
implements ItemListener, ActionListener { 
	CardLayout cards; // the layout manager for the center panel 
	Panel cardPanel; // the center panel 
	Label message; // a message shown at the bottom of the applet 

	public void init() { 
		setBackground(Color.blue); 
		Choice panelChoice = new Choice(); // Set up the "Choice" menu 
		panelChoice.setBackground(Color.white); 
		panelChoice.addItemListener(this); 
		panelChoice.add("FlowLayout"); // Add in the names of the cards. 
		panelChoice.add("FlowLayout with Big Hgap"); 
		panelChoice.add("BorderLayout"); 
		panelChoice.add("GridLayout(3,2)"); 
		panelChoice.add("GridLayout(1,0)"); 
		panelChoice.add("GridLayout(0,1)"); 
		message = new Label("Layout Demo", Label.CENTER); // Set up the mesage 
		message.setBackground(Color.white); 
		message.setForeground(Color.red); 

		cardPanel = new Panel(); // Set up the center panel 
		cardPanel.setBackground(Color.white); 
		cards = new CardLayout(); 
		cardPanel.setLayout(cards); 
		setLayout(new BorderLayout(3,3)); // Lay out the applet as a whole 
		add("Center",cardPanel); 
		add("North",panelChoice); 
		add("South",message); 

		Panel panel; 
//		will represent various cards to be added to the center panel 
//		Set up each "card" in the center panel to have its own layout 
//		manager and to contain a variety of buttons. 

		panel = new Panel(); // use default FlowLayout for panel 
		cardPanel.add(panel, "FlowLayout"); 
		addButton(panel,"First Button"); // ( addButton is a untility method, defined below )
		addButton(panel,"Second Button"); 
		addButton(panel,"Third Button"); 
		addButton(panel,"Fourth Button"); 
		addButton(panel,"Fifth Button"); 
		addButton(panel,"Sixth Button"); 
		addButton(panel,"Seventh Button"); 

		panel = new Panel(); 
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,30000,5)); 
		cardPanel.add(panel,"FlowLayout with Big Hgap"); 
		addButton(panel," A Button"); 
		addButton(panel,"Another Button"); 
		addButton(panel,"A Third Button"); 
		addButton(panel,"A Fourth Button"); 
		addButton(panel,"A Final Button"); 

		panel = new Panel(); 
		panel.setLayout(new BorderLayout()); 
		cardPanel.add(panel,"BorderLayout"); 
		addButton(panel,"Center Button", BorderLayout.CENTER); 
		addButton(panel,"North Button", BorderLayout.NORTH); 
		addButton(panel,"South Button", BorderLayout.SOUTH); 
		addButton(panel,"East Button", BorderLayout.EAST); 
		addButton(panel,"West Button", BorderLayout.WEST); 

		panel = new Panel(); 
		panel.setLayout(new GridLayout(5,4,5,5)); 
		cardPanel.add(panel,"GridLayout(3,2)"); 
		
		for(int i = 0; i < 20; i++){
			addButton(panel,"Button "+String.valueOf(i+1));
		}

		panel = new Panel(); 
		panel.setLayout(new GridLayout(1,0)); 
		cardPanel.add(panel,"GridLayout(1,0)"); 
		
		for(int i = 0; i < 10; i++){
			addButton(panel,"Button "+String.valueOf(i));
		}


		panel = new Panel(); 
		panel.setLayout(new GridLayout(0,1)); 
		cardPanel.add(panel,"GridLayout(0,1)"); 
		addButton(panel,"Button 1"); 
		addButton(panel,"Button 2"); 
		addButton(panel,"Button 3"); 
		addButton(panel,"Button 4"); 
		addButton(panel,"Button 5"); 
		addButton(panel,"Button 6"); 
	} // end init() 

	public Insets getInsets() { // specify borders around the edges of the applet 
		return new Insets(3,3,3,3); 
	} 

	void addButton(Panel p, String name) { 
		// Create a button with the given name and add it 
		// to the given panel. Set up the button to send 
		// events to the applet. 

		Button b = new Button(name); 
		p.add(b); 
		b.addActionListener(this); 
	} 

	void addButton(Panel p, String name, Object option) { 
		// Same as above, but use the "option" object 
		// as an additional parameter in the add method. 
		Button b = new Button(name); 
		p.add(b, option); 
		b.addActionListener(this); 

	} 

	public void actionPerformed(ActionEvent evt) { 
		// A button was pressed. Report the name 
		// of the button by setting the message text. 
		String buttonName = evt.getActionCommand(); 
		message.setText("Button \"" + buttonName + "\" was pressed."); 

	} 

	public void itemStateChanged(ItemEvent evt) { 
		// A selection was made from the "Choice" menu. 
		// Show the card with the same name, and report 
		// the event by setting the message text. 
		String panelName = (String)evt.getItem(); 
		cards.show(cardPanel, panelName); 
		message.setText("Panel \"" + panelName + "\" was selected."); 
	} 
} // end class LayoutDemo