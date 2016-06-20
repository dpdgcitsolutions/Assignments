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
<title>LMS</title>
</head>
<h2>Welcome to GCIT Library Management System</h2>
<h3>Hello Admin! Enter Book details</h3>
<body>
<a href="admin.jsp">Back</a><br/>

<form action="AddBook" method="post">
Enter Book Title: <input type="text" name="bookTitle"><br/>
Publisher:
<select id="pubId" name="pubId" >
	<% for( Publisher p : publishers ) { %>
		<option value=<%=p.getPublisherId() %>><%=p.getPublisherName()%></option>
	<% } %>
</select><br/>
Author:
<select id="authorId" name="authorId">
	<% for( Author a : authors ) { %>
		<option value=<%=a.getAuthorId() %>><%=a.getAuthorName()%></option>
	<% } %>
</select><br/>
Genre:
<select id="genreId" name="genreId">
	<% for( Genre g : genres) { %>
		<option value=<%=g.getGenre_id() %>><%=g.getGenre_name()%></option>
	<% } %>
</select><br/>
<button type="submit">Add Book</button>
</body>
</html>