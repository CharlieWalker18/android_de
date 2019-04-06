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

public class taobanAdapter extends ArrayAdapter<model> {
    static List<Votes> list;
    int GroupID;
    Context context;
    MySQLite mySQLite;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public taobanAdapter(Context context, int resource, List<model> objects, int groupID) {
        super(context, resource, objects);
        GroupID = groupID;
        this.context = context;
    }

    class ViewHolder {
        TextView text1;
        TextView text2;
        TextView text3;
        LinearLayout layout;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        final Votes votes = list.get(position);
        if (viewHolder == null) {
            convertView = LayoutInflater.from(context).inflate(GroupID, parent, false);
            viewHolder.text1 = convertView.findViewById(R.id.txt1);
            viewHolder.text2 = convertView.findViewById(R.id.txt2);
            viewHolder.text3 = convertView.findViewById(R.id.txt3);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //model item = getItem(position);
        viewHolder.text1.setText(String.valueOf(votes.getTenBan()));
        viewHolder.text2.setText(String.valueOf(votes.getSoluongban()));
        viewHolder.text3.setText(String.valueOf(votes.getTinhtrangban()));

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ChiTietActivity.class);
                i.putExtra("ct", votes);
                context.startActivity(i);
            }
        });
        return convertView;
    }
}

