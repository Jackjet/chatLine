/**
 * 
 */
function send(){
	var secondURL = getSecondURL();
	if(secondURL=='chats'){
		sendBySales();
	}else if (secondURL=='chatc'){
		sendByCustomers();
	}
}


function  sendBySales() {
	function h() {
		-1 != g.indexOf("*#emo_") && (g = g.replace("*#", "<img src='img/").replace("#*", ".gif'/>"), h())
	}
	var a = 3,
		b = "../assetsimg/head/1.png",
		c = "../assetsimg/head/2.png",
		d = "用户3";
	var e = new Date,
		f = "";
	f += e.getFullYear() + "-", f += e.getMonth() + 1 + "-", f += e.getDate() + "  ", f += e.getHours() + ":", f += e.getMinutes() + ":", f += e.getSeconds();
	var g = $("#editor1").val();
	h();
	var i = "<div class='message clearfix'><div class='user-logo'><img src='" + b + "'/>" + "</div>" + "<div class='wrap-text'>" + "<h5 class='clearfix'>杀老师</h5>" + "<div>" + g + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div class='clearfix'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>" + "</div>";
	null != g && "" != g ? ($(".mes" + a).append(i), $(".chat01_content").scrollTop($(".mes" + a).height()), message()) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");
	sendChatMes(g);
}


function  showBySales(g){
	function h() {
		-1 != g.indexOf("*#emo_") && (g = g.replace("*#", "<img src='img/").replace("#*", ".gif'/>"), h())
	}
	var a = 3,
		b = "../assetsimg/head/1.png",
		c = "../assetsimg/head/2.png",
		d = "用户3";
	var e = new Date,
	f = "";
	f += e.getFullYear() + "-", f += e.getMonth() + 1 + "-", f += e.getDate() + "  ", f += e.getHours() + ":", f += e.getMinutes() + ":", f += e.getSeconds();
	h();
	var i = "<div class='message clearfix'><div class='user-logo'><img src='" + b + "'/>" + "</div>" + "<div class='wrap-text'>" + "<h5 class='clearfix'>客户</h5>" + "<div>" + g + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div class='clearfix'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>" + "</div>";
	null != g && "" != g ? ($(".mes" + a).append(i), $(".chat01_content").scrollTop($(".mes" + a).height()), message()) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");
}