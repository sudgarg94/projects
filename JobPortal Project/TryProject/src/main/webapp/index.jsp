<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
	<title>JobBoard</title>
	<meta name="description" content="Job Board">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- css -->
<link rel="stylesheet" type="text/css" href="/css/jobboard.css">
</head>


<body data-spy="scroll" data-target="#my-navbar">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
				<a href="/main" class="navbar-brand"><img src="/images/logo-jobboard.png"></a>
			</div> <!-- Nav Header Ends here -->

			<div class="collapse navbar-collapse" id="navbar-collapse">

				
				<ul class="nav navbar-nav pull-right">

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Job Seeker <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="user/login">Log In</a></li>
            <li><a href="user/registerJobSeeker">Register as a JobSeeker</a></li>
          </ul>
        </li>
		
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Company <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="user/login">Log In</a></li>
            <li><a href="user/registerCompany">Register as a Company</a></li>
          </ul>
        </li>
		
		  <li><a href="user/login">Log In</a></li>
        
      </ul>
			</div>

				

		</div> <!-- Container Ends here -->
	</nav> <!-- NavBar Ends here -->

 <div class="homepage-hero-module">
            <div class="video-container">
	            		<video autoplay loop class="fillWidth" width="100%" height="200px">
		                    <source src="/video/jobboard.mp4" type="video/mp4" />
		                    Your browser does not support the video tag. I suggest you upgrade your browser.
		                </video>
		        <div class="overlay">
                <div class="title-container">
                    <div class="container home-margin">
                    	<!-- Job Section -->
                        <div class="row">
                            <div class="col-md-6">
                                <h1 class="headline">
                                <form action="job/searchJob" method="get">
                                <!-- , keywords or company name -->
								<input type="text" name="jobTitle" class="form-control" placeholder="Job title"><span></span>
								<input type="submit" value="Search Job by Title" class="btn btn-danger"><br><br>
								</form>
								<a href="job/list" class="btn btn-info btn-lg"">View All Jobs</a> <br /><br>
                            </div>
                            <div class="col-md-6"></div>
                        </div>
                    </div>
                </div>
            	</div>
            </div>

        </div>
        <br><br><br>
        	<!-- CONTENT -->
        	
        	
        	
        	<!--  -->		
<!-- Footer -->
 <div class="container-fluid footer-container">		
            <footer class="container">
            	<h1 class="page-header">
                        <center>You can get a Job, If you know where to Find !</center><br>
                    </h1>
			<div class="row">
			<div class="col-md-4">
			<h3>About</h3>
			<p>Morbi convallis bibendum urna ut viverra. Maecenas quis consequat libero, a feugiat eros. Nunc ut lacinia tortor morbi ultricies laoreet ullamcorper phasellus semper.</p>
			<button class="btn btn-lg btn-info" onclick="location.href='#'" type="submit">GET STARTED</button>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-2">
			<strong><p>Job Seeker</p></strong>
			<p><a href="#">Register Now</a></p>
			<a href="#">Search Jobs</a></p>
			<a href="#">Login</a></p>
			<a href="#">View Applications</a></p>
			</div>
			<div class="col-md-2">
			<strong><p>Employer</p></strong>
			<p><a href="#">Post a Job</a></p>
			<p><a href="#">Search Resume</a></p>
			<p><a href="#">Sign In</a></p>
			<p><a href="#">Register Now</a></p>
			</div>
			<div class="col-md-2">
			<strong><p>Information</p></strong>
			<p><a href="#">About Us</a></p>
			<p><a href="#">Terms & Conditions</a></p>
			<p><a href="#">Privacy Policy</a></p>
			<p><a href="#">Contact Us</a></p>
			</div>
			</div>
			
			<hr class="line">
			<br><br>
			<div class="row">
			<div class="col-md-10"><p>&copy; JobboardSoftware 2016</p></div>
			<div class="col-md-2 pull-right">
			</div>
			 
			</div>
			
			
            </footer>
			</div>
<!--  -->


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <img src = "/images/logo-jobboard.png" /><br><br>

<a href="user/registerCompany">Register as a Company</a><br/><br>

<a href="user/registerJobSeeker">Register as a JobSeeker</a><br/><br>

<a href="user/login">Log In</a><br/><br> -->
	
</body>
</html>