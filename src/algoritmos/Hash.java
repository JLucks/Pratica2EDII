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
 * @author Jorge & Daniel
 */
public class Hash {
    
    private int C;
    private int mode;
    private int M = 23;
    private int[] P;
    private Object[] hash;
    
    public Hash(int C, int mode){
        Random generator = new Random();
        this.C = C;
        this.mode = mode;
        startHash();
        this.P = new int[C];
        for(int i = 0; i < C; i++)
            P[i] = generator.nextInt(C * M) + 1;
    }
    
    private void startHash(){
        switch(getMode()){
        case 0:
            this.hash = new ListWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new ListWord();
            break;
        case 1:
            this.hash = new TreeBinaryWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new TreeBinaryWord();
            break;
        case 2:
            this.hash = new TreeAVLWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new TreeAVLWord();
            break;
        default:
            this.hash = new TreeRNWord[getM()];
            for(int i = 0; i < getM(); i++)
                hash[i] = new TreeRNWord();
            break;
        }
    }
    
    public void insert(Word word){
        if(word.getWord().length() >= getC()){
            int index = index(word.getWord().substring(0, (getC()-1)));
            insertCollision(word, getHash()[index]);
        }
    }
    
    public Word search(String word){
        Word result = null;
        if(word.length() >= getC()){
            int index = index(word.substring(0, (getC()-1)));
            result = searchCollision(word,getHash()[index]);
        }
        return result;
    }
    
    private int index(String key){
        int sum = 0;
        for(int i = 0; i < key.length(); i++)
            sum += (int) key.charAt(i) * P[i];
        return (sum % getM());
    }
    
    private void insertCollision(Word word, Object no){
        switch(getMode()){
        case 0:
            ListWord list =(ListWord) no;
            list.addWord(word);
            break;
        case 1:
            TreeBinaryWord binary = (TreeBinaryWord) no;
            binary.insertB(binary.getRoot(), word);
            break;
        case 2:
            TreeAVLWord avl = (TreeAVLWord) no;
            avl.insertAVL(avl.getRoot(), word);
            break;
        default:
            TreeRNWord rn = (TreeRNWord) no;
            rn.insertRN(word);
            break;
        }
    }
    
    private Word searchCollision(String word, Object no){
        Word result = null;
        switch(getMode()){
        case 0:
            ListWord list =(ListWord) no;
            result = list.search(word);
            break;
        case 1:
            TreeBinaryWord binary = (TreeBinaryWord) no;
            result = binary.searchB(word);
            break;
        case 2:
            TreeAVLWord avl = (TreeAVLWord) no;
            result = avl.searchAVL(word);
            break;
        default:
            TreeRNWord rn = (TreeRNWord) no;
            result = rn.searchRN(word);
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
