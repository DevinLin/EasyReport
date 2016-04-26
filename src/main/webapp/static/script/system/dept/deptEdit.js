$(function () {
	/** 表单提交* */
	$("#dept_sumbit").on('click', (function() {
		$('#deptEdit_form').bootstrapValidator('validate');
		if ($('#deptEdit_form').data('bootstrapValidator').isValid()) {
			$("#dept_sumbit").attr({"disabled":"disabled"});
			$('#deptEdit_form').ajaxSubmit({
				url : 'dept/editDept.do',
				success : function(data) {
					if (data.resultCode == 1) {
						bootbox.alert(data.resultMsg);// 关闭当前对话框
						$('#deptModal').modal("hide");
						jQuery("#grid-table").jqGrid('setGridParam',{ 
				            postData: {
				            },
				            page:1 
				        }).trigger("reloadGrid"); //重新载入 
					} else {
						bootbox.alert(data.resultMsg);// 关闭当前对话框
					}
					  $("#dept_sumbit").removeAttr("disabled");
				}
			});
		}
		return false;
	}));
	  $('#deptEdit_form').bootstrapValidator({
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	deptName: {
	                selector: '#deptName',
	                validators: {
	                    notEmpty: {}
	                }
	            },
	            deptCode: {
	            	deptCode: '#deptCode',
	                validators: {
	                    notEmpty: {}
	                }
	            }
	        }
	    });
	
	  //汉化日期控件
    $('.dateSelect').datetimepicker({
    	format: 'yyyy-mm-dd',
        weekStart: 1,  
        autoclose: true,  
        startView: 2,  
        minView: 2,  
        forceParse: false,  
        language: 'zh-CN' 
    });
    
    
    //汉化日期控件
    $('.timeSelect').datetimepicker({
    	format: 'hh:ii',
        weekStart: 2,  
        autoclose: true,  
        startView: 0,  
        minView: 4,  
        forceParse: false,  
        language: 'zh-CN' 
    });
});

