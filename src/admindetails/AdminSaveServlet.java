package admindetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminSaveServlet")
public class AdminSaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String fullname=request.getParameter("fullname");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		AdminDetails a =new AdminDetails();
		a.setEmail(email);
		a.setPassword(password);
		a.setFullname(fullname);
		a.setAddress(address);
		a.setPhone(phone);
		
		int status=AdminDetailsDAO.save(a);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("admind.jsp").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}

