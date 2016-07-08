/**
 * 
 */

function showAllSalesmen(data){
	var content = "<thead><tr><th>ID</th><th>昵称</th><th>操作</th></tr></thead><tbody>";
	for(var i = 0;i < data.length;i++){
		var str = "<td>"+data[i].id+"</td><td>"+data[i].name+"</td>";
		str += "<td> <div class='btn-group'>"
		str += "<button type='button' class='btn btn-default' onclick='showChangeSalesmanNameDialog("+data[i].id+")' >修改昵称</button>";
		str += "<button type='button' class='btn btn-default' onclick='showChangeSalesmanPasswordDialog("+data[i].id+")' >重置密码</button>";
		str += "<button type='button' class='btn btn-default' onclick='deleteSalesman("+data[i].id+")' >删除</button>";
		str += "</td></div>"
		content = content +"<tr>"+ str + "</tr>";
	}
	content += "</tbody>";
	$("#showAllSalesmen").html(content);
}

function loadAllSalesmen(){
	$.ajax({url:"findAll",success:function(data){showAllSalesmen(data);},error:function(){alert("无法获取客服列表");}});
}
function refresh(){
	loadAllSalesmen();
}
function changeSalesmanName(id){
	var name = $("#myModal-name").val();
	if(name.length==0){
		alert("昵称不能为空");
	}else{
		$.ajax({
			type:"post",
			url:"update",
			data:{
				"id":id,
				"name":name
			},
			success:function(data){
				if(data="true"){
					alert("修改成功");
					$("#myModal").modal("hide");
				}
				refresh();
			},
			error:function(){alert("修改昵称失败");}
		});
	}
}

function showChangeSalesmanNameDialog(id){
	$("#myModal-body").html("<label>新昵称</label><input type='text' class='form-control' id='myModal-name'/>");
	$("#myModal-comfirm-button").click(
			function(){
				changeSalesmanName(id);
			}
	);
	$("#myModal-title").html("修改昵称");
	$("#myModal").modal("show");
}
function changeSalesmanPassword(id){
	var psw = $("#myModal-password").val();
	if(psw.length==0){
		alert("密码不能为空");
	}else{
		var password = psw;
		$.ajax({
			type:"post",
			url:"update",
			data:{
				"id":id,
				"password":password
			},
			success:function(data){
				if(data=="true"){
					alert("修改成功");
					$("#myModal").modal("hide");
				}
				refresh();
			},
			error:function(){alert("修改密码失败");}
		});
	}
}
function showChangeSalesmanPasswordDialog(id){
	$("#myModal-body").html("<label>新密码</label><input type='password' class='form-control' id='myModal-password'/>");
	$("#myModal-comfirm-button").click(
			function(){
				changeSalesmanPassword(id);
			}
	);
	$("#myModal-title").html("修改密码");
	$("#myModal").modal("show");
}
function deleteSalesman(id){
	alert("操作正在进行,请稍后...");
	$.ajax({
		type:"post",
		url:"delete",
		data:{
			"id":id,
		},
		success:function(data){
			if(data=="true"){
				alert("删除成功");
			}
			refresh();
		},
		error:function(){alert("删除失败");}
	});
}
function addNewSalesman(){
	alert("操作正在进行,请稍后...");
	var name = $("#newname").val();
	var password = $("#newpassword").val();
	if(password.length == 0 || name.length==0){
		alert("属性不能为空");
	}else{
		$.ajax({
			type:"post",
			url:"add",
			data:{
				"name":name,
				"password":password,
			},
			success:function(data){
				data = arguments[2].responseText;
				if(data=="success"){
					alert("添加成功");
					refresh();
				}else if(data=="duplicateName"){
					alert("昵称重复");
				}
			},
			error:function(){alert("添加失败");}
		});
	}
}