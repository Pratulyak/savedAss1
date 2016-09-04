<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.unsw.comp9321.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Digital Bibliography</title>
<%@ include file="pageHeader.jsp"%>
</head>
<body>
	<div class="container">
		<form action='Frontpage' method="POST">
			<input type="submit" value="Back to Search" /> <input type="hidden"
				name="action" value="home" />
		</form>
	</div>
	<div class="container" align="right">
		<input type="submit" value="Add To Cart" /> <input type="hidden"
			name="action" value="add">
	</div>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Journal</th>
					<th>Year</th>
					<th>Add to Cart</th>
				</tr>
			</thead>
			<c:forEach begin="0" end="9" varStatus="loop" var="archives"
				items="${results}">
				<tr>
					<td><c:out value="${archives.title}" /></td>
					<td><c:out value="${archives.journal}" /></td>
					<td><c:out value="${archives.year}" /></td>
					<td><input type="checkbox" name="addToCart"
						value="<c:out value="${archives.title}" />"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<%@ include file = "pageFooter.jsp"%>
</html>