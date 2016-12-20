/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author ctvan
 */
public class Wordizer {
    String sentence;
    public Wordizer(String sentence) {
        this.sentence = sentence;
    }
    public List<Word> wordize(){
      List<Word> lst = new ArrayList();
        StringTokenizer st = new StringTokenizer(sentence,":.,? ");
        while(st.hasMoreTokens()){
            lst.add(new Word(st.nextToken()));
        }
      return lst;
    }
}
