/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;



/**
 *
 * @author malves
 */
public class LoginGrid {
    Frame f = new Frame();
    Panel pEmail = new Panel();
    Panel pSenha = new Panel();
    Panel pLogin = new Panel();
    
    public LoginGrid() {
        f.setSize(300, 200);
        f.setLocation(100, 100);
        f.setTitle("Login");
        f.setResizable(true);
        f.setVisible(true);
        f.setLayout(new GridLayout(3,2));
        
        Label labelEmail = new Label("Email:");
        TextField textFieldEmail = new TextField();
        Label labelSenha = new Label("Senha:");
        TextField textFieldSenha = new TextField();
        Button buttonLogin = new Button("Login");
        
        f.add(labelEmail);
        f.add(textFieldEmail);
        
        f.add(labelSenha);
        f.add(textFieldSenha);
        
        f.add(buttonLogin);
        
    }
    
    public static void main(String[] args) {
        LoginGrid login = new LoginGrid(); 
    }
    
}
