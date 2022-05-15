package edu.iuh.nhom19_appdatdoan.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDon implements Serializable {
    private String email;
    private String hoaDonId;
    private Date thoiGian;
    private Double tongTien;
    private ArrayList<CTHD> cthds;
    public HoaDon() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(String hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public List<CTHD> getCthds() {
        return cthds;
    }

    public void setCthds(ArrayList<CTHD> cthds) {
        this.cthds = cthds;
    }

    public HoaDon(String email, String hoaDonId, Date thoiGian, Double tongTien, ArrayList<CTHD> cthds) {
        this.email = email;
        this.hoaDonId = hoaDonId;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
        this.cthds = cthds;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "email='" + email + '\'' +
                ", hoaDonId='" + hoaDonId + '\'' +
                ", thoiGian=" + thoiGian +
                ", tongTien=" + tongTien +
                ", cthds=" + cthds +
                '}';
    }
}
