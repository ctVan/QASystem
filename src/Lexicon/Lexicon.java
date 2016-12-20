/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexicon;

import Tokenizer.Wordizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author ctvan
 */
public class Lexicon {

    List<Token> lexicon;

    public Lexicon() {
        lexicon = new ArrayList<>();
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
        lexicon.add(new Token("nào", "nào", "danh từ"));
        lexicon.add(new Token("mấy", "mấy", "danh từ"));
        lexicon.add(new Token(Subject.XLNNTN, "XLNNTN", "danh từ"));
        lexicon.add(new Token(Subject.NNLT, "NNLT", "danh từ"));
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
