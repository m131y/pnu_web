<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>[${USER.name}]님 반갑습니다</h1>
	<p>id : ${USER.userId}</p>
	<p>deptNm : ${USER.deptNm}</p>
	<p>email : ${USER.email}</p>
	<p>job : ${USER.job}</p>
	<p>phone : ${USER.phone}</p>
	
	<button type="button" onclick="window.location.href='logout.do'">로그아웃</button>
	<button type="button" onclick="window.location.href='pwdConfirmPage.do'">회원정보수정</button>
</body>
</html>