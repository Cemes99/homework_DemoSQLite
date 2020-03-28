package com.example.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QUANLYSINHVIEN.db";
    private static final String TABLE_NAME = "SINHVIEN";
    private static final String ID = "ID";
    private static final String NAME = "TEN";
    private static final String DATE = "TUOI";
    private static final String SCHOOL = "SCHOOL";
    private static final String SEX = "SEX";
    private static final String FAVORITE = "FAVORITE";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + "(" + ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " text, " + DATE + " text, " + SCHOOL + " text, "
            + SEX + " integer, " + FAVORITE + " text)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private static final int VERSION = 1;

    public StudentDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void addStudent(Student student){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(ID, student.getID());
        contentValues.put(NAME, student.getFullName());
        contentValues.put(DATE, student.getDate());
        contentValues.put(SCHOOL, student.getSchool());
        contentValues.put(SEX, student.getSex());
        contentValues.put(FAVORITE, student.getFavorite());

        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public Cursor readStudents(){
        String[] columns = {ID, NAME, DATE, SCHOOL, SEX, FAVORITE};

        Cursor cursor = getReadableDatabase().query(TABLE_NAME, columns,
                null, null, null, null, null);

        return cursor;
    }

    public void updateStudent(){

    }

    public void deleteStudent(){

    }

    public void getStudent(){

    }
}
