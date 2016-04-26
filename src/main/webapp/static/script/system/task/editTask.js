$(function () {
    $("#TaskEdit_form").bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            project_name: {
                validators: {
                    notEmpty: {
                        message: '项目名称不能为空'
                    }
                }
            },
            summary: {
                validators: {
                    notEmpty: {
                        message: '功能名称不能为空'
                    }
                }
            },
            online_Time: {
                validators: {
                    notEmpty: {
                        message: '上线时间不能为空'
                    },
                    date: {
                        format: 'YYYY-MM-DD'
                    }
                }
            },
            testing_starttime: {
                validators: {
                    notEmpty: {
                        message: '测试起始时间不能为空'
                    },
                    date: {
                        format: 'YYYY-MM-DD HH:mm:ss'
                    }
                }
            },
            testing_endtime: {
                validators: {
                    notEmpty: {
                        message: '测试结束时间不能为空'
                    },
                    date: {
                        format: 'YYYY-MM-DD'
                    }
                }
            },
            tester: {
                validators: {
                    notEmpty: {
                        message: '测试人不能为空'
                    }
                }
            },
            lastWeekSchedule: {
                validators: {
                    notEmpty: {
                        message: '上周进度不能为空'
                    }
                }
            }
        }
    })


    $(".form_datetime").datetimepicker({
        autoclose: true
    });
    $('.form_datetime').datetimepicker('setStartDate', '2012-01-01 00:00');
    //$('.form_datetime').datetimepicker('update');

    /** 表单提交* */
    $("#task_sumbit").on('click', (function () {
        $('#TaskEdit_form').bootstrapValidator('validate');
        if ($('#TaskEdit_form').data('bootstrapValidator').isValid()) {
            //$("#task_sumbit").attr({"disabled": "disabled"});

            $('#TaskEdit_form').ajaxSubmit({
                url:'task/addTask.do',
                type:'get',
                success:function(data){
                    if (data.resultCode == 1) {
                        bootbox.alert(data.resultMsg);// 关闭当前对话框
                        $('#taskModal').modal("hide");
                        jQuery("#employee-grid-table").reload();
                    } else {
                        bootbox.alert(data.resultMsg);// 关闭当前对话框
                    }
                    $("#task_sumbit").removeAttr("disabled");
                }
            });
        }
        return false;
    }));
});

