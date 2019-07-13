package com.itheima01;


import java.sql.*;

// 读取t1 表 中的数据
public class Demo03JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //写sql语句
            String sql = "select * from t1";
            //获取链接路径
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt2", "root", "123");
            //获取执行sql对象
            stat = conn.createStatement();
            //执行sql语句
            rs = stat.executeQuery(sql);//操作DQL语句
            rs.next();                  // boolean next() 将光标从当前位置向下移一行。
            String name = rs.getString("name");
            double d = rs.getDouble(2);
            int i = rs.getInt(3);
            System.out.println(name + "--" + d + "--" + 3);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
