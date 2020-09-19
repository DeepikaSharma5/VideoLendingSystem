package request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestVideoViewServlet")
public class RequestVideoViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminHome.jsp'>Home</a><br>");
		out.println("<h1>Request List</h1>");
		
		List<RequestVideoDetails> list=RequestVideoDAO.getAllRequest();
		out.print("<center>");
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Contact-No</th><th>Video Details</th><th>Edit</th><th>Delete</th></tr>");
		for(RequestVideoDetails v:list){
			out.print("<tr><td>"+v.getId()+"</td><td>"+v.getName()+"</td><td>"+v.getEmail()+"</td><td>"+v.getContactno()+"</td><td>"+v.getVideo()+"</td><td><a href='RequestVideoEditServlet?id="+v.getId()+"'>edit</a></td><td><a href='RequestVideoDeleteServlet?id="+v.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.println("</center>");
		
		out.close();
	}
}