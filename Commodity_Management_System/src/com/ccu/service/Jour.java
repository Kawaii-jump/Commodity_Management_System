package com.ccu.service;

public class Jour {
    private String time;
    private String connect;

    public Jour() {
    }

    public Jour(String time, String connect) {
        this.time = time;
        this.connect = connect;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }
}
