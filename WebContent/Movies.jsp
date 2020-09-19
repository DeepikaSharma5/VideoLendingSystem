<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.Base64"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<style>





.box img{
width: 100px;
height: 140px;

}
.table{

cellspacing:5px;


}
</style>
    <meta charset="utf-8">
    <title>Movies</title>
    <link rel="stylesheet" href="css/movies.css">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" ></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
      

  </head>
  <body>
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
        <a class="nav-link" href="#">Packages</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">ContactUs</a>
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
              
              <div class="bigpic">
              <img src="images/avengers.jpg">
              </div>
              <div class="play-button" data-toggle="modal" data-target="#exampleModalCenter">
              <img src="images/play.png">
              </div>
              <div class="modal fade" id="exampleModalCenter" >
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      
      <div class="modal-body">
        
      </div>
      
    </div>
  </div>
</div>
            
               <div class="rectangle1">
          <h5>Songs</h5>
          <img src="images/jumanji.jpg" alt="">
          <h4>Shape Of You</h4>
          <p></p>
          <button class="play1" data-toggle="modal" data-target="#exampleModalCenter">Play Now</button>
            <div class="modal fade" id="exampleModalCenter" >
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      
      <div class="modal-body">
        
      </div>
      
    </div>
  </div>
</div>

          </div>
              <div class="rectangle2">
          <img src="images/war.jpg" alt="">
          <h4>Badtameez dil</h4>
          <p></p>
          <button class="play2" href="#">Play Now</button>

          </div>
              <div class="rectangle3">
          <img src="images/enthiran.jpg" alt="">
          <h4>Breakup Song</h4>
          <p></p>
          <button class="play3" href="#">Play Now</button>

          </div>
              
              <div class="rectangle4">
          <img src="images/img2.jpg" alt="">
          <h4>Verithanam</h4>
          <p></p>
          <button class="play4" href="#">Play Now</button>

          </div>
              
              <div class="rectangle5">
          <img src="images/sinhala.jpg" alt="">
          <h4>MoneyHeist Trailer(2020)</h4>
          <p></p>
          <button class="play5" href="#">Play Now</button>

          </div>
              
              <div class="rectangle6">
          <img src="images/img5.jpg" alt="">
          <h4>Raanjana</h4>
          <p></p>
          <button class="play6" href="#">Play Now</button>

          </div>
              
              <div class="rectangle7">
          <img src="images/img1.jpg" alt="">
          <h4>Muqabla</h4>
          <p></p>
          <button class="play7" href="#">Play Now</button>

          </div>
              
              <div class="rectangle8">
          <img src="images/img6.jpg" alt="">
          <h4>Senorita</h4>
          <p></p>
          <button class="play8" href="#">Play Now</button>

          </div>
           <div class="box">
         <table class="table" border="0px" cellpadding="200px" >
    <%
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement psmt = null;
        FileInputStream fis;
        String url = "jdbc:mysql://localhost:3306/videos";
        Blob blob;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "kajan003");
            psmt = con.prepareStatement("select * from video_lend where category='Movie'");
            rs = psmt.executeQuery();
            int cnt=0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");

                
                String description = rs.getString("description");
                blob = rs.getBlob("videofile");
                
                
                InputStream in = blob.getBinaryStream();
                
               
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream ot = new ByteArrayOutputStream();
                
                 byte[] buffer = new byte[in.available()];	               
                int i;
                
                
                while ((i = in.read(buffer)) != -1) {
                	outputStream.write(buffer, 0, i); 
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
               
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                in.close();
                outputStream.close();
                ot.close();
                if(cnt==4){
        			out.print("</tr><tr>");
        			cnt=0;
        		}
        		cnt++;
                %>
                
        <td>
               <img src="data:image/jpg;base64,<%= base64Image %>"><br>
               <h4><%=name %></h4><br><%=description %>
		</td>
                
                <%
                    
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    %>
       </table>
         
         
         
         
         
         </div>
                  
               </div>
      </div>
      
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