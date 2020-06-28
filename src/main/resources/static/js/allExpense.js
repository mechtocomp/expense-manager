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
							<td class="expenseTitle">'
						+ value.expenseTitle + 
						 '</td>\
							<td class="category">' + value.category +
						 '</td>\
						<td class="amount">' + value.amount +
						 '</td>\
						<td class="date">' + value.date +
						 '</td>\
						<td> <input type="button" id='+value.id+'  value="Edit" class="edit"></td>\
						<td> <input type="button" id='+value.id+'  value="Delete" class="delete"></td>\
						</tr>');

			})

		},
		error : function(e) {
			alert('error');
			console.log('ERROR', e);
		}
	});

}