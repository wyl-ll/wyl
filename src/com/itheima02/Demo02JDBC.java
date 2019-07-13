package com.itheima02;

import com.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//利用工具类
public class Demo02JDBC {
    public static void main(String[] args) {
        List<Student> list = new Demo02JDBC().method();
        list.forEach(System.out::println);
    }
    public List<Student> method() {
        List<Student> list = null;
        ResultSet rs = null;
        Statement stat = null;
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();//工具类名直接调用静态方法
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(rs,stat,conn);//工具类名直接调用静态方法

        return list;
    }
}
