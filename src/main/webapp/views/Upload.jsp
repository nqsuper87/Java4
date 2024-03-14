<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Fpoly/Upload" method="POST" enctype="multipart/form-data">
	
	<input accept=".jpg,.png, .jpeg," name="file" type="file">
	<br/>
	<button>Upload File</button>
</form>

</body>
</html>