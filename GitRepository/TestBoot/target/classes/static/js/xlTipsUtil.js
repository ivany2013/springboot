var xltips = function (msg,displayTime){
	var tagi = this;
	var tagid = tagi.attr('id');
	var timestamp = (new Date()).valueOf();  
	var msgObj = $("#"+tagid+timestamp);
	if(msgObj.length==0){
		$(document.body).append("<div class='dctUtilMsg' id="+tagid+timestamp+" >"+msg+"</div>");
		msgObj.fadeIn(1000);
		setTimeout(function(){msgObj.fadeOut(1000)},displayTime); 
	}
		tagi.click(function (){
			var msgObj = $("#"+tagid+timestamp);
			var X = (tagi.offset().top)-20;
			var Y = (tagi.offset().left)+50;
			msgObj.css('top',X+"px");
			msgObj.css('left',Y+"px");
			msgObj.fadeIn(1000);
			setTimeout(function(){msgObj.fadeOut(1000)},displayTime); 
		})
}

var xlwarning = function (msg){
	$(document.body).append("<div class='xlWarningMsg'>"+msg+"（点击关闭）"+"</div>");
	var msgObj = $(".xlWarningMsg");
	msgObj.fadeIn(1000);
	$(".xlWarningMsg").click(function (){
		$(".xlWarningMsg").hide();
	});
}


var xlprompt = function(msg){
	var msgObj = $(".xlprompt");
	if($(".xlprompt").length!=0){
		$(".xlprompt").css("opacity","0.5");
	}else {
		$(document.body).append("<div class='xlprompt'>"+msg+"</div>");
	}
	var msgObj = $(".xlprompt");
	msgObj.fadeIn(1000);
	setTimeout(function(){msgObj.hide()},3000); 
}

var xltips2 = function(tagi,msg){
	var X = (tagi.offset().top)-10;
	var Y = (tagi.offset().left)+50;
	var msgObj = $(".xltips2");
	if(msgObj.length==0){
	$(document.body).append("<div class='xltips2'>"+msg+"</div>");
	}else{
		msgObj.html(msg);
	}
	
	
	var msgObj = $(".xltips2");
	msgObj.css('top',X+"px");
	msgObj.css('left',Y+"px");
	
	msgObj.fadeIn(1000);
	setTimeout(function(){msgObj.fadeOut(1000)},1000); 
}


var deletePro = function(url,id){
	var delObj = $(".deletePro");
	if(delObj.length==0){
		$(document.body).append("<div class='deletePro'><h4>是否确认删除？</h4><input type='button' value='确认' class='btn-y'  /> <input type='button' value='取消' class='btn-n'  /></div>");
	}else{
		delObj.show();
	}
	
	$(".btn-n").click(function(){
		$(".deletePro").hide();
		return false;
	});
	
	$(".btn-y").click(function(){
		$(".deletePro").hide();
		location.href=url+"?id="+id;
	});
}



$.extend({
	xlwarning:xlwarning,
	xlprompt:xlprompt,
	xltips2:xltips2,
	deletePro:deletePro
});

$.fn.extend({
	xltips:xltips
	});