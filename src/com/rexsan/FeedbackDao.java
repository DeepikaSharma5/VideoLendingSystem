package com.rexsan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/videos", "root", "kajan003");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Feedback e){
		int status=0;
		try{
			Connection con=FeedbackDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into feedback(name,email,systems,rating,comments) values (?,?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3,e.getsystem());
			ps.setString(4,e.getrating());
			ps.setString(5,e.getcomments());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Feedback e){
		int status=0;
		try{
			Connection con=FeedbackDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update feedback set name=?,email=?,systems=?,rating=?,comments=? where feedbackid=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3,e.getsystem());
			ps.setString(4,e.getrating());
			ps.setString(5,e.getcomments());;
			ps.setInt(6,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=FeedbackDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from feedback where feedbackid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Feedback getEmployeeById(int id){
		Feedback e=new Feedback();
		
		try{
			Connection con=FeedbackDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from feedback where feedbackid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setsystem(rs.getString(4));
				e.setrating(rs.getString(5));
				e.setcomments(rs.getString(6));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Feedback> getAllFeedback(){
		List<Feedback> list=new ArrayList<Feedback>();
		
		try{
			Connection con=FeedbackDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from feedback");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Feedback e=new Feedback();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setsystem(rs.getString(4));
				e.setrating(rs.getString(5));
				e.setcomments(rs.getString(6));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}

