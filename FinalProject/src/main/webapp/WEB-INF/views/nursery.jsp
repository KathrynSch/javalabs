<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nursery</title>
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
	      <li class="active"><a href="../nursery/page">Nursery</a></li>
	      <li><a href="../child/page">Children</a></li>
	      <li><a href="../contract/page">Contract</a></li>
	      <li><a href="../reservation/page">Reservation</a></li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container">
		<h3>Nursery</h3>
		<p> Here are you nursery parameters, you can edit the max capacity and price per hour : </p> 	
		<br><br>
        <table class="table">
            <tr> <th> Maximum nb children </th> <th> Maximum nb babies </th> <th> Price per Hour </th> <th> Edit </th> </tr>
         
        </table>
        
        <br><br>
        
       <div id="myDIV" style="display:none"> <input type="hidden" id="nursery_id">
        NbChild: <input type="number" id="max_nb_child" required="required" name="max_nb_child"><br>
        NbBaby: <input type="number" id="max_nb_baby" required="required" name="max_nb_baby"><br>
        Price: <input type="number" id="price_per_hour" required="required" name="price_per_hour"><br><br>
        <button onclick="submit();">Submit</button>
        <button onclick="edit();">Cancel</button>
        </div>
       </div>
        
                       
     
    <script type="text/javascript">
    
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{
                	nursery_id:$("#nursery_id").val(),
                	max_nb_child:$('#max_nb_child').val(),
                	max_nb_baby:$('#max_nb_baby').val(),
                	price_per_hour:$('#price_per_hour').val()
                },
                success: function(response){
                        alert(response.message);
                        load();    
                }              
            });        
    }
     
 
    edit = function (index){
    	var x = document.getElementById("myDIV");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
        $("#nursery_id").val(data[index].nursery_id);
        $("#max_nb_child").val(data[index].max_nb_child);
        $("#max_nb_baby").val(data[index].max_nb_baby);
        $("#price_per_hour").val(data[index].price_per_hour);      
    }
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $(".table").append("<tr class='tr'> <td> "+response.data[i].max_nb_child+" </td> <td> "+response.data[i].max_nb_baby+" </td> <td> "+response.data[i].price_per_hour+" </td><td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> </tr>");
                    }          
            }              
        });  
    }
         
    </script>
     
</body>
</html>