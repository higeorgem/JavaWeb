<%--
  Created by IntelliJ IDEA.
  User: mutug
  Date: 8/26/19
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="../header.jsp" %>

<%
    response.setHeader("Cache-Control","no-cach,no-store,must-revalidate");
    if(session.getAttribute("username")==null){
        response.sendRedirect("login");
    }
%>

<div class="container mt-5">

    <c:if test="${products!= null}">
    <table class=" table table-hover table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Product ID</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.productDescription}</td>
                <td><a href="edit_product?productId=${product.productId}" role="button" class="btn btn-primary"> Edit</a></td>
                <td><a href="deleteP?productId=${product.productId}" role="button" class="btn btn-primary"> Delete</a></td>

            </tr>
        </c:forEach>


        </tbody>
    </table>
    </c:if>
    <a href="add_product" class="badge badge-primary">Add New Product</a>
        <a href="index.jsp" class="badge badge-primary">Main Menu</a>

</body>
</html>
