package mySQL;

import java.sql.*;

public class GetConnection {
	public Connection getConnetion(Connection con){
		String jdbc = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mysql";    //JDBC的URL    
		try{
			//调用Class.forName()方法加载驱动程序
			Class.forName(jdbc);
			System.out.println("成功加载MySQL驱动！");
		}catch(ClassNotFoundException e1){
			System.out.println("找不到MySQL驱动!");
	        e1.printStackTrace();
	    }
		//调用DriverManager对象的getConnection()方法，获得一个Connection对象
		try {
			con = DriverManager.getConnection(url,"root","lichuzxc");
			//创建一个Statement对象
//			Statement stmt = con.createStatement(); //创建Statement对象
			System.out.println("成功连接到数据库！");
//			stmt.close();
//			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}    
		return con;
	}
}