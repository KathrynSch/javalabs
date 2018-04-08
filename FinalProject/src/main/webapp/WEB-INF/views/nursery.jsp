<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nursery</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">
 
        <input type="hidden" id="nursery_id">
        NbChild: <input type="number" id="max_nb_child" required="required" name="max_nb_child"><br>
        NbBaby: <input type="number" id="max_nb_baby" required="required" name="max_nb_baby"><br>
        Price: <input type="number" id="price_per_hour" required="required" name="price_per_hour"><br>
        <button onclick="submit();">Submit</button>
     
     
 
        <table id="table" border=1>
            <tr> <th> Max Child </th> <th> Max baby </th> <th> Price </th> <th> Edit </th> <th> Delete </th> </tr>
         
        </table>
             
     
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
     
    delete_ = function(id){     
         $.ajax({
            url:'delete',
            type:'POST',
            data:{nursery_id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
	}
     
 
    edit = function (index){
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
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].max_nb_child+" </td> <td> "+response.data[i].max_nb_baby+" </td> <td> "+response.data[i].price_per_hour+" </td><td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].nursery_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });  
    }
         
    </script>
     
</body>
</html>