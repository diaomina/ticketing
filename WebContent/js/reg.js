function checkName(){
	var flag = true;
	var name = $("#username").val().replace("/\s*/g","");
	//alert(name);
	if(name.length==0){
		$("tr td:eq(2)").html("用户名不能为空！");
		flag = false;
	}
	return flag;
}

$(function(){
	$("#username").blur(checkName());
	$("#username").focus(function(){
		$("tr td:eq(2)").html("");
	});
});