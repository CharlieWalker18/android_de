package com.example.dangvannam.coffeapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChiTietActivity extends AppCompatActivity {
    TextView textViewTen;
    TextView textViewMaSP;
    TextView textViewDonVitinh;
    TextView textViewGiatien;
    static List<model> modelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        onInit();
        onGetIntet();
        
    }

    private void onGetIntet() {
        Intent intent = getIntent();
        model item = (model) intent.getSerializableExtra("CTSP");
        textViewTen.setText(String.valueOf(item.getTenSanPham()));
        textViewMaSP.setText(String.valueOf(item.getMaSanPham()));
        textViewDonVitinh.setText(String.valueOf(item.getDonViTinh()));
        textViewGiatien.setText(String.valueOf(item.getGiaTien()));
    }

    private void onInit() {
        textViewTen = findViewById(R.id.chitiet_tv_Ten);
        textViewMaSP = findViewById(R.id.chitiet_tv_MaSP);
        textViewDonVitinh = findViewById(R.id.chitiet_tv_ĐonVitinh);
        textViewGiatien = findViewById(R.id.chitiet_tv_Giatien);

    }
}
