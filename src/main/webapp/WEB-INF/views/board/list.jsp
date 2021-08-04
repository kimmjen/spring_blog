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
		<c:forEach var="board" items="${boards }">
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
</div>
<%@ include file="../layout/footer.jsp"%>

