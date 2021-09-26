package com.istic.mmm.tp1;

import java.util.Date;


public class Client {
    public int id;
    public String name;
    public String date;

    Client(int i, String n, String d) {
        id = i; name = n; date = d;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
