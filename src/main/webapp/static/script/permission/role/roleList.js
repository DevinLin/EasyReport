$(function () {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        url: "role/queryRoleList.do",
        datatype: "json",
        postData: {
        	roleCode:$("#query_roleCode").val(),
        	roleName:$("#query_roleName").val()
        },
        height: 350,
        colNames: ['id', '系统编号', '系统名称', '备注'],
        colModel: [
            {name: 'id', index: 'id', width: 50, hidden: true},
          
            {name: 'roleCode', index: 'roleCode', width: 250},
            {name: 'roleName', index: 'roleName', width: 300},
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
    $("#queryRoleBtn").on('click', function () {
    	jQuery(grid_selector).jqGrid('setGridParam',{ 
            postData: {
            	roleCode:$("#query_roleCode").val(),
            	roleName:$("#query_roleName").val()
            },
            page:1 
        }).trigger("reloadGrid"); //重新载入 
    });  
    
    
    /** 新增按钮**/
    $("#addRoleBtn").on('click', function () {
        $('#roleModal').load("role/gotoRoleEdit.do").modal();
    });  
    
    /** 更新按钮**/
    $("#updateRoleBtn").on('click', function () {
    	var id = $(grid_selector).jqGrid('getGridParam','selarrrow');
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
		 $('#roleModal').load("role/gotoRoleEdit.do?id="+id).modal();	
    	}
    });
    
    
    /** 删除按钮**/
    $("#deleteRoleBtn").on('click', function () {
    	var id = $(grid_selector).jqGrid('getGridParam','selarrrow');
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
    		bootbox.confirm("确定要删除吗?", function(result) {
            	if(result) {
        		
            	jQuery.ajax({
        			type: "post",
        			url: "role/deleteRole.do",
        			data: "id="+id,
        			success: function(data){
        				if (data.resultCode == 1) {
        					bootbox.alert(data.resultMsg);// 关闭当前对话框
        					$('#roleModal').modal("hide");
        					jQuery(grid_selector).jqGrid('setGridParam',{ 
        			            postData: {
        			            	roleCode:$("#query_roleCode").val(),
        			            	roleName:$("#query_roleName").val()
        			            },
        			            page:1 
        			        }).trigger("reloadGrid"); //重新载入 
        				} else {
        					bootbox.alert(data.resultMsg);// 关闭当前对话框
        				}
        				  $("#role_sumbit").removeAttr("disabled");
        			}
        		});
        	}
    		});
    	}
    	
    });
    
    /** 角色分配资源**/
    $("#bsResourceListBtn").on('click', function () {
    	var id = $(grid_selector).jqGrid('getGridParam','selarrrow');
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
    		 $('#roleModal').load("role/gotoRoleResourceList.do?roleId="+id).modal();
    	}
       
    }); 
    

});

