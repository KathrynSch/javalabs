<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Planned Absence</title>
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
	      <li><a href="../contract/page">Contract</a></li>
	      <li><a href="../reservation/page">Reservation</a></li>
	      <li class="active"><a href="../plannedAbsence/page">Planned Absence</a></li>
	    </ul>
	  </div>
	</nav>
	
	
 <div class="container">
 		
		<h3>Planned Absence</h3>
     	<div id="planAbsence">
     	</div>
 
        <table class="table" border=1>
            <tr> <th> Last Name </th> <th> First Name </th> <th>From </th><th>To </th></tr>
         
        </table>
        <br><br>
      </div>
             
     
    <script type="text/javascript">
    data = "";
  
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<data.length; i++){      
                        $(".table").append("<tr class='tr'> <td> "+data[i][0]+" </td> <td> "+data[i][1]+" </td> <td> "+data[i][2]+" </td><td> "+data[i][3]+" </td></tr>");
                    }
                                    		alert("here");
                              
            }              
        });
        
        $.ajax({
        	url:'listRegChildren',
        	type:'POST',
        	data:{ date: $("#date").val()},
        	success: function(response){
        		$("#planAbsence").html("");
        		data = response.data;
        		$("#planAbsence").append("<input type='hidden' id='planned_absence_id'><select id='childLabel'>");
        		for(i=0; i<data.length; i++){
        			$("#childLabel").append("<option value="+data[i][0]+">"+data[i][1]+" "+data[i][2]+"</option>");
        		}
        		$("#planAbsence").append("</select> From: <input type='date' id='from_date'> To: <input type='date' id='to_date'>");
        		$("#planAbsence").append("<button onclick='planAbsence();'>Add</button><br><br> ");
        			
        	}
        });
         
    }
    
    planAbsence = function(){
    	$.ajax({
    		url:'planAbsence',
    		type:'POST',
    		data: { 
    			child_id: $("#childLabel").val(),
    			planned_absence_id: $("#planned_absence_id").val(),
    			start_date:$("#from_date").val(),
                end_date:$('#to_date').val() },
    		success: function(response){
    			load();
    			}
    		});
    }
         
    </script>
     
</body>
</html>