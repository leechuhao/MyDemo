package mySQL;

import java.sql.*;

public class GetConnection {
	public Connection getConnetion(Connection con){
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
	}
}