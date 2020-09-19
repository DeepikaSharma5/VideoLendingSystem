package comingsoon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ComingSoonDeleteServlet")
public class ComingSoonDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			   throws IOException,ServletException {
			  response.setContentType("text/html");
			  Connection con = null;
			  PreparedStatement ps = null;
			  Integer id = 13;
			  ServletOutputStream out = response.getOutputStream();
			  out.println("<html><head><title>Delete</title></head>");
			  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/admin",
			   "root", "deepads12@");
			  ps = con.prepareStatement("delete from photo where id = ? ");
			  ps.setInt(1, id);
			  ps.executeUpdate();
			  out.println("<body><h4><font color='green'>Successfully deleted.<font></h4></body></html>");
			  } catch (Exception e) {
			  e.printStackTrace();
			  out.println("<body><h4><font color='red'>File could not be deleted. <br><br>Exception Thrown:<br>  " + e.getMessage() + "</font></h4></body></html>");
			  }finally {
				  out.println("<a href='AdminHome.jsp'>Home</a>");
			  try {
			  ps.close();
			  con.close();
			  } catch (SQLException e) {
			  e.printStackTrace();
			  }
			  }
			  }
			}

	
	
	