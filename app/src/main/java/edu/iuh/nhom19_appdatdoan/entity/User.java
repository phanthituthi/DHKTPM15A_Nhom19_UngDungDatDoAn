package edu.iuh.nhom19_appdatdoan.entity;

public class User {
    private  String name;
    private  String email;
    private String  diaChi;
    private String sdt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, String diaChi, String sdt) {
        this.name = name;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }
}