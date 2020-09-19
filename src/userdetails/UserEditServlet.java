package userdetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update User</h1>");
		String sid=request.getParameter("Userid");
		int Userid=Integer.parseInt(sid);
		
		UserDetails u = UserDetailsDAO.getuserById(Userid);
		
		out.print("<form action='UserEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='Userid' value='"+u.getUserid()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='first_name' value='"+u.getFirst_name()+"'/></td></tr>");
		out.print("<tr><td>contact Number:</td><td><input type='text' name='contact_no' value='"+u.getContact_no()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+u.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password'value='"+u.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Conform-Password:</td><td><input type='password' name='cnfrmpwd' value='"+u.getCnfrmpwd()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}

