<?php

echo '<html lang="en">

<head>
	  <title>Find Your Doctor</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="icon" href="./images/favicon.ico">

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	  <!--<link rel="stylesheet" href="mycssfile.css">-->
	  
	  <style>
		body{
			padding-top:40px;
			background: url("./images/bg.png");
		}
		.dropdown-menu{
			background-color:#D3D3D3;
		}
		
		.navbar-inverse .navbar-nav li a:hover, .navbar-default .navbar-nav li a:focus {
			background-color: #6495ED;
			color: #000000;
		}
		
		.btn{
			margin-left:10px;
		}
		.carousel-inner .item img {
  
			height:450px;
		}
		.carousel-caption{
			font-weight:bold;
			font-style:italic;
		}
		
		.jumbotron{
			background-color:#E0FFFF;
			background: url("./images/jumbo9.jpg");
			color:#fff;
			font-weight:bold;
			font-size:16px;
		}
		
		.jumbotron.achievements{
			padding-top:15px;
			padding-bottom:10px;
			font-weight:normal;
			color:#000000;
		}
		
		.jumbotron.achievements h3, .jumbotron.achievements small{
			color:#fff;
			font-weight:bold;
		}
		
		#service blockquote{
			background: url("./images/test.jpg");
			background-color:#E0FFFF;
			font-size:18px;
			font-weight:bold;
			color:#fff;
		
		}
		
		#service blockquote small{
			padding-top:15px;
			color:#fff;
		
		}
		
		
		
		.footer{
			background-color:#333333;
			padding:20px,0;
			color:#fff;
			padding-bottom:20px;
			margin-top: 53px;
		
		}
		.footer img{
			padding-top:20px;
		}
		.footer ul{
			list-style:none;
			margin:0;
			padding:0;
		}
		.footer ul li a{
			color:#fff;
			font-size:15px
		}
		
		.panel-info form p{
			font-weight: bold;
			font-size:12px;
			text-align : center;
		}
		
		.shift{
			padding-left:138px;
		
		}

	  </style>
	  
</head>


<body>
';
//<!-----------------------------NAVBAR SECTION BELOW---------------------->
echo '
	<nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
		<div class = "container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="index.html" class="navbar-brand">LiveSmart</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
			
			<!-- <a href="" class="btn btn-info navbar-btn navbar-right">Create Account</a>
			<a href="" class="btn btn-info navbar-btn navbar-right">Sign In</a> -->
			
				<ul class="nav navbar-nav">
								<!--<li><a href="#">Home</a></li>-->
								<ul class="nav navbar-nav">
								<li><a href="index.html#aboutus">About Us</a>
								<li><a href="index.html#services">Services</a>
								<li><a href="index.html#achievements">Achievements</a>
								<li><a href="feedback.html">Feedback</a>
								</ul>
					
					
					<li class="dropdown">
						<a href="#" data-toggle="dropdown">Doctors
						<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="FindDoctor.html">Find A Doctor</a></li>
								<li><form action="requestappt.php" method=post><button type="submit" class="btn">Book Appointments</button></a></form></li>
								
							</ul>
					</li>
					
					<li class="dropdown">
						<a href="#" data-toggle="dropdown">Chemists
						<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="FindStores.html">Find Stores</a></li>
								<li><a href="FindMedicine.html">Medicines</a></li>
							</ul>
					</li>
					
					
					
				</ul>
			</div>
			

		</div>
	</nav>
';	
//<!-----------------------------COMPANY BANNER SECTION BELOW---------------------->	
echo '	
	<div class="jumbotron">
		<div class="container text-center">
			<h1>LiveSmart</h1>
			<p>Your Healthcare Buddy</p>
			
			
		</div>
	</div>
';	
	
	
//<!-----------------------------Find Doctors---------------------->	
	
echo "	<h2><center>Your Pharmacy Store Results<center></h2>";
	


DEFINE ('DB_USER', 'root');
DEFINE ('DB_PASSWORD', '');
DEFINE ('DB_HOST', 'localhost');
DEFINE ('DB_NAME', 'webdesign');

// Make the connection.
$dbc = @mysql_connect (DB_HOST, DB_USER, DB_PASSWORD) OR die ('Could not connect to MySQL: ' . mysql_error() );

// Select the database.
@mysql_select_db (DB_NAME) OR die ('Could not select the database: ' . mysql_error() );

$pickup = $_POST['location'];
//$special = $_POST['specialization'];

//echo $pickup;

//$sql = 'SELECT * from findingdoctor where City = $pickup';

$retval = mysql_query( "SELECT * FROM finding_store WHERE City LIKE '$pickup' ", $dbc );

if (!$retval) { // add this check.
    die('Invalid query: ' . mysql_error());
}

 
	echo "<center><table  style='border: 5px solid; width:1500px;' class='table table-bordered'>";
	
	echo "<thead>
			<tr>
		  
		  <th>Store Name</th>
		  <th>City</th>
		  <th>Store Address</th>
		  
		   
		  </tr>
		  </thead><tbody>";


while($row = mysql_fetch_array($retval, MYSQL_ASSOC))
{
	
	//echo "EMP ID :{$row['Doctor_Id']}  <br> ". "EMP NAME : {$row['Doctor_Name']} <br> ".  "EMP SALARY : {$row['City']} <br> ". "--------------------------------<br>";
  
	
	echo "<tr><td>".$row["Store_Name"]."</td><td>".$row["City"]."</td><td> ".$row["Store_Address"]."</td></tr>";
	
	
	
	
	
	
	
	
}
echo "</tbody></table></center>";

mysql_close($dbc);

echo "<br><br>";

echo '<center><a href="FindStores.html" class="btn btn-lg btn-warning">Make New Search</a></center>';
	
	
//<!-----------------------------FOOTER SECTION BELOW---------------------->	
	echo '
	<div class="container-fluid footer">
		<div class="container">
			
			
			<div class="col-sm-6">
				<img src="./images/title.png" class="img-responsive">
				<p>Providing the best healthcare solutions to people.<br>Your well being is our moto and success</p>
				
				<!--<a href="" class="social-icons"><i class="fa fa-facebook"></i></a>-->
				
				
				
			</div>
			
			<div class="col-sm-3">
				<h3>Quick Links</h3>
					<ul>
						<li><a href="index.html">&raquo;Home</a></li>
						<li><a href="index.html#aboutus">&raquo;About Us</a></li>
						<li><a href="FindStores.html">&raquo;Medical Centers</a></li>
						<li><a href="FindMedicine.html">&raquo;Medicines</a></li>
						<li><a href="FindDoctor.html">&raquo;Doctors</a></li>
						
					</ul>
			
			</div>
			
			<div class="col-sm-3">
				<h3>Contact Us</h3>
					<p><strong>Headquarters:</strong>225 Huntington Avenue<br>Boston MA-02120</p>
					<p><strong>Email Us At:</strong>care@livesmart.com</p>
					<p><strong>Phone: </strong>+1 (800)-800-0000</p>
					<p><strong>Fax: </strong>+1 (750)-888-9900</p>
			
			</div>
			
		</div>
		<div class="text-center"><br><br>
			<p><i>Copyright &copy; 2017 LiveSmart Inc.<br>
			<a href="mailto:admin@livesmart.com">care@livesmart.com</a></i></p>
		</div>
	
	</div>
			
			
			


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
</body>
</html>';
?>