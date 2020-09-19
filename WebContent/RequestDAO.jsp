<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request video a</title>
</head>
<body>
<%
String name=request.getParameter("name");
String email=request.getParameter("email");
String contactno=request.getParameter("contactno");
String video=request.getParameter("video");



try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos", "root", "kajan003");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into request(name,email,contactno,video)values('"+name+"','"+email+"','"+contactno+"','"+video+"')");
out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
</body>
</html>