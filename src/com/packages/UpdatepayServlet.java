package com.packages;

import java.sql.*;  
import javax.servlet.http.*;  
public class UpdatepayServlet extends HttpServlet{  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req,HttpServletResponse res)
	{
	
	 String cid = req.getParameter("CustomerID");
	 String newfn = req.getParameter("FirstName");
	 String newln = req.getParameter("LastName");
     int newcn = Integer.parseInt (req.getParameter("CardNumber"));
     String newed = req.getParameter("ExpirationDate");
     String newem = req.getParameter("Email");
     
    try
    { 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003"); 
        Statement stmt = con.createStatement(); 
      
        // Updating database 
        String q1 = "UPDATE Payment set FirstName = '" + newfn + "', LastName = '" + newln + "' ,CardNumber = '" + newcn + "',ExpirationDate = '" + newed+ "',Email = '" + newem+ "'WHERE  CustomerID = '" + cid + "'"; 
        int x = stmt.executeUpdate(q1); 
       
          
        if (x > 0)             
            System.out.println("Password Successfully Updated");             
        else            
            System.out.println("ERROR OCCURED :"); 
          
        con.close(); 
    } 
    catch(Exception e) 
    { 
        System.out.println(e); 
    } 
} 
} 

