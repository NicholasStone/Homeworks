<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html;charset=gb2312"%>
<%
	request.setCharacterEncoding("GB2312");
%>
<html>
<head>
<title>�޸�ѧ����Ϣ</title>
</head>
<body>
	<%
		Connection con = null;
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
	%>
	<%
		String name = null;
		String gender = null;
		String address = null;
		String phone = null;
		String major = null;

		String id = (String) session.getAttribute("id");
		String sql_3 = "select * from student2 where id='" + id.trim()
				+ "'";
		rs = stmt.executeQuery(sql_3);
		if (rs.next())//���ѧ������
		{
			name = request.getParameter("name");
			gender = request.getParameter("gender");
			address = request.getParameter("address");
			phone = request.getParameter("phone");
			major = request.getParameter("major");
		}

		String sql_4 = "update student2 set name='" + name + "',gender='"
				+ gender + "',address='" + address + "',phone='" + phone
				+ "',major='" + major + "'where id='" + id.trim() + "'";
		stmt.executeUpdate(sql_4);
	%>
	
	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>�޸�ѧ����Ϣ</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>
	
	
	<center>

		<br> <font color="blue"><%=name%></font> ����Ϣ�Ѿ��޸���ϣ�
		<form action="EX14_8_index.jsp" method="post">
			<input type="submit" id="back" name="back" value="����">
		</form>
	</center>

    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>