package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

 private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003");
            
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}


