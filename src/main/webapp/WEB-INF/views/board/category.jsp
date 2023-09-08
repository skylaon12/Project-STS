<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>일반</legend>
		<a href="${cp}/board/getList?category=free">자유게시판</a>
		<hr>
		<a href="${cp}/board/getList?category=notice">공지게시판</a>
		<hr>
		<a href="${cp}/board/getList?category=mom">팀플 회의록</a>
	</fieldset>
	<fieldset>
		<legend>게임</legend>
		<a href="${cp}/board/getList?category=lol">롤</a>
		<hr>
		<a href="${cp}/board/getList?category=dia2">디아2</a>
		<hr>
		<a href="${cp}/board/getList?category=loa">로아</a>
		<hr>
		<a href="${cp}/board/getList?category=bag">배그</a>
	</fieldset>
	<fieldset>
		<legend>커뮤니티</legend>
		<a href="${cp}/board/getList?category=humor">유머</a>
		<hr>
		<a href="${cp}/board/getList?category=animal">동물</a>
		<hr>
		<a href="${cp}/board/getList?category=plants">식물</a>
		<hr>
		<a href="${cp}/board/getList?category=car">자동차</a>
		<hr>
		<a href="${cp}/board/getList?category=politics">정치</a>
		<hr>
		<a href="${cp}/board/getList?category=soccer">축구</a>
		<hr>
	</fieldset>
</body>
</html>