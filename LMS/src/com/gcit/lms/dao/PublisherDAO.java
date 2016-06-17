package com.gcit.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Publisher;

public class PublisherDAO extends BaseDAO{

	public void insertPublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		save("insert into tbl_publisher (publisherName) values (?)", new Object[] {publisher.getPublisherName()});
	}
	
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		save("update  tbl_publisher set publisherName = ? where publisherId = ?", new Object[] {publisher.getPublisherName(), publisher.getPublisherId()});
	}
	
	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		save("delete from tbl_publisher where publisherId=?", new Object[] {publisher.getPublisherId()});
	}
	
	public List<Publisher> readAll() throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_publisher");
		List<Publisher> publishers = new ArrayList<Publisher>();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Publisher p = new Publisher();
			p.setPublisherId(rs.getInt("publisherId"));
			p.setPublisherName(rs.getString("publisherName"));
			publishers.add(p);
		}
		return publishers;
	}
	
	@Override
	public List<?> extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<Publisher> publishers = new ArrayList<Publisher>();
		while(rs.next()){
			Publisher p = new Publisher();
			p.setPublisherId(rs.getInt("publisherId"));
			p.setPublisherName(rs.getString("publisherName"));
			publishers.add(p);
		}
		return publishers;
	}
}
