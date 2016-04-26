$(function(){
	/*自定义下拉菜单 start*/
	 $(".select_action").click(function(){
			var btn=this;
			var ul=$(this).siblings("ul");
			
			if(ul.css("display")=="block")
			ul.css("display","none");
		else
			ul.css("display","block");
		});
		$(".select ul").mouseout(function(){
				$(this).css("display","none");
		}).mouseover(function(){
			$(this).css("display","block");
		});
		$(".select_item").click(function(){
			var index=$(this).attr("index");
			var content=$(this).html();
			$(this).parent().parent().siblings(".curr").attr("index",index);
			$(this).parent().parent().siblings(".curr").html(content);
			$(this).parent().parent().css("display","none");
		})

/*自定义下拉菜单 end*/


		$(".inner").each(function(){
			$(this).find("tr:even").addClass("even");  //奇数行的样式
    $(this).find(".inner tr:odd").addClass("odd");  //偶数行的样式
		}) 
})