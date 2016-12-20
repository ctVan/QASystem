/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xulynntunhien;

//import Tokenizer.Token;

import Lexicon.Token;
import Tokenizer.Tokenizer;
import java.util.List;


/**
 *
 * @author ctvan
 */
public class ProceduvalSematic {
    
    static void run(String question){
        Tokenizer tkn = new Tokenizer(question);
        List<Token> lstToken =tkn.tokenize();
        for(int i = 0; i < lstToken.size();i++){
            System.out.print(lstToken.get(i).word +"/");
        }
    }
}
