window.onload=function () {
    editsQuery()
}
function editsQuery(event,id,numberplate){
    $("#myDetailModa").modal("show");//查看详情时显示模态框
    if(numberplate == ""){
        alert("XXXXXXXX!");
        return
    }
    $.ajax({
        url:"/querydetail",
        type:"post",
        data:{"id":id},
        dataType:"json",
        success:function(car1){//详情数据的回显
            $("#detail1").html(car1.numberPlate);
            $("#detail2").html(car1.carOwner);
            if (car1.carColor==0){
                car1.carColor = "黄色"
            }else if (car1.carColor==1){
                car1.carColor = "黑色"
            }else if (car1.carColor==2){
                car1.carColor = "绿色"
            }else if (car1.carColor==3){
                car1.carColor = "红色"
            }
            $("#detail3").html(car1.carColor);
            $("#detail4").html(car1.engineNumber);
            if (car1.label==0){
                car1.label = "现代"
            }else if (car1.label==1){
                car1.label = "大众"
            }else if (car1.label==2){
                car1.label = "宝马"
            }else if (car1.label==3){
                car1.label = "奔驰"
            }

            $("#detail5").html(car1.label);
            $("#detail6").html(car1.frameNumber);
            $("#detail7").html(car1.carModel);

            if (car1.carType==0){
                car1.carType = "轿车"
            }else if (car1.carType==1){
                car1.carType = "货车"
            }else if (car1.carType==2){
                car1.carType = "客车"
            }else if (car1.carType==3){
                car1.carType = "摩托"
            }
            $("#detail8").html(car1.carType);

            var time1=car1.householdDate.split("T")[0];
            var time2=car1.firstRegistrationDate.split("T")[0];
            // time1 = time.split("T")[0];
            // var d = new Date(time);
            // var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
            $("#detail9").html(time1);
            $("#detail10").html(time2);
            $("#detail11").html("无");
        },
        error:function(){
            alert("请求失败!");
        }
    });
}