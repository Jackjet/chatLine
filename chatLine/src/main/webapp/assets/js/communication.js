/**
 * 
 */
var id ;
var eid;
var did;
var stompClient = null;
var name = "";
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
						showBySales(mes.content);
					}else if (secondURL=='chatc'){
						showByCustomers(mes.content);
					}
		        });
		    },function(){alert("已断线");});
		},
		error:function(){alert("无法连接到服务器");}
	});
    
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