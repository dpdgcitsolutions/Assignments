package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO {
	private static String driver= "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/library";
	private static String username = "root";
	private static String pass = "Kat6825537674";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, pass);
		return conn;
	}
	
	public int save(String query, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = getConnection().prepareStatement(query);
		if(vals !=null){
			int count = 1;
			for(Object o: vals){
				pstmt.setObject(count, o);
				count ++;
			}
		}
		return pstmt.executeUpdate();
	}	
	
	public List<?> read(String query, Object[] vals) throws SQLException, ClassNotFoundException{
		PreparedStatement pstmt = getConnection().prepareStatement(query);
		if(vals !=null){
			int count = 1;
			for(Object o: vals){
				pstmt.setObject(count, o);
				count ++;
			}
		}
		ResultSet rs = pstmt.executeQuery();		
		return extractData(rs);
	}

	public abstract List<?> extractData(ResultSet rs) throws SQLException;
}
