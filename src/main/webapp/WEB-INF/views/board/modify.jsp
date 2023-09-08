<%@ page import="com.skylaon.spring.sm.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/list.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
	<section class="notice">
		<div class="page-title">
			<div class="container">
				<h3>
					<a href="${cp}/board/getList?category=${category}">SKYLAON'S JSP BOARD</a>
				</h3>
				<div class="menu">
					<nav class="clearfix">
						<ul class="clearfix">
							<li><a href="http://www._____.com">준비중</a></li>
							<li><a href="http://www._____.com/About">준비중</a></li>
							<li><a href="http://www._____.com/Project">준비중</a></li>
							<li><a href="http://www._____.com/Travel">준비중</a></li>
							<li><a href="http://www._____.com/Contact">준비중</a></li>
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

		<div class="container">
			<form action="${cp}/board/modify" method="post">
				<table class="board-table">
					<tbody>
						<tr>
							<th>제목</th>
							<td>
								<input type="hidden" name="b_category" value="${read.b_category}">
								<input type="hidden" name="b_no" value="${read.b_no}">
								<input name="b_title" value="${read.b_title}">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="b_text" cols="50" rows="10">${read.b_text}</textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-dark" value="수정">
			</form>
		</div>
	</section>


</body>
</html>