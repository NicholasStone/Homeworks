<%@page language="java" import="java.sql.*"%>
<%@page contentType="text/html;charset=gb2312"  %>
<%
	request.setCharacterEncoding("gb2312");
%>
<html>
<head>
<title>���ѧ����Ϣ</title>
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
	
		
		String	 id = request.getParameter("id");
		String	name = request.getParameter("name");
		String	gender = request.getParameter("gender");
		String	address = request.getParameter("address");
		String	phone = request.getParameter("phone");
		String	major = request.getParameter("major");
		String sql = "INSERT into student2 (id,name,gender,address,phone,major) values('"
				+ id
				+ "','"
				+ name
				+ "','"
				+ gender
				+ "','"
				+ address
				+ "','" + phone + "','" + major + "')";

		stmt.executeUpdate(sql);
	%>
	
	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>���ѧ����Ϣ</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>
	
	<center>
		<br> <font color="blue"><%=name%></font>����Ϣ����ӵ����ݿ�!
		<form action="EX14_8_index.jsp" method="post">
			<input type="submit" id="back" name="back" value="����">
		</form>
	 </center>

    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>
