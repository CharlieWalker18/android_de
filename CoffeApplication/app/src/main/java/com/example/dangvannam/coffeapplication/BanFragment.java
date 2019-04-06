package com.example.dangvannam.coffeapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class BanFragment extends Fragment {
    ListView listView;
    List<model> Ban = new ArrayList<>();
    SanPhamAdapter adapter;
    static MySQLite mysqLite;
    Button btnTao;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_ban, container, false);
        listView = view.findViewById(R.id.tab_list_ban);
        btnTao = (Button) view.findViewById(R.id.btnThem_ban);
        // Inflate the layout for this fragment
        mysqLite = new MySQLite(getContext());
        Ban = mysqLite.getALL();
        if(Ban.isEmpty()){
            Ban = mysqLite.getALL();
        }
        adapter = new SanPhamAdapter(getContext(), R.layout.banlite2, Ban);
        listView.setAdapter(adapter);


        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), UpdateChiTietActivity.class);
                startActivity(i);
            }
        });
        return view;
    }


//    @Override
//    public void onStart(){
//        super.onStart();
//        adapter = new ContactAdapter(getContext(), books, R.layout.bookslist2);
//        listView.setAdapter(adapter);
//    }


}

