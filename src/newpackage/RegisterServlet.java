package newpackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String contact_no  = request.getParameter("contact_no");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		String cnfrmpwd = request.getParameter("cnfrmpwd");
	
		User userModel = new User(first_name, contact_no,email, password,cnfrmpwd);

		
		UserDAO regUser = new UserDAO(ConnectionProvider.getConnection());
		if (regUser.saveUser(userModel)) {
			request.setAttribute("successmessage", "Registred successfully. please login to continue.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
		   
		    request.setAttribute("message", "Already registred. Please login");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		    }

	}

}
