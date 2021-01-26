<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menu.jsp" />
	<div align="center">
		<div><h1>게시글 수정화면</h1></div>
		<div align="center">
		<form id="frm" name="frm" action="/20210125mvc/BoardUpdateSave.do" method="post">
			<table border='1'>
				<tr>
					<th width='70'>글번호</th>
					<td width='50'><input type="text" id="no" name="no" value="${vo.boardNo}" readonly></td>
					<!-- 수정하지 못하니까 readonly? -->
					<th width='70'>작성자</th>
					<td width='100'>${vo.writer}</td>
					<th width='80'>작성일자</th>
					<td width='150'>${vo.creationDate}</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="5"><input type="text" id="title" name="title" value="${vo.title}"></td>
					<!--수정할 수 있도록 input 안에 집어 넣는 거-->
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="5"><textarea rows='7' cols='70' id="content" name="content" >${vo.content}</textarea></td>
				</tr>
				</table>
				<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록가기" onclick="location.href='/20210125mvc/BoardList.do'">
			</form>
		</div>
	</div>
</body>
</html>