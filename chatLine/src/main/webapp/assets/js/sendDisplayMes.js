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
	var 
		b = "../assets/images/img/head/1.png",
		c = "../assets/images/img/head/2.png",
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

function sendByCustomers(){
	var txt = document.getElementById('editor1');
	if (txt.value == '') {
		alert("发送内容不能为空,请输入内容");
	} else if (txt.value != '') {
		var today = new Date();
		var hour = today.getHours();
		var minute = today.getMinutes();
		if (minute < 10) {
			minute = '0' + minute;
		}
		var second = today.getSeconds();
		if (second < 10) {
			second = '0' + second;
		}
		var time = today.toLocaleDateString() + " " + hour + ":" + minute + ":" + second;
		sendChatMes(txt.value);
		$('.chat-alll').append("<ul style='text-align: center;'>" + time + '</ul>' + '<ul class="chat-thread"><li>' + txt.value + '</li></ul>');
		$(".chat-all").scrollTop($(".chat-all")[0].scrollHeight);
		$(".txt").scrollTop($(".txt")[0].scrollHeight);
		//	  							document.getElementById('editor1').value='';
		//	  							document.getElementById('editor1').focus();
		//	  							$('#editor1').val('').trigger("focus");
	}
	
}

function  showBySales(g){
	function h() {
		-1 != g.indexOf("*#emo_") && (g = g.replace("*#", "<img src='img/").replace("#*", ".gif'/>"), h())
	}
	var 
		b = "../assets/images/img/head/1.png",
		c = "../assets/images/img/head/2.png",
		d = "用户3";
	var e = new Date,
	f = "";
	f += e.getFullYear() + "-", f += e.getMonth() + 1 + "-", f += e.getDate() + "  ", f += e.getHours() + ":", f += e.getMinutes() + ":", f += e.getSeconds();
	h();
	var i = "<div class='message clearfix'><div class='user-logo'><img src='" + c + "'/>" + "</div>" + "<div class='wrap-text'>" + "<h5 class='clearfix'>客户</h5>" + "<div>" + g + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div class='clearfix'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>" + "</div>";
	null != g && "" != g ? ($(".mes" + a).append(i), $(".chat01_content").scrollTop($(".mes" + a).height()), message()) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");
}

function showByCustomers(content){
	if (content == '') {
		alert("接收内容为空");
	} else if (content != '') {
		var today = new Date();
		var hour = today.getHours();
		var minute = today.getMinutes();
		if (minute < 10) {
			minute = '0' + minute;
		}
		var second = today.getSeconds();
		if (second < 10) {
			second = '0' + second;
		}
		var time = today.toLocaleDateString() + " " + hour + ":" + minute + ":" + second;
		$('.chat-alll').append("<ul style='text-align: center;'>" + time + '</ul>' + '<ul class="chat-threadd"><li>' + content + '</li></ul>');
		$(".chat-all").scrollTop($(".chat-all")[0].scrollHeight);
		//	  							document.getElementById('editor1').value='';
		//	  							document.getElementById('editor1').focus();
		//	  							$('#editor1').val('').trigger("focus");
	}
	
}