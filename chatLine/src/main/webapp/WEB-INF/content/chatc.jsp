<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="chrome=1"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
		<title>客户</title>
		<script type="text/javascript" src="../assets/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="../assets/js/wysiwyg.js"></script>
		<script type="text/javascript" src=" ../assets/js/wysiwyg-editor.js"></script>
		<script type="text/javascript" src=" ../assets/js/wysiwyg-bind.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../assets/js/lanrenzhijia.js"></script>
		
		<script type="text/javascript" src="../assets/js/changetheme.js"></script>
		<script type="text/javascript" src=" ../assets/js/sendDisplayMes.js"></script>
		<script type="text/javascript" src=" ../assets/js/chat.js"></script>
		<script type="text/javascript" src=" ../assets/js/util.js"></script>
		<script src="http://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
		<script type="text/javascript" src=" ../assets/js/stomp.js"></script>
		<script type="text/javascript" src=" ../assets/js/communication.js"></script>
		<script type="text/javascript">
			<%if(request.getSession().getAttribute("eid")!= null){ %>
				eid = <%=request.getSession().getAttribute("eid")%>
			<%}%>
			<%if(request.getSession().getAttribute("id")!= null){ %>
				id = <%=request.getSession().getAttribute("id")%>
			<%}%>
		</script>
		
		<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
		<link href="../assets/css/style.css" type="text/css" rel="stylesheet" media="screen"/>
		<link href="../assets/css/lanrenzhijia.css" type="text/css" rel="stylesheet" />
		<link href="../assets/css/wysiwyg-editor.css" type="text/css" rel="stylesheet" />
		<link href="../assets/css/reset.css" rel="stylesheet"/>
		<link href="../assets/css/normalize.css" rel="stylesheet"/>
		<link href="../assets/css/wysiwyg-style.css" rel="stylesheet"/>

		<!-- github.io delivers wrong content-type - but you may want to include FontAwesome in 'wysiwyg-editor.css' -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"/>
		
	</head>

	<body onload="connect()">


		<div class="page-container">
			<div class="container" style="position: relative">
				<div class="marketing">
				</div>
				<br />
				<div class="row">
					<div class="span10">
						<div class="responsive">
							<div class="text-center">
								<button class="demo btn btn-primary btn-large" onclick="show()" data-toggle="modal" href="#drag">询问客服</button>
							</div>
						</div>
						<br />
					</div>
				</div>
			</div>

			<script>
				function show()
				{
					var drag = document.getElementById('drag');
					drag.style.visibility='visible';
				}
			</script>

			
			<script>
				function hide()
				{
					var drag = document.getElementById('drag');
					drag.style.visibility='hidden';
				}
			</script>
			
			<script type="text/javascript">
            function changef(){
            	var backtheme=document.getElementById("backtheme");
            	backtheme.style.visibility="hidden";
            }
            </script>


			<div id="drag" class="modal hide fade" tabindex="-1" data-width="760">
			<div id="backtheme">
				<div class="row-fluid">
					<div style="position:absolute;right: 0;margin: 0 5px 5px 0px;">
						<h4 onclick="changef()">x</h4>
					</div>
				    <div style="position: absolute;left: 0;right: auto;margin: 20px 20px 20px 20px;">
				    <p>
				    	<img src="../assets/images/bk1.jpg" style="width: 100px;height: 100px;" onclick="changetheme1()">
				    	<img src="../assets/images/bk2.jpg" style="width: 100px;height: 100px;" onclick="changetheme2()">
				    	<img src="../assets/images/bk2-1.jpg" style="width: 100px;height: 100px;" onclick="changetheme3()">
				    </p>
				    <p>
				    	<img src="../assets/images/bk5.jpg" style="width: 100px;height: 100px;" onclick="changetheme4()">
				    	<img src="../assets/images/bk6-1.jpg" style="width: 100px;height: 100px;" onclick="changetheme5()">
				    	<img src="../assets/images/bk7-1.jpg" style="width: 100px;height: 100px;" onclick="changetheme6()">
				    </p>
				    </div>
				</div>			
			</div>
				<div id="wrap">
					<div style="clear:both">
						<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
						<script src="/follow.js" type="text/javascript"></script>
					</div>
					<div id="whale"></div>
					<script src="../assets/js/whale.js"></script>
				</div>
				<div class="title">
					<h4>与客服对话中</h4>
					<div>
						<a class="min" href="javascript:;" title="最小化"></a>
						<a class="max" href="javascript:;" title="最大化"></a>
						<a class="revert" href="javascript:;" title="还原"></a>
						<a class="close" href="javascript:;" title="关闭"></a>
					</div>
				</div>
				<div class="resizeL"></div>
				<div class="resizeT"></div>
				<div class="resizeR"></div>
				<div class="resizeB"></div>
				<div class="resizeLT"></div>
				<div class="resizeTR"></div>
				<div class="resizeBR"></div>
				<div class="resizeLB"></div>
				<!--<script language="javascript">
				var now=new Date();
				document.write(now.year()+"-"+now.month()+"-"+now.day()+" "+now.hour()+":"+now.minute()+":"+now.second());
				</script>-->
				<!--<script type="text/javascript">
 					var today = new Date();
 					var hour = today.getHours();
 					var minute = today.getMinutes();
 					var second = today.getSeconds();
					document.write(today.toLocaleDateString()+" "+hour+":"+minute+":"+second);
				</script>-->
				<div class="content">

					<div class="row-fluid">
						<div class="span8" >
							<div class="chat-all" id="chat" style="margin:10px 10px 0 10px;">
								<div class="chat-alll">
									<div id="convo " data-from="Sonu Joshi ">
									</div>
								</div>
							</div>
						</div>
						<div class="span4">
							<img src="../assets/images/adward15_fuben.jpg" style="width: 25%; position: absolute;height: 300px;  margin: 24px auto 0 auto;
  padding: 0 20px 0 0;" />
						</div>
						<br></br>
					</div>
				</div>
				<div class="row-fluid">
					<div class="footer" style="position: absolute;left:0;width:100%;margin: 42px 0 0 0;">
						<div class="span8">
						<div style="width:90%; margin: 0 30px 0;">
							<textarea id="editor1" name="editor" style="height: 50px;" placeholder="Type your text here..."></textarea>

							<p>
								<button type="button" onclick="hide()"
								 style="background-image: url(../assets/images/bt_1_close.png);background-size: 100% 100%;width:54px;height:30px"></button>
								<button id="btn" type="button" onclick= "send()" 
								style="background-image: url(../assets/images/bt_2_send.png);background-size: 100% 100%;width:54px;height:30px" ></button>
								<span8>
								<button id="themebtn" type="button" 
									style="position:relative;right:0;background-image: url(../assets/images/bt_3_purple.png);background-size: 100% 100%;width:82px;height:30px"></button>
								<button type="button" style="background-image:url(../assets/images/bt_1_1.jpg);background-size:100% 100%;width:82px;height:30px;" onclick="window.open('meslog/')"></button>	
								</span8>
							</p>
							<script type="text/javascript">var themebtn = document.getElementById("themebtn");
themebtn.onclick = function() {
	var backtheme = document.getElementById("backtheme");
	backtheme.style.visibility = 'visible';
}</script>
						</div>
						</div>
												<div class="span4">
							<img src="../assets/images/zhenguang_fuben_fuben.png" style="width: 25%; position: absolute;height: 150px;  margin: 0 auto 0 auto;
  padding: 0 20px 0 0;" />
						</div>
						
					</div>
					</div>
				</div>

			</div>

		</div>
		
		<div style="text-align:center;clear:both">
			<script src="gg_bd_ad_720x90.js" type="text/javascript"></script>
			<script src="follow.js" type="text/javascript"></script>
		</div>
		<iframe frameborder="0" scrolling="no" src="../star.jsp" width="100%" height="500px"></iframe>
		
		<div style="width:860px; margin: 30px auto;visibility: hidden;">
			<div style="color:#aa0000;font-weight:bold">Raw wysiwyg.js-editor (no jQuery, no CSS):</div>
			<div id="editor0" style="padding:5px;border:1px dashed black">
			</div>
		</div>
	</body>
</html>