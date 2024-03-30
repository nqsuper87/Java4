<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Fpoly/User" method="post">
	<input name="username" placeholder="Username"><br/><br/>
	<input name="password" type="password" placeholder="Password"><br/><br/>
	<input name="fullname" placeholder="Full Name"><br/><br/>
	<input name="email" placeholder="Email Address"><br/><br/>
	
	<input name="admin" type="radio" value="true">Admin
	<br/>
	<input name="admin" type="radio" value="false">User
	<br/>
	
	<button formaction="/Fpoly/create">Create</button>
	<button formaction="/Fpoly/update">Update</button>
	<button formaction="/Fpoly/delete">Delete</button>
	<a href="/Fpoly/User">Reset</a>
	
	<br/>
	<br/>
	
	<table border="1" style="width: 100%">
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
	
</form>

</body>
</html>