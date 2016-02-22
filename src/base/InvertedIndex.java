/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import outros.*;

/**
 *
 * @author Jorge
 */
public class InvertedIndex {
    
    public static List<Word> getInvertedIndex(String[] words, String idDoc, List<Word> lastInvertedIndex){
        List<Word> temp = lastInvertedIndex;
        int i = 0, quantity;
        boolean flag = true;
        while(i < words.length){
            quantity = countWords(words, i);
            WordInDoc wrd = new WordInDoc(idDoc,quantity);
            for(Word w : temp){
                if(words[i].equals(w.getWord())){
                    w.getQuantityByDocs().add(wrd);
                    flag = false;
                    break;
                }
            }
            if(flag){
                ArrayList<WordInDoc> quantityByDoc = new ArrayList<>();
                quantityByDoc.add(wrd);
                Word newWord = new Word(words[i],quantityByDoc);
                temp.add(newWord);
            }
            else{
                flag = true;
            }
            i += quantity;
        }
        Collections.sort(temp);
      return temp;
    }
    
    private static int countWords(String[] words, int index){
        int count = 1, i = index;
        if(i+1 < words.length){
            while(words[i].equals(words[i+1])){
                count++;
                i++;
                if((i+1) >= words.length){
                    break;
                }
            }
        }
        return count;
    } 
}
