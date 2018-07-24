<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 신규 등록</title>
</head>
<body>

<h3>제품 신규 등록</h3>
<hr>
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
</table>
</form>
</body>
</html>