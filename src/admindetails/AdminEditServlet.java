package admindetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminEditServlet")
public class AdminEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Admin</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		AdminDetails a = AdminDetailsDAO.getadminById(id);
		
		out.print("<form action='AdminEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+a.getId()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+a.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+a.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Full Name:</td><td><input type='text' name='fullname' value='"+a.getFullname()+"'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='address'value='"+a.getAddress()+"'/></td></tr>");
		out.print("<tr><td>Phine-Number:</td><td><input type='text' name='phone' value='"+a.getPhone()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
