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
 * @author Jorge
 */
public class ReaderDoc {
    public static String[] getWords(String url) throws FileNotFoundException{
        String[] words;
        List<String> temp = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(url)).useDelimiter("\\s");
        while (scanner.hasNext()) {
          String word = scanner.next();
          temp.add(formatString(word));
        }
        words = temp.toArray(new String[0]);
        words = new MergeSort().mergeSort(words);
        return words;
    }
    public static String formatString(String s) {
        String temp = Normalizer.normalize(s, java.text.Normalizer.Form.NFD);
        temp = temp.replaceAll("[^A-Za-z0-9]", "");
        return temp.toLowerCase();
    }
}
