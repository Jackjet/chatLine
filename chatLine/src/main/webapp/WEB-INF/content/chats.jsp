<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>客服</title>
<script type="text/javascript" src="../assets/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../assets/js/wysiwyg.js"></script>
<script type="text/javascript" src=" ../assets/js/wysiwyg-editor.js"></script>
<script type="text/javascript" src=" ../assets/js/wysiwyg-bind.js"></script>

<script type="text/javascript" src=" ../assets/js/sendDisplayMes.js"></script>
<script type="text/javascript" src=" ../assets/js/chat.js"></script>
<script type="text/javascript" src=" ../assets/js/util.js"></script>
<script src="http://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script type="text/javascript" src=" ../assets/js/stomp.js"></script>
<script type="text/javascript" src=" ../assets/js/communication.js"></script>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href=" ../assets/css/wysiwyg-editor-s.css" />
<link rel="stylesheet" type="text/css" href=" ../assets/css/wysiwyg-style.css" />
<link rel="stylesheet" type="text/css" href=" ../assets/css/chat.css" />
</head>
<body class="keBody" onload="connect()">
<h1 class="keTitle">欢迎您,客服</h1>
<div class="kePublic">
<!--html-->
    <div class="content">
        <div class="chatBox">
            <div class="chatLeft">
                <div class="chat01">
                    <div class="chat01_title">
                        <ul class="talkTo">
                            <li><a href="javascript:;">用户3</a></li></ul>
                        <a class="close_btn" href="javascript:;"></a>
                    </div>
                    <div class="chat01_content">
                        <div class="message_box mes1">
                        </div>
                        <div class="message_box mes2">
                        </div>
                        <div class="message_box mes3" style="display: block;">
                        </div>
                        <div class="message_box mes4">
                        </div>
                        <div class="message_box mes5">
                        </div>
                        <div class="message_box mes6">
                        </div>
                        <div class="message_box mes7">
                        </div>
                        <div class="message_box mes8">
                        </div>
                        <div class="message_box mes9">
                        </div>
                        <div class="message_box mes10">
                        </div>
                    </div>
                </div>
                    <div class="chat02_content">
                        <!--<textarea id="textarea"></textarea>-->
                        <div style="width:560px; margin: 0px auto;">
  							<textarea id="editor1" style="height:93px;background-color:white" name="editor" placeholder="Type your text here...">
  								  
  							</textarea>
						</div>
						<div style="width:860px; margin: 30px auto;visibility: hidden;">
							<div style="color:#aa0000;font-weight:bold">Raw wysiwyg.js-editor (no jQuery, no CSS):</div>
							<div id="editor0" style="padding:5px;border:1px dashed black">
						</div>
					</div>
				</div>
                    <div class="chat02_bar">
                        <ul>
                            <li style="right: 5px; top: 5px;">
                            <a href="javascript:;"><img src=" ../assets/images/img/send_btn.jpg"/></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="chatRight">
                <div class="chat03">
                    <div class="chat03_title">
                        <label class="chat03_title_t"> 联系人</label>
                    </div>
                    <div class="chat03_content">
                        <ul>
                            <li id="user1">
                                <label class="online">
                                </label>
                                <a href="javascript:;">
                                    <img src=" ../assets/images/img//head/2.png"/></a><a href="javascript:;" class="chat03_name">用户1 </a>
                            	<div id="newmes1"></div>
                            </li>
                            <li id="user2">
                                <label class="offline">
                                </label>
                                <a href="javascript:;">
                                    <img src=" ../assets/images/img//head/2.png"/></a><a href="javascript:;" class="chat03_name">用户2</a>
                            	<div id="newmes2"></div>
                            </li>
                            <li  id="user3" class="choosed">
                                <label class="offline">
                                </label>
                                <a href="javascript:;">
                                    <img src=" ../assets/images/img//head/2.png"/></a><a href="javascript:;" class="chat03_name">用户3</a>
                            	<div id="newmes3"></div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div style="clear: both;">
            </div>
        </div>
    </div>
<!--html-->
</div>
<div class="keBottom">
<p class="keTxtP">1 <a class="keUrl" href="#" target="_blank">蠢静静和傻凯凯</a></p>

<p class="keTxtP">2
<a target="_blank" href="#" class="button red" title="1">3</a></p>
</div>
</body>
</html>