<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Family Member</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        function disableBack() {
            window.history.forward();
        }

        function disableNavigation() {
            disableBack();
            setTimeout("disableBack()", 0);
            window.onunload = function () { null };
        }

        function clearUnloadHandler() {
            window.onunload = null;
        }

        // Disable back button
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        };
    </script>
    <style type="text/css">
        label {
            margin-bottom: 5px;
            margin-top: 15px; /* Increased margin-top for better spacing between rows */
        }
    </style>
</head>
<body>

    <div class="Container">
        <div style="height: 100px; width: 100%; background-color: #F01F25;">
        	<div class="d-flex justify-content-end" style="padding-top: 50px; margin-right: 15px;">
            	<p style="padding-botton:30px">${email}</p>
            	<form action="logout" onsubmit="disableNavigation(); clearUnloadHandler();">
                <input class="btn btn-secondary" type="submit" value="Logout">
            </form>
        </div>
        </div>
        <div class="col-md-12 form-container">
        <div class="border rounded p-5" style="">
            <form action="registerMember" style="margin-left: 350px; padding-bottom: 60px; padding-top: 20px" method="post" class="needs-validation" novalidate>
                <h1 style="color:#EEF0E5">Add your Family Member</h1>

                <div class="col-md-6">
                    <label class="form-label">Enter Your Name<span style="color: red; margin-left: 4px">*</span></label>
                    <input class="form-control" type="text" name="MEMBER_Name" required>
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                    <div class="invalid-feedback">
                        Please enter your name.
                    </div>
                </div>

                <div class="col-md-6">
                    <label class="form-label">GENDER:<span style="color: red; margin-left: 4px">*</span> </label>
                    <div class="form-check">
                        <input class="form-check-input" name="GENDER" type="radio" value="Male" checked required>
                        <label class="form-check-label" for="flexRadioDefault1">
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="GENDER" value="Female" required>
                        <label class="form-check-label" for="flexRadioDefault2">
                            Female
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="GENDER" value="Others" required>
                        <label class="form-check-label" for="flexRadioDefault2">
                            Others
                        </label>
                    </div>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Date of Birth:<span style="color: red; margin-left: 4px">*</span></label>
                    <input class="form-control" type="date" name="DATE_OF_BIRTH" required>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="vaccineDropdown">Select ID: <span style="color: red; margin-left: 4px">*</span></label>
                        <select class="form-control" name="ID_PROOF" required id="vaccineDropdown">
                            <option value="" disabled selected>Select a ID Type</option>
                            <option value="Aadhar Card">Aadhar Card <span style="color: red; margin-left: 4px">*</span></option>
                            <option value="PAN CARD">PAN CARD</option>
                            <option value="Voter Id">Voter Id</option>
                        </select>
                    </div>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Enter ${ID_PROOF} ID Proof Number <span style="color: red; margin-left: 4px">*</span></label>
                    <input class="form-control" type="text" name="ID_PROOF_NO" required>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="vaccineDropdown">Select Number of Vaccines: <span style="color: red; margin-left: 4px">*</span></label>
                        <select class="form-control" name="No_OF_DOSE" required id="vaccineDropdown">
                            <option value="" disabled selected>Select a No Of Vaccines</option>
                            <option value="1">1st dose </option>
                            <option value="2">2nd dose </option>
                            <option value="3">3rd dose</option>
                        </select>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="vaccineDropdown">Select Vaccine Name <span style="color: red; margin-left: 4px">*</span></label>
                        <select class="form-control" name="VACCINE_NAME" required id="vaccineDropdown">
                            <option value="" disabled selected>Select a VaccineName</option>
                            <option value="pfizer">pfizer</option>
                            <option value="Bharat Biotech">Bharat Biotech </option>
                            <option value="CO-Vaccine">CO-Vaccine</option>
                            <option value="COVISHIELD">COVISHIELD</option>
                        </select>
                    </div>
                </div>

                <div class="col-12">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                        <label class="form-check-label" for="invalidCheck">
                            Agree to terms and conditions
                        </label>
                        <div class="invalid-feedback">
                            You must agree before submitting.
                        </div>
                    </div>
                </div>
                
                <input type="hidden" name="EMAIL_ID" value="${email}">

                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Add Member</button>
                </div>
            </form>
            </div>
        </div>
        <div style="height: 200px; width:100%; background-color: #232F3E " id="footer"></div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-GLhlTQ8iKt9HxxRlxbt2QbKlqcqYXMbq5x1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-rv5k/AdQ64KvBxpy3FjBbrxN/ctz2RTPd4WpFt6W8FdRJSWV4hbsAgFqGgTm6HAe" crossorigin="anonymous"></script>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
    </script>
</body>
</html>
