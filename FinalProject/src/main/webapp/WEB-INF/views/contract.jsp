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
	      <li class="active"><a href="#">Home</a></li>
	      <li><a href="../nursery/page">Nursery</a></li>
	      <li><a href="../child/page">Children</a></li>
	      <li><a href="../contract/page">Contract</a></li>
	      <li><a href="#">Reservation</a></li>
	    </ul>
	  </div>
	</nav>
 
<div class="container">		
        <div>
	        <h3> Child Details </h3>
	        <input type="hidden" id="child_id">
	        First Name: <input type="text" id="firstName" required="required" name="first_name"><br>
	        Last Name: <input type="text" id="lastName" required="required" name="last_name"><br>
	        Age: <input type="number" id="age" required="required" name="age"><br><br>
        </div>
        
        <div>
	        <h3> Contract Details </h3>
	        <input type="hidden" id="contract_id">
	        <input type="checkbox" id="is_regular" name="is_regular" value=true> Regular contract<br>
	        Start Date: <input type="date" id="start_date" name="start_date"><br>
	        End Date: <input type="date" id="end_date" name="end_date"><br>
	        Email: <input type="email" id="email" name="email"><br>
	        Phone: <input type="tel" id="phone_nb" name="phone_nb"><br><br>
	        <button onclick="submit();">Submit</button> <br><br>
     	</div>

     	
     	<table class="table" border=1>
            <tr> <th> Id </th> <th> Child </th> <th> Regular </th><th> Start </th> <th> End </th> <th> Email </th><th> Phone </th> <th> Delete </th> </tr>
         
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
                        load();    
                }              
            });        
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
    	alert("loading");
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $(".table").append("<tr class='tr'> <td> "+response.data[i].contract_id+" </td> <td> "+response.data[i].child_id+" </td> <td> "+response.data[i].is_regular+" </td> <td> "+response.data[i].start_date+" </td> <td> "+response.data[i].end_date+" </td> <td> "+response.data[i].email+" </td> <td> "+response.data[i].phone_nb+" </td> <td> <a href='#' onclick='delete_("+response.data[i].contract_id+");'> Delete </a></td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>