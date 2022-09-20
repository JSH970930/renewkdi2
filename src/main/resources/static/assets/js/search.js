$(document).ready(function() {
	$("#chkAll").click(function() {
		if($("#chkAll").is(":checked")) $("input[name=chk]").prop("checked", true);
		else $("input[name=chk]").prop("checked", false);
	});

	$("input[name=chk]").click(function() {
		var total = $("input[name=chk]").length;
		var checked = $("input[name=chk]:checked").length;
		
		if(total != checked) $("#chkAll").prop("checked", false);
		else $("#chkAll").prop("checked", true); 
	});



	$("#chkAll2").click(function() {
		if($("#chkAll2").is(":checked")) $("input[name=chk2]").prop("checked", true);
		else $("input[name=chk2]").prop("checked", false);
	});

	$("input[name=chk2]").click(function() {
		var total = $("input[name=chk2]").length;
		var checked = $("input[name=chk2]:checked").length;

		
		if(total != checked) $("#chkAll2").prop("checked", false);
		else $("#chkAll2").prop("checked", true); 
	});



	$("#chkAll3").click(function() {
		if($("#chkAll3").is(":checked")) $("input[name=chk3]").prop("checked", true);
		else $("input[name=chk3]").prop("checked", false);
	});

	$("input[name=chk3]").click(function() {
		var total = $("input[name=chk3]").length;
		var checked = $("input[name=chk3]:checked").length;

		if(total != checked) $("#chkAll3").prop("checked", false);
		else $("#chkAll3").prop("checked", true); 
	});



	$("#chkAll4").click(function() {
		if($("#chkAll4").is(":checked")) $("input[name=chk4]").prop("checked", true);
		else $("input[name=chk4]").prop("checked", false);
	});

	$("input[name=chk4]").click(function() {
		var total = $("input[name=chk4]").length;
		var checked = $("input[name=chk4]:checked").length;

		if(total != checked) $("#chkAll4").prop("checked", false);
		else $("#chkAll4").prop("checked", true); 
	});
	
    
	
});

$(function(){
    $("#datechk").change (function (){
       var st =this.checked; 
        if(st){
            $("input.ckdate").prop("disabled", true); 
        }
        else{
            $("input.ckdate").prop("disabled", false); 
        }
    });
   
});

				
