<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
</head>
<body>

<h1>Add New Feedback</h1>
<form action="AddFeedback" method="post">

<table>
<tr><td>User Name:</td><td><input type="text" name="name"/></td></tr>

<tr><td>User Email:</td><td><input type="email" name="email"/></td></tr>

<tr><td>How do you know this System:</td><td>
<select name="system" style="width:180px">
<option>Friend</option>
<option>Newspapers</option>
<option>College</option>
<option>Other</option>
</select>
</td></tr>

<tr><td>HOW DO YOU RATE THIS SYSTEM:</td><td>
    <INPUT TYPE="radio" NAME="rating" VALUE = "poor"> Poor 
	<INPUT TYPE="radio" NAME="rating" VALUE = "good"> Good 
	<INPUT TYPE="radio" NAME="rating" VALUE="very good" CHECKED> Very Good 
	<INPUT TYPE="radio" NAME="rating" VALUE = "excellent"> Excellent 
	</td></tr> 
<tr><td>Any Suggestion or comments:</td><td>
	<TEXTAREA NAME="comments" ROWS="6" COLS="50">
	</TEXTAREA>	</td></tr>
	
<tr><td colspan="2"><input type="submit" value="Save Feedback"/></td></tr>
<tr><td colspan="2"><input type="reset" value="clear Feedback"/></td></tr>

</table>
</form>

<br/>
<a href="ViewFeedback">view feedback</a>
<a href="AdminHome.jsp" class="btn btn-success">Dashboard</a>

</body>
</html>
