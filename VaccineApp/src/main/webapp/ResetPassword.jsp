<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #DED0B6">
	<div class="container-fluid">
		<div style="height: 100px; width: 100%; background-color: #F01F25;" id="header" action="/VaccineApp/submitDetails.jsp"></div>
		
		<div class="col-md-8" style="margin-left: 30px">
            <p><span style="color: red; margin-left: 4px">${errorMessage}</span></p>
            <form class="border rounded p-5" style="background-color: #EEF0E5; margin: 30px; margin-left: 350px;"
                action="resetPassword" method="post">
                <label class="form-label"> Email ID : <span style="color: red; margin-left: 4px">${response}</span> </label>
                <input class="form-control" required type="text" name="EMAIL_ID">

                <label class="form-label"> Password :<span style="color: red; margin-left: 4px">${password}</label>
                <input class="form-control" required type="password" name="PASSWORD">
              
                <label class="form-label"> Confirm Password :<span style="color: red; margin-left: 4px">${password}</label>
                <input class="form-control" required type="password" name="Confirm_PASSWORD">
              
                                       
                <input style="margin-top: 10px;" class="btn btn-info" type="submit" value="Reset">
            </form>
        </div>
		
		<div style="height: 200px; width:100%; background-color: #232F3E " id="footer"></div>
	</div>
</body>
</html>