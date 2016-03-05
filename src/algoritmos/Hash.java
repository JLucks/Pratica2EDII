/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import base.*;
import java.util.Random;

/**
 *
 * @authors Jorge & Daniel
 */
public class Hash {
    //Variaveis
    private int C;  //Limitar o tamanho da chave
    private int mode;   //O tipo de resolução de conflito
    private int M = 23; //Tamanho da tabela hash
    private int[] P;    //Array de pesos para fazer o hash das chaves
    private Object[] hash;  //Tabela hash
    
    //Função que inicia a tabela hash recebendo o limite de tamanho da chave e o modo de resolução de conflito da tabela
    public Hash(int C, int mode){
        Random generator = new Random();    //Inicia uma classe random para geração dos pesos
        this.C = C;
        this.mode = mode;
        startHash();    //Chamada a função que cria a tabela hash
        this.P = new int[C];
        for(int i = 0; i < C; i++)
            P[i] = generator.nextInt(C * M) + 1;    //Adiciona um peso de valor aleatorio a uma posição do array de pesos
    }
    
    //Função que cria o hash
    private void startHash(){
        switch(getMode()){  //Vericar o modo de resolução de conflito
        case 0: //Cria um array do tipo Lista no caso ListWord
            this.hash = new ListWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new ListWord();   //Inicializa cada posição do array com uma lista vazia
            break;
        case 1: //Cria um array do tipo Arvore Binaria no caso TreeBinaryWord
            this.hash = new TreeBinaryWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new TreeBinaryWord(); //Inicializa cada posição do array com uma arvore vazia
            break;
        case 2: //Cria um array do tipo Arvore AVL no caso TreeAVLWord
            this.hash = new TreeAVLWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new TreeAVLWord();    //Inicializa cada posição do array com uma arvore vazia
            break;
        default:    //Cria um array do tipo Arvore Rubro-Negra no caso TreeRNWord
            this.hash = new TreeRNWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new TreeRNWord(); //Inicializa cada posição do array com uma arvore vazia
            break;
        }
    }
    
    //Função inserir do hash que recebe um tipo Word
    public void insert(Word word){
        if(word.getWord().length() >= getC()){  //Verica se a palavra é maior que o limite minimo
            int index = index(word.getWord().substring(0, (getC()-1))); //Chamada a função index que retorna a posição relativa a C caracteres da palavra
            insertCollision(word, getHash()[index]);    //Chamada ao metodo que ira inserir na posição adequada com o modo de inserir da resolução de conflito escolhido
        }
    }
    
    //Função que procura uma palavra na tabela hash que recebe uma string
    public Word search(String word){
        Word result = null; //Conteiner do resultado da busca
        if(word.length() >= getC()){    //Verica se a palavra é maior que o limite minimo
            int index = index(word.substring(0, (getC()-1)));   //Chamada a função index que retorna a posição relativa a C caracteres da palavra
            result = searchCollision(word,getHash()[index]);    //Chamada ao metodo que ira buscar na posição adequada com o modo de busca da resolução de conflito escolhido
        }
        return result;
    }
    
    //Função que calcula o indice para C caracteres da chave
    private int index(String key){
        int sum = 0;
        for(int i = 0; i < key.length(); i++)
            sum += (int) key.charAt(i) * P[i];  //Gera um numero natural com soma de todos os caracteres da chave multiplicados por o peso relativo a posição dos mesmos
        return (sum % getM());  //Retorna o resto da divisao do numero gerado anteriormente, pelo tamanho da tabela 
    }
    
    //Função que insere na tabela usando a resolução de conflito escolhida, recebe a Word e a posição da tabela hash
    private void insertCollision(Word word, Object no){
        switch(getMode()){  //Verifica o modo de resolução
        case 0: //Tipo lista
            ListWord list =(ListWord) no;   //Converte a posição para o tipo lista
            list.addWord(word); //Usa o metodo da lista para adiconar
            break;
        case 1: //Tipo arvore binaria
            TreeBinaryWord binary = (TreeBinaryWord) no;    //Converte a posição para o tipo arvore binaria
            binary.insertB(binary.getRoot(), word); //Usa o metodo da arvore para adiconar  que recebe a raiz e a Word
            break;
        case 2: //Tipo avl
            TreeAVLWord avl = (TreeAVLWord) no; //Converte a posição para o tipo arvore avl
            avl.insertAVL(avl.getRoot(), word); //Usa o metodo da arvore para adiconar que recebe a raiz e a Word
            break;
        default:    //Tipo arvore rubro negra
            TreeRNWord rn = (TreeRNWord) no;    //Converte a posição para o tipo arvore rubro negra
            rn.insertRN(word);  //Usa o metodo da arvore para adiconar que recebe a Word
            break;
        }
    }
    
    //Função que procura na tabela usando a resolução de conflito escolhida, recebe a palavra e a posição da tabela hash
    private Word searchCollision(String word, Object no){
        Word result = null; //Conteiner do resultado da busca
        switch(getMode()){   //Verifica o modo de resolução
        case 0: //Tipo lista
            ListWord list =(ListWord) no;   //Converte a posição para o tipo lista
            result = list.search(word); //Usa o metodo da lista para buscar
            break;
        case 1: //Tipo arvore binaria
            TreeBinaryWord binary = (TreeBinaryWord) no;    //Converte a posição para o tipo arvore binaria
            result = binary.searchB(word);  //Usa o metodo da arvore para buscar
            break;
        case 2: //Tipo arvore avl
            TreeAVLWord avl = (TreeAVLWord) no; //Converte a posição para o tipo arvore avl
            result = avl.searchAVL(word);   //Usa o metodo da lista para buscar
            break;
        default:    //Tipo arvore rubro negra
            TreeRNWord rn = (TreeRNWord) no;    //Converte a posição para o tipo arvore rubro negra
            result = rn.searchRN(word); //Usa o metodo da lista para buscar
            break;
        }
        return result;
    }

    /**
     * @return the C
     */
    public int getC() {
        return C;
    }

    /**
     * @return the mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @return the M
     */
    public int getM() {
        return M;
    }

    /**
     * @return the hash
     */
    public Object[] getHash() {
        return hash;
    }
}
