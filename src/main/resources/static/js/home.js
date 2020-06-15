$(function() {

	$.ajax({

		type : 'GET',
		contentType : 'application/json',
		url : 'http://localhost:8080/user/dashboard',
		success : function(data, status) {
			var tbody = $('tbody');
			tbody.html('');

			$.each(data, function(key, value) {
				//console.log(key + ": " + value);

				tbody.append(' \
						<tr align="center">\
							<td>'
						+ key + '</td>\
							<td>' + value
						+ '</td>\
						</tr>');

			})

		},
		error : function(e) {
			alert('error');
			console.log('ERROR', e);
		}
	});

});