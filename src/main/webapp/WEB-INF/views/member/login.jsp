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
<link rel="stylesheet" href="../resources/css/index.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
    <h2>SKYLAON</h2>
    <div style="text-align: center;">
        <span id="clock" font-size: 60px;"></span>
        <span id="apm" font-size: 30px;"></span>
    </div>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form id="signupForm"><!--action="${cp}/login/regProc"  -->
                <h1>Create Account</h1>
                <span>or use your email for registration</span>
                <input type="text" id="u_id" name="u_id" minlength="4" maxlength="12" placeholder="id(4자이상,12자 이하)"/>
                <input type="password" id="u_pw" name="u_pw"  minlength="4" maxlength="12" placeholder="pw(4자이상,12자 이하)" />
                <input type="password" id="re_pw" minlength="4" maxlength="12" placeholder="pw재입력"/>
                <input type="text" id="u_name" name="u_name" placeholder="Name">
                <input type="date" id="u_age" name="u_age"  placeholder="생년월일"/>
                남자<input type="radio"  name="u_gender" value="M" checked="checked">
                여자<input type="radio"  name="u_gender" value="F">
                <input class="submit" onclick="submitForm()" value="SIGN IN">
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form action="${cp}/member/loginproc">
                <h1>Sign in</h1>
                <span>or use your account</span>
                	<input type="text" name="u_id" placeholder="ID" />
                	<input type="password" name="u_pw" placeholder="Password" />
                	<a href="#">Forgot your password?</a>
                	<input class="submit" type="submit" value="SIGN IN">
                	<a href="/member/non_login_proc">Login as a non-member</a>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
    css출처 : https://inpa.tistory.com/
    <script src="../resources/js/index.js"></script>
    <script src="../resources/js/time.js"></script>
    <script src="../resources/js/login.js"></script>
</body>
</html>