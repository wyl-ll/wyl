package com.itheima02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo01JDBC {
    public static void main(String[] args) {
        List<Student> list = new Demo01JDBC().method();
        list.forEach(System.out::println);
    }
    public List<Student> method() {
        List<Student> list = null;
        ResultSet rs = null;
        Statement stat = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt3", "root", "123");
            String sql = "select * from student";
            stat = conn.createStatement();

            rs = stat.executeQuery(sql);
            list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String NAME = rs.getString("NAME");
                float chinese = rs.getFloat("chinese");
                float english = rs.getFloat("english");
                float math = rs.getFloat("math");
                String sex = rs.getString("sex");

                Student stu = new Student();

                stu.setId(id);
                stu.setNAME(NAME);
                stu.setChinese(chinese);
                stu.setEnglish(english);
                stu.setMath(math);
                stu.setSex(sex);

                list.add(stu);
            }
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
        return list;
    }
}
