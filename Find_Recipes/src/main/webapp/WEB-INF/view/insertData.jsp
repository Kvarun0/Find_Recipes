<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />


	<div class="row mt-5 ">
		<div class="col col-sm-3"></div>
		<div class="col col-sm-6">
			<div class="card ">
				<div class="card-header text-center bg-info  fw-bolder">Insert
					New Item</div>
				<div class="card-body">

					<f:form action="insertData" method="post" modelAttribute="rec_data">

						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Dish
								Name</label>
							<f:input type="text" class="form-control"
								id="exampleFormControlInput1" placeholder="name of dish"
								path="item_name" />
						</div>

						<div class="mb-3">
							<label for="exampleFormControlTextarea1" class="form-label">Ingredients
								Details</label>
							<f:textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3" path="item_ingredients" />
						</div>
						<div class="mb-3">
							<label for="exampleFormControlTextarea1" class="form-label">Recipe
								Details</label>
							<f:textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3" path="item_recipe" />
						</div>
						
						<f:hidden path="id" />
						
						<div class="mb-3 text-center">
							<input type="submit" class="btn btn-primary" value="Add">
						</div>

					</f:form>


				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-3"></div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>