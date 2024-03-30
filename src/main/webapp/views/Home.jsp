<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>

<jsp:useBean id="now" class="java.util.Date"/>
<h2><fmt:formatDate value="${now}" pattern="dd/MM/yyyy HH:mm:ss"></fmt:formatDate></h2>

<c:forEach var="video" items="${requestScope.videos}">
	<li>${video.title}</li>
	<li>${video.views}</li>
</c:forEach>

<c:if test = "${!empty sessionScope.name}">
	<H3>Xin chào ${sessionScope.name}</H3>
	<form action="/Fpoly/Logout" method="post">
		<button>Logout</button>
	</form>
</c:if>

<c:if test = "${empty sessionScope.name}">
	<c:redirect url="/views/Login.jsp"/>
</c:if>

</body>
</html>