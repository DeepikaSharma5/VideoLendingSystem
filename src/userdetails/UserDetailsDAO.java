package userdetails;

	import java.util.*;
	import java.sql.*;

	public class  UserDetailsDAO{

		public static Connection getConnection(){
			Connection con=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003");
			}catch(Exception e){System.out.println(e);}
			return con;
		}
		public static int save(UserDetails u){
			int status=0;
			try{
				Connection con=UserDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into user (first_name,contact_no,email,password,cnfrmpwd) values (?,?,?,?,?)");
				ps.setString(1,u.getFirst_name());
				ps.setString(2,u.getContact_no());
				ps.setString(3,u.getEmail());
				ps.setString(4, u.getPassword());
				ps.setString(5, u.getCnfrmpwd());
				
				
				status=ps.executeUpdate();
				
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
			
			return status;
		}
		public static int update(UserDetails u){
			int status=0;
			try{
				Connection con=UserDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("update user set first_name=?,contact_no=?,email=?,password=?,cnfrmpwd=? where Userid=?");
				ps.setString(1,u.getFirst_name());
				ps.setString(2,u.getContact_no());
				ps.setString(3,u.getEmail());
				ps.setString(4, u.getPassword());
				ps.setString(5, u.getCnfrmpwd());
				ps.setInt(6,u.getUserid());
				
				status=ps.executeUpdate();
				
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
			
			return status;
		}
		public static int delete(int Userid){
			int status=0;
			try{
				Connection con=UserDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from user where Userid=?");
				ps.setInt(1,Userid);
				status=ps.executeUpdate();
				
				con.close();
			}catch(Exception e){e.printStackTrace();}
			
			return status;
		}
		public static UserDetails getuserById(int Userid){
			UserDetails u =new UserDetails();
			
			try{
				Connection con=UserDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from user where Userid=?");
				ps.setInt(1,Userid);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					u.setUserid(rs.getInt(1));
					u.setFirst_name(rs.getString(2));
					u.setContact_no(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setPassword(rs.getString(5));
					u.setCnfrmpwd(rs.getString(6));
				}
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
			
			return u;
		}
		public static List<UserDetails> getAllUsers(){
			List<UserDetails> list=new ArrayList<UserDetails>();
			
			try{
				Connection con=UserDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from user");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					UserDetails u =new UserDetails();
					u.setUserid(rs.getInt(1));
					u.setFirst_name(rs.getString(2));
					u.setContact_no(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setPassword(rs.getString(5));
					u.setCnfrmpwd(rs.getString(6));
					list.add(u);
				}
				con.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
		}
	
	
		
	}
