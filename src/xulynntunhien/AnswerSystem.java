/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xulynntunhien;

import Data.Data;
import Data.Tuple;
import Tokenizer.Pair;
import java.util.List;

/**
 *
 * @author ctvan
 */
public class AnswerSystem {

    String question;
    public List<Pair> pairWordLst;
    public List<Pair> ttnn;

    public AnswerSystem(String question) {
        this.question = question;
    }

    public String answer() {
        String answer = "";
        ProceduvalSematic pds = new ProceduvalSematic();
        pds.makePair(question);
        pairWordLst = pds.pairWordLst;
        ttnn = pds.ttnn;
        Tuple tuple = new Tuple();
        for (int i = 0; i < ttnn.size(); i++) {
            String first = ttnn.get(i).getKey();
            String second= ttnn.get(i).getValue();
            switch (first) {
                case "sinh viên":
                    tuple.setName(second);
                    break;
                case "MSSV":
                    tuple.setMSSV(second);
                    break;
                case "môn học":
                    tuple.setTen_mon(second);
                    break;
                case "phòng học":
                    tuple.setSo_phong(second);
                    break;
                case "ngày":
                    tuple.setNgay_hoc(second);
                    break;
                case "tiết":
                    if(second.equals("?"))
                        tuple.setTiet_bat_dau(0);
                    else
                        tuple.setTiet_bat_dau(Integer.parseInt(second));
                    break;
                case "?":
                    tuple.setSo_tiet(0);
                    break;
            }
        }
        Data data = new Data();
        Tuple ans = new Tuple();
        if(!tuple.mssvNULL()){
            ans = data.
        }
        return answer;
    }
}
