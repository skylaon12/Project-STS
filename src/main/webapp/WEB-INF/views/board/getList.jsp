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
<link rel="stylesheet"
	href="../resources/css/page.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
<%
	Object o = request.getAttribute("list");
	ArrayList<BoardVO> list = (ArrayList<BoardVO>)o;
%>
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
						<%
						for(int i = 0; i < list.size(); i++){
							int b_no = list.get(i).getB_no();
							String b_title = list.get(i).getB_title();
							String b_id = list.get(i).getB_id();
							int b_hit = list.get(i).getB_hit();
							String b_datetime = list.get(i).getB_datetime();
							String b_category = list.get(i).getB_category();
						%>
						<tr>
							<td><%=b_no%></td>
							<th><a href="${cp}/board/read?category=<%=b_category%>&no=<%=b_no%>}"><%=b_title%></a>
								</th>
								<td><%=b_hit%></td>
								<td><%=b_id%></td>
								<td><%=b_datetime %></td>
						<%
						}
						%>
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
		<div class="page_wrap">
			<div class="page_nation">
				<c:if test="${hasPrev == true}" >
					[<a class="arrow prev" href="${cp}/board/getList?category=${category}&page=${prevPage}"><img src="../resources/img/board/page_prev.png" alt="이전"></a>]
				</c:if>
				<c:forEach var="p" begin="${blockStartNo}" end="${blockEndNo}">
					[<a href="${cp}/board/getList?category=${category}&page=${p}">${p}</a>]
				</c:forEach>
				<c:if test="${hasNext == true}" >
					[<a class="arrow next" href="${cp}/board/getList?category=${category}&page=${nextPage}"><img src="../resources/img/board/page_next.png" alt="다음"></a>]
				</c:if>
			</div>
		</div>
	</section>
</body>
</html>