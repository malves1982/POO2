/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;



/**
 *
 * @author malves
 */
public class LoginNull {
    Frame f = new Frame();
    Panel p = new Panel();
    
    public LoginNull() {
        f.setSize(300, 200);
        f.setLocation(100, 100);
        f.setTitle("Login");
        f.setResizable(true);
        f.setVisible(true);
        //f.setLayout(null);
        
        p.setLayout(null);
        
        Label labelEmail = new Label("Email:");
        labelEmail.setLocation(10, 10);
        labelEmail.setSize(80,25);
        
        TextField textFieldEmail = new TextField();
        textFieldEmail.setLocation(90, 10);
        textFieldEmail.setSize(80,25);
        
        Label labelSenha = new Label("Senha:");
        labelSenha.setLocation(10, 40);
        labelSenha.setSize(80,25);
        
        TextField textFieldSenha = new TextField();
        textFieldSenha.setLocation(90, 40);
        textFieldSenha.setSize(80,25);
        
        Button buttonLogin = new Button("Login");
        buttonLogin.setLocation(10, 70);
        buttonLogin.setSize(80,25);
        
        p.add(labelEmail);
        p.add(textFieldEmail);
        p.add(labelSenha);
        p.add(textFieldSenha);
        p.add(buttonLogin);
        
//        f.add(labelEmail);
//        f.add(textFieldEmail);
//        
//        f.add(labelSenha);
//        f.add(textFieldSenha);
//        
//        f.add(buttonLogin);
        
        f.add(p);
    }
    
    public static void main(String[] args) {
        LoginNull login = new LoginNull(); 
    }
    
}
