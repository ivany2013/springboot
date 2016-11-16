function a(){
	if(!isNaN($("#d1").val())){
		
		   return true;
		 
	}
	  if(isNaN($("#d1").val())) 
	   {
		  alert("序列号不是数字")
		   return false;
		}
	
	
}

function b(){

	  if(isNaN($("#d2").val())) 
	   {
		  alert("序列号不是数字")
		   return false;
		}
	  if($("#i1").val()==null||$("#i1").val()==""||$("#i2").val()==null||$("#i2").val()==""||$("#i3").val()==null||$("#i3").val()==""){
		  alert("不能有选项为空")
		  return false;
	  }
	 return true;
}