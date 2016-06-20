package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import com.gcit.lms.domain.BookGenres;

public class BookGenresDAO extends BaseDAO{
	public BookGenresDAO (Connection conn){
		super(conn);
	}
	
	public void insertBookGenres(BookGenres bg) throws ClassNotFoundException, SQLException{
		save("insert into tbl_book_genres (genre_id, bookId) values (?,?)", new Object[] {bg.getGenreId(), bg.getBookId()});
	}
	
//	public void updateBookGenres(BookGenres bg) throws ClassNotFoundException, SQLException{
//		save("update tbl_book_genres set genre_id = ?, bookId = ? where genre_id = ?, bookId = ?", new Object[] {bg.getGenreId(), bg.getBookId()});
//	}
	
	public void updateGenre(BookGenres bg) throws ClassNotFoundException, SQLException
	{
		save("update tbl_book_genres set genre_id = ? where bookId = ?", new Object[] {bg.getGenreId(), bg.getBookId()} );
	}
	
	public void updateBook(BookGenres bg) throws ClassNotFoundException, SQLException
	{
		save("update tbl_book_genres set bookId = ? where genre_id = ?", new Object[] {bg.getBookId(), bg.getGenreId()} );
	}

	@Override
	public List<BookGenres> extractData(ResultSet rs) throws SQLException {
		List<BookGenres> bgs = new ArrayList<BookGenres>();
		while(rs.next())
		{
			BookGenres bg = new BookGenres();
			bg.setBookId(rs.getInt("bookId"));
			bg.setGenreId(rs.getInt("genre_id"));
			bgs.add(bg);
		}
		return bgs;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
