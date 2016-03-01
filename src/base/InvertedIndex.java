/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @authors Jorge & Daniel
 */
public class InvertedIndex {
    
    //Função que cria e retorna o indice invertido que recebe as palavras dos documento, o documento e o indice invertido atual
    public static List<Word> getInvertedIndex(String[] words, AddressDoc doc, List<Word> lastInvertedIndex){
        List<Word> temp = lastInvertedIndex;    //Carrega a temporaria com a ultima lista de indices invertidos
        int i = 0, quantity;    //Contadoras
        boolean flag = true;    //Caso o indice invertido não contenha a palavra
        while(i < words.length){    //Enquanto existir palavras
            quantity = countWords(words, i);    //Chamada ao metodo que retorna o numero de vezes que a palavra ocorreu no documento
            doc.addNumberWords();   //Adiciona um termo a quantidade de palavras do documento
            WordInDoc wrd = new WordInDoc(doc.getIdDoc(),quantity); //Cria um indice invertido
            for(Word w : temp){ //Percorre a lista de indices
                if(words[i].equals(w.getWord())){   //Verifica se o indice já existe
                    w.getQuantityByDocs().add(wrd); //Adiciona à palavra do indice mais um indice invertido
                    flag = false;   //Avisa que tinha a palavra
                    break;
                }
            }
            if(flag){   //Caso a palavra não exista na lista de indices
                ArrayList<WordInDoc> quantityByDoc = new ArrayList<>(); //Cria uma lista de indices
                quantityByDoc.add(wrd); //Adiciona o indice criado a lista de indices
                Word newWord = new Word(words[i],quantityByDoc);    //Cria uma palavra associada a um indice
                temp.add(newWord);  //Adiciona a nova palavra a ultima lista de indices invertidos
            }
            else{
                flag = true;    //Reinicia a flag
            }
            i += quantity;  //Pula as palavras repetidas
        }
        Collections.sort(temp); //Ordena novamente o Indice Invertido
      return temp;
    }
    
    //Função que retorna a quantidade de vezes que uma palavra aparece num vetor ordenado
    private static int countWords(String[] words, int index){
        int count = 1, i = index;
        if(i+1 < words.length){ //Verifica se existe palavras apos o indice
            while(words[index].equals(words[i+1])){ //Enquanto a proxima palavra for igual a do indice
                count++;
                i++;
                if((i+1) >= words.length){  //Verifica se a palavra é a ultima
                    break;
                }
            }
        }
        return count;
    } 
}
