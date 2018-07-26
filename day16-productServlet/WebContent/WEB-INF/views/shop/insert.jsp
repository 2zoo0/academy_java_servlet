<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 신규 등록</title>
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
<h3 align="center">제품 신규 등록</h3>
<hr>
<div class="element" style="width: 270px">
<form action="insert" method="post">
<table>
	<tr>
		<th colspan="2">제품정보등록하기</th>
	</tr>
	<tr>
		<th>제품코드</th>
		<td><input type="text" name="prodCode" required="required"/></td>
	</tr>
	<tr>
		<th>제품명</th>
		<td><input type="text" name="prodName" /></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="number" name="price" /></td>
	</tr>
	<tr>
		<th>재고</th>
		<td><input type="number" name="quantity" /></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록하기">
			<input type="reset" value="초기화">
		</th>
	</tr>
	<tr>
	<td colspan="2" style="text-align: center;"> <a href="./menu">시작메뉴</a>
	</td>
</tr>
</table>
</form>
</div>
</body>
</html>