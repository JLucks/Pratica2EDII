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
public class TreeBinaryWord {
    
    private NoBinary root;
    
    // Insere na Ávore Binária
    public void insertB(NoBinary x, Word element){
        // Se for o primeiro nó, vira Raiz
        if(x == null)
            setRoot(new NoBinary(element));
        // Se o nó atual for maior que o novo, vai para esquerda
        else if(x.getElement().compareTo(element) > 0){
            // Se tiver elemento continua
            if(x.getLeft() != null)
                insertB(x.getLeft(), element);
            // Se estiver vazio insere
            else{
                x.setLeft(new NoBinary(element));
            }
        }
        // Senão, vai para direita
        else{
            if(x.getRight() != null)
                insertB(x.getRight(), element);
            else{
                x.setRight(new NoBinary(element));
            }
        }
        
    }
    
    // Busca na Árvore Binária
    public Word searchB(String element){
        NoBinary atual = getRoot(); //No que ira percorrer
        while (atual != null) { //Enquanto não for null
            if (!atual.getElement().getWord().equals(element)) {    //Verifica se é igual
                if(atual.getElement().getWord().compareTo(element) > 0){    //Verifica se é menor
                 atual = atual.getLeft();   //Vai para esquerda
                }
                else{
                    atual = atual.getRight();   //Vai para direita
                }
            } else {
                break;
            }
        }            
        if(atual == null)   //Verifica se não encontrou
            return null;
        else
            return atual.getElement();  //Retorna o elemento encontrado
    }

    public NoBinary getRoot() {
        return root;
    }

    public void setRoot(NoBinary root) {
        this.root = root;
    }
}
