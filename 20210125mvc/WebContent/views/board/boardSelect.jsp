<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	text-align: center;
}
</style>
</head>
<body>
<jsp:include page="../common/menu.jsp" />
	<div align="center">
		<div>
			<h1>게시글 상세보기</h1>
		</div>
		<div align="center">
			<table border='1'>
				<tr>
					<th width='70'>글번호</th>
					<td width='50'>${vo.boardNo}</td>
					<th width='70'>작성자</th>
					<td width='100'>${vo.writer}</td>
					<th width='80'>작성일자</th>
					<td width='150'>${vo.creationDate}</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="5">${vo.title}</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="5"><textarea rows='7' cols='70'>${vo.content}</textarea></td>
				</tr>
			</table>
			<br>
			<button onclick="location.href='/20210125mvc/BoardList.do'">목록보기</button>&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='/20210125mvc/BoardDelete.do?row='+${vo.boardNo}">글삭제</button>&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='/20210125mvc/BoardUpdate.do?row='+${vo.boardNo}">글수정</button>
		</div>
	</div>
</body>
</html>