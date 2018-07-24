<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL (3) Core Tag : forEach</title>
</head>
<body>

<h4>&lt;c:forEach&gt;</h4>
<pre>
&lt;c:forEach&gt; : for 구문처럼 전해진 횟수 반복
		자료구조의 데이터를 자동 순회하며 반복

</pre>
<hr>
<h4>1. 정해진 횟수 반복</h4>
<c:forEach begin="1" end="10" step="3">
	안녕하세요. JSTL, forEach...<br>
</c:forEach>

<hr>
<h4>2. index, status 를 사용</h4>
<c:forEach begin="1" end="10" step="2" var="idx" varStatus="status">
	안녕하세요. JSTL, forEach... 반복 횟수 ${status.count }, index : ${idx}<br>
</c:forEach>

<hr>
<h4>3. 값을 누적 계산</h4>
<%-- <c:set>으로 변수 선언 --%>
<c:set var="sum" value="0" scope="page"/>
<c:forEach begin="1" end="10" step="1" varStatus="status">
	${sum} + ${status.index} = ${sum + status.index}<br>
	<c:set var="sum" value="${sum + status.index}"/>
</c:forEach>
sum 변수의 최종 값 : ${sum}

<hr>
<h4>4. varStatus의 다른 속성들</h4>
<c:forEach begin="1" end="10" step="1" varStatus="status" var="result">
	값 : ${result}, 현재아이템:${status.current}<br/>
	<c:if test="${status.first}">
	첫번째 반복입니다.<br/>
	</c:if>
	<c:if test="${status.last}">
	마지막 반복입니다.<br/>
	</c:if>
	
</c:forEach>
	반복의 시작값은 \${status.begin} : ${status.begin}입니다.<br/>
	반복의 종료값은 \${status.end} : ${status.end}입니다.<br/>
	반복의 증가값은 \ ${status.step} : ${status.step}입니다.<br/>
</body>
</html>