<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Fpoly/RegisterServlet" method="post">
	<input name="fullname" placeholder="Fullname?">
	<br/>
	<input name="age" type="number" placeholder="Age">
	<br/>
	<input name="gender" type="radio" value="true">Male
	<br/>
	<input name="gender" type="radio" value="false">FeMale
	<br/>
	<select name="country">
		<option value="VN">Viet Nam</option>
		<option value="US">United States</option>
	</select>
	<input name="salary" type="number" placeholder="Salary">
	<br/>
	<hr>
	<button>Submit</button>
</form>

</body>
</html>