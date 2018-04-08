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
     
  
    load = function(){ 
        $.ajax({
            url:'listFromDate',
            type:'POST',
            data:{
                date:$("#date").val(),
                period:$('#period').val(),
                },
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $(".table").append("<tr class='tr'> <td> "+response.data[i].last_name+" </td> <td> "+response.data[i].first_name+" </td> <td> "+response.data[i].age+" </td> <td> "+response.data[i].absence+" </td><td> <a href='#' onclick='delete_("+response.data[i].reservation_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>