package com.itheima03;

import com.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//JDBC管理事务
public class Demo01JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            //获取链接
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);//false为开启
            //定义sql语句
            String sql1 = "update t2 set money=money-? where id=?";
            String sql2 = "update t2 set money=money+? where id=?";
            //获取执行sql语句对象
            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);
            ps1.setDouble(1,500);
            ps1.setInt(2,1);
            //赋值
            ps2.setDouble(1,500);
            ps2.setInt(2,2);

             ps1.executeUpdate();


             //int a=3/0;
             ps2.executeUpdate();
             //提交事务
            conn.commit();


        } catch (Exception e) {
            if (conn!=null) {
                try {
                    //出现任何异常都会回滚
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(ps1,conn);
            JDBCUtils.close(ps2,null);
        }
    }
}
