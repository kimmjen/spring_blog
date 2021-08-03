<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h2>로그인 화면</h2>

	<form action="#" method="post">
		<div class="form-group">
			<label for="username">아이디:</label> 
			<input type="text" name="username" class="form-control" id="username" placeholder="Enter username">
		</div>

		<div class="form-group">
			<label for="password">비밀번호:</label>
			<input type="password" name="password" class="form-control" id="password" placeholder="Enter password">

		</div>
		<div class="form-group form-check">
			<label class="form-check-label">
			<input name="remember" class="form-check-input" type="checkbox">Remember me
			</label>
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
	</form>


</div>
<script src="../js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>