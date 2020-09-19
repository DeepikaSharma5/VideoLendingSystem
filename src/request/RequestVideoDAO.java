package request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RequestVideoDAO {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int update(RequestVideoDetails v){
		int status=0;
		try{
			Connection con=RequestVideoDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("update request set name=?,email=?,contactno=?,video=? where requestid=?");
			ps.setString(1,v.getName());
			ps.setString(2,v.getEmail());
			ps.setString(3,v.getContactno());
			ps.setString(4,v.getVideo());
			ps.setInt(5,v.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=RequestVideoDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from request where requestid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static RequestVideoDetails getvideoById(int id){
		RequestVideoDetails v =new RequestVideoDetails();
		
		try{
			Connection con=RequestVideoDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from request where requestid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				v.setId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setEmail(rs.getString(3));
				v.setContactno(rs.getString(4));
				v.setVideo(rs.getString(5));
				
			}	
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
			}
		
		return v;
	}
	public static List<RequestVideoDetails> getAllRequest(){
		List<RequestVideoDetails> list=new ArrayList<RequestVideoDetails>();
		
		try{
			Connection con=RequestVideoDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from request");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				RequestVideoDetails v =new RequestVideoDetails();
				v.setId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setEmail(rs.getString(3));
				v.setContactno(rs.getString(4));
				v.setVideo(rs.getString(5));

				list.add(v);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}



}




