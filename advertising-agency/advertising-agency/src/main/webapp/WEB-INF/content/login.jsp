<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Copyright" content="arirusmanto.com">
<meta name="description" content="Admin MOS Template">
<meta name="keywords" content="Admin Page">
<meta name="author" content="Ari Rusmanto">
<meta name="language" content="Bahasa Indonesia">
<title>Login</title>
<link rel="shortcut icon" href="sub/img/devil-icon.png"> <!--Pemanggilan gambar favicon-->
<link rel="stylesheet" type="text/css" href="sub/mos-style.css"> <!--pemanggilan file css-->
</head>
<body>
<div id="header">
    <div class="inHeaderLogin"></div>
</div>
    <div id="loginForm">
    <div class="headLoginForm">
    Login Administrator
    </div>
    <div class="fieldLogin">
    <form method="POST" action="result">
    <label>Username</label><br>
    <input type="text" class="login" name="userName"><br>
    <label>Password</label><br>
    <input type="password" class="login" name="password"><br>
    <span style="color:red;"><s:property value="messageErr"/></span><br><br>
    <input type="submit" class="button" value="Login">
    </form>
    </div>
</div>
</body>
</html>