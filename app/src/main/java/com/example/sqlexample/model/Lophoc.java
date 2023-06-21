package com.example.sqlexample.model;

public class Lophoc {
    private Integer malop;
    private String ten;
    private String mota;

    public Lophoc(){}

    public Lophoc(Integer malop, String ten, String mota) {
        this.malop = malop;
        this.ten = ten;
        this.mota = mota;
    }

    public Lophoc( String ten, String mota) {
        this.ten = ten;
        this.mota = mota;
    }

    public Integer getMalop() {
        return malop;
    }

    public void setMalop(Integer malop) {
        this.malop = malop;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "Lophoc{" +
                "malop=" + malop +
                ", ten='" + ten + '\'' +
                ", mota='" + mota + '\'' +
                '}';
    }
}
