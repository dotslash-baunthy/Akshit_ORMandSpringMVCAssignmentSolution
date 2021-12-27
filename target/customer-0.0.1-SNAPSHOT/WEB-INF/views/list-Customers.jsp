<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

</head>

<body>

	<div class="container">

		<h3>Customers Directory</h3>
		<hr>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<!-- <th>Actions</th> -->
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
<%-- 						<td>
							<!-- Add "update" button/link --> <a
							href="/spring-mvc/students/showFormForUpdate?id=${tempStudent.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/spring-mvc/students/delete?id=${tempStudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>

						</td> --%>

					</tr>
				</c:forEach>

			</tbody>
		</table>

		<!-- Form action on submit is to show form for addition of student -->
		<form action="/CustomerRelationshipManagement/crm/showFormForAdd" class="form-inline">
			<button type="submit" class="btn btn-success btn-sm">Add
				Customer</button>
		</form>

	</div>

</body>

</html>









