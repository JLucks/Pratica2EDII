/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Jorge
 */
public class WordInDoc {
    private String idDoc;
    private int quantity;

    public WordInDoc(String idDoc, int quantity){
        this.idDoc = idDoc;
        this.quantity = quantity;
    }
    
    /**
     * @return the idDoc
     */
    public String getIdDoc() {
        return idDoc;
    }

    /**
     * @param idDoc the idDoc to set
     */
    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
