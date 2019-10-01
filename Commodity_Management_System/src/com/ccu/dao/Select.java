package com.ccu.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Select extends Jdbc {
    private Connection conn;
    private CallableStatement c;
    private ResultSet rs;
    public Select(){

    }
    public ResultSet sel() {
        try {
            conn = Select.getConn();
            c = conn.prepareCall("{call dx()}");
            rs = c.executeQuery();
            return rs;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet setlogin(String user,String pass){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("{call u_p('"+user+"','"+pass+"'"+")}");
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet seluser(int Rank,String username){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("{call seluser("+Rank+",'"+username+"')}");
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet seluser1(int Rank,String username){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("{call seluser1("+Rank+",'"+username+"')}");
            rs = c.executeQuery();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return rs;
    }

    public ResultSet selgoodsclass(){
        try{
            conn = Select.getConn();
            c = conn.prepareCall("call selgoodsclass()");
            rs = c.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet selgoods(String name){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("call selgoods(?)");
            c.setString(1,name);
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet selgoods1(String fame,String name){
        try {
            conn = Select.getConn();
            String sql = "call selgoodss(?,?)";
            c = conn.prepareCall(sql);
            c.setString(1,fame);
            c.setString(2,name);
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet selclass(String name){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("call selclass(?)");
            c.setString(1,name);
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet selorders(String us){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("call selorders(?)");
            if (us==null){

            }
            else if (us.equals("")){
                us=null;
            }
            c.setString(1,us);
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet selJournal(){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("call selJournal()");
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet seluserorders(String us,String user){
        try {
            conn = Select.getConn();
            c = conn.prepareCall("call seluserorders(?,?)");
            if (us==null){

            }
            else if (us.equals("")){
                us=null;
            }
            c.setString(1,us);
            c.setString(2,user);
            rs = c.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public void close() {
        try {
            conn.close();
            c.close();
            rs.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }


    public static void main(String[] args) {
        new Select().selgoods1("","");
    }
}
