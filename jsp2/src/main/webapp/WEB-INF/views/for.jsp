<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>For Example</h1>
	</header>
	<main>
		1에서 10까지 합은?
		<!-- JSP 태그를 활용해서  -->
		<p>
		<% int i, sum = 0;
		   for(i = 1; i <= 10; i++){
			   if(i<10){
		%>
			<%=(i + " + ")%>
		<%
			}else{
			  out.println(i + "=");
			}
			sum += i;
		}
		%>
		<%=sum %>
		</p>
	</main>
</body>
</html>