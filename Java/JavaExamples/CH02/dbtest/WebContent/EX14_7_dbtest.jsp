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

//������������  
try{
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    }
catch(ClassNotFoundException e){}

//�������ݿ�����
try{
	     con=DriverManager.getConnection("jdbc:odbc:student","","");
	     stmt=con.createStatement();
}catch(SQLException ee){}

//������
str = "create table student2(id varchar(20),name varchar(20),gender varchar(2),address varchar(50),phone varchar(20),major varchar(30))";
try {
	stmt.executeUpdate(str);
} catch (SQLException e) {
	e.printStackTrace();
}		

//�������
str = "insert into student2 values('2013001','����','��','̫ԭ��ӭ�������79��','13800000000','�����')";
try {
	stmt.executeUpdate(str);
} catch (SQLException e) {
	e.printStackTrace();
}		%>
<center>������Ϣ</center>
<table border="1" width="100%"   bordercolorlight="#CC99FF"  cellpadding="2" bordercolordark="#FFFFFF"  
 cellpadding="0">
	<tr><th>ѧ��</th><th>����</th><th>�Ա�</th><th>��ַ</th><th>�绰</th><th>רҵ</th></tr>
<% 
//��ȡ���������
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

//�ͷ���Դ
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