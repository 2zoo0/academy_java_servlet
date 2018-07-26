<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 관리 메뉴</title>

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
<h1 align="center">제품 관리 페이지</h1>
<hr>
<div class="element" style="width: 400px">
<!-- ul>(li>a)*2 -->
<ul>
	<li><a href="list">젠체 제품 목록</a></li><br>
	<li><a href="insert">제품 신규 등록</a></li>
</ul>
</div>
</body>
</html>