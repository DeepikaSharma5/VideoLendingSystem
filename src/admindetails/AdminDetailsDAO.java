package admindetails;

import java.util.*;
import java.sql.*;

public class  AdminDetailsDAO{

		public static Connection getConnection(){
			Connection con=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003");
			}catch(Exception e){System.out.println(e);}
			return con;
		}
		public static int save(AdminDetails a){
			int status=0;
			try{
				Connection con=AdminDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into admin (email,password,fullname,address,phone) values (?,?,?,?,?)");
				ps.setString(1,a.getEmail());
				ps.setString(2,a.getPassword());
				ps.setString(3,a.getFullname());
				ps.setString(4, a.getAddress());
				ps.setString(5, a.getPhone());
				
				
				status=ps.executeUpdate();
				
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
			
			return status;
		}
		public static int update(AdminDetails a){
			int status=0;
			try{
				Connection con=AdminDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("update admin set email=?,password=?,fullname=?,address=?,phone=? where adminid=?");
				ps.setString(1,a.getEmail());
				ps.setString(2,a.getPassword());
				ps.setString(3,a.getFullname());
				ps.setString(4,a.getAddress());
				ps.setString(5,a.getPhone());
				ps.setInt(6,a.getId());
				
				status=ps.executeUpdate();
				
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
			
			return status;
		}
		public static int delete(int id){
			int status=0;
			try{
				Connection con=AdminDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from admin where adminid=?");
				ps.setInt(1,id);
				status=ps.executeUpdate();
				
				con.close();
			}catch(Exception e){e.printStackTrace();}
			
			return status;
		}
		public static AdminDetails getadminById(int id){
			AdminDetails a =new AdminDetails();
			
			try{
				Connection con=AdminDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from admin where adminid=?");
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					a.setId(rs.getInt(1));
					a.setEmail(rs.getString(2));
					a.setPassword(rs.getString(3));
					a.setFullname(rs.getString(4));
					a.setAddress(rs.getString(5));
					a.setPhone(rs.getString(6));
				}	
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
				}
			
			return a;
		}
		public static List<AdminDetails> getAllAdmins(){
			List<AdminDetails> list=new ArrayList<AdminDetails>();
			
			try{
				Connection con=AdminDetailsDAO.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from admin");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					AdminDetails a =new AdminDetails();
					a.setId(rs.getInt(1));
					a.setEmail(rs.getString(2));
					a.setPassword(rs.getString(3));
					a.setFullname(rs.getString(4));
					a.setAddress(rs.getString(5));
					a.setPhone(rs.getString(6));
					list.add(a);
				}
				con.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
		}
	
	
	
	}

	
	

