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

<link rel="stylesheet" type="text/css" href="views/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="views/bootstrap/js/bootstrap.min.js"></script>
    <title>Login</title>
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
<form method ="post" action="login">
<input type="text" id="uname" class="fadeIn first" name="uname" placeholder="Username"></br>
<input type="password" id="pass" class="fadeIn second" name="pass" placeholder="password"></br>
<input type="submit" class="fadeIn third" value="Log In">
</form>

<!-- new user registration -->
    <form id="formFooter">
<a class="" href="register_user">Registration</a>
    </form>

</div>
</div>