/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Lexicon.Student;
import Lexicon.Subject;

/**
 *
 * @author ctvan
 */
public class Tuple {

    String stu_name;
    String MSSV;
    String ten_mon;
    String so_phong;
    String ngay_hoc;
    int tiet_bat_dau;
    int so_tiet;

    public Tuple(String name, String MSSV, String ten_mon, String so_phong, String ngay_hoc, int tiet_bat_dau, int so_tiet) {
        this.stu_name = name;
        this.MSSV = MSSV;
        this.ten_mon = ten_mon;
        this.so_phong = so_phong;
        this.ngay_hoc = ngay_hoc;
        this.tiet_bat_dau = tiet_bat_dau;
        this.so_tiet = so_tiet;
    }

    public Tuple() {
        stu_name = "";
        MSSV = "";
        ten_mon = "";
        so_phong = "";
        ngay_hoc = "";
        tiet_bat_dau = -1;
        so_tiet = -1;
    }

    public String getName() {
        return stu_name;
    }

    public void setName(String name) {
        this.stu_name = name;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public String getSo_phong() {
        return so_phong;
    }

    public void setSo_phong(String so_phong) {
        this.so_phong = so_phong;
    }

    public String getNgay_hoc() {
        return ngay_hoc;
    }

    public void setNgay_hoc(String ngay_hoc) {
        this.ngay_hoc = ngay_hoc;
    }

    public int getTiet_bat_dau() {
        return tiet_bat_dau;
    }

    public void setTiet_bat_dau(int tiet_bat_dau) {
        this.tiet_bat_dau = tiet_bat_dau;
    }

    public int getSo_tiet() {
        return so_tiet;
    }

    public void setSo_tiet(int so_tiet) {
        this.so_tiet = so_tiet;
    }

    public boolean equalMSSV(String MSSV) {
        return this.MSSV.equals(MSSV);
    }

    public boolean nameNULL() {
        return stu_name.equals("");
    }

    public boolean mssvNULL() {
        return MSSV.equals("");
    }

    public boolean monNULL() {
        return ten_mon.equals("");
    }

    public boolean phongNULL() {
        return so_phong.equals("");
    }

    public boolean ngayNULL() {
        return ngay_hoc.equals("");
    }

    public boolean tietbdNULL() {
        return tiet_bat_dau == 0;
    }

    public boolean tietNULL() {
        return so_tiet == 0;
    }
}
