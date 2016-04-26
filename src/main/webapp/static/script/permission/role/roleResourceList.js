$(function () {
    var grid_selector_tree = "#grid-table_tree";
    var select_id="";
    jQuery(grid_selector_tree).jqGrid({
    	  treeGrid: true,  
          treeGridModel: 'adjacency', //treeGrid模式，跟json元数据有关 ,adjacency/nested  
          ExpandColumn : 'name',  
          treeIcons: {leaf:'ui-icon-radio-off'},
         url: "role/queryRoleResourceList.do",
         postData : {
            roleId:$("#roleId").val()
        },
        datatype: "json",
        height: 330,
        colNames: ['id','roleId', '系统名称', '系统编码'],
        colModel: [
            {name: 'id', index: 'id', width: 50, hidden: true},
            {name: 'roleId', index: 'roleId', width: 50, hidden: true},
            {name: 'name', index: 'name', width: 330,
            	formatter:function(cellvalue, options, rowObject){
            		var name = rowObject.name;
            		var roleId = rowObject.roleId;
            		if(roleId!=null){
            			return "<input type='checkbox' checked='checked' onclick=\"set_power_status(this,'"+rowObject.id+"','"+rowObject.parentId+"')\"> "+name;
            		}else{
            			return "<input type='checkbox' onclick=\"set_power_status(this,'"+rowObject.id+"','"+rowObject.parentId+"')\"> "+name;
            		}
            		
            	}},
            	{name: 'code', index: 'code', width: 200}
        ],
        altRows: true,
        multiselect: true,
        multiboxonly: true,
        viewrecords: true,
        pager: "false",  
        sortname: 'id',  
        srtorder: "desc",  
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
        // shrinkToFit: false,
        autoScroll: true,
         onSelectRow: function(id){ 
         }
    });
});

function set_power_status(obj,nodeId,parentNodeId){
    var roleId = $("#roleId").val();
    jQuery.ajax({
        "type" : "post",
        "url" : "role/setRoleResource.do",
        "dataType" : "json",
        "data" : {
            flag : obj.checked,
            roleId:roleId,
            resourceId:nodeId
        },
        "success" : function(result) {
          //  alert("操作成功!");
        }
    });

}

