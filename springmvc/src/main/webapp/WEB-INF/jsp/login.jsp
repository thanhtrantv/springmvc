<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="styles/app.css">
        <script type="text/javascript" src="javascript/login.js"></script>
    </head>
    <body>
		<div class="loading-bar">
            <div class="spiner" ></div>
        </div>
        <div class="login-container">
          <div class="username-form form-control">
          	<label >User Name</label>
            <input type="text" id="username" name="username">
          </div>
          <div class="password-form  form-control">
              <label >Password</label>
              <input type="password" id="password" name="password">
          </div>
          <button value="Login" id="submit" name="submit" onClick="login()">Login</button>
        </div>
        
        <jsp:include page = "footer.jsp" flush = "true" />
    </body>
</html>