//@ sourceURL=login_ajax.js
function dologin(){
	//获取页面数据
	var username=$("#username").val().trim();
	var password=$("#password").val();
	if(username==""){
		$("form table tr:eq(0) td span").html("用户名不能为空");
		return false;
	}
	if(password==""){
		$("form table tr:eq(1) td span").html("密码不能为空");
		return false;
	}
	//发送异步请求
	$.ajax({
		url:"/login",
		type:"get",
		data:{"username":username,"password":password},
		dataType:"text",
		success:function(data){
			//result是服务端返回的数据
			if(data=="success"){
				alert("登录成功");
				//location.href="/index2.html";
				window.location.href="/index";

			}else {
				alert("登录失败");
			}
		},
		error:function(){
			alert("请求失败!");
			window.location.href="/";
		}
	});

	return false;
}
