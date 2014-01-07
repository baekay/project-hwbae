$('#testform').submit(function(){
	return false;
});

$(document).ready(function(){
	
});

$('#sendBtn').click(function(){
	
	var accessToken = $('#accessToken').val();
	
	var url = $('#reqUrl').val();
	if ( !url) {
		alert("API URL을 입력하세요");
		$('#reqUrl').focus();
		return false;
	}
	var method = $("#reqMethod option:selected").val()
	var message = $('#sendMessage').val();
	
	if ( method=="POST" && !message) {
		alert("request message를 입력하세요 ");
		$('#sendMessage').focus();
		return false;
	}
	
	$('#statusCode').val('');
	$('#responseMessage').val('');
	
	$.ajax({
		url : url,
		type: method,
		dataType: "json",
		data: message,
		contentType: "application/json",
		headers:{"access_token":accessToken},
		complete:function(res,status){
			var statusCode = res.status;
			var resMsg = res.responseText;
			$('#statusCode').val(statusCode);
			$('#responseMessage').val(resMsg);
		}
		
	});
});