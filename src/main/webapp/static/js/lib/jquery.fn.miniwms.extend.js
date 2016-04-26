/***
 * 扩展的方法
 */
jQuery.extend({
	go:function(url){
		window.location.href=url;
	},
	/**
	 * 导出
	 * @param url
	 */
	msgAlert:function (type, msg,callback) {
		switch (type) {
		case "success":
			// 设置提示类型样式
			jQuery("#sysInnerWarn").attr("class", "alert alert-success");
			// 设置提示类型
			jQuery("#sysInnerInfo").text("恭喜：");
			break;
		case "warn":
			// 设置提示类型样式
			jQuery("#sysInnerWarn").attr("class", "alert alert-warning");
			// 设置提示类型
			jQuery("#sysInnerInfo").text("警告：");
			break;
		case "error":
			// 设置提示类型样式
			jQuery("#sysInnerWarn").attr("class", "alert alert-danger");
			// 设置提示类型
			jQuery("#sysInnerInfo").text("错误：");
			break;
		case "info":
			// 设置提示类型样式
			jQuery("#sysInnerWarn").attr("class", "alert alert-info");
			// 设置提示类型
			jQuery("#sysInnerInfo").text("提示：");
			break;
		default:
		}
		// 设置显示信息
		jQuery("#lblSysInfo").text(msg);
		jQuery("#sysAlert").modal("show");
		setTimeout(function() {
			jQuery("#sysAlert").modal("hide");
			 callback.call(this);   
		}, 1000);
		
}
});
