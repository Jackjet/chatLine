
/**
 * 
 */
function editorClear(){
	$(".wysiwyg-editor").text("");
	$("#editor1").text("");
}

function onSalesmanLogin(){
	if(eid==undefined || eid == -1){
		window.location.href="../salesman/logins/";
	}else{
		connect();
	}
}

function send(){
	var secondURL = getSecondURL();
	if(secondURL=='chats'){
		sendBySales();
	}else if (secondURL=='chatc'){
		sendByCustomers();
	}
	editorClear();
}

function ifcdis()
{
	alert("用户已断开连接");
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
	var i = "<div class='message clearfix'><div class='user-logo'><img src='" + b + "'/>" + "</div>" + "<div class='wrap-text'>" + "<h5 class='clearfix'>客服</h5>" + "<div>" + g + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div class='clearfix'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>" + "</div>";
	null != g && "" != g ? ($(".mes" + did).append(i), $(".chat01_content").scrollTop($(".mes" + did).height())) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");
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
		// $(".txt").scrollTop($(".txt")[0].scrollHeight);
		// document.getElementById('editor1').value='';
		// document.getElementById('editor1').focus();
		// $('#editor1').val('').trigger("focus");
	}
	
}

function ifcdis()
{
	
	/*
	 * var editor1 = document.getElementById("editor1"); editor1.style.disabled =
	 * "disabled";
	 * 
	 * var editor2 = document.getElementByClassName("wysiwyg-editor");
	 * editor2.style.disabled = "disabled";
	 */
	alert("该用户已断线");
	}

function  showBySales(g){
	if(g.result =="DISCONNECTED"){
		$("#clabel"+g.id).removeClass("online");
		$("#clabel"+g.id).addClass("offline");
		ifcdis();
	}
	else{
		$("#clabel"+g.id).removeClass("offline");
		$("#clabel"+g.id).addClass("online");
	 var audioElement = document.createElement('audio');
     audioElement.setAttribute('src', '../assets/gun.mp3');
     audioElement.setAttribute('autoplay', 'autoplay');
     $.get();
     audioElement.addEventListener("load", function() {
         audioElement.play();
     }, true);
     function h() {
 		-1 != g.content.indexOf("*#emo_") && (g.content = g.content.replace("*#", "<img src='img/").replace("#*", ".gif'/>"), h())
 	}
	var 
		b = "../assets/images/img/head/1.png",
		c = "../assets/images/img/head/2.png",
		d = "用户3";
	var e = new Date,
	f = "";
	if(id==g.did){
		f += e.getFullYear() + "-", f += e.getMonth() + 1 + "-", f += e.getDate() + "  ", f += e.getHours() + ":", f += e.getMinutes() + ":", f += e.getSeconds();
		h();
		audioElement.play();
		newM++;
		var n = "<span class='jquery-accordion-menu-label'>" + newM + "</span></li>";
		var i = "<div class='message clearfix'><div class='user-logo'><img src='" + c + "'/>" + "</div>" + "<div class='wrap-text'>" + "<h5 class='clearfix'>用户</h5>" + "<div>" + g.content + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div class='clearfix'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>" + "</div>";
		if($("#newmes"+g.sid).length == 0){
			$("#chat03_content_ul").append("<li id='user"+g.sid + "'><input hidden value='" + g.sid + "'></input><label id='clabel"+g.sid+"' class='online'></label><img src='../assets/images/img//head/2.png'><p class='chat03_name'>用户"+g.sid+"</p><div style='display: block;' id='newmes"+g.sid+"'><span class='jquery-accordion-menu-label'>1</span></div></li>");
			$("#chat01_content").append("<div class='message_box mes"+g.sid+"'></div>");
			$("#user"+g.sid).mouseover(function() {
				$(this).addClass("hover").siblings().removeClass("hover")
			}).mouseout(function() {
				$(this).removeClass("hover").siblings().removeClass("hover")
			}).attr("onclick","clickUser($(this));")
		}
		if(did != g.sid){$("#newmes"+g.sid).show();}
		null != g && "" != g ? ($("#newmes"+g.sid).append(n),$(".mes"+g.sid).append(i), $(".chat01_content").scrollTop($(".mes"+g.sid).height())) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!");
	}}}

function showByCustomers(content){
	if(content.result=="CONNECTED"){
		alert("客服已上线");
	}else if(content.result=="DISCONNECTED"){
		alert("客服已离线");
	}else{
		if (content.content == '') {
			alert("接收内容为空");
		} else if (content.content != '') {
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
			$('.chat-alll').append("<ul style='text-align: center;'>" + time + '</ul>' + '<ul class="chat-threadd"><li>' + content.content + '</li></ul>');
			$(".chat-all").scrollTop($(".chat-all")[0].scrollHeight);
			// document.getElementById('editor1').value='';
			// document.getElementById('editor1').focus();
			// $('#editor1').val('').trigger("focus");
		}
		$('#editor1').val('').trigger("focus");
	}
}
	