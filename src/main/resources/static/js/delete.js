$(function() {

	$(document).on('click', '.delete', function() {

		var rowEl = $(this).closest('tr');
		var uid = rowEl.find('.delete').attr('id');
		ajaxDeleteExpense(uid);
	});

});

function ajaxDeleteExpense(uid) {

	var id = parseInt(uid);
	ajaxurl = 'http://localhost:8080/expense/' + id;

	console.log(uid);
	console.log(id);

	$.ajax({

		type : 'DELETE',
		contentType : 'application/json',
		url : ajaxurl,
		success : function(status) {
			if (status == 'OK') {
				window.location
						.replace("http://localhost:8080/allExpense.html");
			}
		},
		error : function(e) {
			alert('error');
			console.log('ERROR', e);
		}
	});

}