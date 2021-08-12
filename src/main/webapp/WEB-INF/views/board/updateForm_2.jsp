<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="margin-top: 30px;">

	<h2>글 수정하기</h2>
	<br />
	<form>
		<input type="hidden" id="id" value="${board.id }" />
		<div class="from-group">
			<!-- <label for="title">제목</label> -->
			<input value="${board.title }" type="text" class="form-control"
				placeholder="Enter title" id="title">
		</div>
		<br />
		<div class="from-group">
			<!-- <label for="content">내용</label> -->
			<textarea class="form-control summernote" rows="10" cols="85"
				id="content">${board.content }</textarea>
		</div>
		<br /> <br />
		<button id="btn-update" class="btn btn-primary">글 수정 완료</button>
	</form>



</div>

<script>

$('.summernote').summernote({
	placeholder: 'Hello Bootstrap 4',
	tabsize: 2,
	height: 300
});
</script>


<script src="../js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

