<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 전용태그 연습</h1>
	<% String name ="HELLO SPRING"; %>
	<!-- 주석 부분입니다. 소스보기에서 보입니다. -->
	<%-- 이 부분은 JSP페이지에서만 보이고 소스보기 문서에서는 보이지 않아요 브라우저에 보내지 않는 문장 --%>
	<%=name /*표현식 안에서 사용하는 주석 입니다.*/ %> BOOT
</body>
</html>