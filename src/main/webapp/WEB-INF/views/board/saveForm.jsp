<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container" style="margin-top: 30px;">

	<h2>글쓰기</h2>
	<br />
	<form>
		<div class="from-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" placeholder="Enter title" id="title">
		</div>
		<br />
		<div class="from-group">
			<label for="content">내용</label>
			<textarea class="form-control summernote" rows="10" cols="85" id="content"></textarea>
		</div>
		<br/>
		<!-- <div class="from-group">
			<label for="">첨부파일</label> <input type="text" class="form-control">
		</div> -->
		<br />
		<button id="btn-save" class="btn btn-primary">글쓰기</button>
	</form>



</div>
<!-- 썸머노트 script 시작 -->
<!-- $('.summernote').summernote({
  height: 150,   //set editable area's height
  codemirror: { // codemirror options
    theme: 'monokai'
  }
});
 -->
<script>

$('.summernote').summernote({
	placeholder: 'Hello Bootstrap 4',
	tabsize: 2,
	height: 300
});
</script>

<!--썸머노트 script 종료  -->

<script src="../js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

