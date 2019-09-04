<%--
  Created by IntelliJ IDEA.
  User: mutug
  Date: 8/30/2019
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
</head>
<%@ include file="../header.jsp" %>
<body>
<%
    response.setHeader("Cache-Control","no-cach,no-store,must-revalidate");
    if(session.getAttribute("username")==null){
        response.sendRedirect("login");
    }
%>
<c:if test="${receivings!= null}">
    <caption>List of Receivings</caption>
    <table class=" table table-hover table-striped">
    <thead class="thead-dark">
    <tr>
    <th scope="col">Batch No</th>
    <th scope="col">Date</th>
    <th scope="col">Quantity</th>
    <th scope="col">Running Balance</th>
    <th scope="col">Buying Price</th>
    <th scope="col">Selling Price</th>
    <th scope="col">Product ID</th>
    <th scope="col"></th>
    <th scope="col"></th>
    </tr>
    </thead>
        <tbody>
        <c:forEach var="receiving" items="${receivings}">
            <tr>
                <td>${receiving.batchNo}</td>
                <td>${receiving.receivalDate}</td>
                <td>${receiving.qty}</td>
                <td>${receiving.runningBalance}</td>
                <td>${receiving.buyingPrice}</td>
                <td>${receiving.sellingPrice}</td>
                <td>${receiving.productId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        </c:if>
    <a href="add_receiving" class="badge badge-primary">Receive Products</a>
<a href="index.jsp" class="badge badge-primary">Main Menu</a>

</body>
</html>
