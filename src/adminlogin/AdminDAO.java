package adminlogin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminDAO {

		Connection con ;

	    public AdminDAO(Connection con) {
	        this.con = con;
	    }
	    
	      
		public Admin logAdmin(String email, String password) {
			Admin admin = null;
	    	try {
	    		
	    		String query = "select * from admin where email=(?) and password=(?)";
	    		PreparedStatement ps =this.con.prepareStatement(query);
	    		ps.setString(1, email);
	    		ps.setString(2, password);
	    		
	    		ResultSet rs = ps.executeQuery();
	    		if(rs.next()) {
	    			admin =new Admin();
	    			admin.setEmail(email);
	    			admin.setPassword(password);
	    			}
	    		
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
			return admin;
		}

	   


}
