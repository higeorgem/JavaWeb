<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="views/styles/style.css">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
    <title> Register</title>
</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="views/images/img1.jpg" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form method ="post" action="register_user">
            <input type="text" id="userName" class="fadeIn first" name="userName" placeholder="Username"></br>
            <input type="password" id="userPassword" class="fadeIn second" name="userPassword" placeholder="password"></br>
            <input type="submit" class="fadeIn third" value="Register">
        </form>

        <!-- new user registration -->
        <%--<form id="formFooter">
            <a class="" href="register_user">Registration</a>
        </form>--%>

    </div>
</div>
</body>
</html>


<%--


<html>
<head>d>
<title>
    Register
</title>
    <meta charset="utf-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<form action="register_user" method=post>
    <center>
        <table cellpadding=4 cellspacing=2 border=0>
            <th bgcolor="#CCCCFF" colspan=2>
                <font size=5>USER REGISTRATION</font>
                <br>
                <font size=1><sup>*</sup> Required Fields</font>
            </th>
            <tr bgcolor="#c8d8f8">
                <td valign=top colspan=2>
                    <b>User Name<sup>*</sup></b>
                    <br>
                    <input type="text" name="userName" size=10 value=""  maxlength=10 required>
                </td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    <b>Password<sup>*</sup></b>
                    <br>
                    <input type="password" name="userPassword" size=10 value="" maxlength=10 required></td>
               &lt;%&ndash; <td  valign=top>
                    <b>Confirm Password<sup>*</sup></b>
                    <br>
                    <input type="password" name="password2" size=10 value="" maxlength=10></td>&ndash;%&gt;
                <br>
            </tr>

            </tr>
            <tr bgcolor="#c8d8f8">
                <td  align=center colspan=2>
                    <input type="submit" value="Submit"> <input type="reset" value="Reset">
                    <a href="index.jsp" class="badge badge-primary">Main Menu</a>
                </td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
--%>
