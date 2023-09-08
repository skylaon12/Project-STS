<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- <a href="/guest/getList?currentPage=1">방명록가기</a>  -->
<a href="${cp}/member/login">로그인하기</a>
<a href="${cp}/member/logout">로그아웃</a>
<a href="${cp}/shop/category">쇼핑몰가기</a>
<a href="${cp}/board/category">방명록가기</a>
<a href="${cp}/api/w">어제날씨확인하기</a>

id: ${user.u_id} , pw: ${user.u_pw}

</body>
</html>
