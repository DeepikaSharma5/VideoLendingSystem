package com.videobill.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.model.Bill;
import com.video.dao.BillDAO;

/**
 * Servlet implementation class ListBillServlet
 */
@WebServlet("/ListBillServlet")
public class ListBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDAO billDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBillServlet() {
        
        this.billDAO = new BillDAO();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Bill> listBill = billDAO.selectAllBill();
		request.setAttribute("listBill", listBill);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill-list.jsp");
		dispatcher.forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
