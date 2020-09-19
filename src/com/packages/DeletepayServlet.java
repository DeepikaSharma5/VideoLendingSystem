package com.packages;

import java.sql.*;  
import javax.servlet.http.*;  
  
public class DeletepayServlet extends HttpServlet
	{  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req,HttpServletResponse res)
	{
	 	String cid = req.getParameter("CustomerID");
    
    

    try
    { 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003"); 
        Statement stmt = con.createStatement(); 
               
        // Deleting from database 
        String q1 = "DELETE from payment WHERE CustomerID= '" + cid + "'" ; 
                  
        int x = stmt.executeUpdate(q1); 
          
        if (x > 0)   
        {
            res.sendRedirect("Table.jsp");   
        }
        else
        {
            System.out.println("ERROR OCCURED :(");   
        }
        con.close(); 
    } 
    catch(Exception e) 
    { 
        System.out.println(e); 
    } 
} 
} 