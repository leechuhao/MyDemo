package lichuhao3115005534.util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * 数据库工具类
 */
public class DB_util {
	    private String dbUrl = "jdbc:mysql://localhost:3306/bookmanage";
	    //也可以写成private String dbUrl = "jdbc:mysql:///db_book";
	    private String dbUserName = "root";
	    private String dbPassword = "lichuzxc";
	    private String jdbcName = "com.mysql.jdbc.Driver";

	    /**
	     * 获取数据库连接
	     * @return
	     * @throws Exception
	     */
	    public Connection getCon()throws Exception{
	        Class.forName(jdbcName);
	        Connection con = (Connection) DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//链接数据库
	        return con;

	    }

	    /**
	     * 关闭数据库连接
	     * @param con
	     * @throws Exception
	     */
	    public void closeCon (java.sql.Connection con)throws Exception {
	        if(con!=null){
	            con.close();
//	            System.out.println("数据库断开连接");
	        }
	    }
	    
}

