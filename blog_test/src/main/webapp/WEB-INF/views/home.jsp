<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <h1 class = "jumbotron text-center">Lim Woo Sung <br/> Blog</h1>
<%@ include file = "layout/header.jsp" %>

	<main class = "container">
	<c:forEach var = "board" items ="${board.content }">
		<div class = "card col-md12 m-2">
			<div class ="card-bady">
				<h4 class ="card-title">${board.title}</h4>
				<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>			
			</div>
		</div>
	</c:forEach>
	<br/>
	<div class = "pagination justify-content-center">
  	<ul class="pagination">
  		<c:choose>
  			<c:when test="${board.first}">
  			<li class="page-item disabled"><a class="page-link" href="/?page=${boards.pageable.pageNumber - 1}">이전</a></li>
  			</c:when>
  			
  			<c:otherwise>
  			<li class="page-item"><a class="page-link" href="/?page=${boards.pageable.pageNumber - 1}">Previous</a></li>
  			</c:otherwise>
  		</c:choose>
  		<c:choose>
  			<c:when test="${board.last}">
  			<li class="page-item disabled"><a class="page-link" href="/?page=${boards.pageable.pageNumber + 1}">다음</a></li>
  			</c:when>
  			
  			<c:otherwise>
  			<li class="page-item"><a class="page-link" href="/?page=${boards.pageable.pageNumber + 1}">Next</a></li>
  			</c:otherwise>
  		</c:choose>
   </ul>
   </div>
	</main>
 
<%@ include file = "layout/footer.jsp" %>
    
