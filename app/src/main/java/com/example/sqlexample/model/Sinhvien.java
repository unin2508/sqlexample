package com.example.sqlexample.model;

public class Sinhvien {
    private Integer maSv;
    private String ten;
    private String namsinh;
    private String quequan;
    private Integer namhoc;

    public Sinhvien(){}

    public Sinhvien(Integer maSv, String ten, String namsinh, String quequan, Integer namhoc) {
        this.maSv = maSv;
        this.ten = ten;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.namhoc = namhoc;
    }

    public Sinhvien(String ten, String namsinh, String quequan, Integer namhoc) {
        this.ten = ten;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.namhoc = namhoc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public Integer getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(Integer namhoc) {
        this.namhoc = namhoc;
    }

    public Integer getMaSv() {
        return maSv;
    }

    public void setMaSv(Integer maSv) {
        this.maSv = maSv;
    }

    @Override
    public String toString() {
        return "Sinhvien{" +
                "maSv=" + maSv +
                ", ten='" + ten + '\'' +
                ", namsinh='" + namsinh + '\'' +
                ", quequan='" + quequan + '\'' +
                ", namhoc=" + namhoc +
                '}';
    }
}
