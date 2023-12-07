package com.example.duan.model;

public class DichVu {
    private int id_DV;
    private String ten_KH;
    private float giaTien;
    private int soluong;

    public DichVu() {
    }
    public DichVu(int id_DV, String ten_KH, float giaTien, int soluong) {
        this.id_DV = id_DV;
        this.ten_KH = ten_KH;
        this.giaTien = giaTien;
        this.soluong = soluong;
    }

    public int getId_DV() {
        return id_DV;
    }

    public void setId_DV(int id_DV) {
        this.id_DV = id_DV;
    }

    public String getTen_KH() {
        return ten_KH;
    }

    public void setTen_KH(String ten_KH) {
        this.ten_KH = ten_KH;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}

