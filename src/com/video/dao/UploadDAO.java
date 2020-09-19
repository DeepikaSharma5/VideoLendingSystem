package com.video.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.video.model.Upload;

public class UploadDAO {
	String databaseURL = "jdbc:mysql://localhost:3306/videos";
    String user = "root";
    String password = "kajan003";
    
    
     
    public Upload get(int id) throws SQLException, IOException {
        Upload upload = null;
         
        String sql = "SELECT * FROM video_lend WHERE id = ?";
         
        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
             
            if (result.next()) {
                upload = new Upload();
                String name = result.getString("name");
                String category = result.getString("category");
                String description = result.getString("description");
                Blob blob = result.getBlob("videofile");
                 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String videofile = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                inputStream.close();
                outputStream.close();
                 
                upload.setName(name);
                upload.setCategory(category);
                upload.setDescription(description);
                upload.setVideofile(videofile);
            }          
             
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return upload;
    }
}
