<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>

<body>
<link rel = "stylesheet" type ="text/css" href = "css/register.css">

<div class = "signupBox">
<h2> Register </h2>

<form method= "post" name="signup" class = "signupBoxForm"  action="RegisterServlet" >
<tr>
<td><h4>${message}</h4></td>
</tr>
Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
<input type = "text" name = "first_name" id = "first_namename" ><br><br>

Contact No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
<input type="text"  maxlength="10" name="contact_no" pattern="[0-9]{10}" id = "contact" required><br><br>

Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
<input type = "text" name = "email" pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" id = "email" required><br><br>

Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
<input type="password" name="password" id ="password" required><br><br>

Confirm Password : 
<input type="password" name="cnfrmpwd" id = "cnfrmPwd" required><br><br>

<center>
<p>By creating an account you agree to our Terms and Conditions.</p><br>
<p>
  		Already a member? <a href="index.jsp">Log in</a>
</p>
<button type="submit" class="btn" name="reg_user">Register</button>
</center>
</div>
</form>

</body>
</html>