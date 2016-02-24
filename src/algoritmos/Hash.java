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
 * @author Jorge
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
        this.hash = new Object[C];
        this.P = new int[C];
        for(int i = 0; i < C; i++)
            P[i] = generator.nextInt(C * M) + 1;
    }
    
    public void insert(Word word){
        int index = index(word.getWord().substring(0, (C-1)));
        insertCollision(word, hash[index]);
    }
    
    public Word search(String word){
        Word result = null;
        int index = index(word.substring(0, (C-1)));
        result = searchCollision(word,hash[index]);
        return result;
    }
    
    public int index(String key){
        int sum = 0;
        for(int i = 0; i < C; i++)
            sum += (int) key.charAt(i) * P[i];
        return (sum % M);
    }
    
    public void insertCollision(Word word, Object no){
        if(mode == 0){
            
        }else if(mode == 1){
            
        }else if(mode == 2){
            
        }else{
            
        }
    }
    
    public Word searchCollision(String word, Object no){
        Word result = null;
        if(mode == 0){
            
        }else if(mode == 1){
            
        }else if(mode == 2){
            
        }else{
            
        }
        return result;
    }
}
