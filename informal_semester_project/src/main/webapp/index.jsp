<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body style="background: url(background.jpg);background-size:100% 100% ; background-attachment: fixed ">
Login
<form method="post" action="./login">
      username : <input type="text" name="username"/><br/>
      password : <input type="text" name="password"/><br/>
      <input type="SUBMIT" name="submit" value="Submit">
      <a href="register.jsp">register</a>
</form>
</body>
</html>