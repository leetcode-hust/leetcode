package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Created by louyuting on 2017/2/20.
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException {
        Connection con= null;
        Statement st=null;
        int count=1;

        try {
            //1. 注册驱动
            DriverManager.registerDriver(new Driver());
            // 2.获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/louyuting", "root", "vstar123");
            // 3.通过连接对象获取操作sql语句Statement
            st = con.createStatement();
            // 4.操作sql语句
            String sql = "select * from item where name = 'name10000000'";
            // 操作sql语句(select语句),会得到一个ResultSet结果集

            long start = System.currentTimeMillis();
            ResultSet resultSet = st.executeQuery(sql);

            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                System.out.println(id);
            }
            long end = System.currentTimeMillis();

            System.out.println("time: " + (end-start)/1000);
        } finally {
            if(st!=null)
                st.close();
            if(con!=null)
                con.close();
        }

    }
}
