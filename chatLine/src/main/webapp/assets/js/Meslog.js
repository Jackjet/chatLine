function MesLog(did){
	$.ajax({url:"findBySidOrDid(did)",success:function(data){getMeslog(data);},error:function(){alert("无法获取聊天记录");}});
	
}