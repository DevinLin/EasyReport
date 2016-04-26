$(function () {
    var user_grid_selector = "#user-grid-table";
    var user_pager_selector = "#user-grid-pager";

    jQuery(user_grid_selector).jqGrid({
        url: "dept/queryUserDeptList.do",
        datatype: "json",
        postData: {
        	deptCode:$("#deptCode").val()
        },
        height: 350,
        colNames: ['id', 'ERP', '姓名', '邮箱', '负责人','操作'],
        colModel: [
            {name: 'id', index: 'id', hidden: true},
          
            {name: 'userNo', index: 'userNo', width: 120},
            {name: 'userName', index: 'userName', width: 100},
            {name: 'email', index: 'email', width: 120},
            {name: 'admin', index: 'admin', width: 80,
            	formatter:function(cellvalue, options, rowObject){
            		var admin = rowObject.admin;
            		if(admin==1){
            			return "是";
            		}else{
            			return "否";
            		}
            	}
            },{name: '', index: '', width: 120,
            	formatter:function(cellvalue, options, rowObject){
            		var admin = rowObject.admin;
            		var id = rowObject.id;
            		if($("#admin").val()=='true' && admin==0){
            			return "<a href='#' onclick=setAdmin('"+id+"')>设置为负责人</a> <a href='#' onclick=deleteUserDept('"+id+"')>删除</a>";
            		}else{
            			return "";
            		}
            	}}
        ],
        viewrecords: true,
        rownumbers: true,//添加左侧行号
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: user_pager_selector,
        jsonReader: {
            page: "page",
            total: "pages",
            pageSize: "pageSize",
            records: "total",
            rows: "rows"
        },
        altRows: true,
        multiselect: false,
        multiboxonly: true,
        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);
                updatePagerIcons(table);
                setColor() ;
            }, 0);
        },
        sortable: true,
        sortname: 'endTime',
        sortorder: 'desc',
        autowidth: true,
       //shrinkToFit: false,
        autoScroll: true

    });
    setToolsBarIcon(user_grid_selector, user_pager_selector);
    
    
    /** 查询按钮**/
    $("#queryDeptBtn").on('click', function () {
    	jQuery(user_grid_selector).jqGrid('setGridParam',{ 
            postData: {
            	deptName:$("#query_deptName").val()
            },
            page:1 
        }).trigger("reloadGrid"); //重新载入 
    });  
    
    
    /** 查询按钮**/
    $("#queryErp").on('click', function () {
    	var erpNumber = $("#erpNumber").val();
    	if(erpNumber==''){
    		bootbox.alert("帐号不能为空！");
    		return ;
    	}
    
    	var deptCode = $("#deptCode").val();
    	jQuery.ajax({
			type: "post",
			url: "dept/findUserByErp.do",
			data: "erp="+erpNumber+"&deptCode="+deptCode,
			success: function(data){
				if(data.code==1){
					bootbox.alert(data.msg);
					jQuery(user_grid_selector).jqGrid('setGridParam',{ 
			            postData: {
			            	deptCode:$("#deptCode").val()
			            },
			            page:1 
			        }).trigger("reloadGrid"); //重新载入 
				}else{
					bootbox.alert(data.msg);
				}
			}
		});
    });  
    
    
    /** 新增按钮**/
    $("#addDeptBtn").on('click', function () {
        $('#deptModal').load("dept/gotoDeptEdit.do").modal();
    });  
});
function setAdmin(id){
	bootbox.confirm("确定要删除吗?", function(result) {
    	if(result) {
	jQuery.ajax({
		type: "post",
		url: "dept/setAdmin.do",
		data: "id="+id+"&deptCode="+$("#deptCode").val(),
		success: function(data){
			if (data.resultCode == 1) {
				bootbox.alert(data.resultMsg);// 关闭当前对话框
				jQuery("#user-grid-table").jqGrid('setGridParam',{ 
		            postData: {
		            	deptCode:$("#deptCode").val()
		            },
		            page:1 
		        }).trigger("reloadGrid"); //重新载入 
			} else {
				bootbox.alert(data.resultMsg);// 关闭当前对话框
			}
		}
	});
    	}
	});
}
	function deleteUserDept(id){
		bootbox.confirm("确定要删除吗?", function(result) {
        	if(result) {
			jQuery.ajax({
				type: "post",
				url: "dept/deleteUserDept.do",
				data: "id="+id,
				success: function(data){
					if (data.resultCode == 1) {
						bootbox.alert(data.resultMsg);// 关闭当前对话框
						jQuery("#user-grid-table").jqGrid('setGridParam',{ 
				            postData: {
				            	deptCode:$("#deptCode").val()
				            },
				            page:1 
				        }).trigger("reloadGrid"); //重新载入 
					} else {
						bootbox.alert(data.resultMsg);//关闭当前对话框
					}
				}
			});
		}
		});
}
