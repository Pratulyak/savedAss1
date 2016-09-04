<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body style="background-color: white;">

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">DIGITALBILIOGRAPHY</a>
			</div>

			<div>
				<ul class="nav navbar-nav">
					<li ${param.home}><a href="frontpage.jsp">Home</a></li>
					<li>${param.advanced}<a href="AdvancedSearch.jsp">Advanced Search</a></li>
					<li ${param.cart}><a href="ShoppingCart.jsp">Cart</a></li>
				</ul>



				<form action = "Frontpage" class="navbar-form navbar-right" method="post" role="search">
					<div class="form-group">
						<input type="text"  class="form-control" name="searchString" placeholder="Search">
						<input type= "hidden" name="searchString">
					</div>
					<button type="submit" class="btn btn-default" name="action" value="search">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>

			</div>
		</div>

	</nav>

</body>

</html>