$(function() {

	$.ajax({

		type : 'GET',
		contentType : 'application/json',
		url : 'http://localhost:8080/expense/dashboard',
		success : function(data, status) {
			var tbody = $('tbody');
			tbody.html('');

			$.each(data, function(key, value) {
				
				if(value.amount===0) 
					return;
				tbody.append(' \
						<tr align="center">\
							<td>'
						+ value.monthName+" " + value.year+ '</td>\
							<td>' + value.amount
						+ '</td>\
						</tr>');

			})
			
			
			
			
			$.ajax({

				type : 'GET',
				contentType : 'application/json',
				url : 'http://localhost:8080/expense/expenditure',
				success : function(data, status) {
						
						tbody.append(' \
								<tr align="center">\
									<td>Total Expenditure	</td>\
									<td>' + data.expenditure
								+ '</td>\
								</tr>');	

				},		
				error : function(e) {
					alert('error');
					console.log('ERROR', e);
				}
			});
		},
		error : function(e) {
			alert('error');
			console.log('ERROR', e);
		}
	});

});