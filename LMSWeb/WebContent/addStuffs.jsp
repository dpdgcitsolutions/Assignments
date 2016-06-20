<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.service.AdministrativeService" %>
    <%@ page import="com.gcit.lms.domain.Book" %>
    <%@ page import="com.gcit.lms.domain.Author" %>
    <%@ page import="com.gcit.lms.domain.Genre" %>
    <%@ page import="com.gcit.lms.domain.Publisher" %>
    <%AdministrativeService service = new AdministrativeService(); 
    List<Author> authors = new ArrayList<Author>();
    authors = service.viewAuthors();
    List<Genre> genres = new ArrayList<Genre>();
    genres = service.viewGenres();
    List<Publisher> publishers = new ArrayList<Publisher>();
    publishers = service.viewPublishers();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="style.css" type="text/css">
	<title>LMS</title>
</head>

<body>
	<div class="users">
	<div class="container">
		<a style="font-size:20px;" href="admin.jsp">Back</a><br/>
	</div>
</div>
	${message}<br/>
	
	<h3 class="title">Author</h3>
	<form role="form" class="form-horizontal" action="addStuffs" method="post">
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="author">Name:</label>
	      <div class="col-sm-10">
	      	<input type="text" class="form-control" name="authorName" placeholder="Enter Author Name">
		  </div>
	    </div>
		<div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-primary">Add Author</button>
	      </div>
	    </div>
	</form><br/>
	
	<h3 class="title">Book</h3>
	<form role="form" class="form-horizontal" action="addStuffs" method="post">
		<div class="form-group">
	      <label class="control-label col-sm-2" for="book">Title:</label>
	      <div class="col-sm-10">
	      	<input type="text" class="form-control" name="bookTitle" placeholder="Enter Book Title">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="publishers">Publisher:</label>
	      <div class="col-sm-10">
	      <select id="pubId" name="pubId" >
			<% for( Publisher p : publishers ) { %>
				<option value=<%=p.getPublisherId() %>><%=p.getPublisherName()%></option>
			<% } %>
		  </select>
		  </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="authors">Author:</label>
	      <div class="col-sm-10">
	      <select id="authorId" name="authorId">
			<% for( Author a : authors ) { %>
				<option value=<%=a.getAuthorId() %>><%=a.getAuthorName()%></option>
			<% } %>
		  </select>
		  </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="genres">Genre:</label>
	      <div class="col-sm-10">
	      <select id="genreId" name="genreId">
			<% for( Genre g : genres) { %>
				<option value=<%=g.getGenre_id() %>><%=g.getGenre_name()%></option>
			<% } %>
		</select>
		</div>
	    </div>
		<div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-primary">Add Book</button>
	      </div>
	    </div>
	</form><br/>
	
	<h3 class="title">Genre</h3>
	<form role="form" class="form-horizontal" action="addStuffs" method="post">
	 	<div class="form-group">
	      <label class="control-label col-sm-2" for="genre">Genre:</label>
	      <div class="col-sm-10">
	      	<input type="text" class="form-control" name="genreName" placeholder="Enter Genre Name">
	      </div>
	    </div>
		<div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-primary">Add Genre</button>
	      </div>
	    </div>
	</form><br/>
	
	<h3 class="title">Publisher</h3>
	<form role="form" class="form-horizontal" action="addStuffs" method="post">
		<div class="form-group">
	      	<label class="control-label col-sm-2" for="publisher">Name:</label>
	      	<div class="col-sm-10">
	      		<input type="text" class="form-control" name="publisherName" placeholder="Enter Publisher Name">
	      	</div>
	      	<label class="control-label col-sm-2" for="publisher">Address:</label>
	      	<div class="col-sm-10">
	      		<input type="text" class="form-control" name="publisherAddress" placeholder="Enter Publisher Address">
	      	</div>
	      	<label class="control-label col-sm-2" for="publisher">Phone:</label>
	      	<div class="col-sm-10">
	      		<input type="text" class="form-control" name="publisherPhone" placeholder="Enter Publisher Phone">
	      	</div>
	     </div>
	     <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-primary">Add Publisher</button>
	      </div>
	    </div>
	</form><br/>
	
</body>
</html>