<%@page language="java" import="java.sql.*"%>
<%@page contentType="text/html;charset=gb2312"  %>
<%
	request.setCharacterEncoding("gb2312");
%>
<html>
<head>
<title>���ѧ��������Ϣ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body >

	<table width="31%" align="center"><tr>
	<td width="4%" align="left">&nbsp;</td>
	<td width="92%" align="center"><h2><img src="imgs/tianjia1.jpg" width="85" height="94">���ѧ����Ϣ</h2></td>
	<td width="4%" align="right">&nbsp;</td>
	</tr>
	</table>
	
<br>

	<center>
		<form action="EX14_10_insert_3.jsp" method="post">
			<p>
				ѧ��: <input type="text" id="id" name="id">
			<p>
				����: <input type="text" id="name" name="name">
			<p>
				�Ա�: <input type="text" id="gender" name="gender">
			<p>
				��ַ: <input type="text" id="address" name="address">
			<p>
			     �绰: <input type="text" id="phone" name="phone">
			<p>
				רҵ: <input type="text" id="major" name="major">
			<p>
				<input type="submit" id="confirm" name="confirm" value="ȷ��">&nbsp;&nbsp;
				<input type="reset" id="reinput" name="reinput" value="���">&nbsp;&nbsp;
				<input type="button" id="reset" name="reset" value="����"
					onclick="javascript:history.go(-1)">
			</p>
		</form>
	</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>