<%--
  Created by IntelliJ IDEA.
  User: nicholas
  Date: 16-11-15
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    if (application.getAttribute("counter") == null) {
        application.setAttribute("counter", 1);
    } else {
        String num = application.getAttribute("counter").toString();
        int count = Integer.valueOf(num);
        if (session.isNew()) {
            count++;
        }
        application.setAttribute("counter", count);
    }
    out.print(application.getAttribute("counter"));
%>
</body>
</html>
