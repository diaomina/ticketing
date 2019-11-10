//验证用户名是否为空
function checkUserName() {
	var name = $(".name");
	var name = name.val();
	if (!name || name == "") {
		showMsg("用户名不能为空！");
	} else {
		showMsg("");
	}
}

// 验证密码是否为空
function checkPassword() {
	var $password = $(".password");
	var password = $password.val();
	if (!password || password == "") {
		showMsg("密码不能为空！");
	} else {
		showMsg("");
	}
}

// 错误信息提醒
function showMsg(msg) {
	$("#CheckMsg").text(msg);
}
