$(function () {

    $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});

    var employee_grid_selector = "#employee-grid-table";
    var employee_pager_selector = "#employee-grid-pager";

    $(employee_grid_selector).bootstrapTable({
        method: 'get',
        url: 'task/queryTaskList.do',		 //请求后台的URL（*）
        dataType: "json",
        striped: true,     //使表格带有条纹
        pagination: true,    //在表格底部显示分页工具栏
        pageSize: 5,
        pageNumber: 1,
        pageList: [5, 10, 20, 50, 100],
        //idField: "ProductId",  //标识哪个字段为id主键
        showToggle: true,   //名片格式
        cardView: false,//设置为True时显示名片（card）布局
        showColumns: false, //显示隐藏列
        showRefresh: true,  //显示刷新按钮
        singleSelect: true,//复选框只能选择一条记录
        search: false,//是否显示右上角的搜索框
        clickToSelect: true,//点击行即可选中单选/复选框
        sidePagination: "server",//表格分页的位置
        queryParams: queryParams, //参数
        queryParamsType: "limit", //参数格式,发送标准的RESTFul类型的参数请求
        toolbar: "#toolbar", //设置工具栏的Id或者class
        columns: [{
            checkbox: true
        }, {
            field: 'project_name',
            title: '项目名称',
            align: 'center'
        }, {
            field: 'task_type',
            title: '任务类型',
            align: 'center',
            formatter: function (cellValue, options, rowObject) {
                var type = cellValue;
                if (type == 1) {
                    return "项目";
                }
                else if (type == 2) {
                    return "小需求";
                }
                else if (type == 3) {
                    return "联调";
                }
                else {
                    return "未定义";
                }
            }
        }, {
            field: 'summary',
            title: '功能名称',
            align: 'center'
        }, {
            field: 'online_time',
            title: '上线时间',
            align: 'center',
            formatter: function (value) {
                return new Date(value).format("yyyy-MM-dd");
            }
        },
            {
                field: 'testing_starttime',
                title: '测试起始时间',
                align: 'center',
                formatter: function (value) {
                    return new Date(value).format("yyyy-MM-dd");
                }
            },
            {
                field: 'testing_endtime',
                title: '测试结束时间',
                align: 'center',
                formatter: function (value) {
                    return new Date(value).format("yyyy-MM-dd");
                }
            },
            {
                field: 'productMgr',
                title: '产品经理',
                align: 'center'
            },
            {
                field: 'testers',
                title: '测试人',
                align: 'center'
            },
            {
                field: 'lastWeekSchedule',
                title: '上周进度',
                align: 'center'
            },
            {
                field: 'currentSchedule',
                title: '当前进度',
                align: 'center'
            }], //列
        silent: true,  //刷新事件必须设置
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        formatNoMatches: function () {  //没有匹配的结果
            return '无符合条件的记录';
        },
        onLoadError: function (data) {
            $('#reportTable').bootstrapTable('removeAll');
        }
    });


    function queryParams(params) {  //配置参数
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit,   //页面大小
            page: params.pageNumber,  //页码

            online_startTime: $("#online_startTime").val(),
            online_endTime: $("#online_endTime").val(),
            tester: $("tester").val()
        };
        return temp;
    }

    $("#addTask").on('click', function () {
        $('#taskModal').load("task/gotoTaskAdd.do").modal();
    })


});

