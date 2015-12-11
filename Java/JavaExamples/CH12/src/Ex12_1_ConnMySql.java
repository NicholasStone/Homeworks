import java.sql.*;	//��������Ҫ�İ�

public class Ex12_1_ConnMySql {
	public static void main(String[] args) throws Exception{
		//1.����������
		Class.forName("com.mysql.jdbc.Driver");

		//2.ʹ��DriverManager��ȡ���ݿ�����,
		//���з��ص�Connection������Java��������ݿ������
		//��ͬ���ݿ��URLд����Ҫ�������ĵ�֪�������û�����������DBA����
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/select_test" ,"root" , "123456");

		//3.ʹ��Connection����һ��Statment����
		Statement stmt = conn.createStatement();

		//4.ִ��SQL��䡣
		/*
         ��������product����ѡȡpriceֵ����100����������Ϣ
		*/
		ResultSet rs = stmt.executeQuery("select *  from product  where  price > 100");
		//5�����ʽ����
		while(rs.next()){
				System.out.println(rs.getInt(1) + "\t"
					+ rs.getString(2) + "\t"+ rs.getString(3) + "\t"+ rs.getFloat(4));
		}
    //6���ر����ݿ���Դ
	if (rs != null)	{
			rs.close();
		}
		if (stmt != null){
			stmt.close();
		}
	if (conn != null){
			conn.close();
		}
	 }
  }
