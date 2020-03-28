package com.example.demosqlite;

public class Item {
    String name, birthday, school, sex, favor;

    public Item(String name, String birthday, String school) {
        this.name = name;
        this.birthday = birthday;
        this.school = school;
    }

    public Item(String name, String birthday, String school, String sex, String favor) {
        this.name = name;
        this.birthday = birthday;
        this.school = school;
        this.sex = sex;
        this.favor = favor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }
}
