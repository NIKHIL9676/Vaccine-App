<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>Registration</title>
</head>
<body style="background-color:#DED0B6">
    <div class="container-fluid">
        <div style="height: 100px; width: 100%; background-color: #F01F25;" id="header" action="/VaccineApp/submitDetails.jsp">
        </div>
        <h1 style="text-align: center;">welcome to the Registration page</h1>
        <div class="col-md-8" style="margin-left:30px">
            <p style="color:GREEN">${response}</p>
            <form class="border rounded p-5" method="POST" style="background-color:#EEF0E5; margin: 30px; margin-left: 350px;" action="submitDetails">
                <label class="form-label"> User Name :<span style="color:red; margin-left:4px">${username}</span></label>
                <input required class="form-control" type="text" name="USERNAME">
                <label class="form-label"> Email ID :<span style="color:red; margin-left:4px">${email}</span></label>
                <input required class="form-control" type="text" name="EMAIL_ID">
                <label class="form-label"> Password :<span style="color:red; margin-left:4px">${password}</span></label>
                <input required class="form-control" type="password" name="PASSWORD">
                <label class="form-label"> Confirm password :<span style="color:red; margin-left:4px">${password}</span></label>
                <input required class="form-control" type="password" name="CPASSWORD">
                <label class="form-label"> Gender :</label>
                <div style="margin-left:30px">
                    <div class="form-check">
                        <input required class="form-check-input" type="radio" name="GENDER" value="MALE" checked>
                        <label class="form-check-label" for="GENDER">Male</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="GENDER" value="FEMALE">
                        <label required class="form-check-label" for="GENDER">Female</label>
                    </div>
                </div>
                <label class="form-label"> Mobile Number :<span style="color:red; margin-left:4px">${mobile}</span></label>
                <input required style="margin-bottom:10px" class="form-control" type="text" name="MOBILE_NUMBER">
                <input class="btn btn-info" type="submit" value="REGISTER"><br>
                Already have an account <span style="padding-top:20px" ><a class="link-opacity-10-hover"
                        href="login">login</a></span><br>
            </form>
        </div>
        <div style="height: 200px; width:100%; background-color: #232F3E " id="footer">
        </div>
    </div>
</body>
</html>
