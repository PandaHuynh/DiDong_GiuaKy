package com.example.thuanhuynh.ktgiuaky;

/**
 * Created by thuanhuynh on 4/3/18.
 */

public class HocVien {
    int maHV;
    String noiDung;
    String soTien;
    int hinhThuc;
    String dangKy;

    public HocVien(String noiDung, String soTien, int hinhThuc) {
        this.noiDung = noiDung;
        this.soTien = soTien;
        this.hinhThuc = hinhThuc;

    }

    public String getnoiDung() {
        return noiDung;
    }

    public void setnoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getsoTien() {
        return soTien;
    }

    public void setsoTien(String soTien) {
        this.soTien = soTien;
    }

    public int gethinhThuc() {
        return hinhThuc;
    }

    public void sethinhThuc(int hinhThuc) {
        this.hinhThuc = hinhThuc;
    }
}
