package com.itheima02;

import com.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//模拟用户登陆
public class User {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String usename = sc.nextLine();
        System.out.println("请输入密码:");
        String usepassword = sc.nextLine();
        boolean b =method(usename, usepassword);
        if(b){
            System.out.println("登陆成功");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
//使用Statement 来实现(静态拼接有bug)
    public static boolean method(String usename,String usepassword){
        Connection conn =null;
        Statement stat=null;
        ResultSet rs = null;
        if(usename==null || usepassword==null){
            return false;
        }
        try {
            conn = JDBCUtils.getConnection();
            stat = conn.createStatement();
            String sql="select * from xinxi where usename= '"+usename+"'and usepassword='"+usepassword+"'";
            rs = stat.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stat,conn);
        }
       return true;
    }
}
