<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layout/header.jsp"%>

	<div class = "container">
		<form>
			<div class = "form-group">
				<laber for = "title">제목 : </laber>
				<input type = "text" placeholder = "title" id = "title" class = "form-control">
			</div>
			<br/>
			<div class ="form- group">
				<laber for = "content">내용 : </laber>
				<textarea class ="form-control summernote" rows="10" id ="content"></textarea>
			</div>
			<br/>
			<button type = "button" onclick = "saveBoard()" class = "btn btn-primary">글쓰기</button>
		</form>
	</div>
	
<script src="/js/board.js"></script>
<%@ include file = "../layout/footer.jsp"%>