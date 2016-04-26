$(function () {
    var grid_selector = "#grid-table_role";
    var pager_selector = "#grid-pager_role";

    jQuery(grid_selector).jqGrid({
        url: "user/queryUserRoleList.do",
        datatype: "json",
        postData: {
        	userId:$("#userId").val()
        },
        height: 300,
        colNames: ['id', '角色编号', '角色名称'],
        colModel: [
            {name: 'id', index: 'id', width: 50, hidden: true},
            {name: 'userId', index: 'userId', width: 250},
            {name: 'roleName', index: 'roleName', width: 200}
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
        loadComplete: function (data) {
        	var rows = data.rows;
        	for(var i=0;i<rows.length;i++){
        		var obj = rows[i];
        		if(obj.userId!=null){
        			$(grid_selector).jqGrid('setSelection',obj.id);
        		}
        	}
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
    
    
    $("#userRole_sumbit").on('click', (function() {
    	var roleIds = $("#grid-table_role").jqGrid('getGridParam','selarrrow');
    	    var userId = $("#userId").val();
    	    jQuery.ajax({
    	        "type" : "post",
    	        "url" : "user/setUserRole.do",
    	        "dataType" : "json",
    	        "data" : {
    	        	userId :userId,
    	        	roleIds:roleIds+""
    	        },
    	        "success" : function(result) {
    	        	alert("操作成功!");
    	        	$('#userModal').modal("hide");
    	        }
    	    });
    })
	);
});

