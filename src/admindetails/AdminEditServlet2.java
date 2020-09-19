package admindetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminEditServlet2")
public class AdminEditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
	
		String email=request.getParameter("email");
		String password =request.getParameter("password");
		String fullname=request.getParameter("fullname");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		
		AdminDetails a =new AdminDetails();
		a.setId(id);
		a.setEmail(email);
		a.setPassword(password);
		a.setFullname(fullname);
		a.setAddress(address);
		a.setPhone(phone);
		
		int status= AdminDetailsDAO.update(a);
		if(status>0){
			response.sendRedirect("AdminViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
		
	
	}
}
