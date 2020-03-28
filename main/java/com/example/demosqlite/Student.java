package com.example.demosqlite;

public class Student {
    int ID = 1;
    String fullName, date, school, favorite;
    int sex;

    public Student(int ID, String fullName, String date, String school, String favorite, int sex) {
        this.ID = ID;
        this.fullName = fullName;
        this.date = date;
        this.school = school;
        this.favorite = favorite;
        this.sex = sex;
    }

    public Student(String fullName, String date, String school, String favorite, int sex) {
        this.fullName = fullName;
        this.date = date;
        this.school = school;
        this.favorite = favorite;
        this.sex = sex;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
