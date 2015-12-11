<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html;charset=gb2312"%>

<%
	request.setCharacterEncoding("gb2312");
%>
<html>
<head>
<title>删除学生信息</title>
</head>
<body>
	<% 	Connection con = null;
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
	
	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>删除学生信息</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>
	
	<center>
		<form action="EX14_12_delete_2.jsp" method="post">
			请选择要删除的学生： <br> <select name="id">
				<%
					String sql = "select * from student2";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						String id = rs.getString("id");
						String name = rs.getString("name");
				%>
				<option value="<%=id%>"><%=name%>/<%=id%></option>
				<%
					}
				%>
			</select>
			<P>
				<input type="submit" id="confirm" name="confirm" value="确定">&nbsp;&nbsp;
				<input type="button" id="reset" name="reset" value="返回"
					onclick="javascript:history.go(-1)">
			</p>
		</form>
	</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>