<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

			<!-- Bootstrap CSS -->
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
				integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
				crossorigin="anonymous">

<title>List Customers</title>

</head>

<body>

	<div class="container">

		<h3>CUSTOMER RELATIONSHIP MANAGEMENT</h3>
		<hr>

		<!-- Form action on submit is to show form for addition of student -->
		<form action="/CustomerRelationshipManagement/crm/showFormForAdd" class="form-inline">
			<button type="submit">Add
				Customer</button>
		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
 						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerRelationshipManagement/crm/showFormForUpdate?id=${tempCustomer.id}"> Update </a> <!-- Add "delete" button/link -->
							|<a href="/CustomerRelationshipManagement/crm/delete?id=${tempCustomer.id}"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>

</html>









