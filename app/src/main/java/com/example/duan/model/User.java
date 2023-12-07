package com.example.duan.model;

public class User {
    private int id_TaiKhoan;
    private String email, matKhau;

    public User() {
    }

    public int getId_TaiKhoan() {
        return id_TaiKhoan;
    }

    public void setId_TaiKhoan(int id_TaiKhoan) {
        this.id_TaiKhoan = id_TaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public User(int id_TaiKhoan, String email, String matKhau) {
        this.id_TaiKhoan = id_TaiKhoan;
        this.email = email;
        this.matKhau = matKhau;

    }
}