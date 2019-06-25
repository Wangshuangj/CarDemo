// $(function () {
//         var t = $("#table_server").bootstrapTable({
//             url: 'http://localhost:8080/getPage',
//             method: 'post',
//             contentType: "application/x-www-form-urlencoded",
//             dataType: "json",
//             striped: true,//设置为 true 会有隔行变色效果
//             undefinedText: "空",//当数据为 undefined 时显示的字符
//             pagination: true, //分页
//             // paginationLoop:true,//设置为 true 启用分页条无限循环的功能。
//             // showToggle: "true",//是否显示 切换试图（table/card）按钮
//             // showColumns: "true",//是否显示 内容列下拉框
//             pageNumber: 1,//如果设置了分页，首页页码
//             // showPaginationSwitch:true,//是否显示 数据条数选择框
//             pageSize: 5,//如果设置了分页，页面数据条数
//             pageList: [5, 10, 20, 40],	//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
//             paginationPreText: '‹',//指定分页条中上一页按钮的图标或文字,这里是<
//             paginationNextText: '›',//指定分页条中下一页按钮的图标或文字,这里是>
//             // singleSelect: false,//设置True 将禁止多选
//             search: false, //显示搜索框
//             data_local: "zh-US",//表格汉化
//             sidePagination: "server", //服务端处理分页
//             queryParamsType: "undefined",  //设置为"undefined",可以获取pageNumber，pageSize，searchText，sortName，sortOrder
//             queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
//                 return {//这里的params是table提供的
//                     pageSize: params.pageSize,//从数据库第几条记录开始
//                     pageNumber: params.pageNumber//找多少条
//                 };
//             },
//             idField: "numberPlate",//指定主键列
//             columns: [
//                 {
//                     title: '',//表的列名
//                     field: '',//json数据中rows数组中的属性名
//                     align: 'center'//水平居中
//                 },
//                 {
//                     title: '车牌号',//表的列名
//                     field: 'numberPlate',//json数据中rows数组中的属性名
//                     align: 'center'//水平居中
//                 },
//                 {
//                     title: '车辆所有人',
//                     field: 'carOwner',
//                     align: 'center'
//                 },
//                 {
//                     title: '车牌颜色',
//                     field: 'carColor',
//                     align: 'center'
//                 },
//                 {
//                     title: '发动机号',
//                     field: 'engineNumber',
//                     // align: 'center'
//                 },
//                 {
//                     title: '车辆厂牌',
//                     field: 'label',
//                     // align: 'center'
//                 },
//                 {
//                     title: '车辆机架号',
//                     field: 'frameNumber',
//                     align: 'center'
//                 },
//                 {
//                     title: '车辆型号',
//                     field: 'carModel',
//                     align: 'center'
//                 },
//                 {
//                     title: '注册日期',
//                     field: 'householdDate',
//                     align: 'center'
//                 },
//                 {
//                     title: '车辆类型',
//                     field: 'numberPlate',
//                     align: 'center'
//                 },
//                 {
//                     title: '初次登记日期',
//                     field: 'carType',
//                     align: 'center'
//                 }
//             ]
//         });
//
//
//         // t.on('load-success.bs.table', function (data) {//table加载成功后的监听函数
//         //     console.log("load success");
//         //     $(".pull-right").css("display", "block");
//         // });
//
//     });
//
$(function () {
        var t = $("#table_server").bootstrapTable({
        method: 'get',
        // 若以post方式提交，需要补充contentType信息，否则分页参数无法传递到controller
        //contentType: "application/x-www-form-urlencoded",
        // 查询传入起始页码数，后台需要计算起始查询条数
        url : 'http://localhost:8080/getPage',
        formatNoMatches : function() {
            return '无符合条件的记录';
        },
        formatLoadingMessage : function() {
            return "请稍等，正在加载中...";
        },
        cache : false,
        striped: true, //是否显示行间隔色
        dataField: "rows",//controller返回json数据对应key
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination:true,//是否分页
        pageNumber : 1,
        pageSize : 10,
        pageList : [ 10, 25, 50 ],
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        queryParamsType:'', // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber

        // 直接把pageSize,pageNumber，调用queryParamsByBegin函数
        queryParames:queryParamsByBegin,
        idField: "numberPlate",//指定主键列
        columns : [
            {
            title: '',//表的列名
            field: '',//json数据中rows数组中的属性名
            formatter : function operateFormatter(value, row, index) {
                var radiobox = '<input id="radiobox1" name="radiobox" type="radio" onclick="hitbutton(event,\'' + row.id  + '\')">'
                return radiobox;
            }
        },
            {
            align : "center",
            halign : "center",
            valign : "middle",
            field : 'numberPlate',
            title : '车牌号',
             // events: 'operateEvents',
             formatter : function operateFormatter(value, row, index) {
                 var x = '<a  onclick="editsQuery(event,\'' + row.id  + '\',\'' + row.numberPlate  + '\')">' + row.numberPlate  + '</a>';
                 return x;
             }

        }, {
            align : "center",
            halign : "center",
            valign : "middle",
            title: '车辆所有人',
            field: 'carOwner',
        }, {
            align : "center",
            halign : "center",
            valign : "middle",
            title: '车牌颜色',
            field: 'carColor',
                formatter:function(value, row, index){
                    if(0==value){
                        return '黄色';
                    }else if (1==value){
                        return '黑色'
                    }else if (2==value){
                        return '绿色'
                    }
                    return '红色';
                }
        },{
            align : "center",
            halign : "center",
            valign : "middle",
            title: '发动机号',
            field: 'engineNumber',
        }, {
            align : "center",
            halign : "center",
            valign : "middle",
            title: '车辆厂牌',
            field: 'label',
                formatter:function(value, row, index){
                    if(0==value){
                        return '现代';
                    }else if (1==value){
                        return '大众'
                    }else if (2==value){
                        return '宝马'
                    }
                    return '奔驰';
                }
        }, {
            align : "center",
            halign : "center",
            valign : "middle",
            title: '车辆机架号',
            field: 'frameNumber',
        }, {
                align : "center",
                halign : "center",
                valign : "middle",
                title: '车辆型号',
                field: 'carModel',
            },{
                align : "center",
                halign : "center",
                valign : "middle",
                title: '注册日期',
                field: 'householdDate',
                formatter:function(value, row, index) {
                    var d = new Date(value);
                    var times = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
                    return times;
                }
            },{
                align : "center",
                halign : "center",
                valign : "middle",
                title: '车辆类型',
                field: 'carType',
                formatter:function(value, row, index){
                    if(0==value){
                        return '轿车';
                    }else if (1==value){
                        return '货车'
                    }else if (2==value){
                        return '客车'
                    }
                    return '摩托';
                }
            },{
                align : "center",
                halign : "center",
                valign : "middle",
                title: '初次登记日期',
                field: 'firstRegistrationDate',
                formatter:function(value, row, index) {
                    var d = new Date(value);
                    var times = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
                    return times;
                }
            }
        ],

    });
    function queryParamsByBegin(params){
        return{
            pageSize: params.pageSize,
            pageNumber: params.pageNumber
        }
    }

    // 补充操作栏按钮信息（value：当前字段值，row：当前行信息，index：序列索引）

    $("#query").click(function() {
        var numberplate = $("#numberplate").val();
        alert(numberplate);
        $.ajax({
            type: "post",
            url:"/queryCar",
            data:{
                "numberplate": numberplate
            },
            dataType:"json",
            success : function(carList) {
                $("#table_server").bootstrapTable('load', carList);//主要是要这种写法
            }
        });

    });



});
