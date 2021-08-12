<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<h2>목록</h2>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Title</th>
				<th>Content</th>
				<th>count</th>
				<th>CreateDate</th>
			</tr>
		</thead>
		<c:forEach var="board" items="${boards.content }">
			<tbody>
				<tr>
					<td>${board.title}</td>
					<td>${board.content}</td>
					<td>${board.count}</td>
					<td>${board.createDate}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
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
	
	
	<%-- <c:set var="isFirst" value="${boards.first }"></c:set>
		<li class="page-item"><a class="page-link" href="?page=${boards.number-1 }">Previous</a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item active"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="?page=${boards.number+1 }">Next</a></li>
	</ul> --%>
</div>
<%@ include file="../layout/footer.jsp"%>

