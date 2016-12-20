/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexicon;

/**
 *
 * @author ctvan
 */
public class Student {
    String name;
    String MSSV;

    public Student(String name, String MSSV) {
        this.name = name;
        this.MSSV = MSSV;
    }

    public Student() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }
    
}
