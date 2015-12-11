import java.sql.*;
import java.util.*;
import java.io.*;

public class Ex12_3_ExecuteDML {
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

	public int insertData(String sql)throws Exception	{
		try{
			//��������
			Class.forName(driver);
			//��ȡ���ݿ�����
			conn = DriverManager.getConnection(url , user , pass);
			//ʹ��Connection������һ��Statment����
			stmt = conn.createStatement();
			//ִ��DML,������Ӱ��ļ�¼����
			return stmt.executeUpdate(sql);
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
	public static void main(String[] args) throws Exception{
		Ex12_3_ExecuteDML ed = new Ex12_3_ExecuteDML();
		ed.initParam("mysql.ini");
		int result = ed.insertData("insert into jdbc_test(jdbc_name,jdbc_desc)" 
			+ "select s.student_name , t.teacher_name "	+ "from student_table s , teacher_table t "+ "where s.java_teacher = t.teacher_id;");
		System.out.println("------ϵͳ�й���" + result + "����¼��Ӱ��------");
	}
}
