package mySQL;

import java.sql.*;

public class ConnecctSQL {
	Connection con;
	public Connection getConnection(){
		try {//加载数据库驱动
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
		try {//通过访问数据库的URL获取数据库连接对象
			con = DriverManager.getConnection("jdbc:jtbs:sqlserver://localhost:1433/db_jdbc", "sa", "");
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		ConnecctSQL c = new ConnecctSQL();
		c.getConnection();
	}
}
