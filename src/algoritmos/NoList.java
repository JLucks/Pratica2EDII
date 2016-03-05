/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import base.*;

/**
 *
 * @authors Jorge & Daniel
 */
public class NoList {
    private Word word;
    private NoList next;

    public NoList(Word word){
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
    public NoList getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NoList next) {
        this.next = next;
    }
    
}
