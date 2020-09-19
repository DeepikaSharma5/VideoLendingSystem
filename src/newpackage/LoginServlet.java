package newpackage;

  import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("email");
        String Password = request.getParameter("password");
        
        UserDAO db =  new UserDAO(ConnectionProvider.getConnection());
        User user = db.logUser(Email, Password);
        
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
            response.sendRedirect("homepage.jsp");
        }else{
            System.out.println("user not found");
            request.setAttribute("message", "User not found. Click on register or contact us");
			request.getRequestDispatcher("index.jsp").forward(request, response);
        }

	}

}
