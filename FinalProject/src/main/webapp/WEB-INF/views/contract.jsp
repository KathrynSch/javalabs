<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contract</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>


<body onload="load();">
<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">NurseryWebApp</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="../hello/page">Home</a></li>
	      <li><a href="../nursery/page">Nursery</a></li>
	      <li><a href="../child/page">Children</a></li>
	      <li class="active"><a href="../contract/page">Contract</a></li>
	      <li><a href="../reservation/page">Reservation</a></li>
<<<<<<< HEAD
	      <li><a href="../plannedAbsence/page">Planned Absence</a></li>
=======
>>>>>>> b86275096aa85814991302a377690526e9087f3d
	    </ul>
	  </div>
	</nav>

	<div class="container">
        <h3> Child Details </h3>
        <input type="hidden" id="child_id">
        First Name: <input type="text" id="firstName" required="required" name="first_name"><br>
        Last Name: <input type="text" id="lastName" required="required" name="last_name"><br>
        Age: <input type="number" id="age" required="required" name="age"><br>
        
        <h3> Contract Details </h3>
        <input type="hidden" id="contract_id">
        Start Date: <input type="date" id="start_date" name="start_date" placeholder="YYYY-MM-DD"><br>
        End Date: <input type="date" id="end_date" name="end_date" placeholder="YYYY-MM-DD"><br>
        Email: <input type="email" id="email" name="email"><br>
        Phone: <input type="tel" id="phone_nb" name="phone_nb"><br>
        <input type="checkbox" id="is_regular" name="is_regular" onClick="regularOptions();"> Regular contract<br>
        
        <div id="regular">
        <h3> Regular Reservation</h3>
        <input type='hidden' id='reservation_id'>
        Reservation 1:
        <select name ='on_day1' id='on_day1'>
        	<option value='No' selected='selected'>No</option><option value='Monday'>Monday</option><option value='Tuesday'>Tuesday</option><option value='Wednesday'>Wednesday</option><option value='Thursday'>Thursday</option><option value='Friday'>Friday</option>
        	</select><select name='day_period1' id='day_period1'>
        	<option value='AM'>AM</option><option value='PM'>PM</option></select><br>
        Reservation 2:
        <select name ='on_day2' id='on_day2'>
        	<option value='No' selected='selected'>No</option><option value='Monday'>Monday</option><option value='Tuesday'>Tuesday</option><option value='Wednesday'>Wednesday</option><option value='Thursday'>Thursday</option><option value='Friday'>Friday</option></select>
        	<select name='day_period2' id='day_period2'>
        	<option value='AM'>AM</option><option value='PM'>PM</option></select><br>
        Reservation 3:
        <select name ='on_day3' id='on_day3'>
        	<option value='No' selected='selected'>No</option><option value='Monday'>Monday</option><option value='Tuesday'>Tuesday</option><option value='Wednesday'>Wednesday</option><option value='Thursday'>Thursday</option><option value='Friday'>Friday</option></select>
        	<select name='day_period3' id='day_period3'>
        	<option value='AM'>AM</option><option value='PM'>PM</option></select><br>
        Reservation 4:
        <select name ='on_day4' id='on_day4'>
        	<option value='No' selected='selected'>No</option><option value='Monday'>Monday</option><option value='Tuesday'>Tuesday</option><option value='Wednesday'>Wednesday</option><option value='Thursday'>Thursday</option><option value='Friday'>Friday</option></select>
        	<select name='day_period4' id='day_period4'>
        	<option value='AM'>AM</option><option value='PM'>PM</option></select> <br>
    	</div>						
      
        <button onclick="submit();">Submit</button><br><br>
     	
     	<table class="table" border=1>
            <tr> <th> Id </th> <th> Child </th><th> Start </th> <th> End </th> <th> Email </th><th> Phone </th> <th> Delete </th> <th> Reservation </th></tr>         
        </table>
  </div>

             
     
    <script type="text/javascript">
    data = "";
    submit = function(){
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{
                	child_id:$("#child_id").val(),
                	first_name:$('#firstName').val(),
                	last_name:$('#lastName').val(), 
                	age:$('#age').val(),
                	contract_id:$("#contract_id").val(),
                	is_regular:$("#is_regular").is(":checked"),
                	start_date:$("#start_date").val(),
                	end_date:$("#end_date").val(),
                	email:$("#email").val(),
                	phone_nb:$("#phone_nb").val()
                	},
                success: function(response){
                        alert(response.message);
                        if ($("#is_regular").is(":checked")) {
                        	$.ajax({
                				url:'regularReservation',
                				type:'POST',
                				data:{
                					reservation_id: $("#reservation_id").val(),
                					contract_id:response.contract_id,
                					on_day1:$("#on_day1").val(),
                					on_day2:$("#on_day2").val(),
                					on_day3:$("#on_day3").val(),
                					on_day4:$("#on_day4").val(),
                					day_period1:$("#day_period1").val(),
                					day_period2:$("#day_period2").val(),
                					day_period3:$("#day_period3").val(),
                					day_period4:$("#day_period4").val(),                	
                					},
                				success: function(response){
                        			alert(response.message);
                        			}
                        		});
                        }
                        load();    
                }              
            });        
    }
    
    regularOptions = function(){
    	if ($("#is_regular").is(":checked")) {
    		$("#regular").show();	
    	}
    	else {
    		$("#regular").hide();	
    	}
    }
  
    delete_ = function(id){     
         $.ajax({
            url:'delete',
            type:'POST',
            data:{contract_id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
	}
     
     
    load = function(){ 
    	$("#regular").hide();
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){
                    	if(response.data[i].is_regular == true){              
                        	$(".table").append("<tr class='tr'> <td> "+response.data[i].contract_id+" </td> <td> "+response.data[i].child_id+" </td> <td> "+response.data[i].start_date+" </td> <td> "+response.data[i].end_date+" </td> <td> "+response.data[i].email+" </td> <td> "+response.data[i].phone_nb+" </td> <td> <a href='#' onclick='delete_("+response.data[i].contract_id+");'> Delete </a></td> <td> Regular</td> </tr>");
                       	}
                       	else{
                       		$(".table").append("<tr class='tr'> <td> "+response.data[i].contract_id+" </td> <td> "+response.data[i].child_id+" </td> <td> "+response.data[i].start_date+" </td> <td> "+response.data[i].end_date+" </td> <td> "+response.data[i].email+" </td> <td> "+response.data[i].phone_nb+" </td> <td> <a href='#' onclick='delete_("+response.data[i].contract_id+");'> Delete </a></td> <td> Temporary</td></tr>");
                       	}
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>