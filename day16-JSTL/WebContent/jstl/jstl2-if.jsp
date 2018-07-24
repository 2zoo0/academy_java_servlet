<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL (2) Core Tag : if</title>
</head>
<body style="font-family: 'Malgun Gothic';">

<h4>&lt;c:if&gt;</h4>
<pre>
&lt;c:if&gt; : if 구문과 같이 논리 결과에 따라 선택을 분기시키는 기능
	test 속성값이 true / false 인지에 따라 분기
	test 속성값에 EL을 사용할 수 있다.
</pre>
<%-- 1. request 에 name 속성을 추가 --%>
<c:set var="name" value="길동" scope="request"/>

<h4>&lt;c:if&gt; 의 활용</h4>
<pre>
1. request 에 name 이라는 속성 값이 있는가?
   EL : ${not empty requestScope.name}
   
   <b>&lt;c:if&gt; 와 EL 을 조합</b>
   <c:if test="${not empty requestScope.name}">
   request 에 name 값이 있습니다.
   </c:if>
   <c:if test="${empty requestScope.name}">
   request 에 name 값이 없습니다.
   </c:if>

<% // <c:if> 와 동일한 일을 하는 스크립트릿 코드
	if (request.getAttribute("name") != null) {
%>
	request 에 값이 있습니다.
		
<%	} else { %>

	request 에 값이 없습니다.
		
<%	} %>
</pre>
<hr>
<pre>
2. name 이 '길동'입니까?
	EL : \${requestScope.name eq '길동'}
	
	<c:if test="${requestScope.name eq '길동'}">
	이름이 '길동'입니다.
	</c:if>
	<c:if test="${requestScope.name ne '길동'}">
	이름이 '길동'이 아닙니다.
	</c:if>
</pre>

<hr>
<ol>
	<li><a href="http://localhost:8081/day16-JSTL/jstl/jstl2-if.jsp?id=gildong">id=gildong</a></li>
	<li><a href="http://localhost:8081/day16-JSTL/jstl/jstl2-if.jsp?id=">id=</a></li>
	<li><a href="http://localhost:8081/day16-JSTL/jstl/jstl2-if.jsp?">없</a></li>
</ol>
<pre>
3. id 라는 값이 파라미터에 있습니까?
	EL : \${not empty param.id}
	<c:if test="true">
	<c:if test="${not empty param.id}">
	파라미터에 id 값이 존재합니다.
	</c:if>
	<c:if test="${empty param.id}">
	파라미터에 id 값이 존재하지 않습니다.
	</c:if>
	</c:if>
</pre>

<hr>
<ol>
	<li><a href="http://localhost:8081/day16-JSTL/jstl/jstl2-if.jsp?id=gildong&size=L&hobby=movie">id=gildong&size=L&hobby=movie</a></li>
	<li><a href="http://localhost:8081/day16-JSTL/jstl/jstl2-if.jsp?id=gildong&size=L&hobby=cook">id=gildong&size=L&hobby=cook</a></li>
	<li><a href="http://localhost:8081/day16-JSTL/jstl/jstl2-if.jsp?id=&size=S">id=&size=S</a></li>
	<li><a href="http://localhost:8081/day16-JSTL/jstl/jstl2-if.jsp?size=M">size=M</a></li>
</ol>

4. 안녕하세요.
    <c:if test="${not empty param.id}">당신은 ${param.id} 이군요.</c:if>
    <c:if test="${empty param.id}">아무개 씨.</c:if>
    선택한 사이즈는 
    <c:if test="${param.size eq 'L'}">라지입니다.</c:if>
    <c:if test="${param.size eq 'M'}">미디움입니다.</c:if>
    <c:if test="${param.size eq 'S'}">스몰입니다.</c:if>
    <c:if test="${empty param.size}">없습니다.</c:if>
  당신의 취미는
    <c:if test="${empty param.hobby}"> 입력되지 않았습니다.</c:if>
    <c:if test="${not empty param.hobby}">
    <c:if test="${param.hobby eq 'movie'}"> 영화보기 입니다.</c:if>
    <c:if test="${param.hobby ne 'movie'}"> 영화보기가 아닙니다.</c:if>
	</c:if>


</body>
</html>