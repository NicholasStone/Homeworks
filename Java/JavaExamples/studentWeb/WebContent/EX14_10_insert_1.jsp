<%@page language="java" import="java.sql.*"%>
<%@page contentType="text/html;charset=gb2312"  %>
<%
	request.setCharacterEncoding("gb2312");
%>
<html>
<head>
<title>添加学生基本信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body >

	<table width="31%" align="center"><tr>
	<td width="4%" align="left">&nbsp;</td>
	<td width="92%" align="center"><h2><img src="imgs/tianjia1.jpg" width="85" height="94">添加学生信息</h2></td>
	<td width="4%" align="right">&nbsp;</td>
	</tr>
	</table>
	
<br>

	<center>
		<form action="EX14_10_insert_3.jsp" method="post">
			<p>
				学号: <input type="text" id="id" name="id">
			<p>
				姓名: <input type="text" id="name" name="name">
			<p>
				性别: <input type="text" id="gender" name="gender">
			<p>
				地址: <input type="text" id="address" name="address">
			<p>
			     电话: <input type="text" id="phone" name="phone">
			<p>
				专业: <input type="text" id="major" name="major">
			<p>
				<input type="submit" id="confirm" name="confirm" value="确定">&nbsp;&nbsp;
				<input type="reset" id="reinput" name="reinput" value="清空">&nbsp;&nbsp;
				<input type="button" id="reset" name="reset" value="返回"
					onclick="javascript:history.go(-1)">
			</p>
		</form>
	</center>
    <jsp:include page="EX14_13_Home.html"></jsp:include>
</body>
</html>