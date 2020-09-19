<%@page import="java.util.Base64"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
    <style>body{
	background-color: #FAEBD7;

}</style>
        <title>Coming Soon</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
    <table border="0px" cellspacing="20px" cellpadding="70px">
    <%
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement psmt = null;
        FileInputStream fis;
        String url = "jdbc:mysql://localhost:3306/videos";
        Blob blob;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "kajan003");
            psmt = con.prepareStatement("select * from photo");
            rs = psmt.executeQuery();
            int cnt=0;
            while (rs.next()) {
                int id = rs.getInt("photoid");
                String name = rs.getString("name");
                String description = rs.getString("description");
                blob = rs.getBlob("image");
                
                
                InputStream in = blob.getBinaryStream();
                
               
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream ot = new ByteArrayOutputStream();
                
                 byte[] buffer = new byte[in.available()];	               
                int i;
                
                
                while ((i = in.read(buffer)) != -1) {
                	outputStream.write(buffer, 0, i); 
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
               
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                in.close();
                outputStream.close();
                ot.close();
                if(cnt==3){
        			out.print("</tr><tr>");
        			cnt=0;
        		}
        		cnt++;
                %>
                
        <td>
                <img src="data:image/png;base64,<%= base64Image %>"height="200" width="300"><br>
               <h4><%=name %></h4><br><%=description %>
		</td>
                
                <%
                    
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    %>
       </table>
    </body>
</html>