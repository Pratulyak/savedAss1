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
<body>
	
	<center>
		<div class = "icon-search">
			<div class= "jumbotron">
				<form action="Frontpage" method= "POST">
					Title: <input type = "text" name="title"> <input type="hidden" name="action" value="title"><br><br>
					Author: <input type= "text" name= "author"> <input type= "hidden" name="action" value="author"><br><br>
 					Journal: <input type= "text" name= "journal"> <input type= "hidden" name="action" value="journal"><br><br>
 					Year: <input type= "text" name= "year">	<input type = "hidden" name= "action" value="year"><br>
 					<br><input type= "submit" name="search"> <input type= "hidden" name="action" value="search">
				</form>
			</div>
		</div>
		</center>	
</body>
<%@ include file = "pageFooter.jsp"%>
</html>