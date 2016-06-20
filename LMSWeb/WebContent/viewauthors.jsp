<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.service.AdministrativeService" %>
    <%@ page import="com.gcit.lms.domain.Author" %>
    <%AdministrativeService service = new AdministrativeService(); 
    List<Author> authors = new ArrayList<Author>();
    authors = service.viewAuthors();
    %>
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
<div class="users">
	<div class="container">
		<a style="font-size:20px;" href="admin.jsp">Back</a><br/>
	</div>
</div>
<h3 style="padding:14px 10px;">List of Authors</h3>
<table class="table table-hover">
	<thead>
	<tr>
		<th>Author ID</th>
		<th>Author Name</th>
		<th>Book Title</th>
		<th>Edit Author</th>
		<th>Delete Author</th>
	</tr>
	<thead>
	<tbody>
	<%for(Author a: authors){ %>
		<tr>
			<td><%=a.getAuthorId() %></td>
			<td><%=a.getAuthorName() %></td>
			<td><%=a.getBooks().get(0).getTitle() %></td>
			<td><button type="button" class="btn btn-warning" onclick="javascript:location.href='editAuthor?authorId=<%=a.getAuthorId()%>'">EDIT</button></td>
			<td><button type="button" class="btn btn-danger" onclick="javascript:location.href='deleteAuthor?authorId=<%=a.getAuthorId()%>'">DELETE</button></td>
			</tr>
	<%} %>
	</tbody>	
</table>

<!-- <select multiple="multiple" name="selectedAuthors"> -->
<%-- 	<%for(Author a: authors){ %> --%>
<%-- 		<option value=<%=a.getAuthorId() %>><%=a.getAuthorName() %></option> --%>
<%-- 	<%} %> --%>
<!-- 	</select> -->
</html>