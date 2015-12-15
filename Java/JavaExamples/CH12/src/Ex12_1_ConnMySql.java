import java.sql.*;	//导入所需要的包

public class Ex12_1_ConnMySql {
    public static void main(String[] args) throws Exception{
        //1.加载驱动。
        Class.forName("com.mysql.jdbc.Driver");

        //2.使用DriverManager获取数据库连接,
        //其中返回的Connection代表了Java程序和数据库的连接
        //不同数据库的URL写法需要查驱动文档知道，而用户名、密码由DBA分配
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teacher" ,"root" , "126439");

        //3.使用Connection创建一个Statment对象
        Statement stmt = conn.createStatement();

        //4.执行SQL语句。
		/*
         下面语句从product表中选取price值大于100的所有列信息
		*/
        ResultSet rs = stmt.executeQuery("select *  from teachers");
        //5、访问结果集
        while(rs.next()){
            System.out.println(rs.getInt("id") + " \t" + rs.getString("teachername") + " \t"+ rs.getString("sex") + "\t"+ rs.getString("age"));
        }
        //6、关闭数据库资源
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
