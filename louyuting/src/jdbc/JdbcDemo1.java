package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) throws SQLException {
        Connection con= null;
        Statement st=null;
        int count=1;

        try {
            //1. 注册驱动
            DriverManager.registerDriver(new Driver());
            // 2.获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/louyuting", "root", "vstar123");
            //System.out.println(con);
            // 3.通过连接对象获取操作sql语句Statement
            st = con.createStatement();
            for(long i=100000000; i<=100000000; i++){
                // 4.操作sql语句
                String sql = "insert INTO item (id, name, email, phone, address) VALUES ('"+i +"'," +"'name"+i + "','"+ System.currentTimeMillis()+"@qq.com','"+System.currentTimeMillis()+"','"+ "HUST-" +i+ "')";
                // 操作sql语句(select语句),会得到一个ResultSet结果集
                boolean flag= st.execute(sql);
                if(i % 100000 == 0){
                    System.out.println("输出"+ 10*count +"万条数据了.");
                    count++;
                }
                if(i % 1000000 == 0){
                    System.out.println("[输出"+ 100*count +"万条数据了.]");
                }
                if(i % 10000000 == 0){
                    System.out.println("[输出"+ 1000*count +"万条数据了.]");
                }
            }
        } finally {
            if(st!=null)
                st.close();
            if(con!=null)
                con.close();
        }

	}
	
}






