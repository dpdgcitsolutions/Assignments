package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;

public class JDBC {	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Class.forName(driver);
//		Connection conn = DriverManager.getConnection(url, username, pass);
//		String query = "select * from tbl_author";
//		//Statement stmt = conn.createStatement();
//		query = "select * from tbl_author where authorName like ?";
//		PreparedStatement pstmt = conn.prepareStatement(query);
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter a new Author: ");
//		String authorName = scan.nextLine();
//		
//		query = "insert into tbl_author (authorName) values('"+authorName+"')";
//		query = "select * from tbl_author where authorName like '"+authorName+"'";
//		query = "select * from tbl_author where authorId = ?";
//		//stmt.executeUpdate(query);
//		
//		//pstmt.setString(1, authorName);
//		pstmt.setInt(1, 200);
//		ResultSet rs = pstmt.executeQuery();
		
//		while(rs.next()){
//			System.out.println("Author Name: " +rs.getString("authorName"));
//			System.out.println("Author ID: "+rs.getInt("authorId"));
//			System.out.println("-----------------------");
//		}
		Scanner scan = new Scanner(System.in);
		
		// create AuthorDAO
		AuthorDAO authorDAO = new AuthorDAO();
		authorDAO.getConnection();
		// create BookDAO
		BookDAO bookDAO = new BookDAO();
		// create BookAuthorsDAO
		BookAuthorsDAO bkauDAO = new BookAuthorsDAO();
		
		// Add new author
//		System.out.print("Enter a new Author: ");
//		String authorName = scan.nextLine();
//		
//		// create Author object
//		Author author = new Author();
//		author.setAuthorName(authorName);
//		authorDAO.insertAuthor(author);
		
		// Add new book
//		bookDAO.getConnection();
//		System.out.print("Enter a new book: ");
//		String bookTitle = scan.nextLine();
//		
//		// create Book object
//		Book book = new Book();
//		book.setTitle(bookTitle);
//		bookDAO.insertBook(book);
		
		// Read all authors and books from DB
		List<Author> authors = authorDAO.readAll();
		authorDAO.showAll(authors);
		
		// Update author
//		Author author = new Author();
//		author.setAuthorName("Miriam Blanc");
//		author.setAuthorId(14);
//		authorDAO.updateAuthor(author);
		
		// Map book with authors
		bkauDAO.insert(authorDAO, bookDAO, bkauDAO);
	}
}
