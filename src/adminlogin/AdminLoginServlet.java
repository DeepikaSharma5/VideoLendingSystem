package adminlogin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  public AdminLoginServlet() {
      super();
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("email");
      String Password = request.getParameter("password");
      
      AdminDAO db =  new AdminDAO(AdminConnectionProvider.getConnection());
      Admin admin = db.logAdmin(Email, Password);
      
      if(admin!=null){
          HttpSession session = request.getSession();
          session.setAttribute("logAdmin", admin);
          response.sendRedirect("AdminHome.jsp");
      }else{
          System.out.println("user not found");
          request.setAttribute("message", "Wrong email or password");
			request.getRequestDispatcher("adminindex.jsp").forward(request, response);
      }

	}

}
