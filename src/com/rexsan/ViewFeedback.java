package com.rexsan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewFeedback")
public class ViewFeedback extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='feedback.jsp'>Add New Feedback</a>");
		out.println("<a href='AdminHome.jsp'>Dashboard</a>");
		out.println("<h1>Feedback form List</h1>");
		
		List<Feedback> list=FeedbackDao.getAllFeedback();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>System</th><th>rating</th><th>comments</th><th>Edit</th><th>Delete</th></tr>");
		for(Feedback e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getsystem()+"</td><td>"+e.getrating()+"</td><td>"+e.getcomments()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}

