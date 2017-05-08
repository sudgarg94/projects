<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<title>JobBoard</title>
	<meta name="description" content="Job Board">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- css -->
<link rel="stylesheet" type="text/css" href="/css/jobboard.css">

		<title>JobBoard</title>
		<style>


.centered-form {
    margin-top: 120px;
    margin-bottom: 120px;
}
</style>
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
				<a href="#" class="navbar-brand"><img src="/images/logo-jobboard.png"></a>
			</div> <!-- Nav Header Ends here -->

			<div class="collapse navbar-collapse" id="navbar-collapse">
					<a href="${contextPath}/user/logout" class="btn btn-warning navbar-btn navbar-right">Logout</a>
			</div>

				

		</div> <!-- Container Ends here -->
	</nav> <!-- NavBar Ends here -->

	<!-- VIDEO -->
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
                                
                                <c:if  test="${user.role=='Company' }">
                                <p style="color:white">Hi, ${user.companyName}</p><br>
								<a href="${contextPath}/job/add" class="btn btn-info btn-lg">Post A Job</a> <br /><br>
								<a href="${contextPath}/job/specificList" class="btn btn-info btn-lg" style="color:white" >View All Jobs Posted by you</a> <br />
								<input type="hidden" name="userID" value="${sessionScope.user.userID}"></input>
								</c:if>

								<c:if  test="${user.role=='JobSeeker' }">
								<p style="color:white">Hi, ${user.firstName}</p><br>
								<form action="${contextPath}/job/searchJob" method="get">
								<input type="text" name="jobTitle" class="form-control" placeholder="Job title"><span></span>
								<input type="submit" value="Search Job by Title" class="btn btn-danger"><br><br>
								</form>
								<a href="${contextPath}/job/list" class="btn btn-info btn-lg"">View All Jobs</a> <br /><br>
								<a href="${contextPath}/job/appliedList" class="btn btn-info btn-lg">View All Applied Jobs</a> <br />
								</c:if>
								

                            </div>
                            <div class="col-md-6"></div>
                        </div>
                    </div>
                </div>
            	</div>
            </div>

        </div>
	<!-- VIDEO ENDS HERE -->
	

		

		 


		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>