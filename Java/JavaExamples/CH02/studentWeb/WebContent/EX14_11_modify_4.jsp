<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html;charset=gb2312"%>
<%
	request.setCharacterEncoding("GB2312");
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
		String name = null;
		String gender = null;
		String address = null;
		String phone = null;
		String major = null;

		String id = (String) session.getAttribute("id");
		String sql_3 = "select * from student2 where id='" + id.trim()
				+ "'";
		rs = stmt.executeQuery(sql_3);
		if (rs.next())//如果学生存在
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
	<td align="center"><h2>修改学生信息</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>
	
	
	<center>

		<br> <font color="blue"><%=name%></font> 的信息已经修改完毕！
		<form action="EX14_8_index.jsp" method="post">
			<input type="submit" id="back" name="back" value="返回">
		</form>
	</center>

    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>