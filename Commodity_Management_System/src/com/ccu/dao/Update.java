package com.ccu.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

public class Update extends Jdbc{
    private Connection conn;
    private CallableStatement c;

    public Update(){

    }

    public boolean UpUser(int Number,String Username,String Password,int Rank,String phone){
        try {
            conn = Update.getConn();
            c = conn.prepareCall("{call upuser(?,?,?,?,?)}");
            c.setInt(1,Number);
            c.setString(2,Username);
            c.setString(3,Password);
            c.setInt(4,Rank);
            c.setString(5,phone);
            int a = c.executeUpdate();
            if (a!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean upgoods(String gi,String gn,String cf,double p,int s){
        try {
            conn = Update.getConn();
            c = conn.prepareCall("{call upgoods(?,?,?,?,?)}");
            c.setString(1,gi);
            c.setString(2,gn);
            c.setString(3,cf);
            c.setDouble(4,p);
            c.setInt(5,s);
            int a = c.executeUpdate();
            if (a!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean Upclass(String cfnum,String cfn){
        try {
            conn = Update.getConn();
            c = conn.prepareCall("{call upclass(?,?)}");
            c.setString(1,cfnum);
            c.setString(2,cfn);
            int a = c.executeUpdate();
            if (a!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean Uporder(int id,int num1,double price,int num2){
        try {
            conn = Update.getConn();
            c = conn.prepareCall("{call uporders(?,?,?,?)}");
            c.setInt(1,id);
            c.setInt(2,num1);
            c.setDouble(3,price);
            c.setInt(4,num2);
            int a = c.executeUpdate();
            if (a!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
