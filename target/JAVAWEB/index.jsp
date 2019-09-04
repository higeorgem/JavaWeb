<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Main Menu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="views/styles/style.css">

    <link rel="stylesheet" type="text/css" href="views/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="views/bootstrap/js/bootstrap.min.js"></script>
    <style>
        .bs-example{
            margin: 20px;
        }
    </style>
</head>
<%@ include file="views/header.jsp" %>
<body>

<%
    response.setHeader("Cache-Control","no-cach,no-store,must-revalidate");
    if(session.getAttribute("username")==null){
        response.sendRedirect("login");
    }
%>

<div class="bs-example nav navbar">
    <div class="btn-group">
        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">PRODUCT</button>
        <div class="dropdown-menu">
            <a href="add_product" class="dropdown-item">Add Product</a>
            <a href="edit_product" class="dropdown-item">Edit Product</a>
            <div class="dropdown-divider"></div>
            <a href="displayS" class="dropdown-item">View all Stock</a>
        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">RECEIVING</button>
        <div class="dropdown-menu">
            <a href="add_receiving" class="dropdown-item">Add Receiving</a>
            <a href="displayR" class="dropdown-item">Display All Receiving</a>
            <div class="dropdown-divider"></div>
        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">SALE</button>
        <div class="dropdown-menu">
            <a href="make_sale" class="dropdown-item">Make Sale</a>
            <div class="dropdown-divider"></div>
            <a href="displaySales" class="dropdown-item">View all Sale</a>
        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">REPORTS</button>
        <div class="dropdown-menu">
            <a href="displayS" class="dropdown-item">View All Products</a>
            <a href="displayR" class="dropdown-item">View All Receiving</a>
            <a href="#" class="dropdown-item">View All Users</a>
            <a href="#" class="dropdown-item"> View Total Profit</a>
            <a href="displaySales" class="dropdown-item"> View All Sales</a>
        </div>
    </div>
</div>

<div style="margin: auto">
    <form action="logout" method="post">
        <button type="submit" class="btn btn-warning align-self-center" >LOGOUT</button>
    </form>
</div>
</body>
</html>