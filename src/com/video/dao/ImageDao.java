package com.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.video.model.video;
import com.pst.ir.util.DbConnection;


public class ImageDao {
private final String GET_DATA = "select id,name,category,description from video_lend";
private final String GET_IMAGE_QUERY = "select videofile from video_lend where id=?";
private static final String DELETE_VIDEOS_SQL = "delete from video_lend where id=?;";
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

public List<video> getData(){
	video Video = null;
	List<video> videoList = new ArrayList<video>();
	try {
		con = DbConnection.getConnection();
		ps = con.prepareStatement(GET_DATA);
		rs = ps.executeQuery();
		while(rs.next()) {
			Video = new video();
			Video.setId(rs.getInt(1));
			Video.setName(rs.getString(2));
			Video.setCategory(rs.getString(3));
			Video.setDescription(rs.getString(4));
			videoList.add(Video);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return videoList;
}

public byte[] getImage(String id){
	byte[] image = null;
	try {
	con = DbConnection.getConnection();
	ps = con.prepareStatement(GET_IMAGE_QUERY);
	ps.setString(1, id);
	rs = ps.executeQuery();
	if(rs.next()) {
	image = rs.getBytes(1);
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return image;
}

//delete 
public boolean deleteVideo(int id) throws SQLException {
    boolean rowDeleted;
    try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_VIDEOS_SQL);) {
        ps.setInt(1, id);
        rowDeleted = ps.executeUpdate() > 0;
    }
    return rowDeleted;
}

}












