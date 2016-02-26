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
    private NoList first;
    private NoList last;
    private int quantityElements;
    
    /**
     * @return the first
     */
    public NoList getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NoList first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NoList getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NoList last) {
        this.last = last;
    }
    
    public void addWord(Word elemento) {
        NoList nova = new NoList(elemento);
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
        NoList atual = this.first;
        while (atual != null) {
            if (atual.getWord().getWord().equals(elemento)) {
                break;
            }
            atual = atual.getNext();
        }
        if(atual == null)
            return null;
        return atual.getWord();
    }
}
