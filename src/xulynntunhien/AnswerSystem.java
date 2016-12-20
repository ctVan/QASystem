/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xulynntunhien;

import Tokenizer.Word;
import Tokenizer.Wordizer;
import java.util.List;

/**
 *
 * @author ctvan
 */
public class AnswerSystem {
    String question;
    String answer;
    

    public AnswerSystem(String question) {
        this.question = question;
        this.answer = "";
    }

    public AnswerSystem() {
        question = "";
        answer = "";
    }
    
    public String answer(){
        
//        Wordizer tkn = new Wordizer(question);
//        List<Word> tk = tkn.wordize();
//        String str="";
        return answer;
    }
}
