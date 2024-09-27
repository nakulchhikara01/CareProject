package com.example.careproject;

public class Person {
    String Name;
    String Des;

    public Person(String name, String des) {
        Name = name;
        Des = des;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
}
