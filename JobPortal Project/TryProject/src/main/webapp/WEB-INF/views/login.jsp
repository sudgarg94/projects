<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
		<!-- <link rel="stylesheet" type="text/css" href="jobboard.css"> -->
		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		
		

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
				<a href="/main" class="navbar-brand"><img src="/images/logo-jobboard.png"></a>
			</div> <!-- Nav Header Ends here -->

			<div class="collapse navbar-collapse" id="navbar-collapse">

			</div>

				

		</div> <!-- Container Ends here -->
	</nav> <!-- NavBar Ends here -->
		<!--  FORM -->

		 <div class="container" id="container1">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-4	col-md-offset-3		">
                <!-- <div class="panel panel-default"> -->
                   
                        <h3 class="panel-title text-center">Login</h3>
                   
                    <div class="panel-body">
                        <form:form action="${contextPath}/user/login" method="post" commandName="user">
                            
                            <div class="form-group">
                                <form:input path="username" size="30" required="required" placeholder="Username" class="form-control input-md"/>
								
                            </div>
                        	<div class="form-group">
                                <form:input path="password" size="30" required="required" placeholder="Password" class="form-control input-md"/>
								<font color="red"><form:errors path="password" /></font>
                            </div>

                            <input type="submit" value="login" class="btn btn-info btn-block"><br>
                            <center><font color="red"><form:errors path="username" /></font></center><br>
                                                    	<center><h3>Not a User ?</h3><br>
<a href="${contextPath}/user/registerCompany">Register as a Company</a><br/><br>
<a href="${contextPath}/user/registerJobSeeker">Register as a Job Seeker</a><br/><br></center>
                        </form:form>

                    </div>
            </div>
        </div>
    </div>


		<script type="text/javascript" src="assets/js/bootstrap.js"></script>

</body>
</html>