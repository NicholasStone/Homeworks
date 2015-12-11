<html>
<body>
<%
  String username=request.getParameter("UserName");
  String password=request.getParameter("PW");
if(username.trim().equals("admin")&&password.trim().equals("123"))
{%>
<jsp:forward page="EX14_6_hello.html" />
<%}
else
{%>
<jsp:forward page="EX14_6_sorry.html" />
<%}
%>
</body>
</html>
