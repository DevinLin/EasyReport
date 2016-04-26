$(function () {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";
    var select_id="";
    jQuery(grid_selector).jqGrid({
    	  treeGrid: true,  
          treeGridModel: 'adjacency', //treeGrid模式，跟json元数据有关 ,adjacency/nested  
          ExpandColumn : 'code',  
          treeIcons: {leaf:'ui-icon-radio-off'},
        url: "bsResource/queryBsResourceList.do",
        datatype: "json",
        postData: {
        	code:$("#query_code").val(),
        	name:$("#query_name").val()
        },
        height: 350,
       
        colNames: ['id', '系统名称', '系统编号', 'url','类型','备注'],
        colModel: [
           
            {name: 'id', index: 'id', width: 50, hidden: true},
            {name: 'name', index: 'name', width: 130},
            {name: 'code', index: 'code', width: 200},
            {name: 'url', index: 'url', width: 350},
            {name: 'type', index: 'type', width: 130,
            	formatter:function(cellvalue, options, rowObject){
        		var type = rowObject.type;
        		if(type==1 || type==2){
        			return "菜单";
        		}else{
        			return "按钮";
        		}
        		
        	}},
            {name: 'description', index: 'description', width: 200}
        ],
        altRows: true,
        viewrecords: true,
        multiselect: true,
        multiboxonly: true,
        rownumbers: true,//添加左侧行号
        pager: "false",  
        sortname: 'id',  
        sortorder: "desc",  

        jsonReader: {  
            root: "rows",  
            repeatitems : false  
        },  
        treeReader : {  
            level_field: "type",  
            parent_id_field: "parentId",  
            leaf_field: "leaf",  
            expanded_field: "expanded"  
        },  
        autowidth: true,
        height: "auto",    // 设为具体数值则会根据实际记录数出现垂直滚动条  
        rowNum : "-1",     // 显示全部记录  
        shrinkToFit: false,
        autoScroll: false,
        onSelectRow: function(id){ 
           // alert(id);
        	select_id = id;
           }

    });
    setToolsBarIcon(grid_selector, pager_selector);
    
    
    /** 查询按钮**/
    $("#queryBsResourceBtn").on('click', function () {
    	jQuery(grid_selector).jqGrid('setGridParam',{ 
            postData: {
            	bsResourceCode:$("#query_bsResourceCode").val(),
            	bsResourceName:$("#query_bsResourceName").val()
            },
            page:1 
        }).trigger("reloadGrid"); //重新载入 
    });  
    
    
    /** 新增按钮**/
    $("#addBsResourceBtn").on('click', function () {
    	var id = select_id;
    	if(id){
    		$('#bsResourceModal').load("bsResource/gotoBsResourceAdd.do?id="+id).modal();	
    	}else{
    		$('#bsResourceModal').load("bsResource/gotoBsResourceAdd.do").modal();
    	}
    });  
    
    /** 更新按钮**/
    $("#updateBsResourceBtn").on('click', function () {
    	var id = select_id;
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
		 $('#bsResourceModal').load("bsResource/gotoBsResourceEdit.do?id="+id).modal();	
    	}
    });
    
    
    /** 删除按钮**/
    $("#deleteBsResourceBtn").on('click', function () {
    	var id = select_id;
    	if(id==''){
    		bootbox.alert("请选择行");
    	}else{
    		bootbox.confirm("确定要删除吗?", function(result) {
            	if(result) {
        		
            	jQuery.ajax({
        			type: "post",
        			url: "bsResource/deleteBsResource.do",
        			data: "id="+id,
        			success: function(data){
        				if (data.resultCode == 1) {
        					bootbox.alert(data.resultMsg);// 关闭当前对话框
        					$('#bsResourceModal').modal("hide");
        					jQuery(grid_selector).jqGrid('setGridParam',{ 
        			            postData: {
        			            	bsResourceCode:$("#query_bsResourceCode").val(),
        			            	bsResourceName:$("#query_bsResourceName").val()
        			            },
        			            page:1 
        			        }).trigger("reloadGrid"); //重新载入 
        					select_id="";
        				} else {
        					bootbox.alert(data.resultMsg);// 关闭当前对话框
        				}
        				  $("#bsResource_sumbit").removeAttr("disabled");
        			}
        		});
        	}
    		});
    	}
    	
    });

});

