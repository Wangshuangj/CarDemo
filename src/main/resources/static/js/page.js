$(function () {
        var t = $("#table_server").bootstrapTable({
            // 若以post方式提交，需要补充contentType信息，否则分页参数无法传递到controller
            //contentType: "application/x-www-form-urlencoded",
            // 查询传入起始页码数，后台需要计算起始查询条数
        method: 'get',
        url : 'http://localhost:8080/car/getPage',
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
