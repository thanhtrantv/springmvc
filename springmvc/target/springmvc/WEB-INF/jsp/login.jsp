<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="styles/login.css">
        <script type="text/javascript" src="javascript/login.js"></script>
    </head>
    <body>
		<div class="loading-bar" style="display:none;">
            <div class="spiner" ></div>
        </div>
        <div style="width:50%;margin:0 auto;">
	        <h2>Login</h2>
	
			<form action="login/authenticate" method="POST">
			  <div class="imgcontainer">
			    <img src="images/img_avatar2.png" alt="Avatar" class="avatar">
			  </div>
			
			  <div class="container">
			    <label><b>Username</b></label>
			    <input type="text" placeholder="Enter Username" name="username" required>
			
			    <label><b>Password</b></label>
			    <input type="password" placeholder="Enter Password" name="password" required>
			        
			    <button type="submit">Login</button>
			    <input type="checkbox" checked="checked"> Remember me
			  </div>
			
			  <div class="container" style="background-color:#f1f1f1">
			    <button type="button" class="cancelbtn">Cancel</button>
			    <span class="psw">Forgot <a href="#">password?</a></span>
			  </div>
			</form>
		</div>
		<script>
			// Get the modal
			var modal = document.getElementById('id01');
			
			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			    if (event.target == modal) {
			        modal.style.display = "none";
			    }
			}
		</script>
    </body>
</html>