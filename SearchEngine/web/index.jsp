<%-- 
    Document   : index.jsp
    Created on : Aug 6, 2017, 6:08:35 PM
    Author     : kkgarg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Engine</title>
        <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
        
        
        
        <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/smoothness/jquery-ui.css">

        
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
        
	<script src="js/jquery.autocomplete.js"></script> 
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        
       
    </head>
    <style>
body{
	padding-top: 40px;
}

.carousel-inner img{
  width:100%;
  max-height: 600px !important;
}



.line{
	font-family: 'Tangerine', serif;
	font-size: 20px;
	line-height: 200%;
}

.imgsize{
	width: 300px ;
	height: 300px;
	margin:10px;
}


/*container video*/
/*.container { position:relative; }*/
.video-container{
	margin-top: 10px;
}
.video-container video {
    position:relative;
    z-index:0;
    /*transform: scale(2.3);*/
	-webkit-transform: scale(3.6);
	/*-webkit-filter: grayscale(100%);
filter: grayscale(100%);*/
-webkit-filter: blur(1px); /* Safari 6.0 - 9.0 */
filter: blur(1px);
}
.overlay {
	margin-top: 100px;
    position:absolute;
    top:0;
    left:0;
    z-index:1;
}
/*ends*/
/*footer*/
.footer-container{
	margin-top: 200px;
}
/*ends*/
#andspan{ 
  display: inline-block;
  width: 100px;
}

</style>


<body data-spy="scroll" data-target="#my-navbar">


	<!-- Navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="index.jsp" class="navbar-brand"><!-- <img src="images/logo-jobboard.png"> -->
				<span>Search Engine</span></a>
			</div> <!-- Nav Header Ends here -->

			<div class="collapse navbar-collapse" id="navbar-collapse">

				
				<ul class="nav navbar-nav pull-right">

       
		
        <li>
          <a href="<%=request.getContextPath()%>/PrecisionRecall"  data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Precision and Recall</a>
        </li>
		    <!-- <form action="PrintingIndex" method="post">
            <input type="submit" value="Show Index">
        </form> --><li><a href="MultipleQuerySearch.jsp">Perform Multiple Query <span class="sr-only">(current)</span></a></li>
			<li><a href="<%=request.getContextPath()%>/PrintingIndex">Show Index <span class="sr-only">(current)</span></a></li>
        
      </ul>
			</div>

				

		</div> <!-- Container Ends here -->
	</nav> <!-- NavBar Ends here -->
        
 <div class="homepage-hero-module">
            <div class="video-container">
	            		<video autoplay loop class="fillWidth" width="100%" height="200px">
		                    <source src="Resources/jobboard.mp4" type="video/mp4" />
		                    Your browser does not support the video tag. I suggest you upgrade your browser.
		                </video>
		        <div class="overlay">
                <div class="title-container">
                    <div class="container home-margin">

                    	<br><br><br><br><br><br><br>
                    	

                    	<div class="item active">
                <div class="fill img-responsive" ></div>
                <div class="carousel-caption">
                    
                    <h2>Find anything from the Indexed Documents</h2>
					<p>Your search starts and ends with us.</p>
                </div>
            </div>
                        <div class="row" >
                            <div class="col-md-4"></div>
                            
                            <form action="Controller" method="post">
                            <div class="col-md-4">
                            	<input type="text" id="search" name="search" class="form-control" 
                                       placeholder="Type Anything to Search" required>
                            </div>
                                
                            <div class="col-md-2"><button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search"></span> </button></div>
                        </form>
                        </div>

                    </div>
                </div>
            	</div>
	            	

            </div>
            
    
			
        </div>
        <br><br>
                            
<!-- Footer -->
 <div class="container-fluid footer-container">		
 	<div class="container" id="content">
            <!-- Job Section -->
            <div class="row">
                <div class="col-lg-12">
                	<center>
                    <h1 class="page-header">
                        Your Own Search Engine
                    </h1>
                    </center>
                </div>
          	</div>
        </div>
            <footer class="container">
			<div class="row">
			<div class="col-md-4">
			<h3>About</h3>
			<p>Morbi convallis bibendum urna ut viverra. Maecenas quis consequat libero, a feugiat eros. Nunc ut lacinia tortor morbi ultricies laoreet ullamcorper phasellus semper.</p>
			<button class="btn btn-lg btn-info" onclick="location.href='#'" type="submit">GET STARTED</button>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-2"></div>
			<div class="col-md-2"></div>
			
			<div class="col-md-2">
			<strong><p>Information</p></strong>
			<p><a href="#">About Us</a></p>
			<p><a href="#">Terms & Conditions</a></p>
			<p><a href="#">Privacy Policy</a></p>
			<p><a href="#">Resources</a></p>
			<p><a href="#">Contact Us</a></p>
			</div>
			</div>
			
			<hr class="line">
			<br><br>
			<div class="row">
			<div class="col-md-10"><p>&copy; SearchSoftware 2016</p></div>
			<div class="col-md-2 pull-right">
					

			</div>
			 
			</div>
			
			
            </footer>
			</div>
<!--<input type="button" name="addAND" class="bt btn-info"
                                value="AND" onclick="addAND();">
                                 <br><span id="andspan"></span>-->
<!--<input type="button" name="addAND" class="addperson"
        value="AND" onclick="addAND();"> <br><span id="andspan"></span>-->
<!--  -->
<script>
		$("#search").autocomplete("getdata.jsp");
	</script>
<!--        <script type="text/javascript">
   function addAND() {
   	
     var element = document.createElement("input");
     element.setAttribute("type", "text");
     element.setAttribute("name", "and");
     element.className = "form-control";
    var spanvar = document.getElementById("andspan");
    spanvar.appendChild(element);
	
	
   }
   </script>-->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->

        
        <!--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>-->
        <!--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>-->
        
</body>


</html>
