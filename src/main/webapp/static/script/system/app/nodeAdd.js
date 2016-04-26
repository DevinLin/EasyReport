$(function () {
	/** 表单提交* */
	$("#node_sumbit").on('click', (function() {
		$('#nodeEdit_form').bootstrapValidator('validate');
		if ($('#nodeEdit_form').data('bootstrapValidator').isValid()) {
			$("#node_sumbit").attr({"disabled":"disabled"});
			$('#nodeEdit_form').ajaxSubmit({
				url : 'app/addNode.do',
				success : function(data) {
					if (data.flag==1) {
						bootbox.alert(data.msg);// 关闭当前对话框
						$('#nodeModal').modal("hide");
						 ztreeObj.reAsyncChildNodes(currentNode, "refresh");
					} else {
						bootbox.alert(data.msg);// 关闭当前对话框
					}
					  $("#node_sumbit").removeAttr("disabled");
				}
			});
		}
		return false;
	}));
	  $('#nodeEdit_form').bootstrapValidator({
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            nodeCode: {
	            	nodeCode: '#name',
	                validators: {
	                    notEmpty: {}
	                }
	            },
	            nodeCode: {
	            	nodeCode: '#data',
	                validators: {
	                    notEmpty: {}
	                }
	            }
	        }
	    });
});

