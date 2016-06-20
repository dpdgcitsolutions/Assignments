package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookAuthorsDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookGenresDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookAuthors;
import com.gcit.lms.domain.BookGenres;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;

public class AdministrativeService {
	
	ConnectionUtil util = new ConnectionUtil();
	
	public void createAuthor(Author author) throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			AuthorDAO adao = new AuthorDAO(conn);
			adao.insertAuthor(author);
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void createGenre(Genre g) throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			GenreDAO gdao = new GenreDAO(conn);
			gdao.insertGenre(g);
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void createPublisher(Publisher p) throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			PublisherDAO pdao = new PublisherDAO(conn);
			pdao.insertPublisher(p);
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void createBook(Book book) throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			BookDAO bdao = new BookDAO(conn);
			BookAuthorsDAO bkaudao = new BookAuthorsDAO(conn);
			BookGenresDAO bgdao = new BookGenresDAO(conn);
			Integer bookId = bdao.saveWithID("insert into tbl_book (title, pubId) values (?,?)", new Object[] {book.getTitle(), book.getPublisher().getPublisherId()} );
			book.setBookId(bookId);
			for(Author a: book.getAuthors()) {
				BookAuthors bkau = new BookAuthors();
				bkau.setAuthorId(a.getAuthorId());
				bkau.setBookId(bookId);
				bkaudao.insertBookAuthors(bkau);
			}
			for( Genre g: book.getGenres() ) {
				BookGenres bg = new BookGenres();
				bg.setBookId(bookId);
				bg.setGenreId(g.getGenre_id());
				bgdao.insertBookGenres(bg);
			}
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public List<Publisher> viewPublishers() throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			PublisherDAO pdao = new PublisherDAO(conn);
			return pdao.readAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;	
	}
	
	public List<Genre> viewGenres() throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			GenreDAO gdao = new GenreDAO(conn);
			return gdao.readAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;	
	}
	
	public List<Author> viewAuthors() throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}
	
	public List<Book> viewBooks() throws ClassNotFoundException, SQLException{
		Connection conn = util.getConnection();
		try{
			BookDAO bdao = new BookDAO(conn);
			return bdao.readAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}

}
