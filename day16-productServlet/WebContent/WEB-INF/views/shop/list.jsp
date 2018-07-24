<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "shop.vo.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 전체 목록</title>
<style type="text/css">
	table, tr, td, th {
		border: 1px solid black;
	}
</style>
</head>
<body>
<table>
<tr>
	<th>제품코드</th>
	<th>제품이름</th>
	<th>가 격</th>
	<th>재 고</th>
</tr>
<c:if test="${not empty products}">
	<c:forEach items="${products}" var="product">
	<tr>
		<td>${product.prodCode}</td>
		<td>
		<a href="detail?prodCode=${product.prodCode}">${product.prodName}</a>
		</td>
		<td>${product.price}</td>
		<td>${product.quantity}</td>
	</tr>
	
	</c:forEach>
</c:if>
<c:if test="${empty products}">
	<tr>
		<td colspan="4"> 등록된 제품 정보가 존재하지 않습니다.</td>
	</tr>
</c:if>


</table>
</body>
</html>