<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<h2>로그인 화면</h2>

	<form action="/user/login" method="POST">
		<div class="form-group">
			<label for="username">아이디:</label> <input type="text"
				class="form-control" id="username" placeholder="Enter username">
		</div>

		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="password"
				class="form-control" id="password" placeholder="Enter password">

		</div>
	</form>


	<button id="btn-login" class="btn btn-primary">로그인</button>
</div>
<script src="../js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>