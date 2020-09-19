
package com.rexsan;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditFeedback2")
public class EditFeedback2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String system=request.getParameter("system");
		String rating=request.getParameter("rating");
		String comments=request.getParameter("comments");
		
		Feedback e=new Feedback();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setsystem(system);
		e.setrating(rating);
		e.setcomments(comments);
		
		int status=FeedbackDao.update(e);
		if(status>0){
			response.sendRedirect("ViewFeedback");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
