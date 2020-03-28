package com.example.demosqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListStudents extends AppCompatActivity {
    ListView listView;
    ArrayList<Item> arrayList = new ArrayList<>();
    MyAdapter myAdapter = new MyAdapter(this, arrayList);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        listView = findViewById(R.id.list_item);
        listView.setAdapter(myAdapter);

        init();
    }

    private void init(){
        StudentDatabase studentDatabase = new StudentDatabase(this);
        SQLiteDatabase database = studentDatabase.getReadableDatabase();

        Cursor cursor = studentDatabase.readStudents();

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String date = cursor.getString(cursor.getColumnIndex("DATE"));;
            String school = cursor.getString(cursor.getColumnIndex("SCHOOL"));;

            arrayList.add(new Item(name, date, school));
            myAdapter.notifyDataSetChanged();
        }
    }
}
