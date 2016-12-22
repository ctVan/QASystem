/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexicon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ctvan
 */
public class Lexicon {

    List<String> dictionary;
    List<Token> lexicon;

    public Lexicon() {
        lexicon = new ArrayList<>();
        dictionary = new ArrayList<>();
        init();
    }

    private void init() {
        lexicon.add(new Token("sinh viên", "sinh viên", "danh từ"));
        lexicon.add(new Token("môn", "môn học", "danh từ"));
        lexicon.add(new Token("môn học", "môn học", "danh từ"));
        lexicon.add(new Token("mã số", "MSSV", "danh từ"));
        lexicon.add(new Token("mã số sinh viên", "MSSV", "danh từ"));
        lexicon.add(new Token("phòng", "phòng học", "danh từ"));
        lexicon.add(new Token("phòng học", "phòng học", "danh từ"));
        lexicon.add(new Token("tên", "họ và tên", "danh từ"));
        lexicon.add(new Token("họ và tên", "họ và tên", "danh từ"));
        lexicon.add(new Token("ngày", "ngày", "danh từ"));
        lexicon.add(new Token("tiết", "tiết", "danh từ"));
        lexicon.add(new Token("học", "học", "động từ"));
        lexicon.add(new Token("nào", "nào", "từ để hỏi"));
        lexicon.add(new Token("mấy", "mấy", "từ để hỏi"));
        lexicon.add(new Token("gì","nào","từ để hỏi"));
        lexicon.add(new Token("ở","ở","động từ"));
        lexicon.add(new Token("có","có","động từ"));
        lexicon.add(new Token(Subject.XLNNTN, "XLNNTN", "literal"));
        lexicon.add(new Token(Subject.NNLT, "NNLT", "literal"));

        dictionary.add("sinh viên");
        dictionary.add("môn học");
        dictionary.add("mssv");
        dictionary.add("phòng học");
        dictionary.add("họ và tên");
        dictionary.add("ngày");
        dictionary.add("tiết");
        
        dictionary.add(Subject.NNLT);
        dictionary.add(Subject.XLNNTN);
    }

    public boolean inDictionary(String keyword) {
        for (int i = 0; i < dictionary.size(); i++) {
            if (keyword.toLowerCase().equals(dictionary.get(i).toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public Token findToken(String token) {
        for (Token t : lexicon) {
            if (t.equal(token)) {
                return t;
            }
        }
        return null;
    }

    public List<Token> getListToken(String keyword) {
        List<Token> lst = new ArrayList<>();
        lexicon.stream().forEach((token) -> {
            if (token.equal(keyword, 0)) {
                lst.add(token);
            }
        });
        return lst;
    }

    public List<Token> getListToken(String keyword, List<Token> lstToken, int position) {
        List<Token> lst = new ArrayList<>();

        for (Token token : lstToken) {
            if (position >= token.lstword.size()) {
                continue;
            }
            if (token.equal(keyword, position)) {
                lst.add(token);
            }
        }
        return lst;
    }

}
