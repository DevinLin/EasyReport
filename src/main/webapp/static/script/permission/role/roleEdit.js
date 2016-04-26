$(function () {
	/** 表单提交* */
	$("#role_sumbit").on('click', (function() {
		$('#roleEdit_form').bootstrapValidator('validate');
		if ($('#roleEdit_form').data('bootstrapValidator').isValid()) {
			$("#role_sumbit").attr({"disabled":"disabled"});
			$('#roleEdit_form').ajaxSubmit({
				url : 'role/editRole.do',
				success : function(data) {
					if (data.resultCode == 1) {
						bootbox.alert(data.resultMsg);// 关闭当前对话框
						$('#roleModal').modal("hide");
						jQuery("#grid-table").jqGrid('setGridParam',{ 
				            postData: {
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
		return false;
	}));
	  $('#roleEdit_form').bootstrapValidator({
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	roleName: {
	                selector: '#roleName',
	                validators: {
	                    notEmpty: {}
	                }
	            },
	            roleCode: {
	            	roleCode: '#roleCode',
	                validators: {
	                    notEmpty: {}
	                }
	            }
	        }
	    });
});

