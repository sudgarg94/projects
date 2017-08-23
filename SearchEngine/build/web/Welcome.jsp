<%-- 
    Document   : Welcome
    Created on : Aug 6, 2017, 6:16:32 PM
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
#flex{
    /*display: block;*/
    /*overflow: hidden;*/
    /*display: table;*/
/*    display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;*/
  display:  flex;
  flex-wrap: wrap;
}
#flex .col-md-6{
/*     margin-bottom: -99999px;
    padding-bottom: 99999px;*/

/*  display: flex;
  flex-direction: column;*/
    /*flex: 1;*/  
  
  /*padding: 1em;*/
/*  border: solid;*/
}
.submitLink {
  background-color: transparent;
  text-decoration: underline;
  border: none;
  color: blue;
  cursor: pointer;
}
submitLink:focus {
  outline: none;
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
            
 <div class="homepage-hero-module" id="left-Margin">
     <br><br>
    <div class="row" >
<!--            <div class="col-md-4"> 
            </div>-->
        <form action="Controller" method="post">
            <div class="col-md-4">
                <input type="text" id="search" name="search" class="form-control" 
                       placeholder="Type Anything to Search" required>
            </div>
            <div class="col-md-2"><button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search"></span> </button></div>
        </form>
    </div>
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
     
            <h3>Search Results for : <c:out value="${sessionScope.query}"/></h3><br>
            <h4>Found in : <c:out value="${sessionScope.totalHits}"/> Documents</h4>
            <c:if test="${empty sessionScope.searchResults}">
                <h3>Sorry no results found for the query</h3>
                <u><p>Try for any of these words:</p></u>
                    <c:forEach begin="0" end="10" items="${sessionScope.IndexMap}" var="map">
                        <form action="Controller" method="post">
                            <input type="submit" class="submitLink" value="${map.key}" name="search" id="frm1_submit" />
                        </form>
                        

                    </c:forEach>
            </c:if>
                
        <div class="video-container">
            <div class="row" id="flex">
        <c:forEach items="${sessionScope.searchResults}" var="search">
            <div id="col${status.index % 2 + 1}" class="col-md-6" 
                 style="margin-top: 20px;">
                
                <span class="text-info">FileName:</span> ${search.filename} <br>
                <span class="text-info">Score: </span> ${search.score} <br>
                <span class="text-info">Path: </span> ${search.path} <br>
                <span class="text-info">Content-Type: </span>${search.contentType}
                    <h5>Found Following Snippets in this Document :-</h5>
                    <c:forEach items="${search.fragments}" var="fragment" varStatus="status">
                        Snippet: ${fragment} <br>
                    </c:forEach>
                    
                <hr>
            </div>
                
        </c:forEach>
            </div>   
        </div>
    
			
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
			<!-- <div class="col-md-2">
			<strong><p>Job Seeker</p></strong>
			<p><a href="#">Register Now</a></p>
			<a href="#">Search Jobs</a></p>
			<a href="#">Login</a></p>
			<a href="#">View Applications</a></p>
			<a href="#">Job Alerts</a></p>
			</div> -->
			<!-- <div class="col-md-2">
			<strong><p>Employer</p></strong>
			<p><a href="#">Post a Job</a></p>
			<p><a href="#">Search Resume</a></p>
			<p><a href="#">Sign In</a></p>
			<p><a href="#">Register Now</a></p>
			<p><a href="#">Resume Alerts</a></p>
			</div>  -->
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
<script>
		$("#search").autocomplete("getdata.jsp");
	</script>

</body>
</html>
</html>
