<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/Fpoly/User" method="post">
		<input value="${userForm.id}" name="id" placeholder="Username"><br />
		<br /> <input value="${userForm.password}" name="password"
			type="password" placeholder="Password"><br />
		<br /> <input value="${userForm.fullname}" name="fullname"
			placeholder="Full Name"><br />
		<br /> <input value="${userForm.email}" name="email"
			placeholder="Email Address"><br />
		<br /> <input ${userForm.admin?'checked':''} name="admin" type="radio"
			value="true">Admin <br /> <input
			${userForm.admin?'':'checked'} name="admin" type="radio"
			value="false">User <br />

		<button formaction="/Fpoly/User/create">Create</button>
		<button formaction="/Fpoly/User/update">Update</button>
		<button formaction="/Fpoly/User/delete?id${userForm.id}=">Delete</button>
		<a href="/Fpoly/User">Reset</a>
	</form>
	<h4>${message}</h4>
	<br />
	<br />

	<table border="1" style="width: 100%">
		<tr>
			<th>Id</th>
			<th>Password</th>
			<th>Fullname</th>
			<th>User Type</th>
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.password}</td>
				<td>${user.fullname}</td>
				<td>${user.admin?'Admin':'User'}</td>
				<td><a href="/Fpoly/User/edit/${user.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>