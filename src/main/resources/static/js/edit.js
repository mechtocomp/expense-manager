var uid;
var id;

$(function() {

	$(document).on('click', '.edit', function() {

		var rowEl = $(this).closest('tr');
	    uid = rowEl.find('.edit').attr('id');
		
		var expenseTitle= rowEl.find('.expenseTitle').text();
		var category= rowEl.find('.category').text();
		var amount= rowEl.find('.amount').text();
		var date= rowEl.find('.date').text();
		
		//console.log(expenseTitle,category,amount,date);
		
		ajaxUpdateExpense(expenseTitle,category,amount,date,uid);	
		
		//ajaxSubmitUpdate(uid);
		
	});

});



function ajaxUpdateExpense(expenseTitle,category,amount,date,uid){
	
	var id = parseInt(uid);
	
	
	//for appending first add a div
	var tbody = $('#appendForm');
	tbody.html('');
	
	//add form in one row
	tbody.append('\
			<form id="updateForm">\
				Expense Title: <input type="text" id="title" name="title" value='+expenseTitle+' required>&nbsp\
				Category: <input type="text" id="category" name="category" value='+category+' required>&nbsp\
				Amount: <input type="number" id="amount" name="amount" value='+amount+' required  >&nbsp\
				Date: <input type="date" id="date" name="date" value='+date+' required>&nbsp &nbsp\
				<input type="submit" id="submitUpdate">\
			</form>\
			');
	
	
	
	
	$(document).on('click', '#submitUpdate', function() {

		 ajaxSubmitUpdate();
	});
	
	
	function ajaxSubmitUpdate(){
	
		var formData = {
				
				expenseTitle:$('#title').val(),
				category:$('#category').val(),
				amount:$('#amount').val(),
				date:$('#date').val()
			}
		
		
		$.ajax({
		
		type:'PUT',
		contentType:'application/json',
		url:'http://localhost:8080/expense/'+id,
		data: JSON.stringify(formData),
		dataType:'json',
		success: function(data, status){
			if (status == 'OK') {
				window.location.replace("http://localhost:8080/allExpense.html");
			}
			
		},
		error: function(e){
			alert('error');
			console.log('ERROR',e);
		}
	});
	
	}
	
	
}