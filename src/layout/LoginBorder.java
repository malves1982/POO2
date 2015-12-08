/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;



/**
 *
 * @author malves
 */
public class LoginBorder {
    Frame f = new Frame();
    Panel pEmail = new Panel();
    Panel pSenha = new Panel();
    Panel pLogin = new Panel();
    
    public LoginBorder() {
        f.setSize(300, 200);
        f.setLocation(100, 100);
        f.setTitle("Login");
        f.setResizable(true);
        f.setVisible(true);
        
        Label labelEmail = new Label("Email:");
        TextField textFieldEmail = new TextField();
        Label labelSenha = new Label("Senha:");
        TextField textFieldSenha = new TextField();
        Button buttonLogin = new Button("Login");
        
        pEmail.add(labelEmail);
        pEmail.add(textFieldEmail);
        
        pSenha.add(labelSenha);
        pSenha.add(textFieldSenha);
        
        pLogin.add(buttonLogin);
        
        f.add(pEmail, BorderLayout.NORTH);
        f.add(pSenha, BorderLayout.CENTER);
        f.add(pLogin, BorderLayout.SOUTH);
    }
    // comemasa
    public static void main(String[] args) {
        LoginBorder login = new LoginBorder(); 
    }
    
}
