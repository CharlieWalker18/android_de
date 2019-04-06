package com.example.dangvannam.coffeapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaoBanActivity extends AppCompatActivity {
    ListView listView;
    static List<Votes> Votes;
    static taobanAdapter adapter;
    TextView textViewContent;

    public TaoBanActivity(TaoBanActivity taoBanActivity, int ban2lite, List<com.example.dangvannam.coffeapplication.Votes> votes) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_ban);

    }
}
