$(document).ready(function(){	
	
    var height = parseInt(document.documentElement.clientHeight-100)+"px";
    $(".auto-center").css({
    	"height":height,
    	"line-height":height,
    	"vertical-align":"middle",
    	"text-align":"center"
    });
    
    $("#menu li").click(function(){
    	$(this).parent().children().removeClass("active");
    	$(this).addClass("active");
    });
    $("#menu li").hover(function(){
    	//$(this).tClass("active");
    });
    $("#bru_index").click(function(){
   	 $("#mainFrame").load("body.do");
  	 });
    $("#bru_dept").click(function(){
      	 $("#mainFrame").load("dept/gotoDeptList.do");
      });
  
    $("#bru_app").click(function(){
   	 $("#mainFrame").load("app/gotoAppList.do");
   });
    $("#bru_param").click(function(){
     	 $("#mainFrame").load("dept/gotoParamList.do");
     });
});


function updatePagerIcons(table) {
    var replacement =
    {
        'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
        'ui-icon-seek-prev': 'icon-angle-left bigger-140',
        'ui-icon-seek-next': 'icon-angle-right bigger-140',
        'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
        if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
    })
}

function styleCheckbox(table) {
    $("body").find('input:checkbox').addClass('ace')
        .wrap('<label />')
        .after('<span class="lbl align-top" />')
    $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
        .find('input.cbox[type=checkbox]').addClass('ace')
        .wrap('<label />').after('<span class="lbl align-top" />');

}

function setToolsBarIcon(grid_selector,pager_selector){
    jQuery(grid_selector).jqGrid('navGrid', pager_selector,
        {
            edit: false,
            add: false,
            del: false,
            search: false,
            refresh: true,
            refreshicon: 'icon-refresh green'
        }
    );
    
    
}
