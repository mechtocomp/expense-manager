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
		url:'http://localhost:8080/user/addexpense',
		data: JSON.stringify(formData),
		dataType:'json',
		success: function(data, status){
			 $('#postresult').html('<p>  ' + data.response + '</p>');
			alert(status);
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