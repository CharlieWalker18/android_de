package com.example.dangvannam.coffeapplication;

import java.io.Serializable;

public class model implements Serializable {
    public model(String mTenSanPham, String mMaSanPham, String mDonViTinh, String mGiaTien,int id ) {
        this.TenSanPham = mTenSanPham;
        this.MaSanPham = mMaSanPham;
        this.DonViTinh = mDonViTinh;
        this.GiaTien = mGiaTien;
        this.ID = id;
    }

    private String TenSanPham;
    private String MaSanPham;
    private String DonViTinh;
    private String GiaTien;
    private int Status;



    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        MaSanPham = maSanPham;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        DonViTinh = donViTinh;
    }

    public String getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(String giaTien) {
        GiaTien = giaTien;
    }
}


