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
public class CellWord {
    private Word word;
    private CellWord next;

    public CellWord(Word word){
        this.word = word;
    }
    
    /**
     * @return the word
     */
    public Word getWord() {
        return word;
    }

    /**
     * @return the next
     */
    public CellWord getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(CellWord next) {
        this.next = next;
    }
    
}
