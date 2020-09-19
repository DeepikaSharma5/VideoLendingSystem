package com.videobill.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.model.Bill;
import com.video.dao.BillDAO;

/**
 * Servlet implementation class UpdateBillServlet
 */
@WebServlet("/UpdateBillServlet")
public class UpdateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDAO billDAO;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBillServlet() {
        super();
        this.billDAO = new BillDAO();

        // TODO Auto-generated constructor stub
    }

    	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		 int billID = Integer.parseInt(request.getParameter("billID"));
    			String DistributorName=request.getParameter("DistributorName");

    	        String videoName=request.getParameter("videoName");

    	        String price=request.getParameter("price");
    	        
    	        String years=request.getParameter("years");
    	        
    	        String total=request.getParameter("total");
    	        
    	        

    	        
    	        

    	        
    			Bill Bill = new Bill(billID,DistributorName,videoName,price,years,total);
    			try {
					billDAO.updateBill(Bill);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			response.sendRedirect("ListBillServlet");
    		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
