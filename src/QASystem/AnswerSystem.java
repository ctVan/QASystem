/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QASystem;

import Data.Data;
import Data.Tuple;
import Tokenizer.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ctvan
 */
public class AnswerSystem {

    String question;
    public List<Pair> pairWordLst;
    public List<Pair> ttnn;
    String preTTNN;
    String TTNN;
    String pharse;

    public AnswerSystem(String question) {
        this.question = question;
    }

    public void removeDuplicate(List<String> lst) {
        for (int i = 0; i < lst.size(); i++) {
            for (int j = i + 1; j < lst.size(); j++) {
                if (lst.get(i).equals(lst.get(j))) {
                    lst.remove(j);
                    j--;
                }
            }
        }
    }

    public List<String> buildAnswer(Tuple tuple, List<Tuple> lstAnswer) {
        List<String> lst = new ArrayList<>();

        for (Tuple t : lstAnswer) {
            String result = "";
            if (tuple.askName()) {
                result += "<Tên: " + t.getName() + ">";
            }
            if (tuple.askMSSV()) {
                result += " <MSSV: " + t.getMSSV() + ">";
            }
            if (tuple.askMon()) {
                result += " <môn:" + t.getTen_mon() + ">";
            }
            if (tuple.askPhong()) {
                result += " <phòng: " + t.getSo_phong() + ">";
            }
            if (tuple.askNgay()) {
                result += " <ngày:" + t.getNgay_hoc() + ">";
            }
            if (tuple.askTietbd()) {
                result += " <tiết bắt đầu: " + t.getTiet_bat_dau() + ">";
            }
            if (tuple.askTiet()) {
                result += " <số tiết: " + t.getSo_tiet() + ">";
            }
            lst.add(result);
        }
        removeDuplicate(lst);
        return lst;
    }

    public String answer() {
        String answer = "";
        ProceduvalSematic pds = new ProceduvalSematic();
        pds.makePair(question);
        pairWordLst = pds.pairWordLst;
        ttnn = pds.ttnn;
        pharse = pds.pharse;
        Tuple tuple = new Tuple();
        List<Pair> lstParam = new ArrayList<>();

        for (int i = 0; i < ttnn.size(); i++) {
            String first = ttnn.get(i).getKey().toLowerCase();
            String second = ttnn.get(i).getValue();
            switch (first) {
                case "sinh viên":
                    tuple.setName(second);
                    if (!tuple.nameNULL() && !tuple.askName()) {
                        lstParam.add(ttnn.get(i));
                    }
                    break;
                case "mssv":
                    tuple.setMSSV(second);
                    if (!tuple.mssvNULL() && !tuple.askMSSV()) {
                        lstParam.add(ttnn.get(i));
                    }
                    break;
                case "môn học":
                    tuple.setTen_mon(second);
                    if (!tuple.monNULL() && !tuple.askMon()) {
                        lstParam.add(ttnn.get(i));
                    }
                    break;
                case "phòng học":
                    tuple.setSo_phong(second);
                    break;
                case "ngày":
                    tuple.setNgay_hoc(second);
                    break;
                case "tiết":
                    if (second.equals("?")) {
                        tuple.setTiet_bat_dau(0);
                    } else {
                        tuple.setTiet_bat_dau(Integer.parseInt(second));
                    }
                    break;
                case "?":
                    tuple.setSo_tiet(0);
                    break;
            }
        }
        Data data = new Data();
        List<Tuple> ans = data.get(lstParam);
        List<String> lst = buildAnswer(tuple, ans);

        // prepare the answer
        preTTNN = toString(pairWordLst);
        TTNN = toString(ttnn);

        System.out.println("Câu hỏi: " + question);
        System.out.print("Tiền xử lý, tách thành các cụm từ có nghĩa: ");
        System.out.println(pharse);
        System.out.print("Tiền xử lý, gom nhóm các cụm từ có nghĩa: ");
        System.out.println(preTTNN);
        System.out.print("Dạng thủ tục ngữ nghĩa: ");
        System.out.println(TTNN);
        System.out.println("Câu trả lời: ");
        if (lst.size() == 0) {
            System.out.println("không có câu trả lời");
        } else {
            for (int i = 0; i < lst.size(); i++) {
                System.out.println(i+1 + ". " + lst.get(i));
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("");
        }

        return answer;
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
        return result;
    }
}
