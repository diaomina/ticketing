function getDateTime(){
	var myDate = moment().format("YYYY-MM-DD HH:mm:ss");
	var startTime = document.getElementById("startTime");
	var endTime = document.getElementById("endTime");
	startTime.setAttribute("min",myDate);
	endTime.setAttribute("min",myDate);
}