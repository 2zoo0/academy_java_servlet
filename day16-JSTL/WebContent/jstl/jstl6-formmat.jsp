<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL (6) Core Tag : </title>
</head>
<body>
<!-- 사용할 값들 설정   슬라이딩태클,수비조직,대인방어,스탠딩태클,숏패스,스태미너,  
주력,헤딩,개인기,크로스,위치선정,롱패스,파워
-->
<c:set var="number" value="123456.78" scope="page"/>
<c:set var="currency" value="2300000" scope="page"/>
<c:set var="pattern" value="123456.789" scope="page"/>

<h4>1. 숫자 형식 출력</h4>
<pre>
number 형식 출력 : 자동으로 3자리 끊어 읽기 적용
<fmt:formatNumber value="${number}" type="number"/>
<fmt:formatNumber value="987654.321" type="number"/>

currency 형식 출력 : 
<fmt:formatNumber value="${currency}" type="currency" currencySymbol="&#8361; "/>
<fmt:formatNumber value="1987654.321" type="currency" currencySymbol="&#8364;"/>

pattern 형식 출력 : 
<fmt:formatNumber value="${pattern}" type="pattern" pattern=".00"/>
<fmt:formatNumber value="1987634254.321" type="pattern" pattern="000,000.00"/>

</pre>
<hr>
<!-- 오늘의 날짜 생성 -->
<c:set var="today" value="<%=new Date() %>" scope="page"/>
<h4>2. 날짜 형식 출력</h4>
<pre>
(1)시간만 출력
<fmt:formatDate value="${today}" type="time" />
(2)날짜만 출력
<fmt:formatDate value="${today}" type="date"/>
(3)시간 날짜 모두 출력
<fmt:formatDate value="${today}" type="both"/>
</pre>

</body>
</html>