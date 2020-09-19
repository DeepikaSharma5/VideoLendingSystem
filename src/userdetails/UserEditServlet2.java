package userdetails;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UserEditServlet2")
public class UserEditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String sid=request.getParameter("Userid");
		int Userid=Integer.parseInt(sid);
	
		String first_name=request.getParameter("first_name");
		String contact_no =request.getParameter("contact_no");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cnfrmpwd=request.getParameter("cnfrmpwd");
		
		
		UserDetails u =new UserDetails();
		u.setUserid(Userid);
		
		u.setFirst_name(first_name);
		u.setContact_no(contact_no);
		u.setEmail(email);
		u.setPassword(password);
		u.setCnfrmpwd(cnfrmpwd);
		
		int status= UserDetailsDAO.update(u);
		if(status>0){
			response.sendRedirect("UserViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
		
	
	}
}
