package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestVideoEditServlet")
public class RequestVideoEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Request</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		RequestVideoDetails v = RequestVideoDAO.getvideoById(id);
		
		out.print("<form action='RequestVideoEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+v.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+v.getName()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+v.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Contact-Number:</td><td><input type='text' name='contactno' value='"+v.getContactno()+"'/></td></tr>");
		out.print("<tr><td>Video Details:</td><td><input type='text' name='video'value='"+v.getVideo()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
