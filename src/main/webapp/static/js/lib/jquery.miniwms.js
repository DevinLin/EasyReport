$(document).ready(function(){	
	var $wallcontent=$('#wallcontent');
	
	$wallcontent.isotope({
		itemSelector : 'article'
	});

    var  names = ["验收","上架","移库","盘点","盘盈亏审核","订单接收","自动定位","订单查询","报损查询"];
    var urls = ["check.do","upcarriage.do","move.do","stock.do","auditing.do"];
    var items = [];
    $.each(names, function (i, name) {

        items.push('<article><div class="ih-item square effect7"><a href="'+urls[i]+'"><div class="img">' +
            '<img src="static/images/jd.jpg" alt="img"></div><div class="info">' +
            '<h3>'+name+'</h3><p>'+name+'</p></div>' +
            '</a></div>' +
            '<a href="'+urls[i]+'" target="_blank" class="linkc"><div class="details"><h2>' + name + '</h2></div></a>' +
            '</article>');
    });
	var testcontent = $(items.join(''));
	$wallcontent.append(testcontent);
    $wallcontent.imagesLoaded(function(){
        $wallcontent.isotope('appended', testcontent).isotope('reLayout');
    });
});
	