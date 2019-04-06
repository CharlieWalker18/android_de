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
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SanPhamFragment extends Fragment {
    Button btncreate, btnhistory;
    static PagerStateAdapter adapter;
    ListView listView;
    static List<Votes> votesContacts = new ArrayList<>();
    static List<Votes> voteforAdapter = new ArrayList<>();
    //static MySQLite mysqLite;

    public SanPhamFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_san_pham, container, false);
        listView = (ListView) view.findViewById(R.id.lv_vote1);
        btncreate = (Button) view.findViewById(R.id.btnCreate);
        btnhistory = (Button) view.findViewById(R.id.btnHistory);
        //mysqLite = new MySQLite(getContext());

        return view;
    }

}

