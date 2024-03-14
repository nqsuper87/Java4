<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Fpoly/MyServlet" method="post">
	<input name="fullname" placeholder="Full Name"><br/><br/>
	<input type="checkbox" name="hobbies" value="Reading">Reading <br/>
	<input type="checkbox" name="hobbies" value="Playing Football">Playing Football<br/>
	<input type="checkbox" name="hobbies" value="Gaming">Gaming<br/><br/>
	<button type="submit">Submit</button>
	
</form>

</body>
</html>