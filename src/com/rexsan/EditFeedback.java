package com.rexsan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditFeedback extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Feedbackform</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Feedback e=FeedbackDao.getEmployeeById(id);
		out.print("<form action='EditFeedback2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>How do you know this System:</td><td>");
		out.print("<select name='system' value='"+e.getsystem()+"' style='width:180px'>");
		out.print("<option>Friend</option>");
		out.print("<option>Newspapers</option>");
		out.print("<option>College</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>HOW DO YOU RATE THIS SYSTEM:</td><td>");
		out.print("<input type ='text' name='rating' value='"+e.getrating()+"'/></td></tr>");
		out.print("<tr><td>Any suggection or comments :</td><td>");
		out.print("<tr><td>Comments:</td><td><input type='text' name='comments' value='"+e.getcomments()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");		
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
