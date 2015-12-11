<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html;charset=gb2312"%>
<%
	request.setCharacterEncoding("gb2312");
%>
<html>
<head>
<title>修改学生信息</title>
</head>
<body>
	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		//加载驱动程序  
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
		}

		//建立数据库连接
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
	<td align="center"><h2>修改学生信息</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>
	
	
	<center>	
		<form action="EX14_11_modify_4.jsp" method="post">
			<P>
				姓名： <input type="text" id="name" name="name"
					value="<%=rs.getString("name")%>">
			<P>
				性别： <input type="text" id="gender" name="gender"
					value="<%=rs.getString("gender")%>">
			<P>
				地址: <input type="text" id="address" name="address"
					value="<%=rs.getString("address")%>">
			<P>
				电话: <input type="text" id="phone" name="phone"
					value="<%=rs.getString("phone")%>">
			<P>
				专业: <input type="text" id="major" name="major"
					value="<%=rs.getString("major")%>">
			<P>
				<input type="submit" id="confirm" name="confirm" value="确定">&nbsp;&nbsp;
				<input type="reset" id="reinput" name="reinput" value="重写">
			</P>
		</form>
	</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>