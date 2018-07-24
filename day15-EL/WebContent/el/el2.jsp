<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL (2) 파라미터 다루기</title>
</head>
<body>
<%--

	EL 은 기존 JSP 의 scriptlet(<% %>), expression(<%= %>) 이 했던일을 단순하게 표현가능
 --%>

<%
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String id = request.getParameter("id");
	
%>

이 페이지를 요청할 때는 다음의 주소를 복사하여 요청합니다. <br>
<a href="http://localhost:8081/day15-EL/el/el2.jsp">null<br></a>
<a href="http://localhost:8081/day15-EL/el/el2.jsp?name=홍길동">name<br></a>
<a href="http://localhost:8081/day15-EL/el/el2.jsp?name=홍길동&address=율도국">name, address<br></a>
<a href="http://localhost:8081/day15-EL/el/el2.jsp?name=홍길동&address=율도국&id=gildong">name, address, id<br></a>
<a href="http://localhost:8081/day15-EL/el/el2.jsp?name=&address=&id=">name=&address=&id=<br></a>
<h3> EL의 파라미터 추출</h3>
<pre>
1. name = ${param.name}
2. address = ${param.address }
3. id = ${ param.id }

</pre>

<h3> expession Tag의 파라미터 추출</h3>
<pre>

1. name = <%=name %>
2. address = <%=address %>
3. id = <%=id %>
</pre>

<hr />

<h3>EL 의 파라미터 존재 여부 검사</h3>
<pre>
EL의 empty 연산자 : 존재하는 여부를 검사하는 연산자, 없을 때 true
<%-- ${ } 사용 전에 \을 붙이면 사용하지않고 그대로 출력함 --%>


1. parameter name이 존재하는가? 
	\${not empty param.name } = ${not empty param.name } 
2. parameter address이 존재하는가? 
	\${not empty param.address } = ${not empty param.address } 
3. parameter id이 존재하는가? 
	\${not empty param.id } = ${not empty param.id } 
			
4. parameter name이 없는가? 
	\${not empty param.name } = ${ empty param.name } 
5. parameter address이 없는가? 
	\${not empty param.address } = ${ empty param.address } 
6. parameter id이 없는가? 
	\${not empty param.id } = ${ empty param.id } 
</pre>




</body>
</html>