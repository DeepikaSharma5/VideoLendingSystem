<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
    <h3><%=request.getAttribute("Message")%></h3>
    <a href="ComingSoonViewServlet">View Details</a>
</body>
</html>