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
	
		String id = null;
		String name = null;
		String gender = null;
		String address = null;
		String phone = null;
		String major = null;
		String sql = null;

		id = request.getParameter("id");
		sql = "select * from student2 where id='" + id.trim() + "'";
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			name = rs.getString("name");
			gender = rs.getString("gender");
			address = rs.getString("address");
			phone = rs.getString("phone");
			major = rs.getString("major");
		}
		session.setAttribute("id", id);
	%>
	<center>
		<h2>确定删除吗？</h2>
		<hr>

		<P>
			姓名：<%=name%>
		<P>
			性别：<%=gender%>
		<P>
			地址: <%=address%>
		<P>
			电话：<%=phone%>
		<P>
			专业: <%=major%>
		<P>
		<form action="EX14_12_delete_3.jsp" method="post">
			<input type="submit" id="confirm" name="confirm" value="确定">&nbsp;&nbsp;
			<input type="reset" id="back" name="back" value="返回"
				onclick="javascript:history.go(-1)">
		</form>
		</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>