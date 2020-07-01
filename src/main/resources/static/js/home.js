$(function() {
  
  
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url : 'http://localhost:8080/expense/expenditure',
				success : function(data, status) {
						
						if(data.expenditure != null){
							
							$('#addTable').html('<table border="1" class="center">\
									<thead>\
									<tr align="center">\
										<th>Month & Year</th>\
										<th>Expenses (Rs)</th>\
									</tr>\
								</thead>\
								<tbody>\
\
								</tbody>\
							</table>');
						
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
									<td><h4>Total Expenditure</h4>	</td>\
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
              
              
              
              
              
              
              
						}else{
							$('#noExpenditure').html('<p>'+data.noExpense+'</p>');
						}	

				},		
				error : function(e) {
					alert('error');
					console.log('ERROR', e);
				}
			});
  
  
  
  
  
  
  

	

});