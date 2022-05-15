package edu.iuh.nhom19_appdatdoan.entity;

import java.io.Serializable;

public class Cake implements Serializable {
    private int danhgia;
    private int imgCake;
    private String nameCake;
    private String noteCake;
    private int priceCake;

    public Cake(int danhgia, int imgCake, String nameCake, String noteCake, int priceCake) {
        this.danhgia = danhgia;
        this.imgCake = imgCake;
        this.nameCake = nameCake;
        this.noteCake = noteCake;
        this.priceCake = priceCake;
    }

    public Cake() {
    }

    public int getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(int danhgia) {
        this.danhgia = danhgia;
    }

    public int getImgCake() {
        return imgCake;
    }

    public void setImgCake(int imgCake) {
        this.imgCake = imgCake;
    }

    public String getNameCake() {
        return nameCake;
    }

    public void setNameCake(String nameCake) {
        this.nameCake = nameCake;
    }

    public String getNoteCake() {
        return noteCake;
    }

    public void setNoteCake(String noteCake) {
        this.noteCake = noteCake;
    }

    public int getPriceCake() {
        return priceCake;
    }

    public void setPriceCake(int priceCake) {
        this.priceCake = priceCake;
    }
}
