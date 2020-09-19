package adminlogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import javax.servlet.http.*;
 
@WebServlet("/UserLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserLogoutServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("Admin");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminindex.jsp");
            dispatcher.forward(request, response);
        }
    }
}
