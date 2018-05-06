package lichuhao3115005534.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import lichuhao3115005534.model.User;
import lichuhao3115005534.util.StringUtil;

public class Userdao {

	/**
	 * 用户信息确认
	 */
	public static ResultSet logining(Connection con,String name, String password)throws Exception{
		String sbb = ("select * from t_user where user_name ='" + name + "' and user_password ='" + password + "';");
				
		java.sql.Statement ps = con.createStatement();
		ResultSet res = ps.executeQuery(sbb);
		
//		if(res.wasNull()){
//			JOptionPane.showMessageDialog(null, "用户不存在");
//		}
		if(res.wasNull()){
			Exception e = new Exception("用户名或密码错误");
			throw e;
		}
		return res;
	}
	
	public static ResultSet add(Connection con,User user)throws Exception{
		String sbb = ("insert into t_user"
				+ "values(" + user.getId() +",'"+ user.getName() + "','" +user.getPassword()+"','" +user.getSex()+"','" +user.getDept()+"')" + ";");
		
		java.sql.Statement ps = con.createStatement();
		ResultSet res = ps.executeQuery(sbb);
		
		return res;
	}
	
	public static ResultSet alterSex(Connection con,int id, String name)throws Exception{
		String sbb = ("update t_user set user_name ='"+ name +"' where user_id = "+id+ ";");
		
		java.sql.Statement ps = con.createStatement();
		ResultSet res = ps.executeQuery(sbb);
		
		return res;
	}
	
	public static ResultSet delete(Connection con,int id)throws Exception{
		String sbb = ("delete from t_user where user_id = "+ id + ";");
		
		java.sql.Statement ps = con.createStatement();
		ResultSet res = ps.executeQuery(sbb);
		
		return res;
	}
}
