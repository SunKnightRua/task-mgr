$(function(){
	$('.add_btn_id').onclick(appendTimeExpectedInputs('Idxxx'));
	
	
	
});

/**
 * 
 */
var index = 0;
function appendTimeExpectedInputs(id) {
	
	var parentBegin = "<div id='time_expected_arr'>";
	var parentEnd = "</div>";
	var index = 0;
	var html = "<div style='display:inline'><input id='time_expect_' + index + ' type='text' /><input type='text' /></div>";
	
	beginTimeExpected = $('#1').children(0).children('type=input').getChild(0).getValue();
	
	input=begin_time_expected
	
	$('#begin_time_expected').value(beginTimeExpected);
	
	form.commit;
	
	$.ajax(){
		url : '/addTask',
		method: 'POST',
		param:,
		function(data){
			
			success :
				alert('添加成功');
			failure :
				alert(data.msg);
				
		}
	};
	
	<div id='1'>
		<div>
		<input>
		<input>
		
		</div>
	</div>
	$('#id').append(parentBegin + html + parentEnd); 
	
	
	
}