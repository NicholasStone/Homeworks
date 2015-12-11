<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.sql.*"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<% 
Connection con=null;
Statement stmt=null;
ResultSet rs = null;
String str = "";

//加载驱动程序  
try{
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    }
catch(ClassNotFoundException e){}

//建立数据库连接
try{
	     con=DriverManager.getConnection("jdbc:odbc:student","","");
	     stmt=con.createStatement();
}catch(SQLException ee){}

//建立表
str = "create table student2(id varchar(20),name varchar(20),gender varchar(2),address varchar(50),phone varchar(20),major varchar(30))";
try {
	stmt.executeUpdate(str);
} catch (SQLException e) {
	e.printStackTrace();
}		

//添加数据
str = "insert into student2 values('2013001','李四','男','太原市迎泽西大街79号','13800000000','计算机')";
try {
	stmt.executeUpdate(str);
} catch (SQLException e) {
	e.printStackTrace();
}		%>
<center>基本信息</center>
<table border="1" width="100%"   bordercolorlight="#CC99FF"  cellpadding="2" bordercolordark="#FFFFFF"  
 cellpadding="0">
	<tr><th>学号</th><th>姓名</th><th>性别</th><th>地址</th><th>电话</th><th>专业</th></tr>
<% 
//获取并浏览数据
str = "select * from student2";		
try {
	rs = stmt.executeQuery(str);
	while(rs.next()) {%>
	
<tr>	
	<td><%=rs.getString("id")%></td>
	<td><%=rs.getString("name")%></td>
	<td><%=rs.getString("gender")%></td>
	<td><%=rs.getString("address")%></td>
	<td><%=rs.getString("phone")%></td>
	<td><%=rs.getString("major")%></td>
</tr>
<% }}
catch (SQLException e) {
	e.printStackTrace();
}	

//释放资源
try {
	rs.close();
	stmt.close();
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
</table>
</body>
</html>