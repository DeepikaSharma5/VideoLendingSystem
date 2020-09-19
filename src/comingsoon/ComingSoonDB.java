package comingsoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ComingSoonDB {
	
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
        	try{
				Class.forName("com.mysql.jdbc.Driver");
				connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003");
			}catch(Exception e){
				System.out.println(e);
				}
 
            return connection;
        }

    }
   
	public static int update(ComingSoon c){
		int status=0;
		try{
			Connection con=ComingSoonDB.getConnection();
			PreparedStatement ps=con.prepareStatement("update photo set name=?,description=? where photoid=?");
			
			ps.setString(2,c.getName());
			ps.setString(3,c.getDescription());
			ps.setInt(4,c.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=ComingSoonDB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from photo where photoid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static ComingSoon getphotoById(int id){
		ComingSoon c =new ComingSoon();
		
		try{
			Connection con=ComingSoonDB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from photo where photoid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				c.setId(rs.getInt(1));
				c.setImage(rs.getBlob(2));
				c.setName(rs.getString(3));
				c.setDescription(rs.getString(4));
			}	
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
			}
		
		return c;
	}
	public static List<ComingSoon> getAllPhotos(){
		List<ComingSoon> list=new ArrayList<ComingSoon>();
		
		try{
			Connection con=ComingSoonDB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from photo");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComingSoon c =new ComingSoon();
				c.setId(rs.getInt(1));
				c.setImage(rs.getBlob(2));
				c.setName(rs.getString(3));
				c.setDescription(rs.getString(4));
				list.add(c);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}



}



