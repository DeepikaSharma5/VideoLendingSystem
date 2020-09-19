<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Admin Login</title> 
</head>
<body>

<link rel = "stylesheet" type ="text/css" href = "css/adminLogin.css">

<div class = "loginBox" >

<h2> Log in </h2>

<form class = "loginBoxForm" method="post" action="AdminLoginServlet">
<tr>
<td><h4>${message}</h4></td>

</tr>
Email : <br><br>
<input type = "text" name = "email" placeholder="Email" pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required><br><br>

Password : <br><br>
<input type = "password" name = "password" placeholder="********" required> <br><br>

 <input type = "submit"  value = "Log in"></a><br>


</div>
</body>
</html>