/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;
import java.util.List;

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
                temp.add(new Word(words[i],quantityByDoc));
            }
            i += quantity;
      }
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
    
    public static void printInvertedIndex(List<Word> words){
        for(Word word: words){
            System.out.print(word.getWord());
            for(WordInDoc qntWord: word.getQuantityByDocs()){
                System.out.printf(" %d %s", qntWord.getQuantity(), qntWord.getIdDoc());
            }
            System.out.println();
        }
    }
}
