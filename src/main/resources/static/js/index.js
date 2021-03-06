$(function() {

	$('#loginform').submit(function(event) {
		event.preventDefault();
		ajaxPostLogin();
	});
});

function ajaxPostLogin() {
	
	

	var formData = {

		email : $('#email').val(),
		password : $('#password').val()
	}

	$.ajax({

		type : 'PUT',
		contentType : 'application/json',
		url : 'http://localhost:8080/user/login',
		data : JSON.stringify(formData),
		dataType : 'json',
		success : function(data,status) {
			if (data.emailError === 'invalid email') {
				$('#emailError').html('<p>invalid email</p>')
			}else if (data.passwordError === 'invalid password') {
				$('#passwordError').html('<p>invalid password</p>')
			}else if (data.result === 'okay') {
				window.location.replace("http://localhost:8080/home.html");
			}

		},
		error : function(e) {
			alert('error');
			console.log('ERROR', e);
		}
	});

	function resetData() {
		$('#firstName').val('');
		$('#lastName').val('');
		$('#email').val('');
		$('#password').val();
	}
	resetData();
}