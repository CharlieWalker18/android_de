package com.example.dangvannam.coffeapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText edtUserName;
    EditText edtPassword;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInit();
        CheckLoged();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

    }

    private void onInit() {
        edtUserName = findViewById(R.id.login_edt_username);
        edtPassword = findViewById(R.id.login_edt_password);
        btnLogin = findViewById(R.id.login_btnLogin);
        sharedPreferences = getSharedPreferences("save",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
   private void Login(){
        if(edtUserName.getText().toString().equals("1706020107") && edtPassword.getText().toString().equals("1118")){
            Toast.makeText(MainActivity.this,"LOGIN success",Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this,SanPhamActivity.class);
            editor.putBoolean("login",true);
            editor.commit();
            startActivity(i);
        }
        else {
            Toast.makeText(MainActivity.this,"LOGIN fail",Toast.LENGTH_LONG).show();
        }
    }

    void CheckLoged(){
        if (sharedPreferences.getBoolean("login",false)){
            startActivity(new Intent(MainActivity.this,SanPhamActivity.class));
        }
    }

}