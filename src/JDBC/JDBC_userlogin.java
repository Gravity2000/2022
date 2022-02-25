package JDBC;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Scanner;

public class JDBC_userlogin {

    @Test
    public void login() throws Exception{
        String url="jdbc:mysql://localhost:3306/login?useSSL=false";
        String username="root";
        String password="1234";
        Connection conn= DriverManager.getConnection(url, username, password);

        String name="uki777";
        String pwd="98888."; //会被'or '1' = '1';注入破解

        String sql="select * from login where username='"+name+"' and password='"+pwd+"'";
        Statement stmt=conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        if (resultSet.next()){
            System.out.println("登陆成功");
        }else
            System.out.println("登录失败");

        resultSet.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void login2() throws Exception{
        String url="jdbc:mysql://localhost:3306/login?useSSL=false";
        String username="root";
        String password="1234";
        Connection conn= DriverManager.getConnection(url, username, password);

        String name="uki777";
        String pwd="98888."; //不会被'or '1' = '1';注入破解

        String sql="select * from login where username=? and password=?";
        PreparedStatement pstmt=conn.prepareStatement(sql);

        pstmt.setString(1,name);
        pstmt.setString(2,pwd);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()){
            System.out.println("登陆成功");
        }else
            System.out.println("登录失败");

        resultSet.close();
        pstmt.close();
        conn.close();
    }
}
