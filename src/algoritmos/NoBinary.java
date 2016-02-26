/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import base.*;

/**
 *
 * @author Daniel
 */
public class NoBinary {
    
    private Word element;                           //Dados do nó
    private NoBinary left, right;                   //Filhos
    
    public NoBinary(Word element){
        this.element = element;
    }
    
    public NoBinary(Word element, NoBinary left, NoBinary right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public Word getElement() {
        return element;
    }

    public void setElement(Word element) {
        this.element = element;
    }

    public NoBinary getLeft() {
        return left;
    }

    public void setLeft(NoBinary left) {
        this.left = left;
    }

    public NoBinary getRight() {
        return right;
    }

    public void setRight(NoBinary right) {
        this.right = right;
    }
    
    
    
}
