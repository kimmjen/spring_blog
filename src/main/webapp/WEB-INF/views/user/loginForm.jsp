<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<h2>로그인 화면</h2>
	
	<form>
		<div class="form-group">
			<label for="uname">아이디:</label> <input type="text"
				class="form-control" id="uname" placeholder="Enter username"
				name="uname" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호:</label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="pswd" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox" name="remember" required>
				I agree on blabla.
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Check this checkbox to continue.</div>
			</label>
		</div>
		<button type="submit" class="btn btn-primary">로그인하기</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>