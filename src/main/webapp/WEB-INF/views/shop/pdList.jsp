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
<link rel="stylesheet" href="../resources/css/home.css??ver=<%=System.currentTimeMillis()%>">
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
				<li><a href="${cp}/shop/category">제품 목록</a></li>
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

	<main>
		<section class="products">

			<c:forEach var="product" items="${products}">
				<div class="product">
					<a href="${cp}/shop/productInfo?p_id=${product.product_id}"><img src="${product.image_url}" alt="상품1"></a>
					<a href="${cp}/shop/productInfo?p_id=${product.product_id}"><h2>${product.product_name}</h2></a>

					<span class="price">￦${product.price}</span>
					<button>장바구니에 담기</button>
				</div>
			</c:forEach>

		</section>
	</main>

	<footer>
		<p>&copy; 2023 Skylaon Health. All rights reserved.</p>
	</footer>
</body>
</html>