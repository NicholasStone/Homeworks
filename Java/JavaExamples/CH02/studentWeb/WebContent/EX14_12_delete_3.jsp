<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html;charset=gb2312"%>
<%
	request.setCharacterEncoding("GBK");
%>
<html>
<head>
<title>ɾ�� ѧ����Ϣ</title>
</head>
<body>
	<% 	Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//������������  
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
		}

		//�������ݿ�����
		try {
			con = DriverManager.getConnection("jdbc:odbc:student", "", "");
			stmt = con.createStatement();
		} catch (SQLException ee) {
		}
	
         String name = null;
		String id = (String) session.getAttribute("id");
		String sql_1 = "select * from student2 where id='" + id.trim() + "'";
		rs = stmt.executeQuery(sql_1);
		if(rs.next())
		{
		   name = rs.getString("name");
		}
		
		String sql = "delete * from student2 where id='" + id.trim() + "'";
		stmt.executeUpdate(sql);
	%>
	
	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>ɾ��ѧ����Ϣ</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	
	<br>
	
	<center>

		<font color="blue"><%=name%></font>�Ѿ���ɾ����
		<form action="EX14_8_index.jsp" method="post">
			<input type="submit" id="back" name="back" value="����">
		</form>
	</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>