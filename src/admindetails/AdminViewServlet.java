package admindetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminViewServlet")
public class AdminViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='admind.jsp'>Add New Admin</a><br>");
		out.println("<a href='AdminHome.jsp'>Home</a>");
		out.println("<h1>Admin List</h1>");
		
		List<AdminDetails> list=AdminDetailsDAO.getAllAdmins();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Email</th><th>Password</th><th>Fullname</th><th>Address</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>");
		for(AdminDetails a:list){
			out.print("<tr><td>"+a.getId()+"</td><td>"+a.getEmail()+"</td><td>"+a.getPassword()+"</td><td>"+a.getFullname()+"</td><td>"+a.getAddress()+"</td><td>"+a.getPhone()+"</td><td><a href='AdminEditServlet?id="+a.getId()+"'>edit</a></td><td><a href='AdminDeleteServlet?id="+a.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}