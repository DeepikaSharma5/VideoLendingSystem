package newpackage;

import java.sql.*;

public class UserDAO {

	Connection con ;

    public UserDAO(Connection con) {
        this.con = con;
    }
    
    public boolean saveUser(User user){
        boolean set = false;
        try{

            String query = "insert into user(first_name,contact_no,email,password,cnfrmpwd) values(?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getFirst_name());
           pt.setString(2, user.getContact_no());
           pt.setString(3, user.getEmail());
           pt.setString(4, user.getPasssword());
           pt.setString(5, user.getCnfrmpwd());	   
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            System.out.println(e);
        }
        return set;
    }
    
    public User logUser(String email, String password) {
    	User user = null;
    	try {
    		
    		String query = "select * from user where email=? and password=?";
    		PreparedStatement ps =this.con.prepareStatement(query);
    		ps.setString(1, email);
    		ps.setString(2, password);
    		
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			user = new User();
    			user.setUserid(rs.getInt("Userid"));
    			user.setFirst_name(rs.getString("first_name"));
    			user.setEmail(email);
    			user.setContact_no(rs.getString("contact_no"));
    			user.setPasssword(rs.getString("password"));
    			user.setCnfrmpwd(rs.getString("cnfrmpwd"));
    			}
    		
    	}catch(Exception e) {
    		System.out.println(e);
    	}
		return user;
    	
    }
}


