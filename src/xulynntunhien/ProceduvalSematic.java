/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xulynntunhien;

//import Tokenizer.Token;
import Lexicon.Lexicon;
import Lexicon.Student;
import Lexicon.Subject;
import Lexicon.Token;
import Tokenizer.Pair;
import Tokenizer.Tokenizer;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author ctvan
 */
public class ProceduvalSematic {

    public List<Pair> pairWordLst;
    public List<Pair> ttnn;

    public String findPre(List<Token> lstToken, int position) {
        String result = "";
        Lexicon lexicon = new Lexicon();
        for (int i = position - 1; i >= 0; i--) {
            if (lexicon.inDictionary(lstToken.get(i).getMeaning())) {
                return lstToken.get(i).getMeaning();
            }
        }
        return result;
    }

    public String findPost(List<Token> lstToken, int position) {
        String result = "";
        Lexicon lexicon = new Lexicon();
        for (int i = position + 1; i <= lstToken.size(); i++) {
            if (lexicon.inDictionary(lstToken.get(i).getMeaning())) {
                return lstToken.get(i).getMeaning();
            }
        }
        return result;
    }

    boolean nextIsRelated(List<Token> lstToken, int position) {
        return lstToken.get(position + 1).isLit() || lstToken.get(position + 1).isWHword();
    }

    boolean currIsQues(List<Token> lsToken, int position) {
        return lsToken.get(position).isWHword();
    }

    boolean nextIsLit(List<Token> lsToken, int position) {
        return lsToken.get(position + 1).isLit();
    }

    void makePair(String question) {
        Tokenizer tkn = new Tokenizer(question);
        List<Token> lstToken = tkn.tokenize();
        tkn.removeUnrelatedWord(lstToken);

        pairWordLst = new ArrayList<>();
        ttnn = new ArrayList<>();

        Student student = new Student();
        Subject subject = new Subject();

        // mark that this toke is made pair
        int posMakePair = -1;
        for (int i = 0; i < lstToken.size() - 1; i++) {
            if (nextIsRelated(lstToken, i)) {
                pairWordLst.add(new Pair(lstToken.get(i).word, lstToken.get(i + 1).word));

                if (!lstToken.get(i + 1).isWHword()) {
                    ttnn.add(new Pair(lstToken.get(i).getMeaning(), lstToken.get(i + 1).word));
                } else {
                    ttnn.add(new Pair(lstToken.get(i).getMeaning(), "?"));
                }
                i++;
                posMakePair = i;
            } // current is question word -> case "mấy tiết"
            else if (currIsQues(lstToken, i)) {
                if (lstToken.get(i).meaning("mấy")) {
                    if (posMakePair == i - 1) {
                        pairWordLst.add(new Pair(lstToken.get(i).word, lstToken.get(i + 1).getMeaning()));

                        if (!lstToken.get(i).isWHword()) {
                            ttnn.add(new Pair(lstToken.get(i).word, lstToken.get(i + 1).getMeaning()));
                        } else {
                            ttnn.add(new Pair("?", lstToken.get(i + 1).getMeaning()));
                        }
                        i++;
                        posMakePair = i;
                    } else {
                        System.err.println("Some thing wrong here");
                    }
                }
            }
        }
    }

    String toString(List<Pair> lstpair) {
        String result = "";
        for (int i = 0; i < lstpair.size(); i++) {
            result += "<";
            result += lstpair.get(i).getKey();
            result += ",";
            result += lstpair.get(i).getValue();
            result += "> ";
        }
        System.out.println(result);
        return result;
    }
}
