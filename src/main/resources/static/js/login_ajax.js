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
		dataType:"json",
		success:function(result){
			//result是服务端返回的数据
			if(result.status==1){
				alert("登录成功");
				window.location.href="/index";

			}else if(result.status==0){
				alert(result.message);
			}
			alert(getCookie("loginName"));
		},
		error:function(){
			alert("请求失败!");
			window.location.href="/";
		}
	});

	return false;
}
