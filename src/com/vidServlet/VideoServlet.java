package com.vidServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Request;

import com.video.dao.ImageDao;

import com.video.dao.videoDAO;
import com.video.model.video;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet("/")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private videoDAO videoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
       this.videoDAO = new videoDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doGet(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		
	
		switch(action) {
		case "/new":
			showNewForm(request,response);
		break;
		
		case "/delete":
			try {
				deleteVideo(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateVideo(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			ImageViewerController(request,response);
			break;
		}
		
		}
	private void showNewForm(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("video-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void deleteVideo(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		videoDAO.deleteVideo(id);
		response.sendRedirect("ImageViewerController");
	}
	
	private void showEditForm(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		video existingVideo = videoDAO.selectVideo(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("video-form.jsp");
		request.setAttribute("video", existingVideo);
		dispatcher.forward(request, response);
	}
	
	private void updateVideo(HttpServletRequest request,HttpServletResponse response)throws  IOException, SQLException{
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		video newVideo = new video(id,name,category,description);
		videoDAO.updateVideo(newVideo);
		response.sendRedirect("list");
		
	}
	
	private void listVideo(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException, SQLException{
		List<video>listVideo = videoDAO.selectAllVideos();
		request.setAttribute("listVideo", listVideo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("video-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void ImageViewerController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ImageDao imageDao = null;
		imageDao = new ImageDao();
		List<video> list =  imageDao.getData();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("videoList.jsp");
		dispatcher.forward(req, resp);
	}
	


}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	


