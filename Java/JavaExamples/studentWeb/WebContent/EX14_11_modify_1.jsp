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
		Statement stmt = null;
		ResultSet rs = null;

		//������������  
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
		}

		//�������ݿ�����
		try {
			Connection	con = DriverManager.getConnection("jdbc:odbc:student", "", "");
			stmt = con.createStatement();
		} catch (SQLException ee) {
		}
	%>

	<table width="100%"><tr>
	<td align="left"><img src="imgs/left.gif" /></td>
	<td align="center"><h2>�޸�ѧ����Ϣ</h2></td>
	<td align="right"><img src="imgs/right.gif" /></td>
	</tr>
	</table>
	
	<br>

	<center>

		<form action="EX14_11_modify_2.jsp" method="post">
			��ѡ�������޸ĵ�ѧ���� <select name="id">
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
				<input type="submit" name="submit" value="ȷ��">&nbsp;&nbsp;
				<input type="button" name="reset" value="����"
					onclick="javascript:history.go(-1)">
		</form>
		</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>