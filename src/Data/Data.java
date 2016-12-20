/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Lexicon.Subject;
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
        Tuple tuple1 = new Tuple("Phạm Văn Hai", "MT12001", Subject.XLNNTN, "205B10", "T2", 7, 3);
        Tuple tuple3 = new Tuple("Nguyễn Thị Mai", "MT12003", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple4 = new Tuple("Nguyễn Thị Trang", "MT12004", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple7 = new Tuple("Trần Quốc Việt", "MT12007", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple8 = new Tuple("Đoàn Minh Thịnh", "MT12008", Subject.XLNNTN, "205B10", "t2", 7, 3);
        Tuple tuple10 = new Tuple("Nguyễn Hạnh Phúc", "MT12010", Subject.XLNNTN, "205B10", "t2", 7, 3);

        Tuple tuple2 = new Tuple("Trần Anh Dũng", "MT12002", Subject.NNLT, "402C6", "T4", 1, 4);
        Tuple tuple5 = new Tuple("Đỗ Thanh H", "MT12005", Subject.NNLT, "402C6", "T4", 1, 4);
        Tuple tuple6 = new Tuple("Lê Minh Tr", "MT12006", Subject.NNLT, "402C6", "T4", 1, 4);
        Tuple tuple9 = new Tuple("Văn Bạch Mai", "MT12009", Subject.NNLT, "402C6", "T4", 1, 4);

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
    
    Tuple get(String MSSV){
        for(int i = 0; i < table.size(); i++){
            if(table.get(i).equalMSSV(MSSV))
                return table.get(i);
        }
        return null;
    }
//    List<Tuple> get(String subject_name){
//        List<Tuple> lst = new ArrayList();
//        for(Tuple t:table){
//            if(t.)
//        }
//    }
}
