<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
</head>
<body>
	<header>
		<div style="display: flex;">
			<h5>[${USER.name}]님 반갑습니다.</h5>
			<div style="margin: auto;">
				<button type="button" onclick="window.location.href='${pageContext.request.contextPath }/main.do'">회원정보</button>
				<button type="button" onclick="window.location.href='${pageContext.request.contextPath }/logout.do'">로그아웃</button>
			</div>
		</div>
	</header>
	<section>
		<h3>게시글 상세</h3>
		<table>
			<tr>
				<th>제목</th>
				<td><c:out value="${board.title}"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><c:out value="${board.writerName}"/></td>
			</tr>
			<tr>
				<th>등록날짜</th>
				<td><c:out value="${board.registrationDate}"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><c:out value="${board.contents}"/></td>
			</tr>
		</table>
		<button type="button" onclick="window.history.go(-1)">이전</button>
		<c:if test="${board.writer_id = USER.userId }">
			<button type="button" id="updateBtn">수정</button>
			<button type="button" id="deleteBtn">삭제</button>
		</c:if>
	</section>
</body>

<script type="text/javascript">
	
	window.onload = function() {
		var updateBtn = document.getElementById("updateBtn");
		updateBtn.onclick = function () {
			var path = "${pageContext.request.contextPath }/updateBoardPage.do";
			var params = {
				"boardId" : "${board.boardId}"	
			}
			post(path, params);
		}
		var deleteBtn = document.getElementById("deleteBtn");
		updateBtn.onclick = function () {
			if(confirm("게시글을 삭제하시겠습니까?")){
				var path = "${pageContext.request.contextPath }/updateBoardPage.do";
				var params = {
					"boardId" : "${board.boardId}"		
			}
			}
			post(path, params);
		}
	}
	
	function post(path, params) {
		var form = document.createElement("form");
		form.action = path;
		form.method = "post";
		
		for (var key in params) {
			if(params.hasOwnProperty(key)){
				var hiddenField = document.createElement("input");
				hiddenField.type = "hidden";
				hiddenField.name = key;
				hiddenField.value = params[key];
				form.appendChild(hiddenField);
			}
		}
		document.body.appendChild(form);
		form.submit();
	}
</script>
</html>