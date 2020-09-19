<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>video ui</title>
    <style>
    
    </style>
    <link rel="stylesheet" href="css/Lobby.css"> 

    </head>
    
    <body>
        <div class="main">
            <nav>
            <div class="logo">
                
                
                </div>
                
            </nav>
            
            <div class="information">
                <img src="images/logo2.png">
                
                <img src="images/fam1.png" class="fam">
            <div id="circle">
                <div class="feature one">
                <img src="images/tv1.png">
                    <div>
                    <h1>Songs</h1>
                    </div>
                </div>
                <div class="feature two">
                <img src="images/tv1.png">
                    <div>
                    <h1>Movies</h1>
                    </div>
                    
                </div>
                <div class="feature three">
                <img src="images/tv1.png">
                    <div>
                    <h1>Series</h1>
                    </div>
                </div>
                <div class="feature four">
                <img src="images/tv1.png">
                    <div>
                    <h1>Movies</h1>
                    </div>
                
                </div>
                </div>
                
                <div class="overlay"></div>
                
            </div>
            <div class="btn1">
            <a href="index.jsp" class="button" class="btn">Subscriber</a>
            </div>
            <div class="btn2">
            <a href="adminindex.jsp" class="button" class="btn">Admin</a>
            </div>
            <div class="control">
                <img src="images/arrow.png" id="upBtn">
                <h3>Features</h3>
                <img src="images/arrow.png" id="downBtn">
            </div>
        </div>
        
        <script>
            var circle = document.getElementById("circle");
            var upBtn = document.getElementById("upBtn");
            var downBtn = document.getElementById("downBtn");
            
            var rotateValue = circle.style.transform;
            var rotateSum;
            
            upBtn.onclick = function()
            {
                rotateSum = rotateValue + "rotate(-90deg)";
                circle.style.transform= rotateSum;
                rotateValue=rotateSum;
            }
            downBtn.onclick = function()
            {
                rotateSum = rotateValue + "rotate(90deg)";
                circle.style.transform= rotateSum;
                rotateValue=rotateSum;
            }
        </script>
        
        
    </body>
</html>