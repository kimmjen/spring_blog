<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<div class="container">

	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title }</h4>
				<a href="/board/${board.id }" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>
	
	<ul class="pagination justify-content-center">
	
	<c:choose>
		<c:when test="${boards.first }">
			<li class="page-item disable"><a class="page-link" href="?page=${boards.number-1}">Previous</a>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${boards.last }">
			<li class="page-itemdisable"><a class="page-link" href="?page=${boards.number+1}">Next</a>
		</c:when>
		<c:otherwise>
			<li class="page-item-disable"><a class="page-link" href="?page=${boards.number+1}">Next</a>
		</c:otherwise>
	</c:choose>


	<!-- <div class="card m-2">
		<div class="card-body">
			<h4 class="card-title">제목 적는 부분</h4>
			<a href="#" class="btn btn-primary">상세보기</a>
		</div>
	</div>

	<div class="card m-2">
		<div class="card-body">
			<h4 class="card-title">제목 적는 부분</h4>
			<a href="#" class="btn btn-primary">상세보기</a>
		</div>
	</div> -->

</div>

<%@ include file="layout/footer.jsp"%>


