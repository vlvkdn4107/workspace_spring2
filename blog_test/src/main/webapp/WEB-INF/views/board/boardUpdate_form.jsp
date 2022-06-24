<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class = "container">
	<form>
		<div class ="form-gruoup">
			<label for = "title">Title : </label>
			<input type ="text" value="${board.title}" placeholder="title" id ="title" class = "form-control">
		</div>
		<br/>
		<div class = "form-group">
			<label for = "content">Content : </label>
			<textarea class = "form-control summernote" rows="5" id = "content" >${board.content}</textarea>
		</div>
		<br/>
		<button type="button" onclick ="updateBoard(${board.id})" class = "btn btn-primary">글 수정하기</button>
		
	</form>
</div>
 <script src = "/js/board.js"></script>
  
<%@ include file="../layout/footer.jsp"%>