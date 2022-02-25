package JDBC;

import org.junit.jupiter.api.Test;
import pojo.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC_resultset {

    //DQL语句，即查询语句
   @Test
           public void testResultset() throws Exception{
       //1、注册驱动
       Class.forName("com.mysql.jdbc.Driver");

       //2、获取连接
       String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
       String username = "root";
       String password = "1234";
       Connection conn = DriverManager.getConnection(url, username, password);

       //定义sql语句
       String sql="select * from stu";

        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);

        while(rs.next()){
            int ID = rs.getInt("id");
            String name = rs.getString(2);
            double age=rs.getDouble(3);
            System.out.println(ID);
            System.out.println(name);
            System.out.println(age);

            System.out.println("=============================");


        }
        rs.close();
        conn.close();
        stmt.close();
   }


   //查询stu表数据，封装到stu类中，并且存储到ArrayList集合中
    //1、定义实体类stu
    //2、查询数据，封装到stu对象中
    //3、将stu对象存入到ArrayList对象中
   @Test
    public void testresult2() throws Exception{
       //1、注册驱动
       Class.forName("com.mysql.jdbc.Driver");

       //2、获取连接
       String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
       String username = "root";
       String password = "1234";
       Connection conn = DriverManager.getConnection(url, username, password);

       //定义sql语句
       String sql="select * from stu";

       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(sql);

       //创建集合用于存放stu对象
       List<stu> arr=new ArrayList<>(); //程序要尽量依赖于抽象，使用接口

       while(rs.next()){ //光标向下移动一行，并判断当前行是否为有效行
           stu stu1=new stu();
           int ID = rs.getInt("id");
           String name = rs.getString(2);
           double age=rs.getDouble(3);

           //给stu赋值
           stu1.setId(ID);
           stu1.setName(name);
           stu1.setAge(age);

           arr.add(stu1);
       }
       System.out.println(arr);  //需要重写toString方法

       rs.close();
       conn.close();
       stmt.close();
   }
}
