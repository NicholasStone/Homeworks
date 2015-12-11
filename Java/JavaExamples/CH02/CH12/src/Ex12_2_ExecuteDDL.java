import java.sql.*;
import java.util.*;
import java.io.*;

public class Ex12_2_ExecuteDDL {
	private String driver;
	private String url;
	private String user;
	private String pass;
	Connection conn;
	Statement stmt;

	public void initParam(String paramFile)throws Exception	{
		//ʹ��Properties�������������ļ�
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void createTable(String sql)throws Exception	{
		try{
			//��������
			Class.forName(driver);
			//��ȡ���ݿ�����
			conn = DriverManager.getConnection(url , user , pass);
			//ʹ��Connection������һ��Statment����
			stmt = conn.createStatement();
			//ִ��DDL,�������ݱ�
			stmt.executeUpdate(sql);
		}
		//ʹ��finally�����ر����ݿ���Դ
		finally{
			if (stmt != null){
				stmt.close();
			}
			if (conn != null){
				conn.close();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Ex12_2_ExecuteDDL ed = new Ex12_2_ExecuteDDL();
		ed.initParam("mysql.ini");
		ed.createTable("create table jdbc_test "
			+ "( jdbc_id int auto_increment primary key, " 
			+ "jdbc_name varchar(255), "
			+ "jdbc_desc text);");
		System.out.println("---------����ɹ�--------");
	}
}
