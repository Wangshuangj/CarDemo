window.onload=function () {
    editsQuery()
}
function editsQuery(event,id,numberplate){
    $("#myDetailModa").modal("show");
    //var numberplate = event.currentTarget.innerHTML;
    // var id = event.currentTarget.id;
    alert(id);

    if(numberplate == ""){
        alert("XXXXXXXX!");
        return
    }
    $.ajax({
        url:"/querydetail",
        type:"post",
        data:{"id":id},
        dataType:"json",
        success:function(car1){
            $("#detail1").html(car1.numberPlate);
            // document.getElementById("detail1").innerHTML=car1.numberPlate;
            $("#detail2").html(car1.carOwner);
            // document.getElementById("detail2").innerHTML=car1.carOwner;
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
            // document.getElementById("detail3").innerHTML=car1.carColor;
            $("#detail4").html(car1.engineNumber);
            // document.getElementById("detail4").innerHTML=car1.engineNumber;
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
            // document.getElementById("detail6").innerHTML=car1.frameNumber;

            $("#detail7").html(car1.carModel);
            // document.getElementById("detail7").innerHTML=car1.carModel;
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
            // document.getElementById("detail8").innerHTML=car1.carType;


            var time=car1.householdDate;
            var time=car1.firstRegistrationDate;
            var d = new Date(time);

            var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();


            $("#detail9").html(times);
            // document.getElementById("detail9").innerHTML=times;
            $("#detail10").html(times);
            // document.getElementById("detail10").innerHTML=times;
            $("#detail11").html("无");
            // document.getElementById("detail11").innerHTML="无";



        },
        error:function(){
            alert("请求失败!");
           // window.location.href="";
        }
    });
}