<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>

	<jsp:include page="navbar.jsp" />

	<c:forEach items="${data}" var="d">
		<div class="row mt-5 ">
			<div class="col col-sm-1"></div>
			<div class="col col-sm-10">
				<div class="card text-center">
					
					<div class="card-header">${d.item_name}</div>
					
					<div class="card-body mb-2">
						
						<h5 class="card-title">ingredients</h5>
						
						<p class="card-text">${d.item_ingredients}</p>
						
						<h5 class="card-title">recipe</h5>
						
						<p class="card-text">${d.item_recipe }</p>
						
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>