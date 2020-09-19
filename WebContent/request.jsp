<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Request Video</title>
<style>body{
	background-color:  #FAEBD7;
}
</style>
 </head>
</div>
 
<link rel = "stylesheet" type ="text/css" href = "css/request.css">

<div class = "loginBox" >

<h2> Request video</h2>

<form  method="post" action="RequestDAO.jsp" class = "loginBoxForm" >

Name: <br><br>
<input type = "text" name = "name" placeholder="Name" required><br><br>
Email: <br><br>
<input type = "email" name = "email" placeholder="***@***.com" required><br><br>

Contact-No: <br><br>
<input type = "text" name = "contactno" placeholder="07********" required><br><br>

Video: <br><br>
<input type = "text" name = "video" placeholder="Request item" required><br><br>

 <input type = "submit"  value = "Submit"><br>


</div>
</body>
</html>