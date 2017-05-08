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
<link rel="stylesheet" type="text/css" href="jobboard.css">

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

	<!-- FORM -->
	<div class="container" id="container1">
        <div class="row centered-form">
        
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-4	col-md-offset-3">
                <!-- <div class="panel panel-default"> -->
                   
                        <h3 class="panel-title text-center">Apply</h3>
                   
                    <div class="panel-body">
                        <form:form action="${contextPath}/job/apply" method="post" commandName="jobApplication" enctype="multipart/form-data">
                            <div class="form-group">
                            	<b>Job TITLE: </b> ${job.title} <br><br>
                            </div>

                            <div class="form-group">
                            	<b>Job Description: </b> ${job.message} <br><br>
                            </div>

                            <div class="form-group">
                            	<b>Company: </b> ${job.company.companyName} <br><br>
                            </div>

                            <div class="form-group">
                            	<b>First Name: </b> ${user.firstName}<br><br>
                            </div>

                            <div class="form-group">
                            	<b>Last Name: </b> ${user.lastName}<br><br>
                            </div>

                            <div class="form-group">
                                <span><b>Upload Resume:</b><input type="file" name="photo"/></span>
								<font color="red"><form:errors path="photo" /></font><br/><br/>
                            </div>
                        	
							<input type="hidden" name="jobId" value="${job.id}"/>
                        <input type="submit" value="Submit Application" class="btn btn-info">
            		</form:form>
                    </div>
            </div>
            
        </div>
    </div>
	

		

		 


		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>