package com.itheima01;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo01JDBC {
    public static void main(String[] args) throws Exception {
        //导入jar包
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt2", "root", "123");
        //定义sql语句
        String sql = "update t1 set money=2000 where name='huge'";

        //获取执行sql语句对象Statement
        Statement statement = conn.createStatement();
        //执行sql
        int i = statement.executeUpdate(sql);// 执行DML(insert,update,delete)语句,DDL语句


        System.out.println();
        System.out.println("git");

        statement.close();
        conn.close();


    }
}
