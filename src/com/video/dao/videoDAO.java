package com.video.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.video.model.video;

//CRUD database operations for videostable
public class videoDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/videos";
	private String jdbcUsername="root";
	private String jdbcPassword="kajan003";
	
	private static final String INSERT_VIDEOS_SQL = "INSERT INTO video_lend" + "(name,category,description,videofile) VALUES"
			+ "(?,?,?);";
	
	private static final String SELECT_VIDEOS_BY_ID = "select id,name,category,description,videofile from video_lend where id = ?";
	private static final String SELECT_ALL_VIDEOS = "select* from video_lend";
	private static final String DELETE_VIDEOS_SQL = "delete from video_lend where id=?;";
	private static final String UPDATE_VIDEOS_SQL = "update videos set name=?,category=?,description=?,videofile=? where id=?;";
	
	public videoDAO() {}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//insert user
	 public void insertVideo(video video) throws SQLException {
	        System.out.println(INSERT_VIDEOS_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VIDEOS_SQL)) {
	            preparedStatement.setString(1, video.getName());
	            preparedStatement.setString(2,video.getCategory());
	            preparedStatement.setString(3,video.getDescription());
	            preparedStatement.setBytes(4, video.getVideofile());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }
	//update user
	 public boolean updateVideo(video video) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_VIDEOS_SQL);) {
	            statement.setString(1,video.getName());
	            statement.setString(2,video.getCategory());
	            statement.setString(3,video.getDescription());
	            statement.setBytes(4, video.getVideofile());
	            statement.setInt(5,video.getId());
	            

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	//select user by id
	 public video selectVideo(int id) {
	        video video = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VIDEOS_BY_ID);) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String category = rs.getString("category");
	                String description = rs.getString("description");
	                byte[] videofile = rs.getBytes(1);
	                
	                video = new video(id, name, category, description,videofile);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return video;
	    }
	//select users
	 public List < video > selectAllVideos() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < video > video = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VIDEOS);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String category = rs.getString("category");
	                String description = rs.getString("description");
	                byte[] videofile = rs.getBytes(1);
	                
	                video.add(new video(id, name, category, description,videofile));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return video;
	    }

	//delete user
	 public boolean deleteVideo(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_VIDEOS_SQL);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	private void printSQLException(SQLException ex) {
		// TODO Auto-generated method stub
		for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
		
}
	


