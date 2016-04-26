 function gotoDeployPage(deptCode,appName){
    	$("#mainFrame").load("app/gotoAppDeployList.do?deptCode="+deptCode+"&appName="+appName);
    }
    function gotoConfigPage(deptCode,appName){
    	$("#mainFrame").load("app/gotoAppConfigList.do?deptCode="+deptCode+"&appName="+appName);
    }
    function backAppList(){
    	$("#mainFrame").load("app/gotoAppList.do");
    }
    
jQuery(function () {
	$('#otherInfoTab a:last').tab('show');//初始化显示哪个tab
	$('#otherInfoTab a').click(function(e) {
		e.preventDefault();//阻止a链接的跳转行为
		$(this).tab('show');//显示当前选中的链接及关联的content
	});
    //加载字典树
    initTree();
});
/**
 * 初始化字典树
 */
var ztreeObj;
function initTree() {
    //根节点
    var zNodes = [
        {name: $("#appName").val(), path:$("#parentPath").val(),isParent: true, open: true}
    ];
    var settings = {
        async: {
            enable: true,
            url: $("#treeUrl").val()+"?deptCode="+$('#deptCode').val()+"appName="+$('#appName').val()+"&timestamp=" + new Date().getTime(),
            autoParam: ["name","path"],
            dataFilter: filter,
            type: "post"
        },
        view: {
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "name"
            },
            key: {
                name: "name"
            }
        }
    }
    ztreeObj = jQuery.fn.zTree.init($("#tree_div"), settings,zNodes);
    var nodes = ztreeObj.getNodes();
    ztreeObj.expandNode(nodes[0], true);
}

function filter(treeId, parentNode, childNodes) {
	if (!childNodes)
		return null;
	for ( var i = 0, l = childNodes.length; i < l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\./g, '.');
	}
	return childNodes;
}


var currentNode;
/**
 * 鼠标移到到树节点时显现的操作
 * @param treeId
 * @param treeNode
 */
function addHoverDom(treeId, treeNode) {
    currentNode = treeNode;
    var aObj = $("#" + treeNode.tId + "_a");
    //判断是否已经显示了操作
    if ( $("#editBtn_" +
        treeNode.tId).length > 0 || $("#detailBtn_" + treeNode.tId).length > 0 ) {
        return;
    }
    //判断节点，不同的节点有不同的操作
    var operator = "";
    var add = '<span id="addBtn_' + treeNode.tId + '"' + 'class="button add" title="添加 " onfocus="this.blur()  "> </span>';
    var edit = '<span id="editBtn_' + treeNode.tId + '"' + 'class="button edit" title="修改 " onfocus="this.blur()  "> </span>';
    var del = '<span id="deleteBtn_' + treeNode.tId + '"' + 'class="button remove" title="删除 " onfocus="this.blur()  "> </span>';
    var detail = '<span id="detailBtn_' + treeNode.tId + '"' + 'class="button detail" title="详情" onfocus="this.blur()"> </span>'
    
    if($("#type").val()=='1'){
    	 operator = detail;
    }else{
    	operator = add+edit + del+detail;
    }
    
    aObj.append(operator);
    //给当前节点的操作注册事件
    registerEvent(treeNode);
}

function removeHoverDom(treeId, treeNode) {
	 $("#addBtn_" + treeNode.tId).unbind().remove();
    $("#editBtn_" + treeNode.tId).unbind().remove();
    $("#deleteBtn_" + treeNode.tId).unbind().remove();
    $("#detailBtn_" + treeNode.tId).unbind().remove();
}

function registerEvent(treeNode) {
	
	//添加操作
    var addBtn = $("#addBtn_" + treeNode.tId);
    
    //修改操作
    var updateBtn = $("#editBtn_" + treeNode.tId);
    
    //删除操作
    var deleteBtn = $("#deleteBtn_" + treeNode.tId);
    
    //详情
    var detailBtn = $("#detailBtn_" + treeNode.tId);
    
    if (addBtn) {
        addBtn.bind("click", function () {
            selectClickNode(currentNode)
            removeHoverDom(undefined, treeNode);
            //添加
            add();
        })
    }
    
    
    if (updateBtn) {
        updateBtn.bind("click", function () {
            selectClickNode(currentNode)
            removeHoverDom(undefined, treeNode);
            //修改
            update();
        })
    }
    if (deleteBtn) {
    	deleteBtn.bind("click", function () {
            selectClickNode(currentNode)
            removeHoverDom(undefined, treeNode);
            //修改
            del();
        })
    }
    if (detailBtn) {
        detailBtn.click(function () {
            selectClickNode(currentNode)
            removeHoverDom(undefined, treeNode);
            detail();
        })
    }
}


function update() {
	 $('#nodeModal').load("app/gotoNodeEdit.do?path="+currentNode.path).modal();
}
function del() {
	if(confirm("确认要删除该节点吗?")){
		jQuery.ajax({
			"type" : "post",
			"url" : "app/deleteNode.do",
			"data" : {
				path : currentNode.path,
				version:currentNode.version
			}, // 以json格式传递
			"success" : function(msg) {
				if(msg.flag==1){
					alert(msg.msg);
					 ztreeObj.reAsyncChildNodes(currentNode.getParentNode(), "refresh");
				}else{
					alert(msg.msg);
				}
				
			},"error":function(resp){
				
			}
		});
	}
	
}
function add() {
	 $('#nodeModal').load("app/gotoNodeAdd.do?path="+currentNode.path).modal();
}


function detail() {
	 $('#nodeModal').load("app/gotoNodeDetail.do?path="+currentNode.path).modal();
}
/**
 * 选中当前操作节点
 */
function selectClickNode(node) {
    //选中节点
    ztreeObj.selectNode(node, true);
    jQuery.each(ztreeObj.getSelectedNodes(), function () {
        ztreeObj.selectNode(this, false);
    });
}