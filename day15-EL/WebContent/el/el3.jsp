<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL (3) 다중 파라미터의 처리</title>
</head>
<body>
이 페이지를 요청할 때는 다음의 주소를 복사하여 요청합니다. <br>
<a href="http://localhost:8081/day15-EL/el/el3.jsp">null<br></a>
<a href="http://localhost:8081/day15-EL/el/el3.jsp?hobby=야구">야구<br></a>
<a href="http://localhost:8081/day15-EL/el/el3.jsp?hobby=야구&hobby=축구">야구축구<br></a>
<a href="http://localhost:8081/day15-EL/el/el3.jsp?hobby=야구&hobby=축구&hobby=서핑">야구 축구 서핑<br></a>
<a href="http://localhost:8081/day15-EL/el/el3.jsp?hobby=">hobby=<br></a>

<h3>EL의 다중 파라미터 처리 : paramValue</h3>
<pre>
paramValue 로 파라미터를 추출하면 배열로 받아짐
따라서 배열 인덱스를 나타내는 [숫자]로 접근 가능

1. hobby 의 [0]번째 값 : \${paramValues.hobby[0] } = ${paramValues.hobby[0] }
2. hobby 의 [1]번째 값 : \${paramValues.hobby[1] } = ${paramValues.hobby[1] }
3. hobby 의 [2]번째 값 : \${paramValues.hobby[2] } = ${paramValues.["hobby"][2]}

</pre>

<h3>scriptlet, expession Tag 를 사용한 파라미터 처리 : getParameterValues()</h3>
<%
	String[] hobbies = request.getParameterValues("hobby");
	
	if (hobbies != null) {
		for (String hobby : hobbies) {
			int idx = 0;
%>
			1. hobby의[<%= idx%>]번째 값 <%= hobby%> <br>

			<% idx++; } 
		} else { %>
			파라미터 hobby에 값이 없습니다.

	 <% } %>
</body>
</html>