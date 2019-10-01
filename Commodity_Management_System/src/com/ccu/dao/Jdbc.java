package com.ccu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    private static String drive = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String passWord = "mysql";
    private static String URL = "jdbc:mysql://localhost:3308/goods?characterEncoding=utf8&useSSL=false&useUnicode=true";
    private static Connection conn;

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        Jdbc.conn = conn;
    }

    public Jdbc(){
        setcon();
    }

    public static void setcon()  {
        try{
            //加载驱动
            Class.forName(drive);
            //获取连接
            conn = DriverManager.getConnection(URL,userName,passWord);
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
