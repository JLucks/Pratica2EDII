/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @authors Jorge & Daniel
 */
public class AddressDoc {
    //Variaveis
    private String idDoc;   //Id do documento
    private String address; //Caminho para o documento
    private int numberWords;    //Numero de termos no documento

    public AddressDoc(String idDoc, String address){
        this.idDoc = idDoc;
        this.address = address;
        this.numberWords = 0;
    }
    
    public AddressDoc(String idDoc, String address, int numberWords){
        this.idDoc = idDoc;
        this.address = address;
        this.numberWords = numberWords;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the numberWords
     */
    public int getNumberWords() {
        return numberWords;
    }

    /**
     * @param numberWords the numberWords to set
     */
    public void setNumberWords(int numberWords) {
        this.numberWords = numberWords;
    }
    
    //Incrementa o numero de termos do documento
    public void addNumberWords() {
        this.numberWords++;
    }
}
