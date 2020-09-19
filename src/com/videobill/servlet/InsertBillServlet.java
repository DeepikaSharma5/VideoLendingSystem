package com.videobill.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.dao.BillDAO;
import com.video.model.Bill;;

/**
 * Servlet implementation class InsertBillServlet
 */
@WebServlet("/InsertBillServlet")
public class InsertBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDAO billDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBillServlet() {
        
        this.billDAO = new BillDAO();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String DistributorName=request.getParameter("DistributorName");
		String videoName=request.getParameter("videoName");
		String price=request.getParameter("price");
		String years=request.getParameter("years");
		
	        

	        
		Bill newBill = new Bill(DistributorName,videoName,price,years);
		try {
			billDAO.insertBill(newBill);
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
