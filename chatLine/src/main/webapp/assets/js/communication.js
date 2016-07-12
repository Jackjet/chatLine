/**
 * 
 */
var id = 1;
var eid = -1;
var did=1;
var stompClient = null;
function connect() {
    var rootUrl = getRootURL();
    var socket = new SockJS(rootUrl + '/chatMes');
    stompClient = Stomp.over(socket);
    alert("连接中...");
    stompClient.connect({"eid":eid}, function(frame) {
        alert("已连接上");
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/cMes/'+id, function(greeting){
            var mes = JSON.parse(greeting.body);
            greeting.ack();
            var secondURL = getSecondURL();
			if(secondURL=='chats'){
				showBySales(mes);
			}else if (secondURL=='chatc'){
				showByCustomers(mes);
			}
        });
    },function(){alert("已断线");});
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