package com.ccu.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

public class Delete extends Jdbc{
    private Connection conn;
    private CallableStatement c;
    public Delete(){

    }

    public boolean deluser(int Number){
        try {
            conn = Delete.getConn();
            c = conn.prepareCall("call deluser(?)");
            c.setInt(1,Number);
            int t = c.executeUpdate();
            if(t!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delgoods(String GoodsId){
        try {
            conn = Delete.getConn();
            c = conn.prepareCall("call delgoods(?)");
            c.setString(1, GoodsId);
            int t = c.executeUpdate();
            if(t!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delclass(String ClassificationNum){
        try {
            conn = Delete.getConn();
            c = conn.prepareCall("call delclass(?)");
            c.setString(1, ClassificationNum);
            int t = c.executeUpdate();
            if(t!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delorders(int num){
        try {
            conn = Delete.getConn();
            c = conn.prepareCall("call delorders(?)");
            c.setInt(1, num);
            int t = c.executeUpdate();
            if(t!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
