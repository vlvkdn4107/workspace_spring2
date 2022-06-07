<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>TEST</header>
	<main>아무거나 해보기</main>
	<p>
		<%String a = "a";
			for(int i = 1; i <=10; i++){
				if(i<10){
		%>		
			<%= (a + "-") %>
		<%
		
			}else{
				a =(a+ "=");
			}
				
			}
		%>
		<%= a %>
		
	</p>
</body>
</html>