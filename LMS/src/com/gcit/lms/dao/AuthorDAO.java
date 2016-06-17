package com.gcit.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;

public class AuthorDAO extends BaseDAO{

	public void showAll(List<Author> authors) throws ClassNotFoundException, SQLException
	{
		System.out.printf("\nAUTHORS\n");
		for( Author a : authors )
		{
			System.out.println("Author Name: " + a.getAuthorName());
			System.out.println("Author ID: "+ a.getAuthorId());
			if( a.getBooks() == null )
			{
				System.out.println("----------------------");
				continue;
			}
			for( Book b : a.getBooks() )
			{
				System.out.println("Book Title: " + b.getTitle());
				System.out.println("Book ID: "+ b.getBookId());
			}
			System.out.println("-----------------------?");
		}
	}
	
	public void insertAuthor(Author author) throws ClassNotFoundException, SQLException{
		save("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()});
	}
	
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException{
		save("delete from tbl_author where authorId=?", new Object[] {author.getAuthorId()});
	}
	
	public void deleteAll() throws ClassNotFoundException, SQLException{
		save("delete * from tbl_author", null);
	}
	
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException{
		save("update tbl_author set authorName = ? where authorId = ?", new Object[] {author.getAuthorName(), author.getAuthorId()});
	}
	
	public boolean searchAuthorId (int id) throws ClassNotFoundException, SQLException	{
		List<Author> authors = (List<Author>) read("select * from tbl_author where authorId = ?", new Object[] { id });
		if( authors.size() == 0 )
			return false;
		else
			return true;
	}
	
	public List<Author> readAll() throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_author;");
		List<Author> authors = new ArrayList<Author>();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Author a = new Author();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			BookDAO b = new BookDAO();
			List<Book> books = (List<Book>) b.read("SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId FROM tbl_book_authors WHERE authorId = " + a.getAuthorId() + ")", null);
			a.setBooks(books);
			authors.add(a);
		}
		return authors;
	}

	@Override
	public List<Author> extractData(ResultSet rs) throws SQLException {
		List<Author> authors = new ArrayList<Author>();
		while(rs.next()){
			Author a = new Author();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			
			authors.add(a);
		}
		return authors;
	}
}
