package mySQL;

import java.sql.*;
import mySQL.GetConnection;

public class Gradation extends GetConnection{
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	/*public Connection getConnetion(){
		String jdbc = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mysql";    //JDBC��URL    
		try{
			//����Class.forName()����������������
			Class.forName(jdbc);
			System.out.println("�ɹ�����MySQL������");
		}catch(ClassNotFoundException e1){
			System.out.println("�Ҳ���MySQL����!");
	        e1.printStackTrace();
	    }
		//����DriverManager�����getConnection()���������һ��Connection����
		try {
			con = DriverManager.getConnection(url,"root","lichuzxc");
			//����һ��Statement����
//			Statement stmt = con.createStatement(); //����Statement����
			System.out.println("�ɹ����ӵ����ݿ⣡");
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
				System.out.print(" ��ţ� " + id);
				System.out.print(" ������ " + name);
				System.out.print(" �Ա� " + sex);
				System.out.println(" ���գ� " + birthday);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
	}
	
}
