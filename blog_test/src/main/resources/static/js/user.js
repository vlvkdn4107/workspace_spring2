let index = {
	init: function(){
		$("#btn-save").bind("click", () =>{
			alert("btn-save 버튼이 눌러 졌습니다.");
			this.save();
		});
		$("#btn-login").bind("click",() =>{
			alert("login 버튼이 눌러 졌습니다.");
			this.login
		})
	},
	save: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		$.ajax({
			type: "POST",
			url: "/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			alert("회원가입 성공!")
			location.href = "/";
		}).fail(function(xhr){
			alert("회원가입 실패!");
		});
	},
	login: function(){
		let data = {
			username: $("username").val(),
			password: $("password").val()
		}
		$.ajax({
			type: "POST",
			url: "api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			alert("로그인 성공!")
			location.href = "/"
			console.log(data);
		}).fail(function(error){
			alert("로그인 실패!")
			console.log(error);
		});
  }
}
index.init(); // 메서드 실행 시켜라!!!!