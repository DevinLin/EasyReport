$(function () {
	/** 表单提交* */
	$("#bsResource_sumbit").on('click', (function() {
		$('#bsResourceEdit_form').bootstrapValidator('validate');
		if ($('#bsResourceEdit_form').data('bootstrapValidator').isValid()) {
			$("#bsResource_sumbit").attr({"disabled":"disabled"});
			$('#bsResourceEdit_form').ajaxSubmit({
				url : 'bsResource/editBsResource.do',
				success : function(data) {
					if (data.resultCode == 1) {
						bootbox.alert(data.resultMsg);// 关闭当前对话框
						$('#bsResourceModal').modal("hide");
						jQuery("#grid-table").jqGrid('setGridParam',{ 
				            postData: {
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
		return false;
	}));
	  $('#bsResourceEdit_form').bootstrapValidator({
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	bsResourceName: {
	                selector: '#bsResourceName',
	                validators: {
	                    notEmpty: {}
	                }
	            },
	            bsResourceCode: {
	            	bsResourceCode: '#bsResourceCode',
	                validators: {
	                    notEmpty: {}
	                }
	            }
	        }
	    });
});

