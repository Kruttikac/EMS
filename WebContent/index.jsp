<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <title>Test Page</title>
 		<link rel="stylesheet" type="text/css" href="css/Index/form.css" />
 		<link rel="stylesheet" type="text/css" href="css/Index/style.css" />
    </head>	
    <body>
		<div id='cssmenu'>
			<ul>
			   <li class='active'><a href='index.html'><span>Home</span></a></li>
			  <!-- <li><a href='#'><span></span></a></li>-->
			   <li><a href='#'><span>About</span></a></li>
			   <li class='last'><a href='#'><span>Contact</span></a></li>

			</ul>
		</div>
    	<div id="main">
    		<div class="container">
		    <div class="login">
		      <h1>Employee Login</h1>
		      <form method="post" action="LoginServlet">
		        <p><input type="text" name="id" value="895727" ></p>
		        <p><input type="password" name="password" value="employee1" ></p>
		        <p class="remember_me">
		          <label>
		            <input type="checkbox" name="remember_me" id="remember_me">
		            Remember me on this computer
		          </label>
		        </p>
		        <p class="submit"><input type="submit" name="commit" value="Login"></p>
		      </form>
		    </div>

		    <div class="login-help">
		      <p>Forgot your password? <a href="EmployeeID.html">Click here to reset it</a>.</p>
		    </div>
		  </div>
    	</div>
    	<div id="footer">
    		<br>
             Footer
    	</div>
    </body>
</html>