<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">
	<h2>Welcome to the Nursery Web Application!</h2>
	<p> Select your nursery : </p>

  	 <table id="table" border=1>
            <tr> <th> Nursery Id </th> <th> Max Child </th> <th> Max baby </th> <th> Price </th> </tr>
         
       </table>
       <br><br>
       <p> <a name="nursery" href="nursery/page" >Add or edit nursery</a></p>
        
  		
  		
  		 <script type="text/javascript">
    data = ""; 
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].nursery_id+" </td> <td> "+response.data[i].max_nb_child+" </td> <td> "+response.data[i].max_nb_baby+" </td> <td> "+response.data[i].price_per_hour+" </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>
