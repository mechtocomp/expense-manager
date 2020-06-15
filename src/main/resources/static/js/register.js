$(function(){
	
	$('#registerform').submit(function(event){
		event.preventDefault();
		ajaxPostRegister();
	});
});

function ajaxPostRegister(){
	
	var formData = {
			
			firstName:$('#firstName').val(),
			lastName:$('#lastName').val(),
			email:$('#email').val(),
			password:$('#password').val()
	}
	
	$.ajax({
		
		type:'POST',
		contentType:'application/json',
		url:'http://localhost:8080/user',
		data: JSON.stringify(formData),
		dataType:'json',
		success: function(result){
			$('#postresult').html('<p> WELCOME ' + result.firstName + '</p>');
		},
		error: function(e){
			alert('error');
			console.log('ERROR',e);
		}
	});
	
	function resetData(){
		$('#firstName').val('');
		$('#lastName').val('');
		$('#email').val('');
		$('#password').val();
	}
	resetData();
}
