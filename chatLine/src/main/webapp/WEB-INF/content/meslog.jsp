<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>聊天记录</title>
   <script src="../assets/js/jquery-3.0.0.min.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../assets/js/util.js"></script>
    <script src="../assets/js/jQuery.md5.js"></script>
    <script src="../assets/js/salesmanDisplay.js"></script>
    <script src="../assets/js/communication.js"></script>
    <script type="text/javascript">
		<%if(request.getSession().getAttribute("id")!= null){ %>
			id = <%=request.getSession().getAttribute("id")%>
		<%}%>
	</script>
	<link href="../assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../assets/css/salesman.css" rel="stylesheet" type="text/css" media="all" />

</head>

<body  onload="loadChatMesLog()" background="../assets/images/bk.jpg">

	 <div class="container" style="position:absolute;left:200px;top:200px">
		<h1 ><img src=" ../assets/images/log.png" style="height: 65px" alt="聊天记录"/></h1>
		<table id="showChatMesLog" class="table  table-bordered table-hover table-condensed">
		
		</table>
	</div> 
</body>
</html>
