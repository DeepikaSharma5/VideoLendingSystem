package com.packages;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
  

@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet
{  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req,HttpServletResponse res)
	{
	 String cid = req.getParameter("CustomerID");
	 String fn = req.getParameter("FirstName");
	 String ln = req.getParameter("LastName");
     int cn = Integer.parseInt (req.getParameter("CardNumber"));
     String ed = req.getParameter("ExpirationDate");
     String em = req.getParameter("Email");
     String pg= req.getParameter("Package");

	        try
	        { 
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003");
	            Statement stmt = con.createStatement(); 
	              
	            // Inserting data in database 
	            String q1 = "insert into payment values('" +cid+ "','" +fn+ "', '" +ln+ "', '" +cn+ "', '" +ed+ "','" +em+ "','"+pg +"')"; 
	            int x = stmt.executeUpdate(q1); 
	            if (x > 0)             
	                res.sendRedirect("Table.jsp");            
	            else            
	                System.out.println("Insert Failed"); 
	              
	            con.close(); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println(e); 
	        } 
	    } 
	} 
