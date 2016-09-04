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
<%@ include file="pageHeader.jsp"%>
</head>
</head>
<body>
	<center>
		<h1>Shopping Cart</h1>
	</center>
	<div class="container">
		<form action="F
		rontpage" method="post">
			<input align="left" type="hidden" name="home"> <input
				type="submit" name="action" value="Home">
		</form>
	</div>
	<div class = "container">
		<form action = "Frontpage">
		<input align = "right" type= "hidden" name = "checkout">
		<input type = "submit" name = "action" value = "Checkout">
		</form>
	</div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Year</th>
					<th>Price</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<%@ include file = "pageFooter.jsp"%>
</html>