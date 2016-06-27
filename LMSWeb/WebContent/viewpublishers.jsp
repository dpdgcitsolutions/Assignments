<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.service.AdministrativeService" %>
    <%@ page import="com.gcit.lms.domain.Publisher" %>
    <%AdministrativeService service = new AdministrativeService(); 
    List<Publisher> pubs = new ArrayList<Publisher>();
    pubs = service.viewPublishers();%>
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
<h3>List of Publishers</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Phone Number</th>
				<th>Edit Publisher</th>
				<th>Delete Publisher</th>
			</tr>
		</thead>
		<tbody>
		<% for(Publisher p : pubs) {%>
			<tr>
				<td><%=p.getPublisherName() %></td>
				<td><%=p.getPublisherAddress() %></td>
				<td><%=p.getPublisherPhone() %></td>
				<td><button type="button" class="btn btn-warning" onclick="javascript:location.href='editAuthor?authorId=<%=p.getPublisherId()%>'">EDIT</button></td>
				<td><button type="button" class="btn btn-danger" onclick="javascript:location.href='deleteAuthor?authorId=<%=p.getPublisherId()%>'">DELETE</button></td>
			</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>