package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fullName, date, school;
    private RadioButton male, female;
    private CheckBox readBook, travel, sport;
    private Button input, again, viewList;
    private StudentDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectView();

        // set listen click of button
        input.setOnClickListener(this);
        again.setOnClickListener(this);
        viewList.setOnClickListener(this);

        // create new database
        db = new StudentDatabase(this);
    }

    private void connectView(){
        fullName = findViewById(R.id.full_name);
        date = findViewById(R.id.date);
        school = findViewById(R.id.school);

        male = findViewById(R.id.radioMale);
        female = findViewById(R.id.radioFemale);

        readBook = findViewById(R.id.read_book);
        travel = findViewById(R.id.travel);
        sport = findViewById(R.id.sport);

        input = findViewById(R.id.input);
        again = findViewById(R.id.again);
        viewList = findViewById(R.id.view_list);
    }

    @Override
    public void onClick(View v) {
        if(v == input) {
            String n = fullName.getText().toString();
            String d = date.getText().toString();
            String s = this.school.getText().toString();

            int sx = 0;
            if(female.isChecked()) sx = 1;

            String f = "";
            if(readBook.isChecked()) f += "read book\n";
            if(travel.isChecked()) f += "travel\n";
            if(sport.isChecked()) f += "sport";

            Student student = new Student(n, d, s, f, sx);

            if(student!= null) {
                db.addStudent(student);
                Toast.makeText(MainActivity.this, "Tạo sinh viên thành công",
                        Toast.LENGTH_SHORT).show();
            }
        }

        if(v == again) {
            fullName.setText("");
            date.setText("");
            school.setText("");

            male.setChecked(true);

            readBook.setChecked(false);
            travel.setChecked(false);
            sport.setChecked(false);
        }

        if(v == viewList) {
            Intent intent = new Intent(MainActivity.this, ListStudents.class);
            startActivity(intent);
        }
    }

    // BT thêm sửa xóa xem danh sách sinh viên trong database
}
