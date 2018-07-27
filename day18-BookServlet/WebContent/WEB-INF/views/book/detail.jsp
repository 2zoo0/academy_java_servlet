<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="book.vo.Book" %>    
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

<h3 align="center">도서 상세 조회</h3>
<hr align="center">
<div class="element" style="width: 300px; text-align: center;" >
<table style="text-align: left">
	<tr>
		<th>도서 아이디</th>
		<td>
			<input name=bookId type="text" readonly="readonly"
					value="${book.bookId}" />
				</td>
	</tr>
	<tr>
		<th>도서명</th>
		<td>
			<input name="title" type="text" 
			       readonly="readonly"
			       value="${book.title}"/>
		</td>
	</tr>
	<tr>
		<th>저자명</th>
		<td>
			<input name="author" type="text" 
			       readonly="readonly"
			       value="${book.author}"/>
		</td>
	</tr>
	<tr>
		<th>가격</th>
		<td>
			<fmt:formatNumber value="${book.price}" type="currency" currencySymbol="&#8361; "/>
		</td>
	</tr>
	<tr>
		<th>ISBN</th>
		<td>
			<input name="isbn" type="text" 
			       readonly="readonly"
			       value="${book.isbn}"/>
		</td>
	</tr>
	<tr>
		<th>출판사</th>
		<td>
			<input name="publish" type="text" 
			       readonly="readonly"
			       value="${book.publish}"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;">
			<a href="${contextPath}/main/list">목록보기</a>
			<a href="${contextPath}/main/update?bookId=${book.bookId}">수정</a>
			<a href="${contextPath}/main/delete?bookId=${book.bookId}">삭제</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>
