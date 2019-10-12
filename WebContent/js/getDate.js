function getDate(){
	var myDate = moment().format("YYYY-MM-DD");
	var startTime = document.getElementById("startTime");
	startTime.setAttribute("min",myDate);
}