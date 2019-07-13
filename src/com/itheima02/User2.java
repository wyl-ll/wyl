package com.itheima02;

import com.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

//模拟用户登陆
public class User2 {
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
//使用PrepareStatement 来实现
    public static boolean method(String usename,String usepassword){
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        if(usename==null || usepassword==null){
            return false;
        }
        try {
            //获取链接
            conn = JDBCUtils.getConnection();
            //定义sql语句
            String sql="select * from xinxi where usename= ? and usepassword= ? ";
            //获取执行sql语句对象
            ps = conn.prepareStatement(sql);
            //赋值
            ps.setString(1,usename);
            ps.setString(2,usepassword);
            //执行查询语句
            rs= ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
       return true;
    }
}
