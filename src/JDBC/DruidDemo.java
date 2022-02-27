package JDBC;


//数据库连接池是个容器，负责分配管理数据库连接
//允许应用程序重复使用现有的一个数据库连接，而不是再建立一个
//释放空间时间超过最大空闲时间的数据库连接来避免因为没有释放数据库连接而引起的数据库连接遗漏
//数据库连接池好处：1、资源重用  2、提升系统响应速度 3、避免数据库连接遗漏

//所使用的的jar包，druid-1-1-12.jar


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

//Druid数据池演示
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //导入Jar包

        //定义配置文件druid.properties

        //加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("C:\\Users\\86189\\Desktop\\2022.2.23\\gitstudy\\src\\druid.properties"));
        //获取连接池对象


        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);


        //获取数据库连接Connection
        Connection connection=dataSource.getConnection();
        System.out.println(connection);

        System.out.println(System.getProperty("user.dir")); //打印出当前路径
    }

}
