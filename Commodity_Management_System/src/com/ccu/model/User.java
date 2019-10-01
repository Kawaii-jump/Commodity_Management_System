package com.ccu.model;

public class User {
    private String userName;
    private String passward;
    private int rank;
    private String phone;

    public User(){}

    public User(String userName, String passward, int rank, String phone) {
        this.userName = userName;
        this.passward = passward;
        this.rank = rank;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
