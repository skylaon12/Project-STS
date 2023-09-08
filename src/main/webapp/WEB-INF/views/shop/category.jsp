<%@page import="com.skylaon.spring.sm.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Skylaon Health - 쇼핑몰</title>
<link rel="stylesheet"
	href="../resources/css/home.css??ver=<%=System.currentTimeMillis()%>">
</head>
<body>
	<%
	MemberVO user = (MemberVO) session.getAttribute("user");
	%>
	<header>
		<h1>Skylaon Health</h1>
		<nav>
			<ul>
				<li><a href="#">홈</a></li>
				<li><a href="#">제품 목록</a></li>
				<li><a href="#">장바구니</a></li>
				<li><a href="#">주문하기</a></li>
			</ul>
		</nav>
		<%
		if (user == null) {
		%>
		<div class="login-btn">
			<a href="${cp}/member/login"><button>로그인</button></a>
		</div>
		<%
		} else {
		%>
		<div class="login-btn">
			<a href="${cp}/member/logout"><button>로그아웃</button></a>
		</div>
		<%
		}
		%>

	</header>
	<form action="${cp}/shop/search_pdList">
		<label for="search" class="blind">제품 검색</label>
		<input type="text" name="word" placeholder="제품명" />
		<button type="submit" class="submit" value="검색"></button>
	</form>

	<main>
		<section class="products">
			<div class="product">
				<a href="${cp}/shop/pdList?id=0"> <img
					src="../resources/img/category/proteinShake.jpg" alt="프로틴쉐이크"></a>
				<h2>프로틴 쉐이크</h2>
			</div>
			<div class="product">
				<a href="${cp}/shop/pdList?id=1"> <img
					src="../resources/img/category/sportWear.jpeg" alt="스포츠웨어"></a>
				<h2>스포츠 웨어</h2>
			</div>
			<div class="product">
				<a href="${cp}/shop/pdList?id=2"> <img
					src="../resources/img/category/proteinBar.png" alt="프로틴 바"></a>
				<h2>프로틴바&스낵</h2>
			</div>
			<div class="product">
				<a href="${cp}/shop/pdList?id=3"> <img
					src="../resources/img/category/vitamin.png" alt="비타민"></a>
				<h2>비타민</h2>
			</div>
			<div class="product">
				<a href="${cp}/shop/pdList?id=4"> <img
					src="../resources/img/category/food.png" alt="식단"></a>
				<h2>식단</h2>
			</div>

		</section>
	</main>

	<footer>
		<p>&copy; 2023 Skylaon Health. All rights reserved.</p>
	</footer>
</body>
</html>