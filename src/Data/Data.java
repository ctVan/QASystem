/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Lexicon.Subject;
import Tokenizer.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ctvan
 */
public class Data {

    List<Tuple> table;

    public Data() {
        table = new ArrayList<>();
        init();
    }

    public void init() {
        Tuple tuple1 = new Tuple("Phạm Văn Hai", "MT12001", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple3 = new Tuple("Nguyễn Thị Mai", "MT12003", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple4 = new Tuple("Nguyễn Thị Trang", "MT12004", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple7 = new Tuple("Trần Quốc Việt", "MT12007", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple8 = new Tuple("Đoàn Minh Thịnh", "MT12008", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple10 = new Tuple("Nguyễn Hạnh Phúc", "MT12010", Subject.XLNNTN, "205B10", "t2", 7, 3);

        Tuple tuple2 = new Tuple("Trần Anh Dũng", "MT12002", Subject.NNLT, "402C6", "t4", 1, 4);
        Tuple tuple5 = new Tuple("Đỗ Thanh H", "MT12005", Subject.NNLT, "402C6", "t4", 1, 4);
        Tuple tuple6 = new Tuple("Lê Minh Trang", "MT12006", Subject.NNLT, "402C6", "t4", 1, 4);
        Tuple tuple9 = new Tuple("Văn Bạch Mai", "MT12009", Subject.NNLT, "402C6", "t4", 1, 4);

        table.add(tuple1);
        table.add(tuple2);
        table.add(tuple3);
        table.add(tuple4);
        table.add(tuple5);
        table.add(tuple6);
        table.add(tuple7);
        table.add(tuple8);
        table.add(tuple9);
        table.add(tuple10);
    }

    public List<Tuple> getbyMSSV(String MSSV) {
        List<Tuple> ret = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).equalMSSV(MSSV)) {
                ret.add(table.get(i));
            }
        }
        return ret;
    }

    public List<Tuple> getbySubject(String subject_name) {
        List<Tuple> ret = new ArrayList();
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getTen_mon().equals(subject_name)) {
                ret.add(table.get(i));
            }
        }
        return ret;
    }

    public List<Tuple> getbyName(String stu_name) {
        List<Tuple> ret = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getName().equals(stu_name)) {
                ret.add(table.get(i));
            }
        }
        return ret;
    }

    public List<Tuple> get(List<Pair> lstParam) {
        List<Tuple> ret = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            boolean isAdd = true;
            for (int j = 0; j < lstParam.size(); j++) {
                switch (lstParam.get(j).getKey()) {
                    case "sinh viên":
                        if (!lstParam.get(j).equalValue(table.get(i).getName())){
                            isAdd = false;
                        }
                        break;
                    case "MSSV":
                        if (!lstParam.get(j).equalValue(table.get(i).getMSSV())) {
                            isAdd = false;
                        }
                        break;
                    case "môn học":
                        if (!lstParam.get(j).equalValue(table.get(i).getTen_mon())) {
                            isAdd = false;
                        }
                        break;
                }
            }
            if (isAdd) {
                ret.add(table.get(i));
            }
        }
        return ret;
    }
}
