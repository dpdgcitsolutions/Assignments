<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.service.AdministrativeService" %>
    <%@ page import="com.gcit.lms.domain.Genre" %>
    <%AdministrativeService service = new AdministrativeService(); 
    List<Genre> genres = new ArrayList<Genre>();
    genres = service.viewGenres();%>
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
<body>
<h3>List of Genres</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Edit Publisher</th>
				<th>Delete Publisher</th>
			</tr>
		</thead>
		<tbody>
		<% for(Genre g : genres) {%>
			<tr>
				<td><%=g.getGenre_id() %></td>
				<td><%=g.getGenre_name() %></td>
				<td><button type="button" class="btn btn-warning" onclick="javascript:location.href='editAuthor?authorId=<%=g.getGenre_id()%>'">EDIT</button></td>
				<td><button type="button" class="btn btn-danger" onclick="javascript:location.href='deleteAuthor?authorId=<%=g.getGenre_id()%>'">DELETE</button></td>
			</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>