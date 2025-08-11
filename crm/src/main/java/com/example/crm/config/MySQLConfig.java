package com.example.crm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {
    private static final String url = "jdbc:mysql://localhost:3307/crm_app";
    private static final String user = "root";
    private static final String password = "Huynhbao2606";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.out.println("Lỗi Kết Nối: " + e.getMessage());
        }

        return conn;
    }

}
