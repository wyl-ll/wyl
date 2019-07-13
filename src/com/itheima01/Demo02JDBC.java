package com.itheima01;


import java.sql.*;

// t1 表 添加一条数据
public class Demo02JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //写sql语句
            String sql = "insert into t1 value ('zhangsan',1000)";
            //获取链接路径
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt2", "root", "123");
            //获取执行sql对象
            stat = conn.createStatement();
            //执行sql语句
            int i = stat.executeUpdate(sql);
            System.out.println(i);

            if (i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
