package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.gcit.lms.domain.BookAuthors;

public class BookAuthorsDAO extends BaseDAO {

	public void insertBookAuthors(BookAuthors bkau) throws ClassNotFoundException, SQLException{
		save("insert into tbl_book_authors (bookId, authorId) values (?,?)", new Object[] {bkau.getBookId(), bkau.getAuthorId()});
	}
	
	public void updateBookAuthors(BookAuthors bkau) throws ClassNotFoundException, SQLException{
		save("update tbl_book_authors set bookId = ?, authorId = ? where bookId = ?, authorId = ?", new Object[] {bkau.getBookId(), bkau.getAuthorId()});
	}
	
	public void updateAuthor(BookAuthors bkau) throws ClassNotFoundException, SQLException
	{
		save("update tbl_book_authors set authorId = ? where bookId = ?", new Object[] {bkau.getBookId(), bkau.getAuthorId()} );
	}
	
	public void updateBook(BookAuthors bkau) throws ClassNotFoundException, SQLException
	{
		save("update tbl_book_authors set bookId = ? where authorId = ?", new Object[] {bkau.getAuthorId(), bkau.getBookId()} );
	}
	
	public static void insert(AuthorDAO authorDAO, BookDAO bookDAO, BookAuthorsDAO bkauDAO) throws ClassNotFoundException, SQLException
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter author's ID: ");
		int authorId = scan.nextInt();
		if( authorDAO.searchAuthorId(authorId) == false )
		{
			System.out.println("Can't find author's ID");
			return;
		}
		System.out.print("Enter book's ID: ");
		int bookId = scan.nextInt();
		if( bookDAO.searchBookId(bookId) == false )
		{
			System.out.println("Can't find book's ID");
			return;
		}
		BookAuthors bkau = new BookAuthors();
		bkau.setAuthorId(authorId);
		bkau.setBookId(bookId);
		bkauDAO.insertBookAuthors(bkau);
	}
	
	public void deleteBookAuthors(BookAuthors bkau) throws ClassNotFoundException, SQLException{
		save("delete from tbl_book_authors where where bookId = ?, authorId = ?", new Object[] {bkau.getBookId(), bkau.getAuthorId()});
	}
	@Override
	public List<?> extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
