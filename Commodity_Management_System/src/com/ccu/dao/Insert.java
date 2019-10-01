package com.ccu.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

public class Insert extends Jdbc{
    private Connection conn;
    private CallableStatement c;
    private ResultSet rs;
    public Insert(){

    }

    public boolean inuser(int Number,String Username,String Password,int Rank,String phone){
        try {
            conn = Insert.getConn();
            c = conn.prepareCall("{call inuser(?,?,?,?,?)}");
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

    public boolean ingoods(String gi,String gn,String cf,double p,int s){
        try {
            conn = Insert.getConn();
            c = conn.prepareCall("{call ingoods(?,?,?,?,?)}");
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
    public boolean inclass(String cln,String cfn){
        try {
            conn = Insert.getConn();
            c = conn.prepareCall("{call inclass(?,?)}");
            c.setString(1,cln);
            c.setString(2,cfn);
            int a = c.executeUpdate();
            if (a!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean inusergoods(String gi,int num,double p,String user){
        try {
            conn = Insert.getConn();
            c = conn.prepareCall("{call inusergoods(?,?,?,?)}");
            c.setString(1,gi);
            c.setInt(2,num);
            c.setDouble(3,p);
            c.setString(4,user);
            int a = c.executeUpdate();
            if (a!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean Jwrite(String str){
        try {
            conn = Insert.getConn();
            c = conn.prepareCall("{call Jwrite(?)}");
            c.setString(1,str);
            int a = c.executeUpdate();
            if(a!=0)return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
