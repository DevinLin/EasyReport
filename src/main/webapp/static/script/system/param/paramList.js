$(function () {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        datatype: "json",
        height: 350,
        mtype: 'POST',  
        colNames: ['id', 'path','部门', '应用', '分组', 'IP', '类别', '属性', '值'],
        colModel: [
            {name: 'id', index: 'id', width: 50, hidden: true},
            {name: 'path', index: 'path', width: 100,hidden: true},
            {name: 'deptCode', index: 'deptCode', width: 100},
            {name: 'appName', index: 'appName', width: 180},
            {name: 'groupName', index: 'groupName', width: 120},
            {name: 'ipName', index: 'ipName', width: 120},
            {name: 'configTypeName', index: 'configTypeName', width: 120},
            {name: 'nodeName', index: 'nodeName', width: 200},
            {name: 'data', index: 'data', width: 200}
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
    $("#queryParamBtn").on('click', function () {
    	jQuery(grid_selector).jqGrid('setGridParam',{ 
    		url: "param/queryParamList.do",
            postData: {
            	appPath:$("#query_appName").val(),
            	group:$("#group").val()
            },
            page:1 
        }).trigger("reloadGrid"); //重新载入 
    });  
    
    /** 更新按钮**/
    $("#updateParamBtn").on('click', function () {
    	var rowId=$(grid_selector).jqGrid("getGridParam","selrow");
    	var rowData = $(grid_selector).jqGrid('getRowData',rowId);
    	if(rowData.path==''){
    		bootbox.alert("请选择行");
    	}else{
    		$('#nodeModal').load("app/gotoNodeEdit.do?path="+rowData.path).modal();
    	}
    });
    
   
  
});

function initGroup(obj){
	$("#group option").remove();
	$("#group").append("<option value=''>-----请选择------</option>");
	jQuery.ajax({
		type: "post",
		url: "param/queryGroup.do",
		data: "appName="+obj.value,
		success: function(data){
			  for(var i=0;i<data.length;i++){
				  $("#group").append("<option value='"+data[i].name+"'>"+data[i].name+"</option>");
			  }
			  $("#role_sumbit").removeAttr("disabled");
		}
	});
}

