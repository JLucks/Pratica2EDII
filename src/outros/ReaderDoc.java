/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @authors Jorge & Daniel
 */
public class ReaderDoc {
    //Função que retorna as palavras do documento
    public static String[] getWords(String url) throws FileNotFoundException{
        String[] words;
        List<String> temp = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(url)).useDelimiter("\\s"); //Ler apartir do documento quebrando por espaços, tabulações e quebra de linhas
        while (scanner.hasNext()) { //Enquanto não chegar ao final do arquivo
          String word = scanner.next(); //Carrega a palavra
          if(!word.equals(""))
            temp.add(formatString(word)); //Adiciona a palavra formatada a lista
        }
        words = temp.toArray(new String[temp.size()]);  //Transforma a lista em array
        words = new MergeSort().mergeSort(words);   //Usa o mergeSort para ordenar o array
        return words;
    }
    
    public static String formatString(String s) {
        String temp = Normalizer.normalize(s, java.text.Normalizer.Form.NFD);
        temp = temp.replaceAll("[^A-Za-z0-9]", ""); //Remove caracteres especiais
        return temp.toLowerCase();
    }
}
