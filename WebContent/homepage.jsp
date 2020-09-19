<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/NewFile.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body class="body">
<div id="container">
          <div id="main">
      <section id = "nav-bar">
      <nav class="navbar navbar-expand-lg navbar-light">
  <a class="navbar-brand" href="#"><img src="images/logofinal.png"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="homepage.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <div class="dropdown">
  <button class="dropbtn">Categories</button>
  <div class="dropdown-content">
  <a href="Series.jsp">Series</a>
  <a href="Movies.jsp">Movies</a>
  <a href="Songs.jsp">Songs</a>
  </div>
</div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Table.jsp">Packages</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="feedback.jsp">ContactUs</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ComingSoon.jsp">Coming Soon</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="request.jsp">Request video</a>
      </li>
        </ul>
      <ul class="navbar-nav ml-auto">
     
          <li class="nav-item">
          
                  <a href="LogoutServlet" class="login" class="btn">Logout</a>
        
      </li>
         
      <li class="nav-item">
          <a href="register.jsp" class="signup" class="btn btn-success">SignUp</a>
          </li>
          
      </ul>
      
      
      
    
  </div>
</nav>
          </section>
    
          
      
    <div class="slidershow middle">

      <div class="slides">
        <input type="radio" name="r" id="r1" checked>
        <input type="radio" name="r" id="r2">
        <input type="radio" name="r" id="r3">
        <input type="radio" name="r" id="r4">
        <input type="radio" name="r" id="r5">
        <div class="slide s1">
          <img src="images/img6.jpg" alt="">
        </div>
        <div class="slide">
          <img src="images/img2.jpg" alt="">
        </div>
        <div class="slide">
          <img src="images/img3.jpg" alt="">
        </div>
        <div class="slide">
          <img src="images/img4.jpg" alt="">
        </div>
        <div class="slide">
          <img src="images/img5.jpg" alt="">
        </div>
      </div>

      <div class="navigation">
        <label for="r1" class="bar"></label>
        <label for="r2" class="bar"></label>
        <label for="r3" class="bar"></label>
        <label for="r4" class="bar"></label>
        <label for="r5" class="bar"></label>
      </div>
    </div>
        
     
      <div class="rect1">
     <img src="images/bigil.jpg" alt="">
          <h4>Bigil(2019)</h4>
          <p>ex champian struggling to make women football team to win<br>
#commercial #sports</p>
          <button class="watch2" href="#">Watch Now</button>

          </div>
      
      <div class="rect2">
          
          <img src="images/img2.jpg" alt="">
          <h4>Joker trailer(2019)</h4>
          <p>In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society.<br>
#crime #thriller</p>
          <button class="watch2" href="#">Watch Now</button>

          </div>
      
      <div class="rect3">
          
          <img src="images/img6.jpg" alt="">
          <h4>Despicable Me 3(2017)</h4>
          <p>Gru meets his long-lost twin brother Dru, after getting fired from the Anti-Villain League<br>#comedy #anime
          </p>
          
          <button class="watch2" href="#">Watch Now</button>
 
           </div>
              
              
      </div>
      
              </div>
      
      <!---------------about us------->
      <section id="about-us">
      <div class="container">
          <h1 class="title text-center">About Us</h1>
          <div class="row">
          <div class="col-md-6 about-us">
             <p class="about-title">KRDS videos</p>
              <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
              
              </div>
              <div class="col-md-6">
              <img src="images/fam.jpg" class="imgfam">
              </div> 
          </div>
          </div>
      
      </section>
      <!-------------footer------------->
     
      <section id="footer">
          <img src="images/wave2.png" class="footer-img">
          <div class="container">
          <div class="row">
              
            
            <div class="col-md-4 footer-box">
                <p><b>ProjectX</b></p>
                <img src="images/logofinal.png">
              <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
              </div>
              <div class="col-md-4 footer-box">
              <p><b>Contact Us</b></p>
              <p><i class="fa fa-map-marker" aria-hidden="true"></i> No5,Malabe,Colombo</p>
              <p><i class="fa fa-phone" aria-hidden="true"></i> +94 077 67543241</p>
              <p><i class="fa fa-envelope-o" aria-hidden="true"></i> projectx@gmail.com</p>

              
              </div>
              <div class="col-md-4 footer-box">
            
                  <p><b>FIND US ON SOCIAL MEDIA</b></p>
                      
                  <a href="#"><i class="fa fa-instagram"></i></a>

                  <a href="#"><i class="fa fa-facebook-square" aria-hidden="true"></i></a>

                  <a href="#"><i class="fa fa-twitter-square" aria-hidden="true"></i></a>
      
                      
                      </div>
                  
                  </div>
                 
              
              </div>
              
          
          
      </section>


</body>
</html>