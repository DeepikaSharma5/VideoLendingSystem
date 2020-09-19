<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

</head>
<body>
 
<link rel = "stylesheet" type ="text/css" href = "css/login.css">

<div class = "loginBox" >

<h2> Log in </h2>
    
<form class = "loginBoxForm" method= "post" action="LoginServlet">
<tr>
<td><h4>${message}</h4></td>
<td><h4>${successmessage}</h4></td>
</tr>
Email : <br><br>
<input type = "text" name = "email" pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder = "Email address" required><br><br>

Password : <br><br>
<input type = "password" name = "password" placeholder = "Password" required> <br><br>

<input  type = "submit"  value = "Log in"><br>

<center>
Not registered? <a href = "register.jsp" >Register</a>
Lobby<a href = "Lobby.jsp" >Lobby</a>
</center>
</div>

</form>
</body>
</html>