package com.example.demosqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;

    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView =layoutInflater.inflate(R.layout.item, parent, false);

        TextView name = convertView.findViewById(R.id.name_description);
        TextView age = convertView.findViewById(R.id.age_description);
        TextView school = convertView.findViewById(R.id.school_description);

        name.setText(items.get(position).getName());
        age.setText(items.get(position).getBirthday());
        school.setText(items.get(position).getSchool());

        return convertView;
    }
}
