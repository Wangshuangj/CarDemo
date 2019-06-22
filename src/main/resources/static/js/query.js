// function query(){
//     //发送异步请求
//     $.ajax({
//         type:"post",
//         url:"/queryByPlate",
//         data:{numberplate:$("#numberplate").val()},
//         async:true, //默认-异步（true） 同步-false
//         dataType:"json",
//         success:function (carList) {
//             alert(carList);
//             //解析JSON数据result，并显示到Table上
//             for (var i = 0; i < carList.length; i++) {
//                 var tr;
//                 //注意这里[tr=]不要写成[tr+=]
//                 tr = "<td>"+"<input id=\"radiobox1\"  name=\"radiobox\" type=\"radio\" value=\"1\" >"+"</td>";
//                 tr += "<td>"+carList[i]['numberPlate']+"</td>";
//                 tr += "<td>"+carList[i]['carOwner']+"</td>";
//                 tr += "<td>"+carList[i]['carColor']+"</td>";
//                 tr += "<td>"+carList[i]['engineNumber']+"</td>";
//                 tr += "<td>"+carList[i]['label']+"</td>";
//                 tr += "<td>"+carList[i]['frameNumber']+"</td>";
//                 tr += "<td>"+carList[i]['carModel']+"</td>";
//                 tr += "<td>"+carList[i]['householdDate']+"</td>";
//                 tr += "<td>"+carList[i]['carType']+"</td>";
//                 tr += "<td>"+carList[i]['firstRegistrationDate']+"</td>";
//
//
//                 //将语句拼接到<table>中显示
//                 $(".table").append("<tr>"+tr+"</tr>");
//             }
//
//         },
//         error:function (e) {
//             alert("错误！"+e.status);
//         },
//         complete:function () {
//         }
//     });
//
//     return false;
// }
