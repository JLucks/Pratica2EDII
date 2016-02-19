/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import interfaces.Home;
import javax.swing.JFrame;

/**
 *
 * @author Jorge
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static final String nome = "Looking Words";	//Nome da janela
    public static JFrame janela = new JFrame(nome);
    
    public static void main(String[] args) {
        janela.setSize(615,460);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new Home());
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    
}
