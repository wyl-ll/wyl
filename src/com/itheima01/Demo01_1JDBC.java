package com.itheima01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01_1JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt2", "root", "123");
        Statement stat = conn.createStatement();
        String sql="update t1 set money=2000 where age=3";
        int i = stat.executeUpdate(sql);
        System.out.println(i);
        stat.close();
        conn.close();
    }

}
