var submit_type = 0;//0代表新增，1代表编辑
var hit = "";//全局id的赋值

window.onload = function () {
	$( "#Date" ).datepicker();
	$( "#Date1").datepicker();

}

// function query(mark){//用于页面加载时所有数据的查询和详情页面的查询
//
// 	var numberplate = "";
// 	if(mark == 1){
// 		numberplate = $("#numberplate").val();
// 	}
// 	$.ajax({
// 		type:"post",
// 		url:"/queryCar",
// 		async:true, //默认-异步（true） 同步-false
// 		data:{
// 			"numberplate": numberplate
// 		},
// 		dataType:"json",
// 		success:function (carList) {
// 			$(".sa").remove();
// 			//alert(carList);
// 			//解析JSON数据result，并显示到Table上
// 			for (var i = 0; i < carList.length; i++) {
// 				var tr;
// 				//注意这里[tr=]不要写成[tr+=]
// 				tr = "<td class='sa'>"+"<input id=\"radiobox1\" name=\"radiobox\" type=\"radio\" value=\"1\" onclick='hitbutton(event)' car_id='"+carList[i]['id']+"'>"+"</td>";
// 				tr += "<td class='sa'>"+"<a numberplate='"+carList[i]['numberPlate']+"' id='"+carList[i]['id']+"' onclick='editsQuery(event)'>"+carList[i]['numberPlate']+"</a>"+"</td>";
// 				tr += "<td class='sa'>"+carList[i]['carOwner']+"</td>";
// 				tr += "<td class='sa'>"+sas(carList[i]['carColor'])+"</td>";
// 				tr += "<td class='sa'>"+carList[i]['engineNumber']+"</td>";
// 				tr += "<td class='sa'>"+lab(carList[i]['label'])+"</td>";
// 				tr += "<td class='sa'>"+carList[i]['frameNumber']+"</td>";
// 				tr += "<td class='sa'>"+carList[i]['carModel']+"</td>";
// 				tr += "<td class='sa' id='time'>"+t(carList[i]['householdDate'])+"</td>";
// 				tr += "<td class='sa'>"+model(carList[i]['carType'])+"</td>";
// 				tr += "<td class='sa' id='time'>"+t(carList[i]['firstRegistrationDate'])+"</td>";
//
//
// 				//将语句拼接到<table>中显示
// 				$(".table").append("<tr>"+tr+"</tr>");
// 			}
//
// 		},
// 		error:function (e) {
// 			alert("错误！"+e.status);
// 		},
// 		complete:function () {
// 		}
// 	});
// }
function t(time) {
	var d = new Date(time);
	var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
	return times;
}
function sas(num) {
	switch(num){
		case 0:
			return "黄色";
		case 1:
			return "黑色";
		case 2:
			return "绿色";
		case 3:
			return "红色";
	}
}
function lab(num) {
	switch(num){
		case 0:
			return "现代";
		case 1:
			return "大众";
		case 2:
			return "宝马";
		case 3:
			return "奔驰";
	}
}
function model(num) {
	switch(num){
		case 0:
			return "轿车";
		case 1:
			return "货车";
		case 2:
			return "客车";
		case 3:
			return "摩托";
	}
}
function hitbutton(event,id) {//单选按钮的绑定，取出id值付给全局变量hit
	// alert(id)
	hit = id;
}
function carEdits() {//详情页面的数据查询，根据id查询
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
						// if(type=='radio'){
						// 	$(this).attr('checked',$(this).val()==value);
						// }else if(type=='checkbox'){
						// 	arr = value.split(',');
						// 	for(var i =0;i<arr.length;i++){
						// 		if($(this).val()==arr[i]){
						// 			$(this).attr('checked',true);
						// 			break;
						// 		}
						// 	}
						// }else{
							$(this).val(value);
						// }
					}else if(tagName=='SELECT' || tagName=='TEXTAREA'){
						$(this).val(value);
					}

				});
			}
			alert("成功");
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
				success: function () {
					alert("注册成功");
					// if (success == 1) {
					//     alert("注册成功");
					window.location.href="/index";
					// }

				},
				error : function() {
					alert("车牌号已存在！");
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
			dataType:"json",

			success: function () {
				alert("修改成功")
			},
			err: function () {
				alert("修改失败")
			}
		});

	}

}

function buttonClick(mark){
	if(mark == 0){
		$("#myModalLabel_add_edit").html("注册");
	}else if(mark==1){
		$("#myModalLabel_add_edit").html("编辑");
		carEdits();//编辑时的数据查询回显
	}
	submit_type = mark;
}

