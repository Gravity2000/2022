package Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import pojo.brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {

    @Test
    public void BrandTest() throws Exception {
        Properties prop=new Properties();
        prop.load(new FileInputStream("C:\\Users\\86189\\Desktop\\2022.2.23\\gitstudy\\src\\druid.properties"));
        //获取连接池对象


        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);


        //获取数据库连接Connection
        Connection conn=dataSource.getConnection();

        //查询操作

        String sql="select * from tb_brand";
        PreparedStatement pstmt=conn.prepareStatement(sql);

        //Statement不对sql语句作处理，直接交给数据库；而PreparedStatement支持预编译，会将编译好的sql语句放在数据库端，相当于缓存。对于多次重复执行的sql语句，使用PreparedStatement可以使得代码的执行效率更高。
        //
        //Statement的sql语句使用字符串拼接的方式，容易导致出错，且存在sql注入的风险；PreparedStatement使用“?”占位符提升代码的可读性和可维护性，并且这种绑定参数的方式，可以有效的防止sql注入。


        ResultSet resultSet = pstmt.executeQuery();

        List<brand> arr=new ArrayList<>();
        while(resultSet.next()){
            brand brand1=new brand();
            int ID=resultSet.getInt(1);
            String brand_name=resultSet.getString(2);
            String company_name=resultSet.getString(3);
            int ordered=resultSet.getInt(4);
            String description=resultSet.getString(5);
            int status=resultSet.getInt(6);

            brand1.setId(ID);
            brand1.setBrand_name(brand_name);
            brand1.setCompany_name(company_name);
            brand1.setOrdered(ordered);
            brand1.setDescription(description);
            brand1.setStatus(status);

            arr.add(brand1);
            System.out.println(brand1.toString());
        }
       resultSet.close();
        conn.close();
        pstmt.close();



    }
}
