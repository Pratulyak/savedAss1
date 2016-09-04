<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.*"%>
<jsp:useBean id="cart" class="edu.unsw.comp9321.Frontpage"
	scope="session" />
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
<%@ include file="header.html"%>
</head>
<body style="background-color: white;">
	<div class="container">
		<form action="F
		rontpage" method="post">
			<input align="left" type="hidden" name="home"> <input
				type="submit" name="action" value="Home">
		</form>
	</div>
	<div align="right" class="container-fluid">
		<img
			src="http://platosociety.org/wp-content/uploads/2013/12/Bibliography.jpg"
			class="img-responsive" width="250" height="250">
	</div>
	<div class="container">
		<center>
			<form action="Frontpage" method="post">


				<div class="form-group">
					<input type="text" name="searchString" size="40"> <input
						type="hidden" name="action" value="search"> <input
						type="submit" name="search" value="Search"> <br> <a
						href="AdvancedSearch.jsp">Advanced |</a> <a
						href="ShoppingCart.jsp">Shopping Cart</a>
				</div>
			</form>
		</center>
	</div>
	<div class="container" align="right">
		<form method = "post">
			<input type="submit" value="Add To Cart" /> <input type="hidden"
				name="action" value="add">
		</form>
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
				items="${archives}">
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


</html>