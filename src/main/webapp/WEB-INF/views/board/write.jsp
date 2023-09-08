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
<link rel="stylesheet"
	href="../resources/css/list.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
	<c:choose>
		<c:when test="${user eq null}">
			<script>
				alert('로그인 후 이용가능합니다.');
				// 	location.href = "${cp}"+"/board/getList?category=" + "${param[category]}"";
				var redirectUrl = "${cp}/board/getList?category="+ "${param.category}";
				console.log("리디렉션 URL: " + redirectUrl);
				location.href = redirectUrl;
			</script>
		</c:when>
		<c:otherwise>
			<section class="notice">
				<div class="page-title">
					<div class="container">
						<h3>
							<a href="${cp}/board/getList?category=${category}">SKYLAON'S
								JSP BOARD</a>
						</h3>
						<div class="menu">
							<nav class="clearfix">
								<ul class="clearfix">
									<li><a href="http://www._____.com">준비중</a></li>
									<li><a href="http://www._____.com/About">준비중</a></li>
									<li><a href="http://www._____.com/Project">준비중</a></li>
									<li><a href="http://www._____.com/Travel">준비중</a></li>
									<li><a href="http://www._____.com/Contact">준비중</a></li>
									<li><a href="${cp}/member/logout">로그아웃</a></li>
								</ul>
								<a id="pull" href="#"></a>
							</nav>
						</div>
					</div>
				</div>

				<div class="container">
					<form action="${cp}/board/write" method="post">
						<input type="hidden" name="b_category" value="${param.category}">
						<table class="board-table">
							<tbody>
								<tr>
									<th>제목</th>
									<td><input name="b_title"><br></td>
								</tr>
								<tr>
									<th>작성자</th>
									<td><input type="text" name="b_id" value="${user.u_id}"
										readonly="readonly"></td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea name="b_text" cols="50" rows="10"></textarea></td>
								</tr>
							</tbody>
						</table>
						<input type="submit" class="btn btn-dark" value="쓰기">
					</form>
				</div>
			</section>
		</c:otherwise>
	</c:choose>
</body>
</html>