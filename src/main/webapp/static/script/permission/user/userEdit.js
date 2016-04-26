$(function () {
    /** 表单提交* */
    $("#user_sumbit").on('click', (function () {
        $('#userEdit_form').bootstrapValidator('validate');
        if ($('#userEdit_form').data('bootstrapValidator').isValid()) {
            $("#user_sumbit").attr({"disabled": "disabled"});
            $('#userEdit_form').ajaxSubmit({
                url: 'user/editUser.do',
                success: function (data) {
                    if (data.resultCode == 1) {
                        bootbox.alert(data.resultMsg);// 关闭当前对话框
                        $('#userModal').modal("hide");
                        jQuery("#grid-table").jqGrid('setGridParam', {
                            postData: {},
                            page: 1
                        }).trigger("reloadGrid"); //重新载入
                    } else {
                        bootbox.alert(data.resultMsg);// 关闭当前对话框
                    }
                    $("#user_sumbit").removeAttr("disabled");
                }
            });
        }
        return false;
    }));
    $('#userEdit_form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                selector: '#userName',
                validators: {
                    notEmpty: {}
                }
            },
            userCode: {
                userCode: '#userCode',
                validators: {
                    notEmpty: {}
                }
            }
        }
    });
});

