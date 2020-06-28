$(function() {

	
		
		ajaxAllExpenses();
	
});

function ajaxAllExpenses() {

	$.ajax({

		type : 'GET',
		contentType : 'application/json',
		url : 'http://localhost:8080/expense/allExpense',
		success : function(data, status) {
			var tbody = $('tbody');
			tbody.html('');
			
			

			$.each(data, function(key, value) {

				if (value.amount === 0) return;
				tbody.append(' \
						<tr align="center">\
							<td>'
						+ value.expenseTitle + 
						 '</td>\
							<td>' + value.category +
						 '</td>\
						<td>' + value.amount +
						 '</td>\
						<td>' + value.date +
						 '</td>\
						</tr>');

			})

		},
		error : function(e) {
			alert('error');
			console.log('ERROR', e);
		}
	});

}