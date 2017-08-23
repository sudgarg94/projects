<%-- 
    Document   : PrintedIndex
    Created on : Aug 13, 2017, 8:51:50 PM
    Author     : kkgarg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

#left-Margin{
     margin-left: 0.5cm;
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
filter: blur(0px);
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
		    <li><a href="MultipleQuerySearch.jsp">Perform Multiple Query <span class="sr-only">(current)</span></a></li>
			<li><a href="<%=request.getContextPath()%>/PrintingIndex">Show Index <span class="sr-only">(current)</span></a></li>
        
      </ul>
			</div>

				

		</div> <!-- Container Ends here -->
	</nav> <!-- NavBar Ends here -->
            
 
        <div id="left-Margin">
            <h3>Precision Recall </h3><br>
            <p><b>Precision</b> (also called positive predictive value) is the fraction of relevant instances among the retrieved instances, <br>
                While <b>Recall</b> (also known as sensitivity) is the fraction of relevant instances that have been retrieved over 
                the total amount of relevant instances.</p>
            
            <u><h4>Qrels File</h4></u>
        <span>0	 0	 books.xml		1</span><br>
0 	 0 	 hello.txt     		1<br>
0	 0	 mock_data.csv		1<br>
0	 0	 promotion.html		1<br>
0	 0	 resume.doc		1<br>
0 	 0 	 try.pdf	     	1<br>

        </div>
        
        <div class="homepage-hero-module" id="left-Margin">
     <br><br>
    
     <h4>Results: ( Query : Sudhanshu )</h4>
                
                
     
                <h4><span class="text-info">Average Precision: <c:out value="${PrecisionRecall.averagePrecision}"></c:out></span></h4>
                <h4><span class="text-info">Recall: <c:out value="${PrecisionRecall.recall}"></c:out></span></h4>
                <h4><span class="text-info">MRR: <c:out value="${PrecisionRecall.mmr}"></c:out></span></h4>
                <h4><span class="text-info">Search Time: <c:out value="${PrecisionRecall.searchTime}"></c:out> milli seconds</span></h4>			
        </div>



<!-- Footer -->
 <!--<div class="container-fluid footer-container">-->		
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
			<!--</div>-->
<!--  -->


</body>
</html>
