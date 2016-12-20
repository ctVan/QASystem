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
public class Subject {
    public static String XLNNTN = "xử lý ngôn ngữ tự nhiên";
    public static String NNLT = "ngôn ngữ lập trình";
    
    String ten_mon;
    String so_phong;
    String ngay_hoc;
    int tiet_bat_dau;
    int so_tiet;

    public Subject(String ten_mon, String so_phong, String ngay_hoc, int tiet_bat_dau, int so_tiet) {
        this.ten_mon = ten_mon;
        this.so_phong = so_phong;
        this.ngay_hoc = ngay_hoc;
        this.tiet_bat_dau = tiet_bat_dau;
        this.so_tiet = so_tiet;
    }

    public Subject() {
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
    
}
