<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <script src="http://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
    <script src="assets/js/stomp.js"></script>
    <script src="assets/js/base64.js"></script>
    <script src="assets/js/jquery-3.0.0.min.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/util.js"></script>
    <script type="text/javascript">
        var stompClient = null;
        var id = "0";
        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            id = $("#sid").val();
            var rootUrl = getRootURL();
            var socket = new SockJS(rootUrl + '/chatMes');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/cMes/'+id, function(greeting){
                    var mes = JSON.parse(greeting.body);
                    showGreeting(mes.content);
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendChatMes() {
            id = document.getElementById('sid').value;
            console.log(id);
            var did = document.getElementById('did').value;
            console.log(did);
            var content = document.getElementById('content').value;
            console.log(content);
            if(content.length > 990000000){
				alert("信息长度过长");
				console.log("信息长度过长");
            }else{
            	stompClient.send("/app/cMes", {}, JSON.stringify({'content':content,'sid':id,'did':did}));
            }
        }

        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.innerHTML = message;
            response.appendChild(p);
        }
    </script>
</head>
<body onload="disconnect()">
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
	<label>Sid</label><input type="text" id="sid" /><br/>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>Content</label><input type="text" id="content" /><br/>
        
        <label>Did</label><input type="text" id="did" /><br/>
        <button id="sendChatMes" onclick="sendChatMes();">Send</button>
        <p id="response"></p>
    </div>
</div>
</body>
</html>