<%--
  Created by IntelliJ IDEA.
  User: mutug
  Date: 8/30/2019
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<%
    response.setHeader("Cache-Control","no-cach,no-store,must-revalidate");
    if(session.getAttribute("username")==null){
        response.sendRedirect("./login");
    }
%>




</body>
</html>
