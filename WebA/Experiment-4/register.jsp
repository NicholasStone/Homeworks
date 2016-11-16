<%--
  Created by IntelliJ IDEA.
  User: nicholas
  Date: 16-11-15
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.regex.Pattern" %>
<%
    Pattern pattern = Pattern.compile("^(user)([a-zA-Z1-9_.\\-]*)");
    String username = request.getParameter("username");
    String output;
    if (pattern.matcher(username).matches()) {
        output = "该用户名已被注册";
    } else if (username.equals("admin")) {
        output = "欢迎您 , 管理员";
    } else {
        output = "注册成功";
    }
    out.print(output);
%>
<html>
<head>
    <title>Register</title>
</head>
<body>

</body>
</html>
