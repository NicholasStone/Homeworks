<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html;charset=gb2312"%>
<%
	request.setCharacterEncoding("gb2312");
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
		String id = request.getParameter("id");
		String sql_2 = "select * from student2 where id='" + id + "'";
		rs = stmt.executeQuery(sql_2);
		rs.next();
		session.setAttribute("id", rs.getString("id"));
	%>
	
	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>�޸�ѧ����Ϣ</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>
	
	
	<center>	
		<form action="EX14_11_modify_4.jsp" method="post">
			<P>
				������ <input type="text" id="name" name="name"
					value="<%=rs.getString("name")%>">
			<P>
				�Ա� <input type="text" id="gender" name="gender"
					value="<%=rs.getString("gender")%>">
			<P>
				��ַ: <input type="text" id="address" name="address"
					value="<%=rs.getString("address")%>">
			<P>
				�绰: <input type="text" id="phone" name="phone"
					value="<%=rs.getString("phone")%>">
			<P>
				רҵ: <input type="text" id="major" name="major"
					value="<%=rs.getString("major")%>">
			<P>
				<input type="submit" id="confirm" name="confirm" value="ȷ��">&nbsp;&nbsp;
				<input type="reset" id="reinput" name="reinput" value="��д">
			</P>
		</form>
	</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>