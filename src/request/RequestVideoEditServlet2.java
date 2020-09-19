package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestVideoEditServlet2")
public class RequestVideoEditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
	
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contactno=request.getParameter("contactno");
		String video=request.getParameter("video");
		
		
		
		RequestVideoDetails v =new RequestVideoDetails();
		v.setId(id);
		v.setName(name);
		v.setEmail(email);
		v.setContactno(contactno);
		v.setVideo(video);
		
		
		int status= RequestVideoDAO.update(v);
		if(status>0){
			response.sendRedirect("RequestVideoViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
		
	
	}
}
