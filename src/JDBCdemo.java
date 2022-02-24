import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCdemo {


    public static void main(String[] args) throws Exception{
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url="jdbc:mysql://localhost:3306/db1";
        String username="root";
        String password="1234";
        Connection conn=DriverManager.getConnection(url, username, password);

        //3、定义sql语句
        String sql="update stu set age = 19 where id=1";

        //4、获取执行sql的对象statement
        Statement stmt=conn.createStatement();

        //5、执行sql
        int count=stmt.executeUpdate(sql);

        System.out.println(count);

        stmt.close();
        conn.close();
    }
}
