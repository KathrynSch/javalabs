<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Child</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>


<body>
<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">NurseryWebApp</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="../hello/page">Home</a></li>
	      <li><a href="../nursery/page">Nursery</a></li>
	      <li class="active"><a href="../child/page">Children</a></li>
	      <li><a href="../contract/page">Contract</a></li>
	      <li><a href="#">Reservation</a></li>
	    </ul>
	  </div>
	</nav>
	
	
 <div class="container">
 		
		<h3>Children</h3>
        <input type="date" id="date">
        <select id="period">
        <option value='AM' selected='selected'>AM</option>
        <option value='PM'>PM</option>
        </select>
        <button onclick="load();">Submit</button><br><br>
     	
     	<div id="addReservation">
     	</div>
 
        <table class="table" border=1>
            <tr> <th> Last Name </th> <th> First Name </th> <th>Age </th><th>Absence </th> <th> Delete </th> </tr>
         
        </table>
        <br><br>
      </div>
             
     
    <script type="text/javascript">
    data = "";
    
     
    delete_ = function(id){     
         $.ajax({
            url:'delete',
            type:'POST',
            data:{reservation_id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
        
}

	checkAbsence = function(state, id){
		$.ajax({
			url:'updateAbsence',
			type:'POST',
			data:{
				state:state,
				reservation_id:id
				},
			success: function(){
				load();
				}
			});
	}
	
     
  
    load = function(){ 
        $.ajax({
            url:'listByDate',
            type:'POST',
            data:{
                date:$("#date").val(),
                period:$('#period').val(),
                },
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){ 
                    	if(response.data[i][5] ==1) //present
                    	{         
                        	$(".table").append("<tr class='tr'> <td> "+response.data[i][2]+" </td> <td> "+response.data[i][1]+" </td> <td> "+response.data[i][3]+" </td> <td><form><input type='radio' checked>Present <input type='radio' onclick='checkAbsence("+2+","+response.data[i][4]+");'>Absent<input type='radio' onclick='checkAbsence("+3+","+response.data[i][4]+");'>Justified</form></td><td> <a href='#' onclick='delete_("+response.data[i][4]+");'> Delete </a>  </td> </tr>");
                    	}
                    	if(response.data[i][5] ==2) //absent
                    	{         
                        	$(".table").append("<tr class='tr'> <td> "+response.data[i][2]+" </td> <td> "+response.data[i][1]+" </td> <td> "+response.data[i][3]+" </td> <td><form><input type='radio' onclick='checkAbsence("+1+","+response.data[i][4]+");'>Present <input type='radio' checked>Absent<input type='radio' onclick='checkAbsence("+3+","+response.data[i][4]+");'>Justified</form></td><td> <a href='#' onclick='delete_("+response.data[i][4]+");'> Delete </a>  </td> </tr>");
                    	}
                    	if(response.data[i][5] ==3) //justified
                    	{         
                        	$(".table").append("<tr class='tr'> <td> "+response.data[i][2]+" </td> <td> "+response.data[i][1]+" </td> <td> "+response.data[i][3]+" </td> <td><form><input type='radio' onclick='checkAbsence("+1+","+response.data[i][4]+");'>Present <input type='radio' onclick='checkAbsence("+2+","+response.data[i][4]+");'>Absent<input type='radio' checked>Justified</form></td><td> <a href='#' onclick='delete_("+response.data[i][4]+");'> Delete </a>  </td> </tr>");
                    	}
                    	
                    }          
            }              
        });
        $.ajax({
        	url:'listTempChildren',
        	type:'POST',
        	data:{ date: $("#date").val()},
        	success: function(response){
        		$("#addReservation").html("");
        		data = response.data;
        		$("#addReservation").append("<h3>Add temporary reservation</h3><br><input type='hidden' id='reservation_id'><select id='childLabel'>");
        		for(i=0; i<data.length; i++){
        			$("#childLabel").append("<option value="+data[i][0]+">"+data[i][1]+" "+data[i][2]+"</option>");
        		}
        		$("#addReservation").append("</select><button onclick='addReservation();'>Add</button><br><br> ");
        			
        	}
        });
         
    }
    
    addReservation = function(){
    	$.ajax({
    		url:'addTempReservation',
    		type:'POST',
    		data: { 
    			child_id: $("#childLabel").val(),
    			reservation_id: $("#reservation_id").val(),
    			date:$("#date").val(),
                period:$('#period').val() },
    		success: function(response){
    			load();
    			}
    		});
    }
         
    </script>
     
</body>
</html>