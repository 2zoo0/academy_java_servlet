<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shop.vo.Product" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 조회</title>
<style type="text/css">
	table, tr, th, td {
		border: 1px solid black;
	}
	table {
		align-content: center;
	}
	
	.element {
    display: block;
    margin-left: auto;
    margin-right: auto;
  }
</style>
</head>
<body>

<h3 align="center">제품 상세 조회</h3>
<hr align="center">
<div class="element" style="width: 300px; text-align: center;" >
<table style="text-align: left">
	<tr>
		<th>제품 코드</th>
		<td>
			<input name="prodCode" type="text" 
			       readonly="readonly"
			       value="${product.prodCode}"/>
		</td>
	</tr>
	<tr>
		<th>제품 이름</th>
		<td>
			<input name="prodName" type="text" 
			       readonly="readonly"
			       value="${product.prodName}"/>
		</td>
	</tr>
	<tr>
		<th>가격</th>
		<td>
			<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="&#8361; "/>
		</td>
	</tr>
	<tr>
		<th>재고</th>
		<td>
			<input name="quantity" type="number" 
			       readonly="readonly"
			       value="${product.quantity}"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;">
			<a href="list">목록보기</a>
			<a href="update?prodCode=${product.prodCode}">수정</a>
			<a href="delete?prodCode=${product.prodCode}">삭제</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>
