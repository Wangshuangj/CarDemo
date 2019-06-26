var submit_type = 0;//0代表新增，1代表编辑
var hit = "";//全局id的赋值

window.onload = function () {
	$( "#Date" ).datepicker({dateFormat:"yy-mm-dd"});
	$( "#Date1").datepicker({dateFormat:"yy-mm-dd"});

}

function hitbutton(event,id) {//单选按钮的绑定，取出id值付给全局变量hit
	hit = id;
}
function carEdits() {//编辑时数据回显
	var  id = hit;
	$.ajax({
		url: "/querydetail",
		type: "post",
		data: {"id": id},
		dataType: "json",
		success: function (car1) {
			var obj = car1;
			var key,value,tagName,type,arr;
			for(x in obj){
				key = x;
				value = obj[x];
				if (x=="householdDate"||x=="firstRegistrationDate"){//做日期格式数据的判断并转化
					 var time=obj[x];
					 var d = new Date(time);
					 var value=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
				}


				$("[name='"+key+"'],[name='"+key+"[]']").each(function(){
					tagName = $(this)[0].tagName;
					type = $(this).attr('type');
					if(tagName=='INPUT'){
							$(this).val(value);
					}else if(tagName=='SELECT' || tagName=='TEXTAREA'){
						$(this).val(value);
					}

				});
			}
		},
		err: function () {
			alert("请求失败")
		}

	});
}


function regist() {

	var  NumberPlate = $("#carNumberPlate").val();
	var checkPwd = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
	if (checkPwd.test(NumberPlate)){//验证通过才进行注册
		if(submit_type == 0){//注册
			$.ajax({
				type: "POST",//方法类型
				url: "/car/regist" ,
				data: $('#myForm').serialize(),//提交序列化表单
				dataType:"text",
				success: function (data) {
					if (data=="success"){
						alert("注册成功");
						window.location.href="/index";
					}

				},
				error : function() {
					alert("注册失败！");
				}
			});
		}
	} else {//验证失败
		alert("车牌输入格式不正确，示例：川A1234A")
	}

	if(submit_type == 1){//编辑

		var id = hit;
		var data = $.param({"id":id}) + "&" + $('#myForm').serialize() + "";
		$.ajax({
			url: "/update",
			type: "post",
			data: data,
			dataType:"text",
			success: function (data) {
				if (data=="success"){
					alert("修改成功");
					window.location.href="/index";
				}
			},
			err: function () {
				alert("修改失败");
			}
		});

	}

}

function buttonClick(mark){


	if(mark == 0){
		$("#myModalLabel_add_edit").html("注册");
		$(":input","#myForm").not(":button",":reset","hidden","submit","select").val("");
	}else if(mark==1){
		$("#myModalLabel_add_edit").html("编辑");
		var  id = hit;
		if (""==id) {
			alert("请选择一条信息。。。")
		}else {
			carEdits(id);//编辑时的数据查询回显
			$("#myModal").modal("show");
		}


	}
	submit_type = mark;
}

