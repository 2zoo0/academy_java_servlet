<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 메뉴</title>

<style type="text/css">
	table, tr, th, td {
		border: 1px solid black;
	}
	
	.element {
    display: block;
    margin-left: auto;
    margin-right: auto;
  }
</style>

</head>

<body>
<h1 align="center">도서 관리 페이지</h1>
<hr>
${contextPath}<br>
<div class="element" style="width: 400px">
<!-- ul>(li>a)*2 -->
<ul>
	<li><a href="${contextPath}/main/list">도서 제품 목록</a></li>
	<li><a href="${contextPath}/main/insert">도서 신규 등록</a></li>
	<li><a href="${contextPath}/logout">로그아웃</a></li>
	
</ul>
</div>
</body>
</html>