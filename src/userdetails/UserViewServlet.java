package userdetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UserViewServlet")
public class UserViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='userd.jsp'>Add New Users</a><br>");
		out.println("<a href='AdminHome.jsp'>Home</a>");
		out.println("<h1>User List</h1>");
		
		List<UserDetails> list=UserDetailsDAO.getAllUsers();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Contact Number</th><th>Email</th><th>Password</th><th>Conform-password</th><th>Edit</th><th>Delete</th></tr>");
		for(UserDetails u:list){
			out.print("<tr><td>"+u.getUserid()+"</td><td>"+u.getFirst_name()+"</td><td>"+u.getContact_no()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td><td>"+u.getCnfrmpwd()+"</td><td><a href='UserEditServlet?Userid="+u.getUserid()+"'>edit</a></td><td><a href='UserDeleteServlet?id="+u.getUserid()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}