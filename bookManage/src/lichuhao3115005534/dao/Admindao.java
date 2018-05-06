package lichuhao3115005534.dao;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Admindao {
	public static ResultSet logining(Connection con,String name, String password)throws Exception{
		String sbb = ("select * from t_admin where account ='" + name + "' and password ='" + password + "';");
				
		java.sql.Statement ps = con.createStatement();
		ResultSet res = ps.executeQuery(sbb);
		if(res.wasNull()){
			Exception e = new Exception("用户名或密码错误");
			throw e;
		}
		return res;
	}
}
