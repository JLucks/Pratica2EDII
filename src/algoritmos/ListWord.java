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
public class ListWord {
    //Variaveis
    private NoList first;   //Primeiro elemento da lista
    private NoList last;    //Ultimo elemento da lista
    private int quantityElements;   //Quantidade de elementos da lista
    
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
    
    //Função que adiciona uma Word na lista
    public void addWord(Word elemento) {
        NoList nova = new NoList(elemento); //Cria um novo no para a lista
        if (this.quantityElements == 0) {   //Verifica se a lista esta vazia
            this.first = nova;  //O primeiro elemento sera o novo
            this.last = this.first; //O ultimo elemento tambem sera o novo
        } else {
            this.last.setNext(nova);    //Insere o novo elemento apos o ultimo
            this.last = nova;   //O ultimo elemento sera o novo
        }
        this.quantityElements++;    //Incrementa a quantidade de elementos da lista
    }
    
    //Função que procura uma palavra na lista
    public Word search(String elemento) {
        NoList atual = this.first;  //Cria uma variavel no para percorrer a lista
        while (atual != null) { //Enquanto não terminar a lista
            if (atual.getWord().getWord().equals(elemento)) {   //Verifico se o elemento tem a palavra da busca
                break;  //Caso tenha para e vai embora com o no que contem a palavra
            }
            atual = atual.getNext();    //O no percorre vai para o proximo
        }
        if(atual == null)   //Caso tenha terminado a lista
            return null;    //Retorna vazio
        return atual.getWord(); //Retorna o no encontrado
    }
}
