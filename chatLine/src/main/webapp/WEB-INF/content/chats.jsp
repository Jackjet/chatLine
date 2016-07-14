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
<script type="text/javascript" src=" ../assets/js/sockjs.min.js"></script>
<script type="text/javascript" src=" ../assets/js/stomp.js"></script>
<script type="text/javascript" src=" ../assets/js/communication.js"></script>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href=" ../assets/css/wysiwyg-editor-s.css" />
<link rel="stylesheet" type="text/css" href=" ../assets/css/wysiwyg-style.css" />
<link rel="stylesheet" type="text/css" href=" ../assets/css/chat.css" />
<script type="text/javascript">
	<%if(request.getSession().getAttribute("eid")!= null){ %>
		eid = <%=request.getSession().getAttribute("eid")%>
	<%}%>
	<%if(request.getSession().getAttribute("id")!= null){ %>
		id = <%=request.getSession().getAttribute("id")%>
	<%}%>
</script>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="../assets/css/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="../assets/css/custom-styles.css" rel="stylesheet" />
<link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body class="keBody" onload="onSalesmanLogin()">
<div class="keTitle">
        <h1 style="font-size: 35px">欢迎您,客服~</h1>
        <div class="opr" style="height: 100px">
        <h1 id = "discon" style="font-size: 20px"><i class="fa fa-twitter fa-fw" id="dis2"></i> 离线</a></h1>
        <h1 id = "con" style="font-size: 20px"><i class="fa fa-tasks fa-fw"></i> 连接</a></h1>
        </div>
        <div class="dropdown-user" style="height: 100px">
        <a href="../salesman/"><i class="fa fa-user fa-fw"></i> 客服列表</a>
        <a href="../salesman/logout/"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
        </div>
        </div>
<div class="kePublic">
<!--html-->
    <div class="content">
        <div class="chatBox">
            <div class="chatLeft">
                <div class="chat01">
                    <div class="chat01_title">
                        <div class="talkTo">
                          	  <h5 id="talkToTitle" >没有选择用户</h5>
                        </div>
                        <a class="close_btn" href="javascript:;"></a>
                    </div>
                    <div class="chat01_content" id ="chat01_content" >
                    </div>
                </div>

                    <div class="chat02_content">
                        <!--<textarea id="textarea"></textarea>-->
                        <div style="width:560px; margin: 0px auto;">
  							<textarea id="editor1" 
  							style="height:93px;background-color:white" name="editor" placeholder="Type your text here...">
  								  
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
                            <a href="../chatc/meslog/">聊天记录</a>
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
                        <ul id = "chat03_content_ul">
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

        <h1 style="font-size:35px;color='white'" text-align="center">软妹心仪客服系统</h1>
        <p class="keTxtP">

        <p class="keTxtP">为您提供最萌的服务</p>
        </div>
</body>
</html>