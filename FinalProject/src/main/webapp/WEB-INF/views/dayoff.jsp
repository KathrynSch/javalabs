<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Day Off</title>
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
	      <li class="active"><a href="../hello/page">Home</a></li>
	      <li><a href="../nursery/page">Nursery</a></li>
	      <li><a href="../child/page">Children</a></li>
	      <li><a href="../contract/page">Contract</a></li>
	      <li><a href="../reservation/page">Reservation</a></li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container">
		<h3>Day Off</h3>
		  
		
        <input type="hidden" id="day_off_id">
        At Date(yyyy-MM-dd): <input type="date" id="at_date" name="at_date"><br>
        Period of Day: <select name='period_of_day' id='period_of_day'>
        	<option value='AM'>AM</option><option value='PM'>PM</option></select><br>
        <button onclick="submit();">Submit</button><br><br>
     
     
 
        <table class="table" border=1>
            <tr> <th> At Date </th> <th> Period of Day </th> <th> Edit </th> <th> Delete </th> </tr>
         
        </table>
        <br><br>
      </div>
             
     
    <script type="text/javascript">
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{
                	day_off_id:$("#day_off_id").val(),
                	at_date:$('#at_date').val(),
                	period_of_day:$('#period_of_day').val(),
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
            data:{day_off_id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
}
     
 
    edit = function (index){
        $("#day_off_id").val(data[index].day_off_id);
        $("#at_date").val(data[index].at_date);
        $("#period_of_day").val(data[index].period_of_day);
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $(".table").append("<tr class='tr'> <td> "+response.data[i].at_date+" </td> <td> "+response.data[i].period_of_day+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].day_off_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
		  
  
</body>
</html>