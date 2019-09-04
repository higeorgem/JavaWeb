<%--
  Created by IntelliJ IDEA.
  User: mutug
  Date: 9/3/2019
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! String name = "Coder";%>
<% out.println("Your Name is "+name);%>
<% out.println("</br>");%>
<%= "I love silent nights"%>

<%! int sum(){
    int a =10; int b=25;
    int c = a+b;
    return c;
}%>
<%= sum()%>

</body>
</html>
