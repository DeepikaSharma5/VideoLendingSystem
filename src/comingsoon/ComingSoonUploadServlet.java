package comingsoon;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/ComingSoonUploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class ComingSoonUploadServlet extends HttpServlet {
	private static final long serialVersionUID = -1623656324694499109L;
    private Connection conn;

    public ComingSoonUploadServlet() {
        conn = ComingSoonDB.getConnection();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        InputStream inputStream = null;

        
        Part filePart = request.getPart("image");
        if (filePart != null) {
           
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

          
            inputStream = filePart.getInputStream();
        }

        String message = null; 

        try {
           
            String s = "INSERT INTO photo (image, name, description) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(s);
            if (inputStream != null) {
            	statement.setBlob(1, inputStream);
            }
            statement.setString(2, name);
            statement.setString(3, description);

            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Image is uploaded successfully into the Database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        }
        request.setAttribute("Message", message);

       
        getServletContext().getRequestDispatcher("/submit.jsp").forward(
                request, response);
    }
}

