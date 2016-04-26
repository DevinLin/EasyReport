$(function () {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        url: "user/queryUserList.do",
        datatype: "json",
        postData: {
            userCode: $("#query_userCode").val(),
            userName: $("#query_userName").val()
        },
        height: 350,
        colNames: ['id', '角色编号', '角色名称', '备注'],
        colModel: [
            {name: 'id', index: 'id', width: 50, hidden: true},

            {name: 'userCode', index: 'userCode', width: 250},
            {name: 'userName', index: 'userName', width: 300},
            {name: 'description', index: 'description', width: 520}
        ],
        viewrecords: true,
        rownumbers: true,//添加左侧行号
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: pager_selector,
        jsonReader: {
            page: "page",
            total: "pages",
            pageSize: "pageSize",
            records: "total",
            rows: "rows"
        },
        altRows: true,
        multiselect: true,
        multiboxonly: true,
        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);
                updatePagerIcons(table);
                // setColor() ;
            }, 0);
        },
        sortable: true,
        sortname: 'endTime',
        sortorder: 'desc',
        // shrinkToFit: false,
        autoScroll: true

    });
    setToolsBarIcon(grid_selector, pager_selector);


    /** 查询按钮**/
    $("#queryUserBtn").on('click', function () {
        jQuery(grid_selector).jqGrid('setGridParam', {
            postData: {
                userCode: $("#query_userCode").val(),
                userName: $("#query_userName").val()
            },
            page: 1
        }).trigger("reloadGrid"); //重新载入 
    });


    /** 新增按钮**/
    $("#addUserBtn").on('click', function () {
        $('#userModal').load("user/gotoUserEdit.do").modal();
    });

    /** 更新按钮**/
    $("#updateUserBtn").on('click', function () {
        var id = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
        if (id == '') {
            bootbox.alert("请选择行");
        } else {
            $('#userModal').load("user/gotoUserEdit.do?id=" + id).modal();
        }
    });

    /** 删除按钮**/
    $("#deleteUserBtn").on('click', function () {
        var id = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
        if (id == '') {
            bootbox.alert("请选择行");
        } else {
            bootbox.confirm("确定要删除吗?", function (result) {
                if (result) {

                    jQuery.ajax({
                        type: "post",
                        url: "user/deleteUser.do",
                        data: "id=" + id,
                        success: function (data) {
                            if (data.resultCode == 1) {
                                bootbox.alert(data.resultMsg);// 关闭当前对话框
                                $('#userModal').modal("hide");
                                jQuery(grid_selector).jqGrid('setGridParam', {
                                    postData: {
                                        userCode: $("#query_userCode").val(),
                                        userName: $("#query_userName").val()
                                    },
                                    page: 1
                                }).trigger("reloadGrid"); //重新载入
                            } else {
                                bootbox.alert(data.resultMsg);// 关闭当前对话框
                            }
                            $("#user_sumbit").removeAttr("disabled");
                        }
                    });
                }
            });
        }

    });
    /** 角色分配资源**/
    $("#userRoleListBtn").on('click', function () {
        var id = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
        if (id == '') {
            bootbox.alert("请选择行");
        } else {
            $('#userModal').load("user/gotoUserRoleList.do?userId=" + id).modal();
        }

    });

});

