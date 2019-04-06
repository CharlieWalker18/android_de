package com.example.dangvannam.coffeapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<model> {
    private Context mContext;
    private List<model> list;
    private int mResourse;
    public SanPhamAdapter( Context context, int resource, List<model> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.list = objects;
        this.mResourse = resource;
    }
    class ViewHolder{
        TextView textViewSanPham;
        TextView textViewMaSanPham;
        TextView textViewDonViTinh;
        TextView textViewGiaTien;
        LinearLayout sanpham;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        final  model model =list.get(position);
        if (viewHolder == null){
            convertView = LayoutInflater.from(mContext).inflate(mResourse,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textViewSanPham = convertView . findViewById(R.id.mh_tv_TenSanPham);
            viewHolder.textViewMaSanPham = convertView .findViewById(R.id.mh_tv_MaSanPham);
            viewHolder.textViewDonViTinh = convertView. findViewById(R.id.mh_tv_DonViTinh);
            viewHolder.textViewGiaTien = convertView.findViewById(R.id.mh_tv_GiaTien);
            viewHolder.sanpham = convertView.findViewById(R.id.coffe);
        }
        else{
            viewHolder =(ViewHolder)convertView.getTag();
        }
        model item = list.get(position);
        //model item = getItem(position);
        viewHolder.textViewMaSanPham.setText(String.valueOf(item.getMaSanPham()));
        viewHolder.textViewSanPham.setText(String.valueOf(item.getTenSanPham()));
        viewHolder.textViewDonViTinh.setText(String.valueOf(item.getDonViTinh()));
        viewHolder.textViewGiaTien.setText(String.valueOf(item.getGiaTien()));

        viewHolder.sanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, UpdateChiTietActivity.class);
                i.putExtra("MaSP", model.getMaSanPham());
                i.putExtra("Ten",model.getTenSanPham());
                i.putExtra("DonVitinh",model.getDonViTinh());
                i.putExtra("Giatien",model.getGiaTien());
                i.putExtra("ID", model.getID());
                i.putExtra("index",position);
                mContext.startActivity(i);
            }
        });
        return convertView;
    }

}
