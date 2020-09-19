package com.pst.ir.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection con=null;
public static Connection getConnection(){
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","kajan003");
	}catch(Exception e) {
		System.out.println(e);
	}
	return con;
}
}
