package com.example.sqlexample.model;

public class SinhvienLophoc {
    private Integer idSv;
    private Integer idlop;
    private String kyhoc;
    private Integer sotinchi;

    public SinhvienLophoc(){}

    public SinhvienLophoc(Integer idSv, Integer idlop, String kyhoc, Integer sotinchi) {
        this.idSv = idSv;
        this.idlop = idlop;
        this.kyhoc = kyhoc;
        this.sotinchi = sotinchi;
    }

    public Integer getIdSv() {
        return idSv;
    }

    public void setIdSv(Integer idSv) {
        this.idSv = idSv;
    }

    public Integer getIdlop() {
        return idlop;
    }

    public void setIdlop(Integer idlop) {
        this.idlop = idlop;
    }

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }

    public Integer getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(Integer sotinchi) {
        this.sotinchi = sotinchi;
    }

    @Override
    public String toString() {
        return "SinhvienLophoc{" +
                "idSv=" + idSv +
                ", idlop=" + idlop +
                ", kyhoc='" + kyhoc + '\'' +
                ", sotinchi=" + sotinchi +
                '}';
    }
}
