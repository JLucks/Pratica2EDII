/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import base.Word;

/**
 *
 * @author Daniel
 */
public class TreeAVLWord {
    
    private NoAVL root;
    
    // Inserção na Árvore AVL
    public void insertAVL(NoAVL x, Word element){
        // Se for o primeiro nó vira Raiz
        if(x == null)
            setRoot(new NoAVL(element, null));
        // Se o nó atual for maior que o novo, vai para esquerda
        else if(x.getElement().compareTo(element) > 0){
            // Se tiver elemento continua
            if(x.getLeft() != null)
                insertAVL(x.getLeft(), element);
            // Se estiver vazio insere, o pai é o nó atual
            else{
                x.setLeft(new NoAVL(element, x));
                balanceAVL(x);
            }
        }
        // Se o nó atual for menor que o novo, vai para esqueda
        else{
            if(x.getRight() != null)
                insertAVL(x.getRight(), element);
            else{
                x.setRight(new NoAVL(element, x));
                balanceAVL(x);
            }
        }
        
    }
    
    // Rotação para Direita
    public NoAVL rotateRight(NoAVL y){
        NoAVL x = y.getLeft();
        y.setLeft(x.getRight());
        x.setRight(y);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight()))+1);
        x.setHeight(Math.max(getHeight(x.getLeft()), y.getHeight())+1);
        return x;
    }
    
    // Rotação para Esquerda
    public NoAVL rotateLeft(NoAVL x){
        NoAVL y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight()))+1);
        y.setHeight(Math.max(getHeight(y.getRight()), x.getHeight())+1);
        return y;
    }
    
    // Rotação Simples Esquerda + Rotação Simples Direita
    public NoAVL rotateDoubleRight(NoAVL x){
        x.setLeft(rotateLeft(x.getLeft()));
        return rotateRight(x);
    }
    
    // Rotação Simples Direita + Rotação Simples Esquerda
    public NoAVL rotateDoubleLeft(NoAVL x){
        x.setRight(rotateRight(x.getRight()));
        return rotateLeft(x);
    }
    
    // Faz o Balanceamento
    public void balanceAVL(NoAVL x){
        
        // Se preciasa balancear, faz as rotações 
        if(balancingFactor(x) == 2){
            if(balancingFactor(x.getLeft()) == -1)
                x = rotateLeft(x.getLeft());
            x = rotateRight(x);
        }
        else if(balancingFactor(x) == -2){
            if(balancingFactor(x.getRight()) == -1)
                x = rotateRight(x.getRight());
            x = rotateLeft(x);
        }
        
        // Se ainda não chegamos na raiz, continuamos a balancear
        if(x.getParent() != null){
            balanceAVL(x.getParent());
        }
        // Se chegamos, atualiza a nova raiz
        else{
            setRoot(x);
        }
    }
    
    // Fator de Balanceamento
    public int balancingFactor(NoAVL x){
        return getHeight(x.getLeft())-getHeight(x.getRight());
    }
    
    // Retorna a altura
    public int getHeight(NoAVL x){
        if(x == null)
            return -1;
        int h1 = getHeight(x.getLeft());
        int h2 = getHeight(x.getRight());
        
        return (1+Math.max(h1,h2));
    }
    
    // Busca na Árvore AVL
    public Word searchAVL(String element){
        NoAVL cur = getRoot();
        while (cur != null) {
            if (!cur.getElement().getWord().equals(element)) {
                if(cur.getElement().getWord().compareTo(element) > 0){
                 cur = cur.getLeft();
                }
                else{
                    cur = cur.getRight();
                }
            } else {
                break;
            }
        }            
        if(cur == null)
            return null;
        else
            return cur.getElement();
    }

    public NoAVL getRoot() {
        return root;
    }

    public void setRoot(NoAVL root) {
        this.root = root;
    }
    
}
