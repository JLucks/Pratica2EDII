/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Word {
    private String word;
    private ArrayList<WordInDoc> quantityByDocs;
    
    public Word(){
        this.quantityByDocs = new ArrayList<>();
    }
    
    public Word(String word, ArrayList<WordInDoc> quantityByDocs){
        this.word = word;
        this.quantityByDocs = quantityByDocs;
    }
    
    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return the quantityByDocs
     */
    public ArrayList<WordInDoc> getQuantityByDocs() {
        return quantityByDocs;
    }

    /**
     * @param wd the quantityByDocs to set
     */
    public void setQuantityByDocs(WordInDoc wd) {
        this.quantityByDocs.add(wd);
    }
}
