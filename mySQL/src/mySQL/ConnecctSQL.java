package mySQL;

import java.sql.*;

public class ConnecctSQL {
	Connection con;
	public Connection getConnection(){
		try {//�������ݿ�����
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			System.out.println("���ݿ��������سɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
		try {//ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
			con = DriverManager.getConnection("jdbc:jtbs:sqlserver://localhost:1433/db_jdbc", "sa", "");
			System.out.println("���ݿ����ӳɹ�");
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
