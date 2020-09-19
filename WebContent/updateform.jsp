<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="Width=device-width, initial-scale=1">

<style>
				input[type=text],input[type=number],input[type=date],input[type=email]
					{
  						width: 70%;
  						padding: 15px;
  						margin: 5px 0 22px 0;
  						display: inline-block;
  						border: none;
  						background: #f1f1f1;
					}

				input[type=text]:focus, input[type=number]:focus,input[type=date]:focus
					{
 						 background-color: #ddd;
  							outline: none;
					}

				button
					 {
  							background-color: #4189b3;
  							color: white;
    						font-size: 16px;
  							padding: 15px 35px;
    						margin:10px 15px;
  							border:none;
  							cursor: pointer;
  							width: 20%;
    						display:block;
 							opacity:0.9;

					}

				button:hover 
					{
 							 opacity:1;
    						background-color: lightsteelblue;
    						color:black;
					}

			.container 
					{
  						padding: 16px;
					}


			.modal 	
					{
  						display: none; 
  						position: fixed; 
  						z-index: 1; 
 						 left: 0;
  						top: 0;
 						 width: 1000%; 
 						height: 100%;
  						overflow: auto; 
  						background-color: #474e5d;
  						padding-top: 50px;
					}


			


			hr {
 					 border: 1px solid palevioletred;
  					 margin-bottom: 25px;
				}
 

			.cancelbtn, .signupbtn {
     					width: 50%;
 					 }
 					 
 					body{
 						
  						margin: 5% auto 15% auto; 
 						 border: 1px solid palevioletred;
 						 width: 80%; 
 					}
			
  
</style>
</head>
<body>

<form action="upd" method="post" name="f4" class="modal-content"  >
        <div class="container" >
                    <h2>Update your credit or debit card payment details.</h2>
                    <p>
                       Please enter your details for update your payment details.
                       <br><br>
                       
                    </p>
        <hr>
        			<label for="cid"><b>CustomerID</b></label><br>
                    <input type="text" placeholder="Enter your customer id" name="CustomerID" required>
        <br>
        			<label for="fn"><b>First Name (Must match card)</b></label><br>
                    <input type="text" placeholder="Enter your first name" name="FirstName" required>
                 <br>   
                    <label for="ln"><b>Last Name (Must match card)</b></label><br>
                    <input type="text" placeholder="Enter your last name" name="LastName" required>
            <br>
                    <label for="cn"><b>Card Number</b></label><br>
                    <input type="number" placeholder="Enter your card number" name="CardNumber" required>
               <br>     
                    <label for="ed"><b>Expiration Date</b></label><br>
                    <input type="date" placeholder="Enter your card expiration date" name="ExpirationDate" required>
               <br>     
                    <label for="em"><b>e-mail address</b></label><br>
                    <input type="email" placeholder="Enter your e-mail address" name="Email" required>
                    
                </div>

      <div align="center">
      <button type="submit" value="Submit">Update</button>
      </div>
 </form>
 <form action="Table.jsp" method="post" name="f7" >
       <button type="submit" > Cancel </button>   
 </form>
      
</body>
</html>