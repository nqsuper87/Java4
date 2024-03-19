<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<jsp:useBean id="now" class="java.util.Date" scope="page" ></jsp:useBean>	
	<H3>Hôm nay: ${now.date}/${now.month+1}/${now.year+1900}
	</H3>
</body>
</html>