$(function () {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        url: "dept/queryDeptList.do",
        datatype: "json",
        mtype: 'POST',  
        postData: {
        	deptCode:$("#query_deptCode").val(),
        	deptName:$("#query_deptName").val()
        },
        height: 350,
        colNames: ['id', '部门编号', '部门名称', '备注'],
        colModel: [
            {name: 'id', index: 'id', width: 50, hidden: true},
          
            {name: 'deptCode', index: 'deptCode', width: 250},
            {name: 'deptName', index: 'deptName', width: 300},
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
        autowidth: true,
        shrinkToFit: false,
        autoScroll: true

    });
    setToolsBarIcon(grid_selector, pager_selector);
    
    
    /** 查询按钮**/
    $("#queryDeptBtn").on('click', function () {
    	jQuery(grid_selector).jqGrid('setGridParam',{ 
            postData: {
            	deptCode:$("#query_deptCode").val(),
            	deptName:$("#query_deptName").val()
            },
            page:1 
        }).trigger("reloadGrid"); //重新载入 
    });  
    
    
    /** 新增按钮**/
    $("#addDeptBtn").on('click', function () {
        $('#deptModal').load("dept/gotoDeptEdit.do").modal();
    });  
    
    /** 更新按钮**/
    $("#updateDeptBtn").on('click', function () {
    	var id = $(grid_selector).jqGrid('getGridParam','selarrrow');
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
		 $('#deptModal').load("dept/gotoDeptEdit.do?id="+id).modal();	
    	}
    });
    
    /** 用户授权按钮**/
    $("#userListBtn").on('click', function () {
    	var id = $(grid_selector).jqGrid('getGridParam','selarrrow');
    	var deptCode = $(grid_selector).jqGrid('getCell',id,"deptCode");
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
    		$('#deptModal').load("dept/gotoUserList.do?deptCode="+deptCode).modal();
    	}
     }
    );
    
    /** 删除按钮**/
    $("#deleteDeptBtn").on('click', function () {
    	var id = $(grid_selector).jqGrid('getGridParam','selarrrow');
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
    		bootbox.confirm("确定要删除吗?", function(result) {
            	if(result) {
        		
            	jQuery.ajax({
        			type: "post",
        			url: "dept/deleteDept.do",
        			data: "id="+id,
        			success: function(data){
        				if (data.resultCode == 1) {
        					bootbox.alert(data.resultMsg);// 关闭当前对话框
        					$('#deptModal').modal("hide");
        					jQuery(grid_selector).jqGrid('setGridParam',{ 
        			            postData: {
        			            	deptCode:$("#query_deptCode").val(),
        			            	deptName:$("#query_deptName").val()
        			            },
        			            page:1 
        			        }).trigger("reloadGrid"); //重新载入 
        				} else {
        					bootbox.alert(data.resultMsg);// 关闭当前对话框
        				}
        				  $("#dept_sumbit").removeAttr("disabled");
        			}
        		});
        	}
    		});
    	}
    	
    });

});

