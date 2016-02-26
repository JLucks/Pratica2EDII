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
public class BinaryT {
    
    private NoBinary root;
    
    public void insertBinaryT(Object T, NoBinary x, Word element){
        //Se for o primeiro nó vira Raiz
        if(getRoot() == null)
            setRoot(x);
        else if(x.getElement().compareTo(x.getElement()) < 0){
            //Se tiver elemento continua
            if(x.getLeft() != null)
                insertBinaryT(T, x.getLeft(), element);
            //Se estiver vazio insere
            else{
                x.getLeft().setElement(element);
            }
        }
        else{
            if(x.getRight() != null)
                insertBinaryT(T, x.getRight(), element);
            else{
                x.getRight().setElement(element);
            }
        }
        
    }
    
    public Word searchBinaryT(String element){
        
        NoBinary atual = getRoot();
        
        while (atual != null) {
            if (!atual.getElement().getWord().equals(element)) {
                if(atual.getElement().getWord().compareTo(element) < 0){
                 atual = atual.getLeft();
                }
                else{
                    atual = atual.getRight();
                }
            } else {
                break;
            }
        }
            
        if(atual == null)
            return null;
        else
            return atual.getElement();
    }

    public NoBinary getRoot() {
        return root;
    }

    public void setRoot(NoBinary root) {
        this.root = root;
    }
}