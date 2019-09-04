<%--
  Created by IntelliJ IDEA.
  User: mutug
  Date: 8/28/2019
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sell Item</title>
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
        response.sendRedirect("./login");
    }
%>

<div class="container">
    <table class="table table-striped">
        <tbody>
        <tr>
            <td colspan="1">
                <form class="well form-horizontal" method="post" action="make_sale">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Product ID</label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="productId" name="productId" placeholder="Product ID" class="form-control" required="true" value="" type="number"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Quantity</label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="quantity" name="quantity" placeholder="Quantity Sold" class="form-control" required="true" value="" type="number"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Customer Name</label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="customerName" name="customerName" placeholder="Customer Name" class="form-control" required="true" value="" type="text"></div>
                            </div>
                        </div>
                        <button class="btn btn-lg btn-primary text-uppercase" type="submit" name="login_btn">Press To Sell</button>
                        <a href="index.jsp" class="badge badge-primary">Main Menu</a>
                    </fieldset>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
