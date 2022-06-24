function saveBoard(){
	let title = document.querySelector("#title").value;
	let content = document.querySelector("#content").value;
	
	let board = {
		title : title,
		content : content
	}
	// 글쓰기 
	fetch("/boardSave",{
		method: "post",
		headers: {
			'content-type' : 'application/json; charset=utf-8'
		},
		body: JSON.stringify(board)
	})
	.then(res => res.text())
	.then(res =>{
		if(res == "ok"){
			alert("글쓰기 성공");
			location.href= "/"
		}else{
			alert("글쓰기 실패!");
		}
	});
}

function deleteBoard(id){
	fetch("/deleteBoard/"+id,{
		method: "delete"
	})
	
	.then(res => res.text())
	.then(res => {
		console.log("res:" + res);
		if(res == "true"){
			alert("게시글을 삭제했습니다.");
			location.href="/";
		}else{
			alert("게시글 삭제를 실패했습니다.");
		}
	});
}
function updateBoard(id){
	let title = document.querySelector("#title").value;
	let content = document.querySelector("#content").value;
	let board = {
		title : title,
		content : content
	}
	console.log(title + " : title");
	console.log(content + " : content");
	fetch("/updateOk/" + id,{
		method: "put",
		headers: {
			'content-type' : 'application/json; charset=utf-8'
		},
		body: JSON.stringify(board)
	})
	.then(res => res.text())
	.then(res => {
		if(res == "ok"){
			alert("수정 성공");
			location.href = "/";
		}else{
			alert("수정 실패");
		}
	});
}

