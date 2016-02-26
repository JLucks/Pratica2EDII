/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import base.Word;

/**
 *
 * @author Jorge
 */
public class TreeRNWord {
    private NoRN root;
    private NoRN nil;
    
    public TreeRNWord(){
        this.nil = new NoRN();
        this.root = this.nil;
    }
    
    private void leftRotate(NoRN x){
        NoRN y = x.getRight();
        x.setRight(y.getLeft());
        y.getLeft().setDad(x);
        y.setDad(x.getDad());
        if(x.getDad().equals(getNil())){ 
            setRoot(y);
        }
        else{
            if(x.equals(x.getDad().getLeft())){
                x.getDad().setLeft(y);
            }
            else{
                x.getDad().setRight(y);
            }
        }
        y.setLeft(x);
        x.setDad(y);
    }
    
    private void rightRotate(NoRN x){ 
        NoRN y = x.getLeft();
        x.setLeft(y.getRight());
        y.getRight().setDad(x);
        y.setDad(x.getDad());
        if(x.getDad().equals(getNil())){
            setRoot(y);
        }
        else{
            if(x.equals(x.getDad().getRight())){
                x.getDad().setRight(y);
            }
            else{
                x.getDad().setLeft(y);
            }
        }
        y.setRight(x);
        x.setDad(y);
    }
    
    public void insertRN(Word word){
        NoRN z = new NoRN(word);
        NoRN y = getNil();
        NoRN x = getRoot(); 
        while(!x.equals(getNil())){
            y = x;
            if(z.getElement().compareTo(x.getElement()) < 0){
                x = x.getLeft();
            }
            else{
                x = x.getRight();
            }
        }
        z.setDad(y);
        if(y.equals(getNil())){
            setRoot(z);
        }
        else{
            if(z.getElement().compareTo(y.getElement()) < 0){
                y.setLeft(z);
            }
            else{
                y.setRight(z);
            }
        }
        z.setLeft(getNil()); 
        z.setRight(getNil()); 
        z.setCor(true);
        insertFixupRN(z);
    }
    
    private void insertFixupRN(NoRN z){
        NoRN y;
        while(z.getDad().isCor()){
            if(z.getDad().equals(z.getDad().getDad().getLeft())){
                y = z.getDad().getDad().getRight();
                if(y.isCor()){
                    z.getDad().setCor(false);
                    y.setCor(false);
                    z.getDad().getDad().setCor(true);
                    z = z.getDad().getDad();
                }
                else if(z.equals(z.getDad().getRight())){
                    z = z.getDad();
                    leftRotate(z);
                    z.getDad().setCor(false);
                    z.getDad().getDad().setCor(true);
                    rightRotate(z.getDad().getDad());
                }
            }
            else if(z.getDad().equals(z.getDad().getDad().getRight())){
                y = z.getDad().getDad().getLeft();
                if(y.isCor()){
                    z.getDad().setCor(false);
                    y.setCor(false);
                    z.getDad().getDad().setCor(true);
                    z = z.getDad().getDad();
                }
                else if(z.equals(z.getDad().getLeft())){
                    z = z.getDad();
                    rightRotate(z);
                    z.getDad().setCor(false);
                    z.getDad().getDad().setCor(true);
                    leftRotate(z.getDad().getDad());
                }
            }
        }
        getRoot().setCor(false);
    }

    public Word searchRN(String element){
        NoRN atual = getRoot();
        while (!atual.equals(getNil())) {
            if (!atual.getElement().getWord().equals(element)) {
                if(atual.getElement().getWord().compareTo(element) > 0){
                 atual = atual.getLeft();
                }
                else{
                    atual = atual.getRight();
                }
            } else {
                break;
            }
        }            
        if(atual.equals(getNil()))
            return null;
        else
            return atual.getElement();
    }
    
    /**
     * @return the root
     */
    public NoRN getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(NoRN root) {
        this.root = root;
    }

    /**
     * @return the nil
     */
    public NoRN getNil() {
        return nil;
    }

    /**
     * @param nil the nil to set
     */
    public void setNil(NoRN nil) {
        this.nil = nil;
    }
}
