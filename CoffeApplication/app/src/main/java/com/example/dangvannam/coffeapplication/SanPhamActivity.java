package com.example.dangvannam.coffeapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SanPhamActivity extends AppCompatActivity {
    ListView listView;
    static List<model> modelList;
    static SanPhamAdapter adapter;
    TextView textViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        onInit();
        ontSetValue();
        adapter = new SanPhamAdapter(SanPhamActivity.this,R.layout.sanpham_item,modelList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                model item = (model) listView.getItemAtPosition(position);
                Intent intent = new Intent(SanPhamActivity.this,ChiTietActivity.class);
                intent.putExtra("CTSP",item);
                startActivity(intent);
            }
        });
        textViewContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void ontSetValue() {
        modelList = new ArrayList<>();
        modelList.add(new model("AMERICANO", "CB110", "000.000.0VND", "50.000VND", 01));
        modelList.add(new model("CAPPUCINNO", "CB112", "000.000.0VND", "80.000VND",1));
        modelList.add(new model("CARAMEL MACCHIATO", "CB113", "000.000.0", "55.000VND",2));
        modelList.add(new model("ESPRESSO", "CB114", "000.000.0VND", "45.000VND",3));
        modelList.add(new model("LATE", "CB115", "000.000.0VND", "50.000VND",4));
        modelList.add(new model("MOCHA", "CB115", "000.000.0VND", "60.000VND",5));
    }

    private void onInit() {
        listView = findViewById(R.id.lvSanPham);
        textViewContent = findViewById(R.id.tv_content);
    }
    public class SanPhamAdapter extends ArrayAdapter<model>{
        private Context mContext;
        private List<model> list;
        private int mResource;
        public SanPhamAdapter( Context context, int resource, List<model> objects) {
            super(context, resource, objects);
            this.mContext = context;
            this.list = objects;
            this.mResource = resource;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (viewHolder == null){
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textViewSanPham = convertView.findViewById(R.id.mh_tv_TenSanPham);
            viewHolder.textViewMaSP = convertView.findViewById(R.id.mh_tv_MaSanPham);
            viewHolder.textViewDonViTinh = convertView.findViewById(R.id.mh_tv_DonViTinh);
            viewHolder.textViewGiaTien = convertView.findViewById(R.id.mh_tv_GiaTien);
            viewHolder.ivDelete = convertView.findViewById(R.id.item_iv_delete);
            viewHolder.ivUpdate = convertView.findViewById(R.id.item_iv_update);
        }
        else{
                viewHolder = (ViewHolder)convertView.getTag();
            }
            final model item = list.get(position);
            model item1 = getItem(position);
            viewHolder.textViewMaSP.setText(String.valueOf(item.getMaSanPham()));
            viewHolder.textViewSanPham.setText(String.valueOf(item.getTenSanPham()));
            viewHolder.textViewDonViTinh.setText(String.valueOf(item.getDonViTinh()));
            viewHolder.textViewGiaTien.setText(String.valueOf(item.getGiaTien()));
            viewHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(item);
                    notifyDataSetChanged();

                }
            });
            viewHolder.ivUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SanPhamActivity.this,UpdateChiTietActivity.class);
                    intent.putExtra("UPDAEITEM",item);
                    intent.putExtra("POS",position);
                    startActivity(intent);
                }
            });
            return convertView;
    }
        public class ViewHolder{
            TextView textViewSanPham;
            TextView textViewMaSP;
            TextView textViewDonViTinh;
            TextView textViewGiaTien;
            ImageView ivUpdate;
            ImageView ivDelete;
        }
    }
}

    
