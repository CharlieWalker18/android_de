package com.example.dangvannam.coffeapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateChiTietActivity extends AppCompatActivity {
    EditText edtTen;
    EditText edtMaSP;
    EditText edtDonVitinh;
    EditText edtGiatien;
    Button btnUpdate;
    Button btBack;
    int position = 0;

    int ID;
    String mMA;
    String mTen;
    String mDonVitinh;
    String mGiatien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_chi_tiet);
        onInit();
        onGetValue();
    }

    private void onGetValue() {
        Intent intent = getIntent();
        edtMaSP.setText(intent.getStringExtra("MaSP"));
        edtTen.setText(intent.getStringExtra("Ten"));
        edtDonVitinh.setText(intent.getStringExtra("DonVitinh"));
        edtDonVitinh.setText(intent.getStringExtra("Giatien"));
        ID=intent.getIntExtra("ID",0);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onValidateFrom()) {
                    Toast.makeText(UpdateChiTietActivity.this,"Add item success", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(UpdateChiTietActivity.this,SanPhamActivity.class));
                    finish();


                }
            }
        });
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }

    Boolean onValidateFrom() {
        mTen = edtTen.getText().toString();
        if (mTen.length() < 1) {
            edtTen.setError("null");
            return false;
        }
        mMA = edtMaSP.getText().toString();
        if (mMA.length() < 1) {
            edtMaSP.setError("null");
            return false;
        }
         mDonVitinh= edtDonVitinh.getText().toString();
        if (mDonVitinh.length() < 1) {
            edtDonVitinh.setError("null");
            return false;
        }
        mGiatien = edtGiatien.getText().toString();
        if (mGiatien.length() < 1) {
            edtGiatien.setError(null);
            return false;
        }
        return true;
    }


    private void onInit() {
        edtMaSP  = findViewById(R.id.update_edt_masp);
        edtTen = findViewById(R.id.update_edt_tsp);
        edtDonVitinh = findViewById(R.id.update_edt_dvt);
        edtGiatien = findViewById(R.id.update_edt_gt);
        btnUpdate = findViewById(R.id.update_btn_update);
        btBack = findViewById(R.id.update_btn_back);

    }
}
