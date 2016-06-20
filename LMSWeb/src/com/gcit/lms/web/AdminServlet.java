package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;
import com.gcit.lms.service.AdministrativeService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/addStuffs")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
    }
    AdministrativeService service = new AdministrativeService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Author
		String authorName = request.getParameter("authorName");
		if(authorName != null)
		{
			Author author = new Author();
			author.setAuthorName(authorName);
			try {
				service.createAuthor(author);
				request.setAttribute("message", "<div class='alert alert-success'>Author added sucessfully!</div>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "<div class='alert alert-danger'>Author failed sucessfully!</div>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Book
		String bookTitle = request.getParameter("bookTitle");
		if( bookTitle != null )
		{
			// publisher
			int pubId = Integer.parseInt(request.getParameter("pubId"));
			Publisher p = new Publisher();
			p.setPublisherId(pubId);
			// author
			int authorId = Integer.parseInt(request.getParameter("authorId"));
			Author a = new Author();
			a.setAuthorId(authorId);
			List<Author> authors = new ArrayList<Author>();
			authors.add(a);
			// genre
			int genreId = Integer.parseInt(request.getParameter("genreId"));
			Genre g = new Genre();
			g.setGenre_id(genreId);
			List<Genre> genres = new ArrayList<Genre>();
			genres.add(g);
			// book
			Book b = new Book();
			b.setTitle(bookTitle);
			b.setAuthors(authors);
			b.setPublisher(p);
			b.setGenres(genres);
			try {
				service.createBook(b);
				request.setAttribute("message", "<div class='alert alert-success'>Book added sucessfully!</div>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "<div class='alert alert-danger'>Book failed sucessfully!</div>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Publisher
		String pubName = request.getParameter("publisherName");
		if( pubName != null )
		{
			Publisher p = new Publisher();
			p.setPublisherName(pubName);
			p.setPublisherAddress(request.getParameter("publisherAddress"));
			p.setPublisherPhone(request.getParameter("publisherPhone"));
			try {
				service.createPublisher(p);
				request.setAttribute("message", "<div class='alert alert-success'>Publisher added sucessfully!</div>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "<div class='alert alert-danger'>Publisher failed sucessfully!</div>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		// Genre
		String genreName = request.getParameter("genreName");
		if( genreName != null )
		{
			Genre g = new Genre();
			g.setGenre_name(genreName);
			try {
				service.createGenre(g);
				request.setAttribute("message", "<div class='alert alert-success'>Genre added sucessfully!</div>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "<div class='alert alert-danger'>Genre failed sucessfully!</div>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("addStuffs.jsp");
		rd.forward(request, response);
	}

}
