<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.util.Date" %>

<%
	request.setCharacterEncoding("gb2312");
%>
<html>
<head>
<title>��ѯѧ����Ϣ</title>
</head>
<body >
 
	<table width="61%" align="center">
	  <tr>
<td width="3%" height="94" align="left">&nbsp;</td> 
	<td width="95%" align="center"><h2><img src="imgs/chaxun.jpg" width="89" height="89">��ѯѧ����Ϣ</h2></td>
<td width="2%" align="right">&nbsp;</td>
	</tr>
	</table>
<br>

	<%
		java.sql.Connection con = null;
	    java.lang.String strCon;
		java.sql.Statement stmt = null;
		java.sql.ResultSet rs = null;
		//������������  
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
		}

		//�������ݿ�����
		try {
			con = java.sql.DriverManager.getConnection("jdbc:odbc:student", "", "");
			stmt = con.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
		  rs = stmt.executeQuery("select * from student2");			
	%>
	
	<center>
	<table width="70%" border="2">
	<tr><th width="11%">ѧ��</th>
	<th width="15%">����</th>
	<th width="13%">�Ա�</th>
	<th width="20%">��ַ</th>
	<th width="17%">�绰</th>
	<th width="24%">רҵ</th>
	</tr>
	<%
	
		while (rs.next()) {
	%>
	    <tr>
		<td><%=rs.getString("id")%></td>
		<td><%=rs.getString("name")%></td>
		<td><%=rs.getString("gender")%></td>
		<td><%=rs.getString("address")%></td>
		<td><%=rs.getString("phone")%></td>
		<td><%=rs.getString("major")%></td>
	    </tr>		
	<%
		}
	%>
	</table>
	<% } catch(SQLException e){out.println(e.toString());}
finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(con!=null)con.close();	
}
	

	%>
	
  <form action="EX14_8_index.jsp" method="post">
		<input type="submit" name="back" value="����">
	</form>	
    </center>
    	 

 <br>
	<jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>