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
		Statement stmt = null;
		ResultSet rs = null;

		//加载驱动程序  
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
		}

		//建立数据库连接
		try {
			Connection	con = DriverManager.getConnection("jdbc:odbc:student", "", "");
			stmt = con.createStatement();
		} catch (SQLException ee) {
		}
	%>

	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>修改学生信息</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>

	<center>

		<form action="EX14_11_modify_2.jsp" method="post">
			请选择你想修改的学生： <select name="id">
				<%
					rs = stmt.executeQuery("select * from student2");
					while (rs.next()) {
						String id = rs.getString("id");
						String name = rs.getString("name");
				%>
				<option value="<%=id%>"><%=id%>/<%=name%></option>
				<%
					}
				%>
			</select>
			<P>
				<input type="submit" name="submit" value="确定">&nbsp;&nbsp;
				<input type="button" name="reset" value="返回"
					onclick="javascript:history.go(-1)">
		</form>
		</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>