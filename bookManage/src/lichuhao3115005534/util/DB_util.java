package lichuhao3115005534.util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * ���ݿ⹤����
 */
public class DB_util {
	    private String dbUrl = "jdbc:mysql://localhost:3306/bookmanage";
	    //Ҳ����д��private String dbUrl = "jdbc:mysql:///db_book";
	    private String dbUserName = "root";
	    private String dbPassword = "lichuzxc";
	    private String jdbcName = "com.mysql.jdbc.Driver";

	    /**
	     * ��ȡ���ݿ�����
	     * @return
	     * @throws Exception
	     */
	    public Connection getCon()throws Exception{
	        Class.forName(jdbcName);
	        Connection con = (Connection) DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//�������ݿ�
	        return con;

	    }

	    /**
	     * �ر����ݿ�����
	     * @param con
	     * @throws Exception
	     */
	    public void closeCon (java.sql.Connection con)throws Exception {
	        if(con!=null){
	            con.close();
//	            System.out.println("���ݿ�Ͽ�����");
	        }
	    }
	    
}

