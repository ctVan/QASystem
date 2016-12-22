/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexicon;

import Tokenizer.Word;
import Tokenizer.Wordizer;
import java.util.List;

/**
 *
 * @author Van
 */
public class Token {
    public String word;
    public List<Word> lstword;
    String meaning;
    String cat;

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Token(String word, String meaning, String cat) {
        Wordizer wdz = new Wordizer(word);
        this.lstword = wdz.wordize();
        this.meaning = meaning;
        this.cat = cat;
        this.word = word;
    }
    public boolean isWHword(){
        return cat.equals("từ để hỏi");
    }
    public boolean isLit(){
        return cat.equals("literal");
    }
    public boolean equal(String word, int position){
        return word.toLowerCase().equals(this.lstword.get(position).word.toLowerCase());
    }
    public boolean equal(String word){
        return word.toLowerCase().equals(this.word.toLowerCase());
    }
    public boolean meaning(String word){
        return meaning.toLowerCase().equals(word.toLowerCase());
    }
}
