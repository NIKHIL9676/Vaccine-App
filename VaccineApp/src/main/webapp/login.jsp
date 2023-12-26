<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Include Bootstrap and Font Awesome -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <!-- Add your custom styles -->
    <meta http-equiv="pragma" content="no-cache">
    
  	<script>
        $(document).ready(function() {
            // Clear browser history to prevent navigating back
            if (window.history && window.history.pushState) {
                window.history.pushState('', '', window.location.href);
                $(window).on('popstate', function() {
                    window.history.pushState('', '', window.location.href);
                });
            }
        });
    </script>
    
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body style="background-color: #DED0B6">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <div style="height: 100px; width: 100%; background-color: #F01F25;" id="header" action="/VaccineApp/submitDetails.jsp"></div>

<%
	response.setHeader("cache-control", "no-cache, no-store , must-revalidate");
%>
    <div class="container">
        <h1 style="text-align: center;">Welcome to the Login page</h1>
        <div class="col-md-8" style="margin-left: 30px">
            <span style="color: red; margin-left: 4px">${errorMessage}</span>
            <form class="border rounded p-5" style="background-color: #EEF0E5; margin: 30px; margin-left: 350px;" action="logintoaccount" method="POST">
            <p><span style="color: green; margin-left: 4px">${isPasswordResetted}</span></p>
               
                <label class="form-label"> Email ID : <span style="color: red; margin-left: 4px">${response}</span> </label>
                <input class="form-control" required type="text" name="EMAIL_ID">

                <label class="form-label"> Password :<span style="color: red; margin-left: 4px">${password}</label>
                <div class="input-group">
                    <input class="form-control" required type="password" name="PASSWORD">
                    <div class="input-group-addon" id="show_hide_password">
                        <a href=""><i class="fa fa-eye-slash" aria-hidden="true"></i></a>
                    </div>
                </div>
                
                
                <p style="margin-top: 10px"><a class="link-opacity-10-hover" href="/vaccineApp/ResetPassword.jsp">Forgot password?</a></p>
                <p style="margin-top: 10px">Don't have an account <a class="link-opacity-10-hover" href="register">Create Account</a></p>
                
                <input style="margin-top: 10px;" class="btn btn-info" type="submit" value="LOGIN">
            </form>
        </div>
        
        <div style="height: 200px; width:100%; background-color: #232F3E " id="footer"></div>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
    
    <!-- Include your custom scripts -->
    <!-- Add your script for password visibility toggle here -->
</body>
</html>
