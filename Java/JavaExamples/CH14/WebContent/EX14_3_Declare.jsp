<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>声明测试</title>
</head>
<body><font size=5>
<%!  int i=0; %>
<%i++;   %>
  <%--将i的值加1输出--%>
 <p> 你是第<%=i%>个访问本网页的客户。 </p>
<br>
</font>
</body>
</html>