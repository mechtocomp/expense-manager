$(function() {

	$('#logout').click(function(event) {
		event.preventDefault();
		ajaxPostLogin();
	});
});

function ajaxPostLogin() {

	$.ajax({

		type : 'GET',
		contentType : 'application/json',
		url : 'http://localhost:8080/user/logout',
		success : function(result) {
			if (result == 'OK') {
				window.location.replace("http://localhost:8080/index.html");
			}

		},
		error : function(e) {
			alert('error');
			console.log('ERROR', e);
		}
	});
}