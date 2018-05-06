package lichuhao3115005534.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import com.mysql.jdbc.util.ResultSetUtil;

import lichuhao3115005534.model.Book;

public class LendOrRe {
	public static void addLend(Connection con, int id, int book_id, int user_id, String day)throws Exception{
    	String sql = ("insert into lend values(" +id +", " + book_id+", " + user_id + ",'" + day + "');");
    	
    	java.sql.Statement st = con.createStatement();
    	st.executeUpdate(sql);
    }
	
	public static void addRe(Connection con, int lend_id, Date date)throws Exception{
    	String sql = ("insert into re values(" +lend_id + ",'" + date + "');");
    	
    	java.sql.Statement st = con.createStatement();
    	st.executeUpdate(sql);
    }
	
	public static int checkid(Connection con)throws Exception{
		int id;
		String sql = ("select max(lend_id) from lend;");
    	
    	java.sql.Statement st = con.createStatement();
    	ResultSet res = st.executeQuery(sql);
    	if(res.next()){
    		id = res.getInt("max(lend_id)");
    		return id+1;
    	}
    	return 0;
	}
}
