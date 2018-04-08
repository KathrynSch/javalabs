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
		<h3>Children</h3>
        <input type="hidden" id="child_id">
        First Name: <input type="text" id="firstName" required="required" name="first_name"><br>
        Last Name: <input type="text" id="lastName" required="required" name="last_name"><br>
        Age: <input type="number" id="age" required="required" name="age"><br><br>
        <button onclick="submit();">Submit</button><br><br>
     
     
 
        <table class="table" border=1>
            <tr> <th> Last Name </th> <th> First Name </th> <th> Age </th> <th> Edit </th> <th> Delete </th> </tr>
         
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
                	child_id:$("#child_id").val(),
                	first_name:$('#firstName').val(),
                	last_name:$('#lastName').val(), 
                	age:$('#age').val()
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
            data:{child_id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
}
     
 
    edit = function (index){
        $("#child_id").val(data[index].child_id);
        $("#firstName").val(data[index].first_name);
        $("#lastName").val(data[index].last_name);
        $("#age").val(data[index].age);
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $(".table").append("<tr class='tr'> <td> "+response.data[i].last_name+" </td> <td> "+response.data[i].first_name+" </td> <td> "+response.data[i].age+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].child_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>