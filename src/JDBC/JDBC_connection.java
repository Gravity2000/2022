package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_connection {
    public static void main(String[] args) throws Exception{
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
        String username="root";
        String password="1234";
        Connection conn= DriverManager.getConnection(url, username, password);

        //3、定义sql语句
        String sql1="update stu set age = 19 where id=1";
        String sql2="update stu set age = 19 where id=2";
        //4、获取执行sql的对象statement
        Statement stmt=conn.createStatement();

        //开启事务，为了便于回滚事务，使用try/catch

        try {
            //开启事务
            conn.setAutoCommit(false); //false为手动提交，true为自动提交

            //5、执行sql
            int count1=stmt.executeUpdate(sql1);

            System.out.println(count1);



            int count2=stmt.executeUpdate(sql2);

            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (SQLException throwables) {
            //回滚事务
            throwables.printStackTrace();
        }

        stmt.close();
        conn.close();
    }
}
