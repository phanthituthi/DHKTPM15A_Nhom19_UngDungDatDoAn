package edu.iuh.nhom19_appdatdoan.entity;

public class CTHD {
    private String CTHDId;
    private Cake cake;
    private int soLuong;


    public CTHD(String CTHDId, Cake cake, int soLuong) {
        this.CTHDId = CTHDId;
        this.cake = cake;
        this.soLuong = soLuong;

    }

    public CTHD() {
    }

    public String getCTHDId() {
        return CTHDId;
    }

    public void setCTHDId(String CTHDId) {
        this.CTHDId = CTHDId;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "CTHD{" +
                "CTHDId='" + CTHDId + '\'' +
                ", cake=" + cake +
                ", soLuong=" + soLuong +
                '}';
    }
    public Integer TinhTien(){
        return soLuong*cake.getPriceCake();
    }
}
