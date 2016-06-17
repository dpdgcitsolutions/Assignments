package com.gcit.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Book;

public class BookDAO extends BaseDAO {

	public void insertBook(Book book) throws ClassNotFoundException, SQLException{
		save("insert into tbl_book (title) values (?)", new Object[] {book.getTitle()});
	}
	
	public void updateBook(Book book) throws ClassNotFoundException, SQLException{
		save("update tbl_book set title = ? where bookId = ?", new Object[] {book.getTitle(), book.getBookId()});
	}
	
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException{
		save("delete from tbl_book where bookId=?", new Object[] {book.getBookId()});
	}
	
	public boolean searchBookId (int id) throws ClassNotFoundException, SQLException	{
		List<Book> books = (List<Book>) read("select * from tbl_book where bookId = ?", new Object[] { id });
		if( books.size() == 0 )
			return false;
		else
			return true;
	}
	
	public void showAll(List<Book> books) throws ClassNotFoundException, SQLException
	{
		System.out.printf("\nBOOKS\n");
		for( Book b : books )
		{
			System.out.println("Book Title: " + b.getTitle());
			System.out.println("Book ID: "+ b.getBookId());
			System.out.println("-----------------------");
			
		}
	}
	
	public List<Book> readAll() throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_book");
		List<Book> books = new ArrayList<Book>();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			books.add(b);
		}
		return books;
	}
	
	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			books.add(b);
		}
		return books;
	}
}
