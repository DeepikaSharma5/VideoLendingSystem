package comingsoon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ComingSoonViewServlet")
public class ComingSoonViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<a href='ComingSoonform.jsp'>Add New </a><br>");
		out.println("<a href='AdminHome.jsp'>Home</a>");
		out.println("<h1>List</h1>");
		
		List<ComingSoon> list=ComingSoonDB.getAllPhotos();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Image</th><th>Name</th><th>Description</th><th>Delete</th></tr>");
		for(ComingSoon c:list){
			out.print("<tr><td>"+c.getId()+"</td><td>"+c.getImage()+"</td><td>"+c.getName()+"</td><td>"+c.getDescription()+"</td>><td><a href='ComingSoonDeleteServlet?id="+c.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}