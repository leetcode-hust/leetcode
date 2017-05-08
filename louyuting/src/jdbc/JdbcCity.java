package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class JdbcCity {

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
            for(long i=1; i<=1000; i++){
                // 4.操作sql语句r
                Random random = new Random();
                StringBuilder city = new StringBuilder("");
                for(int j=0; j<12; j++){
                    city.append( 'a'+(random.nextInt(24)) );
                }

                String sql = "insert INTO city_demo (city) VALUES ('"+ city.toString() +"'";
                // 操作sql语句(select语句),会得到一个ResultSet结果集
                boolean flag= st.execute(sql);
            }
        } finally {
            if(st!=null)
                st.close();
            if(con!=null)
                con.close();
        }

	}
	
}






