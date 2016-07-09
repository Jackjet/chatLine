/**
 * 
 */
var sid = 1;
var did = 1;
var stompClient = null;
function connect() {
    var rootUrl = getRootURL();
    var socket = new SockJS(rootUrl + '/chatMes');
    stompClient = Stomp.over(socket);
    alert("连接中...");
    stompClient.connect({}, function(frame) {
        alert("已连接上");
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/cMes/'+sid, function(greeting){
            var mes = JSON.parse(greeting.body);
            var secondURL = getSecondURL();
			if(secondURL=='chats'){
				showBySales(mes.content);
			}else if (secondURL=='chatc'){
				showByCustomers(mes.content);
			}
        });
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
    	stompClient.send("/app/cMes", {}, JSON.stringify({'content':content,'sid':sid,'did':did}));
    }
}