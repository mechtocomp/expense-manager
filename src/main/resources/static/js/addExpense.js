$(function(){
	
	$('#expenseform').submit(function(event){
		event.preventDefault();
		ajaxPostAddExpense();
	});
});

function ajaxPostAddExpense(){
	
var formData = {
			
			expenseTitle:$('#title').val(),
			category:$('#category').val(),
			amount:$('#amount').val(),
			date:$('#date').val()
	}
	
	$.ajax({
		
		type:'POST',
		contentType:'application/json',
		url:'http://localhost:8080/expense/addexpense',
		data: JSON.stringify(formData),
		dataType:'json',
		success: function(data, status){
			 $('#postresult').html('<p>  ' + data.response + '</p>');
			
		},
		error: function(e){
			alert('error');
			console.log('ERROR',e);
		}
	});

	function resetData(){
		expenseTitle:$('#title').val('');
		category:$('#category').val('');
		amount:$('#amount').val('');
		date:$('#date').val('');
	}
	resetData();
}