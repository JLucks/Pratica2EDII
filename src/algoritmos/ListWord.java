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
public class ListWord {
    private CellWord first;
    private CellWord last;
    private int quantityElements;
    
    /**
     * @return the first
     */
    public CellWord getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(CellWord first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public CellWord getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(CellWord last) {
        this.last = last;
    }
    
    public void addWord(Word elemento) {
        CellWord nova = new CellWord(elemento);
        if (this.quantityElements == 0) {
            this.first = nova;
            this.last = this.first;
        } else {
            this.last.setNext(nova);
            this.last = nova;      
        }
        this.quantityElements++;
    }
    
    public Word search(String elemento) {
        CellWord atual = this.first;
        while (atual != null) {
            if (atual.getWord().getWord().equals(elemento)) {
                break;
            }
            atual = atual.getNext();
        }
        return atual.getWord();
    }
}
