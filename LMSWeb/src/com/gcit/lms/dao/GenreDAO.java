package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Genre;

public class GenreDAO extends BaseDAO {

	public GenreDAO(Connection conn) {
		super(conn);
	}
	
	public void insertGenre(Genre g) throws ClassNotFoundException, SQLException{
		save("insert into tbl_genre (genre_name) values (?)", new Object[] {g.getGenre_name()});
	}
	
	public List<Genre> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from tbl_genre", null);
	}

	@Override
	public List<Genre> extractData(ResultSet rs) throws SQLException {
		GenreDAO gDAO = new GenreDAO(connection);
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()){
			Genre g = new Genre();
			g.setGenre_id(rs.getInt("genre_id"));
			g.setGenre_name(rs.getString("genre_name"));
			genres.add(g);
		}
		return genres;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) throws SQLException {
		GenreDAO gDAO = new GenreDAO(connection);
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()){
			Genre g = new Genre();
			g.setGenre_id(rs.getInt("genre_id"));
			g.setGenre_name(rs.getString("genre_name"));
			genres.add(g);
		}
		return genres;
	}
	
	

}
