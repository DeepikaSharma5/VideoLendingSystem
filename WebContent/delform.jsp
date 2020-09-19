  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="Width=device-width, initial-scale=1">

<style >


					
body{
			
  						margin: 5% auto 5% auto; 
 						 border: 1px solid maroon;
 						 width: 80%; 
 						 length: 80%; 
}
hr {
 					 border: 1px solid maroon;
  					 margin-bottom: 25px;
				}
</style>
</head>
<body>
<form action="del" method="post" name="f3" >
        <div class="container">
                    <h2>Delete your credit or debit card payment details</h2>
                    <p>
                       Please enter your customer id for delete your payment details.
                       After delete your payment details , do not allow to watch our video packages.<br><br>
                       
                    </p>
        <hr>
        
                 
 						
   					 <label for="cid"><b>CustomerID</b></label>
                    <input type="text" placeholder="Enter your customer id" name="CustomerID" required>
                     <input type="submit" Value="Confirm & Delete" name="S"> 
                     </div><br>
                      </form>
    <form action="Table.jsp" method="post" name="f8">
      <button type="submit" Value="Cancel" name="S"> Cancel</button>
 </form>
   
                    
</body>
</html>