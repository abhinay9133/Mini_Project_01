<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Report Plans</h2>
		<form:form action="plan" method="post" modelAttribute="search">
			<table class="table table-striped">
				<tr>
					<td>Plane Name :</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${plannames}" />
						</form:select></td>
					<td>Plan Status :</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}" />
						</form:select></td>
					<td>Gender :</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date :</td>
					<td><form:input type="date" path="startDate"
							class="date-picker" /></td>
					<td>End Date :</td>
					<td><form:input type="date" path="endDate" class="date-picker" /></td>
					<td><input type="submit" value="Search" class="btn btn-primary btn-sm"/></td>
				</tr>
			</table>
		</form:form>
		<hr>
		<table class="table table-striped  table-hover">
			<thead class="table-dark">
				<tr>
					<td>S.no</td>
					<td>Name</td>
					<td>Plan Name</td>
					<td>Gender</td>
					<td>Status</td>
					<td>Start Date</td>
					<td>End Date</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.planName}</td>
						<td>${plan.citizenGender}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty plans}">
				<tr><td colspan="7" align="center">No Records Found</td></tr>
				</c:if>
			</tbody>
		</table>
		<hr>
		<p>${export}</p>
		<a href="/excel">Export Excel</a>
		<a href="pdf">Export Pdf</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

</body>
</html>