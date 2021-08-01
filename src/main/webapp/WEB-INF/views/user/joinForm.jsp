<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h2>회원가입 화면</h2>
	
	<form>
		<div class="form-group">
			<label for="uname">닉네임:</label>
			<input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호:</label>
			<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
		</div>
		<div class="form-group">
			<label for="uname">이메일:</label>
			<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		</div>
		
		<button id="btn-save" class="btn btn-primary">회원가입하기</button>
	</form>
</div>

<script src="../js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>