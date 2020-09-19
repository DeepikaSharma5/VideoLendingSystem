package com.video.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.video.model.Bill;



public class BillDAO {
	private String jdbcURL ="jdbc:mysql://localhost:3306/videos?useSSL=false";
	private String jdbcUsername ="root";
	private String jdbcPassword ="kajan003";
	
	private static final String INSERT_BILL_SQL ="INSERT INTO bill" + "(DistributorName,videoName,price,years) VALUES "   +"(?,?,?,?);";
	private static final String SELECT_BILL_BY_BILLID ="select billID,DistributorName,videoName,price,years from bill where billID =?";
	private static final String SELECT_ALL_BILL ="select billID,DistributorName,videoName,price,years,years * price as 'total' from bill";
	private static final String DELETE_BILL_SQL ="delete from bill where billID = ?;";
	private static final String UPDATE_BILL_SQL ="update bill set DistributorName=?,videoName=?,price=?,years=? where billID =?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	
	}
	
	//create or insert bill
	public void insertBill(Bill Bill) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_SQL)){
			preparedStatement.setString(1, Bill.getDistributorName());
			preparedStatement.setString(2, Bill.getVideoName());
			preparedStatement.setString(3, Bill.getPrice());
			preparedStatement.setString(4, Bill.getYears());
			
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
	//Update supplier
		public boolean updateBill(Bill Bill) throws SQLException{
			boolean rowUpdated;
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_BILL_SQL);){
				statement.setString(1, Bill.getDistributorName());
				statement.setString(2, Bill.getVideoName());
				statement.setString(3, Bill.getPrice());
				statement.setString(4, Bill.getYears());
				
			
				statement.setInt(5, Bill.getBillID());
				
				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
		
		//select supplier by billID
		public Bill selectBill(int billID) {
			Bill Bill = null;
			try(Connection connection = getConnection(); 
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_BY_BILLID);){
				preparedStatement.setInt(1, billID);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String DistributorName = rs.getString("DistributorName");
					String videoName = rs.getString("videoName");
					String price = rs.getString("price");
					String years = rs.getString("years");
					Bill = new Bill(billID,DistributorName,videoName,price,years);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return Bill;
		}
				
		public List<Bill> selectAllBill(){
			List<Bill> Bill = new ArrayList<>();
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BILL);){
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					int billID = rs.getInt("billID");
					String DistributorName=rs.getString("DistributorName");
					String videoName=rs.getString("videoName");
					String price=rs.getString("price");
					String years=rs.getString("years");
					String total = rs.getString("total");
					Bill.add(new Bill(billID,DistributorName,videoName,price,years,total));
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return Bill;
		}
		
		public boolean deleteBill(int billID) throws SQLException{
			boolean rowDeleted;
			try(Connection connection = getConnection();
					PreparedStatement statement=connection.prepareStatement(DELETE_BILL_SQL);){
				statement.setInt(1, billID);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
}
