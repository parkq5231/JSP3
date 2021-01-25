<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr.row:hover {
	background-color: lightyellow;
}
</style>

</head>
<body>
	<jsp:include page="../common/menu.jsp" />

<div align="center">
	<h1>게시글 목록</h1>
	<div>
		<table border='1'>
			<tr>
				<th width="50">글번호</th>
				<th width="200">제 목</th>
				<th width="150">작성자</th>
				<th width="150">작성일자</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr class="row" onclick="location.href='/20210125mvc/BorderRowSelect.do?row='+${vo.boardNo}"><!-- survlet의 row값에 vo.boardNO를 넣어준다 -->
					<td align="center">${vo.boardNo}</td>
					<td>&nbsp;${vo.title}</td>
					<td align="center">${vo.writer}</td>
					<td align="center">${vo.creationDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div><br>
	<div>
	<button type="button" onclick="location.href='views/board/boardInputForm.jsp'">글쓰기</button>
	</div>
</div>
</body>
</html>