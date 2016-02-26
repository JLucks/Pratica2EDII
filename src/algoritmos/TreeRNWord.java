/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Jorge
 */
public class TreeRNWord {
    private NoRN root;
    private NoRN nil;
    
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
    
    public void insertRB(Object T, NoRN z){
        NoRN y = getNil();
        NoRN x = getRoot(); 
        while(!x.equals(getNil())){
            x = y;
            if(z.getElement().compareTo(x.getElement()) < 0){
                x = x.getLeft();
            }
            else{
                x = x.getRight();
            }
        }
        z.setDad(y);
        if(y.equals(T)){
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
        insertFixupRB(z);
    }
    
    private void insertFixupRB(NoRN z){
        
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
