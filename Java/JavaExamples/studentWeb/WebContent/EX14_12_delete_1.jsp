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
	%>
	
	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>ɾ��ѧ����Ϣ</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>
	
	<center>
		<form action="EX14_12_delete_2.jsp" method="post">
			��ѡ��Ҫɾ����ѧ���� <br> <select name="id">
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
				<input type="submit" id="confirm" name="confirm" value="ȷ��">&nbsp;&nbsp;
				<input type="button" id="reset" name="reset" value="����"
					onclick="javascript:history.go(-1)">
			</p>
		</form>
	</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>