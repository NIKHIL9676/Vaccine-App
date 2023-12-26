<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Logout</title>
    <script>
        // Use JavaScript to redirect to the login page after a brief delay
        setTimeout(function(){
            window.location.href = "/VaccineApp/login";
        }, 2000); // Adjust the delay as needed (in milliseconds)
        window.history.forward();
        function noBack() { window.history.forward(); }
        noBack();
        window.onload = noBack;
        window.onpageshow = function(evt) { if (evt.persisted) noBack(); }
        window.onunload = function() { void(0); }
    </script>
</head>
<body>
    <p>Logging out...</p>
</body>
</html>
