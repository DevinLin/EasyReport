$(function () {
	/** 表单提交* */
	$("#bsResource_add_sumbit").on('click', (function() {
		$('#bsResourceAdd_form').bootstrapValidator('validate');
		if ($('#bsResourceAdd_form').data('bootstrapValidator').isValid()) {
			$("#bsResource_add_sumbit").attr({"disabled":"disabled"});
			$('#bsResourceAdd_form').ajaxSubmit({
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
					  $("#bsResource_add_sumbit").removeAttr("disabled");
				}
			});
		}
		return false;
	}));
	  $('#bsResourceAdd_form').bootstrapValidator({
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	bsResourceName: {
	                selector: '#name',
	                validators: {
	                    notEmpty: {}
	                }
	            },
	            bsResourceCode: {
	            	bsResourceCode: '#code',
	                validators: {
	                    notEmpty: {}
	                }
	            }
	        }
	    });
});

