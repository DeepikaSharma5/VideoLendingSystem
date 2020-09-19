package com.vidServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.dao.ImageDao;;
/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteVideoServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImageDao ImageDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        this.ImageDao = new ImageDao();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			deleteVideo(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void deleteVideo(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		ImageDao.deleteVideo(id);
		response.sendRedirect("videoList.jsp");
	}

}
