package mySQL;

import java.sql.*;
import mySQL.GetConnection;

public class Gradation extends GetConnection{
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	/*public Connection getConnetion(){
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
	}*/
	
	public static void main(String[] args) {
		Gradation c = new Gradation();
		con = c.getConnetion(con);
		try {
			sql = con.createStatement();
			res = sql.executeQuery("select * from mydata.java");
			while(res.next()){
				String id = res.getString("id");
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.print(" 编号： " + id);
				System.out.print(" 姓名： " + name);
				System.out.print(" 性别： " + sex);
				System.out.println(" 生日： " + birthday);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
	
}
