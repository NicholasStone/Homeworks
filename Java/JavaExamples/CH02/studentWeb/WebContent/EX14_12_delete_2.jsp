<%@ page language="java" import="java.sql.*"%>
<%@ page contentType="text/html;charset=gb2312"%>

<%
	request.setCharacterEncoding("gb2312");
%>
<html>
<head>
<title>ɾ��ѧ����Ϣ</title>
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
		<h2>ȷ��ɾ����</h2>
		<hr>

		<P>
			������<%=name%>
		<P>
			�Ա�<%=gender%>
		<P>
			��ַ: <%=address%>
		<P>
			�绰��<%=phone%>
		<P>
			רҵ: <%=major%>
		<P>
		<form action="EX14_12_delete_3.jsp" method="post">
			<input type="submit" id="confirm" name="confirm" value="ȷ��">&nbsp;&nbsp;
			<input type="reset" id="back" name="back" value="����"
				onclick="javascript:history.go(-1)">
		</form>
		</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>