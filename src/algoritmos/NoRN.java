/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import base.*;

/**
 *
 * @author Jorge
 */
public class NoRN {
    private Word element;
    private NoRN dad, left, right;
    private boolean cor;
    
    public NoRN(Word element){
        this.element = element;
    }
    
    public NoRN(Word element, NoRN left, NoRN right){
        this.element = element;
        this.left = left;
        this.right = right;
        this.cor = false;
    }
}
