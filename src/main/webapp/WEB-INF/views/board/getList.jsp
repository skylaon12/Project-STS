<%@page import="com.skylaon.jsp.BoardListProcessor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.skylaon.spring.sm.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="../resources/css/list.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
	<section class="notice">
		<div class="page-title">
			<div class="container">
				<h3>SKYLAON'S JSP BOARD</h3>
				<div class="menu">
					<nav class="clearfix">
						<ul class="clearfix">
							<li><a href="http://www._____.com">준비중</a></li>
							<li><a href="http://www._____.com/About">준비중</a></li>
							<li><a href="http://www._____.com/Project">준비중</a></li>
							<li><a href="${cp}/board/category">게시판 목록</a></li>


							<c:choose>
								<c:when test="${user == null}">
									<li><a href="${cp}/member/login">로그인</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${cp}/member/logout">로그아웃</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
						<a id="pull" href="#"></a>
					</nav>
				</div>
			</div>
		</div>

		<!-- board seach area -->
		<div id="board-search">
			<div class="container">
				<div class="search-window">
					<form action="/board/list">
						<div class="search-wrap">
							<label for="search" class="blind">공지사항 내용 검색</label> <input
								type="hidden" name="category" value="">
							<input name="word" type="search" placeholder="검색어를 입력해주세요."
								value="">
							<button type="submit" class="btn btn-dark">검색</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- board list area -->
		<div id="board-list">
			<div class="container">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col" class="th-num">번호</th>
							<th scope="col" class="th-title">제목</th>
							<th scope="col" class="th-title">조회수</th>
							<th scope="col" class="th-date">작성자</th>
							<th scope="col" class="th-date">등록일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="guest" items="${list}">
							<c:set var="no" value="${guest.b_no}" />
							<c:set var="title" value="${guest.b_title}" />
							<c:set var="hit" value="${guest.b_hit}" />
							<c:set var="id" value="${guest.b_id}" />
							<c:set var="datetime" value="${guest.b_datetime}" />
							<c:set var="category" value="${guest.b_category}" />
							<tr>
								<td>${no}</td>
								<th><a href="${cp}/board/read?category=${category}&no=${no}">${title}</a>
								</th>
								<td>${hit}</td>
								<td>${id}</td>
								<td>${datetime}</td>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="board-write">
			<div class="container">
				<a href="${cp}/board/write?category=${category}"><button
						class="btn btn-dark">게시물 작성</button></a>
			</div>
		</div>

	</section>
</body>
</html>