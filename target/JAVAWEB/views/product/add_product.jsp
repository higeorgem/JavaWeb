<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="../styles/style.css">

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
<div class="container">
    <table class="table table-striped">
        <tbody>
        <tr>
            <td colspan="1">
<%--                <c:if test="${products== null}">--%>
                <form class="well form-horizontal" method="post" action="add_product">
<%--                    <c:if test="${products!= null}">--%>
<%--                        <form class="well form-horizontal" method="post" action="edit_product">--%>
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Product Name</label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="productName" name="productName" placeholder="Product Name" class="form-control" required="true" value="" type="text"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Description</label>
                            <i class="glyphicon glyphicon-home">
                            <textarea rows="5" cols="30" name="productDescription" id="productDescription">

                            </textarea>
                            </i>
                        </div>
                        <button class="btn btn-lg btn-primary text-uppercase" type="submit" name="login_btn">Add Product</button>
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