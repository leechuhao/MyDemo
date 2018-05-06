package lichuhao3115005534.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import lichuhao3115005534.model.Book;
import lichuhao3115005534.util.StringUtil;

public class Bookdao {

	/**
     * 图书信息查询
     * @param con
     * @param book
     * @return
     * @throws Exception
     */
    public static ResultSet findBook(Connection con,String name)throws Exception{
    	String sql = ("select * from t_book where book_name like '%" + name + "%'");
    	java.sql.Statement st = con.createStatement();
    	ResultSet res = st.executeQuery(sql);
    	
    	return res;
//        StringBuffer sb=new StringBuffer("select * from t_book where book_id is not null");        
//        if(StringUtil.isNotEmpty(book.getName())){
//            sb.append(" and book_name like '%"+book.getName()+"%'");
//        }
       
//        PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
//        return pstmt.executeQuery();
    }
    
    public static void addBook(Connection con, Book book)throws Exception{
    	String sql = ("insert into t_book values('" +book.getId() +"', '" + book.getName() +"', '" + 
    			book.getType() + "','"+ book.getState() + "');");
    	
    	java.sql.Statement st = con.createStatement();
    	st.executeUpdate(sql);
    }
	
    public static void deleteBook(Connection con, int id)throws Exception{
    	String sql = ("delete from t_book where book_id = " + id);
    	
    	java.sql.Statement st = con.createStatement();
    	st.executeUpdate(sql);	
	}
	
    public static void alterBook(Connection con, int id, String name)throws Exception{
    	String sql = ("update t_book "
    			+ "set  book_name = '" + name 
    			+ " where book_id = '" +id + "';");
    	
    	java.sql.Statement st = con.createStatement();
    	st.executeUpdate(sql);
    }
	
}
