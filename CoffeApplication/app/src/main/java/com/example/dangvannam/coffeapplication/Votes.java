package com.example.dangvannam.coffeapplication;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Votes implements Serializable {
    public String getTenBan() {
        return TenBan;
    }

    public void setTenBan(String tenBan) {
        TenBan = tenBan;
    }

    public String getSoluongban() {
        return Soluongban;
    }

    public void setSoluongban(String soluongban) {
        Soluongban = soluongban;
    }

    public String getTinhtrangban() {
        return Tinhtrangban;
    }

    public void setTinhtrangban(String tinhtrangban) {
        Tinhtrangban = tinhtrangban;
    }

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

    private String TenBan;
    private String Soluongban;
    private String Tinhtrangban;
    private int Status;

    public Votes(String tenBan,String soluongban, String tinhtrangban, String datefinish) {
        TenBan = tenBan;
        Soluongban = soluongban;
        Tinhtrangban = tinhtrangban;
        Status = 0;
    }
    public Votes(){
        super();
    }
}
