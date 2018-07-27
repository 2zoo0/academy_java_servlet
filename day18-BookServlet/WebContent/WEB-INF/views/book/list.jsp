<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="book.vo.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 전체 목록</title>
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
<h3 align="center">도서 전체 목록</h3>
<hr>
<div class="element" style="text-align: center;">
<table>
<!-- tr>(th*4) -->
	<tr>
		<th>도서아이디</th>
		<th>도서제목</th>
		<th>저자명</th>
		<th>가격</th>
		<th>ISBN</th>
		<th>출판사</th>
		<th></th>
	</tr>
<c:if test="${not empty books}">
  <c:forEach items="${books}" var="book">
  	<tr>
  		<td>${book.bookId}</td>
  		<td>${book.author}</td>
  		<td>
  			<a href="${contextPath}/main/detail?bookId=${book.bookId}">
  				${book.title}
  			</a>
  		</td>
  		<td><fmt:formatNumber value="${book.price}" type="currency" currencySymbol="&#8361; "/></td>
  		<td>${book.isbn}</td>
  		<td>${book.publish}</td>
  		</td>
  		<td><a href="${contextPath}/main/delete?bookId=${book.bookId}">
  				삭제
  			</a></td>
  	</tr>
  </c:forEach>
</c:if>
<c:if test="${empty books}">
	<tr>
		<td colspan="5">등록된 제품정보가 존재하지 않습니다.</td>
	</tr>
</c:if>
<tr>
	<td colspan="7" style="text-align: right;"> 
		<a href="${contextPath}/main/insert">신규제품 추가</a>
		<a href="${contextPath}/main/menu">시작메뉴</a>
	</td>
</tr>
</table>

</div>
</body>
</html>
