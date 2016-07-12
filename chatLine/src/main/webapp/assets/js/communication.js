/**
 * 
 */
var id ;
var eid;
var did;
function connect() {
    if(id == undefined){
    	id = -1;
    }
    if(did == undefined){
    	did = -1;
    }
    if(eid == undefined){
    	eid = -1;
    }
    $.ajax({
		type:"post",
		url:"../connect",
		data:{
			"id":id,
			"eid":eid,
			"name":name
		},
		success:function(data){
		    var rootUrl = getRootURL();
		    var socket = new SockJS(rootUrl + '/chatMes');
			id = data.id;
			did = data.did;
			stompClient = Stomp.over(socket);
		    alert("连接中...");
		    stompClient.connect({"id":id},function(frame) {
		        alert("已连接上");
		        console.log('Connected: ' + frame);
		        stompClient.subscribe('/topic/cMes/'+id, function(greeting){
		            var mes = JSON.parse(greeting.body);
		            var secondURL = getSecondURL();
					if(secondURL=='chats'){
						showBySales(mes);
					}else if (secondURL=='chatc'){
						showByCustomers(mes);
					}
		        });
		    },function(){alert("已断线");});
		},
		error:function(){alert("无法连接到服务器");}
	});
}

function showChatMesLog(data){
	var content="<thead><tr><th>发送方</th><th>时间</th><th>内容</th></tr></thead><tbody>";
	for(var i = 0;i < data.length;i++){
		var today = new Date(data[i].time);
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
		if(data[i].sid==id)
			{
				var str = "<td>客户</td><td>"+time+"</td><td>"+data[i].content+"</td>";
			}
		else
			{
			var str = "<td>客服</td><td>"+time+"</td><td>"+data[i].content+"</td>";
			}
		content = content+"<tr>"+str+"</tr>";
	}
	content+="</tbody>";
	$("#showChatMesLog").html(content);

	
}

function loadChatMesLog(){
	$.ajax({type:"post",url:"../findLog/",data:{"sid":id},success:function(data){showChatMesLog(data);},error:function(){alert("无法获取聊天记录");}});
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    alert("已断线");
    console.log("Disconnected");
}

function sendChatMes(content) {
    if(content.length > 990000000){
		alert("信息长度过长");
		console.log("信息长度过长");
    }else{
    	stompClient.send("/app/cMes", {}, JSON.stringify({'content':content,'sid':id,'did':did}));
    }
}