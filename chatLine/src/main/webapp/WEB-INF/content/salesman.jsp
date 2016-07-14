<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>客服管理</title>
   <script src="../assets/js/jquery-3.0.0.min.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../assets/js/util.js"></script>
    <script src="../assets/js/jQuery.md5.js"></script>
    <script src="../assets/js/salesmanDisplay.js"></script>
	<link href="../assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../assets/css/salesman.css" rel="stylesheet" type="text/css" media="all" />

</head>

<body  onload="loadAllSalesmen()" background="../assets/images/icon/bg.jpeg">

	 <div class="container">
		<h1 ><img src=" ../assets/images/icon/kefu.jpg" alt="客服列表"/></h1>
		<div class="modal fade" id="myModal" 
			tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog  white-bg">
			         <div class="modal-header">
			         
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	           
	            <h4 class="modal-title" id="myModal-title">
	            </h4>
	            
			</div>
			
			<div class="modal-body" id="myModal-body">
			</div>
			
			<div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" id="myModal-comfirm-button">确定</button>
         </div>
      </div>
		</div>
		<table id="showAllSalesmen" class="table  table-bordered table-hover table-condensed">
		
		</table>
		<form>
			<h4><img src=" ../assets/images/icon/add.jpg" width="120px" height="50px" alt="添加客服"/></h4>
			<label><img src=" ../assets/images/icon/name.jpg" width="60px" height="25px" alt="昵称"/></label><input type="text" name="name" id="newname"/>
			<label><img src=" ../assets/images/icon/psd.jpg" width="60px" height="25px" alt="密码"/></label><input type="password" name="password" id="newpassword"/>
			<label>手机</label><input type="text" name="phone" id="newphone"/>
			<button type="button" autofocus="autofocus" onclick="addNewSalesman()"><img src=" ../assets/images/icon/btn.jpg" width="75px" height="35px" alt="确定"></button>
		</form>
	</div> 
</body>
</html>
