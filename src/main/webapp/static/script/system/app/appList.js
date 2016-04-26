 function gotoDeployPage(deptCode,appName){
    	$("#mainFrame").load("app/gotoAppDeployList.do?deptCode="+deptCode+"&appName="+appName);
    }
    function gotoConfigPage(deptCode,appName){
    	$("#mainFrame").load("app/gotoAppConfigList.do?deptCode="+deptCode+"&appName="+appName);
    }
$(function () {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        url: "app/queryAppList.do",
        datatype: "json",
        postData: {
        },
        height: 350,
        colNames: ['id','应用名称','部门编号','所属部门','操作'],
        colModel: [
            {name: 'id', index: 'id', width: 50, hidden: true},
            {name: 'name', index: 'name', width: 480},
            {name: 'deptCode', index: 'deptCode', width: 200},
            {name: 'deptName', index: 'deptName', width: 200},
            {name: 'name', index: 'name', width: 200,
            	formatter:function(cellvalue, options, rowObject){
            		//var value = rowObject.deptCode+"/"+rowObject.name;
            		return "" +
            				"<div class=\"btn-group btn-group-sm\" style=\"margin-left:10px;\" >"+
            				"<button  type=\"button\" onclick=\"gotoDeployPage('"+rowObject.deptCode+"','"+cellvalue+"')\" class=\"btn  btn-xs btn-primary\"><i class='glyphicon glyphicon-cog'></i>部署</button>"+
            				"<button  type=\"button\"  onclick=\"gotoConfigPage('"+rowObject.deptCode+"','"+cellvalue+"')\" class=\"btn btn-xs btn-primary\"><i class='glyphicon glyphicon-wrench'></i>配置 </button>"+
            				"</div>";
            	}}
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
        multiselect: false,
        multiboxonly: false,
        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);
                updatePagerIcons(table);
               // setColor() ;
            }, 0);
        },
        sortable: true,
        sortname: 'id',
        sortorder: 'desc',
        autowidth: true,
        shrinkToFit: false,
        autoScroll: true

    });
    setToolsBarIcon(grid_selector, pager_selector);
    
   
});


