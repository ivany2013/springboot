$(function(){
	
	var a=null;
	 $("#jname2").hide();
	 $("#jpwd3").hide();
	 $("#jpwd4").hide();
	 $("#jrpwd3").hide();
	 $("#jrpwd4").hide();
	 $("#jrname2").hide();
	 $("#rpwd2").attr("disabled",true);
	 $("#register").hide();
	 
	 $("#name").blur( function () { 
		 var name = $("#name").val();
		 var pwd = $("#pwd").val();
		 if(name.trim()==""){
			$("#fname").addClass('has-error');
			$("#jname2").show();
		 }else{
			 $("#fname").addClass('has-success');
			 $("#fname").removeClass('has-error');
				 $("#jname2").hide();
		 }
		 if(name.trim()!="" && pwd.trim()!=""){
			 $("#sub").attr("disabled",false);
		 }else {
			 $("#sub").attr("disabled",true);   
		 }
		 
	 } );
	 
	 $("#rname").blur( function () { 
		 var rname = $("#rname").val();
		 var rpwd1 = $("#rpwd1").val();
		 if(rname.trim()==""){
			$("#frname").addClass('has-error');
			$("#jrname2").show();
		 }else{
			 $("#frname").addClass('has-success');
			 $("#frname").removeClass('has-error');
				 $("#jrname2").hide();
		 }
	 } );
	 
	 
	 
	 
	 
	 $("#pwd").blur( function () { 
		 var pwd = $("#pwd").val();
		 var name = $("#name").val();
		 if(pwd.trim()==""){
			$("#fpwd").addClass('has-error');
			$("#jpwd4").show();
		 }else{
			 $("#fpwd").addClass('has-success');
			 $("#fpwd").removeClass('has-error');
				 $("#jpwd4").hide();
		 }
		 
		 if(name.trim()!="" && pwd.trim()!=""){
			 $("#sub").attr("disabled",false);
		 }else {
			 $("#sub").attr("disabled",true);   
		 }
		 
	 } );
	 

	 $("#rpwd1").blur( function () { 
		 var rpwd1 = $("#rpwd1").val();
		 var rpwd2 = $("#rpwd2").val();
		 if(rpwd1.trim()==""){
			$("#frpwd1").addClass('has-error');
			$("#jrpwd3").show();
			 $("#rpwd2").attr("disabled",true);
		 }else{
			 $("#frpwd1").addClass('has-success');
			 $("#frpwd1").removeClass('has-error');
				 $("#jrpwd3").hide();
				 $("#rpwd2").attr("disabled",false);
		 }
		 
		 if(rpwd2.trim()!=rpwd1.trim()){
				$("#frpwd2").addClass('has-error');
				 $("#jrpwd4").html("两次输入不一致");
				$("#jrpwd4").show();
			 }else{
				 $("#frpwd2").addClass('has-success');
				 $("#frpwd2").removeClass('has-error');
					 $("#jrpwd4").hide();
			 }	 
		 
		 
		 
		 
	 } );
	 
	 $("#rpwd2").blur( function () { 
		 var rpwd1 = $("#rpwd1").val();
		 var rpwd2 = $("#rpwd2").val();
		 if(rpwd2.trim()==""){
			 $("#frpwd2").addClass('has-error');
			 $("#jrpwd4").html("输入有误");
				$("#jrpwd4").show();
		 }
		 if(rpwd2.trim()!=rpwd1.trim()){
			$("#frpwd2").addClass('has-error');
			 $("#jrpwd4").html("两次输入不一致");
			$("#jrpwd4").show();
		 }else{
			 $("#frpwd2").addClass('has-success');
			 $("#frpwd2").removeClass('has-error');
				 $("#jrpwd4").hide();
		 }	 
	 } );
	 
	 
	 
	 $("#reg").click( function () {
		 $("#login").hide();
		 $("#register").show();
	 } );
	 
	 $("#back").click( function () { 
		 $("#login").show();
		 $("#register").hide();
	 } );
	 
	 
	 $("#sub").click( function () { 
		 var name = $("#name").val();
		 var pwd = $("#pwd").val();
		 $.ajax({
			   type: "POST",
			   url: "login",
			   data: {
				   "name":name,
				   "age":pwd
			   },
			   success: function(msg){
				   var obj = jQuery.parseJSON(msg);
				  
				   if(obj.success=="true"){
					   var ii = layer.load();
					   //此处用setTimeout演示ajax的回调
					   setTimeout(function(){
					   layer.close(ii);
					   location.href="users";
					   }, 1000); 
				   }else {
					  
					   $.xlprompt("登录信息不正确");
				   }
			       
			   }
			});
		 
		 
	 } );
	 
	 var reg2 = $("#reg2");
	 
	 reg2.click( function () { 
		 var name = $("#rname").val();
		 var pwd = $("#rpwd1").val();
		 var pwd2 = $("#rpwd2").val();
		 
		 if(pwd.trim()!=pwd2.trim() || name.trim()=="" || pwd.trim()==""){
			 $.xltips2(reg2,"输入信息有误");
			 return false;
		 }
		 
		 $.ajax({
			   type: "POST",
			   url: "loadByName",
			   data: {
				   "name":name,
				   "age":pwd
			   },
			   success: function(msg){
				   var obj = jQuery.parseJSON(msg);
				  
				   if(obj.success=="true"){
					   var ii = layer.load();
					   //此处用setTimeout演示ajax的回调
					   setTimeout(function(){
					   layer.close(ii);
					   location.href="index";
					   }, 1000); 
				   }else {
					   $.xltips2(reg2,obj.msg);
				   }
			       
			   }
			});
	 } );
	 
	 
	 
	 $("#test").xltips("无法连接数据库",1000);
	 
	 $("#prompt").xltips("需要输入1000字",1000);
	 
	 $.xlwarning("温馨提示，进入Mysteel");
	 
	 
	
	 
});
function deleteTee(url,id){
  $.deletePro(url,id);
 }


