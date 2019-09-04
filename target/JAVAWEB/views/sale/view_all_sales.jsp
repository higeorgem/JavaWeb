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
    <title>Received Batches</title>
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
<c:if test="${sales!= null}">
    <table class=" table table-hover table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Quantity</th>
            <th scope="col">Product ID</th>
            <th scope="col">Product Name</th>
            <th scope="col">Selling Price</th>
            <th scope="col">Customer Id</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Cahier Name</th>
            <th scope="col">cashier ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sale" items="${sales}">
            <tr>
                <td>${sale.saleDate}</td>
                <td>${sale.qty}</td>
                <td>${sale.productId}</td>
                <td>${sale.productName}</td>
                <td>${sale.sellingPrice}</td>
                <td>${sale.customerId}</td>
                <td>${sale.customerName}</td>
                <td>${sale.userName}</td>
                <td>${sale.userId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<a href="make_sale" class="badge badge-primary">Sell Item</a>
<a href="index.jsp" class="badge badge-primary">Main Menu</a>

</body>
</html>
