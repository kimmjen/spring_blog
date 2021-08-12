<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="margin-top: 30px;">

	<h2>글 상세보기</h2>
	<hr />
	
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id }">
		<a href="/board/${board.id }/updateForm" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br /><br />
	<div>
		글 번호 : <span id="id"><i>${board.id }</i></span>
		작성자 : <span><i>${board.user.username }</i></span>
	</div>
	
	<div>
		<label for="title">제목</label>
		<h3>${board.title}</h3>
	</div>
	<br />
	<div>
		<label for="content">내용</label>
		<div>${board.content }</div>
	</div>
	<br />
	<!-- <div class="from-group">
			<label for="">첨부파일</label> <input type="text" class="form-control">
		</div> -->
	<br />

</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

