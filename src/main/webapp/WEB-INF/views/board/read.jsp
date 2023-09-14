<%@page import="com.skylaon.spring.sm.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="../resources/css/list.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
	<%
	/*	GuestVO read = (GuestVO)request.getAttribute("read");
		long bno = read.getBno();
		String btext = read.getBtext();*/
	%>

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
			<table class="board-table">
				<tbody>
					<tr>
						<th>번호</th>
						<td>${read.b_no}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${read.b_title}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${read.b_id}</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${read.b_hit}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${read.b_text}</td>
					</tr>
				</tbody>
			</table>
			<c:if test="${user != null}">
				<c:if test="${read.b_id eq user.u_id}">
					<a href="${cp}/board/modify?no=${read.b_no}&category=${read.b_category}"><button
						class="btn btn-dark">수정하기</button></a>
					<br>
					<a href="${cp}/board/del?no=${read.b_no}&category=${read.b_category}"><button
						class="btn btn-dark">삭제하기</button></a>
					<br>
				</c:if>
			</c:if>
			<a href="${cp}/board/getList?category=${category}"><button
						class="btn btn-dark">돌아가기</button></a>

		</div>
		<!-- 댓글 창 -->
		<div class="container">
		    <h4>댓글[${read.b_reply_count}]</h4>
		    <div class="cmt_list">
		        <!-- 댓글 목록이 여기에 표시됩니다. -->
		        <!-- 댓글 목록 예시 -->
		       	<c:forEach var="com" items="${comment}">
		        	<div class="comment-item">
		        		<p class="comment-content">댓글내용: ${com.b_text}</p>
        				<span class="comment-author">작성자: ${com.b_id}</span><br>
        				<span class="comment-date">작성일자: ${com.b_datetime}</span>
        				<c:if test="${user.u_id eq com.b_id}">
        					<a href="${cp}/board/delComment?category=${category}&no=${com.b_no}&ori=${read.b_no}">삭제하기</a>
        				</c:if>
	        		</div>
		       	</c:forEach>
		    </div>
		    <form id="comment-form" class="comment-form">
		    	<input type="hidden" id= "b_category" value="${read.b_category}"/>
		    	<input type="hidden" id="u_id" value="${user.u_id}"/>
		    	<input type="hidden" id="b_ori_id" value="${read.b_no}"/>
		        <textarea id="comment" placeholder="댓글을 입력하세요..." rows="4"></textarea>
		        <button type="button" onclick="submitComment()" class="btn btn-dark">댓글 등록</button>
		    </form>
		</div>
	</section>

<script src="../resources/js/commentRegister.js"></script>
</body>
</html>