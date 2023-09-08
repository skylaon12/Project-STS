<%@page import="com.skylaon.spring.sm.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/home.css??ver=<%=System.currentTimeMillis()%>">
</head>
<body>
	<%
	MemberVO user = (MemberVO) session.getAttribute("user");
	%>
	<header>
		<a href="/product/main"><h1>Skylaon Health</h1></a>
		<nav>
			<ul>
				<li><a href="#">홈</a></li>
				<li><a href="${cp}/shop/category">제품 목록</a></li>
				<li><a href="/cartList.jsp">장바구니</a></li>
				<li><a href="/purchaseList.jsp">주문하기</a></li>
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
	<div class="container">
		<div class="product-image">
			<img src="${product.image_url}" alt="상품1">
		</div>
		<div class="product-details">
			<h2>${product.product_name}</h2>
			<p>${product.product_description}></p>
			<p>리뷰 개수: ${product.review_count}개</p>
			<p>리뷰 점수: ${product.rating}</p>
			<p>가격: ￦${product.price}</p>
			<button>구매하기</button>
			<a href="/product/cart_input_proc?p_id=${product.product_id}"><button>장바구니에
					담기</button></a>
		</div>
	</div>

</body>
</html>