package com.videobill.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.dao.BillDAO;
import com.video.model.Bill;;

/**
 * Servlet implementation class DeleteBillServlet
 */
@WebServlet("/DeleteBillServlet")
public class DeleteBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDAO billDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBillServlet() {
        super();
        this.billDAO = new BillDAO();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int billID = Integer.parseInt(request.getParameter("billID"));
		try {
			billDAO.deleteBill(billID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ListBillServlet");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);


}
}
