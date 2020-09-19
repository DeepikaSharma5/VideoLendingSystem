<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="Width=device-width, initial-scale=1">
<style>
		table {
				border-collapse: collapse;
 				 width: 100%;
 				
			  }


			td{
    			font-size: 40;
   				text-align:left;
    			padding: 8px;
    		  }
    		  
			th{
    			font-size: 50;
    			text-align:left;
    			padding: 8px;
    
			  }
			tr:nth-child(even)
			{
    			background-color:#f2f2f2; 
			}
			
			button
			 {
  					background-color:steelblue;
  					color: white;
   					 font-size: 18px;
  					padding: 8px;
    				border:none;
  					cursor:pointer;
  					width: 17%;
    				display:block;
  				}

			button:hover 
			{
  
   				background-color: lightslategray;
    			color:black;
			}
			hr{
			border:1px solid darkslateblue;
			}
			
			
			
</style>
</head>
<body>
<form name="f" action="Form.jsp" method="post">
<div align="center">
       	<h1> <font color="darkslateblue" ><b>Choose the plan that's right for you.</b></font> </h1>
        <h2> <font color="darkslateblue" >  Downgrade or upgrade at any time </font></h2>
        <hr>
    
<table>
		<tr><th>Features</th>
    		<th>Basic</th>
    		<th>Standard</th> 
    		<th>Premium</th></tr>
		<tr><td>Monthly price</td>
    		<td>Rs.500 (up to 20 movies)</td>
    		<td>Rs.650 (up to 25 movies)</td>
    		<td>Rs.800 (up to 30 movies)</td></tr>
		<tr><td>Additional charge</td>
    		<td>Rs.6 </td>
   		 	<td>Rs.5 </td>
    		<td>Rs.4</td></tr>
		<tr><td >HD available</td>
    		<td>No</td>
    		<td>Yes</td>
    		<td>Yes</td></tr>
		<tr><td>Ultra HD available</td>
    		<td>No</td>
    		<td>No</td>
   		    <td>Yes</td></tr>
		<tr><td>Screens you can watch on at the same time</td>
   			<td>1</td>
    		<td>2</td>
   		    <td>4</td></tr>
		<tr><td>Watch on your laptop,TV,phone and tablet</td>
   			 <td>Yes</td>
    		 <td>Yes</td>
    		 <td>Yes</td></tr>
		<tr><td>Cancel anytime</td>
    		<td>Yes</td>
    		<td>Yes</td>
    		<td>Yes</td></tr>
		<tr><td>Select your package</td>
    		<td><input type="radio" name="Choose" value="Basic"></td>
    		<td><input type="radio" name="Choose" value="Standard"></td>
    		<td><input type="radio" name="Choose" value="Premium"></td></tr>    
       
</table>
</div>
		<br>
	<div align="center">
     <button type="submit">Continue</button>
     </div>	
</form>
<form name="f2" action="delform.jsp" method="post">
<h3><font color="darkpink">If you want to delete your payment details please click this option</font></h3>		
	<button type="submit" name="del">Delete Details</button><br>
</form>

<form name="f3" action="updateform.jsp" method="post">
	<h3><font color="darkpink">If you want to edit your payment details please click this option</font></h3>
		<button type="submit" value="update">Update Details</button>
</form>
</body>
</html>