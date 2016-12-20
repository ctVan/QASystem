/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokenizer;

import Lexicon.Lexicon;
import Lexicon.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Van
 */
public class Tokenizer {

    String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Tokenizer(String input) {
        this.input = input;

    }

    public int getLongestLength(int position) {
        int longestLength = 0;
        List<Token> lstToken = new ArrayList<>();
        Wordizer wdz = new Wordizer(input);
        List<Word> lstWord = wdz.wordize();
        Lexicon lexicon = new Lexicon();
        int len = lstWord.size();

        // get list token have first word match
        List<Token> lst = lexicon.getListToken(lstWord.get(position).word);
        // just ignore those word don't know
        if (lst.size() == 0) {
            return 0;
        }
        longestLength++;
        int j = position + 1;
        int pos = 1;
        while (j < len) {
            lst = lexicon.getListToken(lstWord.get(j).word, lst, pos);
            if (lst.size() == 0) {
                break;
            }
            j++;
            longestLength++;
            pos++;
        }

        return longestLength;
    }

    public List<Token> tokenize() {
        List<Token> lstToken = new ArrayList<>();
        Wordizer wdz = new Wordizer(input);
        List<Word> lstWord = wdz.wordize();
        Lexicon lexicon = new Lexicon();
        int length = lstWord.size();
        for (int i = 0; i < length; i++) {
            int len = getLongestLength(i);
            if(len == 0)
                continue;
            String token = "";
            int x = 0;
            while (x < len) {
                if (x < len - 1) {
                    token += lstWord.get(i + x).word + " ";
                } else {
                    token += lstWord.get(i + x).word;
                }
                x++;
            }
            
            // find token
            Token t = lexicon.findToken(token);
            if(t == null)
                System.err.println("Something wrong find token");
            lstToken.add(t);
            // increase index, because i++ of for loop
            i += len - 1;
        }
        return lstToken;
    }
}
