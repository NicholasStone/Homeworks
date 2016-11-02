<%--
  Created by IntelliJ IDEA.
  User: nicholas
  Date: 16-11-2
  Time: 上午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String time = request.getParameter("time");
    if (time.equals("8")){
        out.println("回答正确");
    }else{
        out.println("回答错误");
    }
%>
</body>
</html>
