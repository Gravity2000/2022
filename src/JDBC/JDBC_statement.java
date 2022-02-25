package JDBC;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_statement {
   //执行DML语句，DML即增删查改语句
   @Test
   public void testDML() throws Exception{

         //1、注册驱动
         Class.forName("com.mysql.jdbc.Driver");

         //2、获取连接
         String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
         String username="root";
         String password="1234";
         Connection conn=DriverManager.getConnection(url, username, password);

         //3、定义sql语句
         String sql1="update stu set age = 1 where id=1";
         String sql2="update stu set age = 1 where id=2";
         //4、获取执行sql的对象statement
         Statement stmt=conn.createStatement();

         //5、执行sql
         int count=stmt.executeUpdate(sql1); //执行完DML语句后，受影响的行数
         stmt.executeUpdate(sql2);
         if(count>0){
            System.out.println("修改成功");
         }else
         {
            System.out.println("修改失败");
         }

         stmt.close();
         conn.close();

   }

   //执行DDL语句，DDL即创建，ALTER，DROP语句
   @Test
   public void testDDL() throws Exception{

      //1、注册驱动
      Class.forName("com.mysql.jdbc.Driver");

      //2、获取连接
      String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
      String username="root";
      String password="1234";
      Connection conn=DriverManager.getConnection(url, username, password);

      //3、定义sql语句
      String sql1="create database db2";
      String sql2="drop database db2";
      //4、获取执行sql的对象statement
      Statement stmt=conn.createStatement();

      //5、执行sql
      int count=stmt.executeUpdate(sql1); //执行完DML语句后，受影响的行数
      stmt.executeUpdate(sql2);
      if(count>0){
         System.out.println("修改成功");
      }else
      {
         System.out.println("修改失败");
      }

      stmt.close();
      conn.close();

   }

   @Test
    public void insert() throws Exception{
       String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
       String username="root";
       String password="1234";
       Connection conn=DriverManager.getConnection(url, username, password);

       Statement stmt=conn.createStatement();
       String sql="insert into stu(id,name,age) values(4,'james',33)";
       int count = stmt.executeUpdate(sql);
       if(count>0){
           System.out.println("修改成功");
       }else
       {
           System.out.println("修改失败");
       }

       stmt.close();
       conn.close();

   }
}
