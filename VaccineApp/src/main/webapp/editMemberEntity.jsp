<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Include Bootstrap and Font Awesome -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="Container">
		<div style="height: 100px; width: 100%; background-color: #F01F25;" id="header" >
		
			<div class="Container">
			<div class="col-md-12 form-container">
        <div class="border rounded p-5" style="">
            <form method="POST" action="submitModifiedMemberEntity" style="margin-left: 350px;margin-top:40px padding-bottom: 60px; padding-top: 90px" method="post" class="needs-validation" novalidate>

				<input type="hidden" name="MEMBER_ID" value="${MEMBER_ID}">
                <div class="col-md-6">
                    <label class="form-label">Enter Your Name<span style="color: red; margin-left: 4px">*</span></label>
                    <input class="form-control" type="text" name="MEMBER_Name" value=${MEMBER_Name} required>
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                    <div class="invalid-feedback">
                        Please enter your name.
                    </div>
                </div>
				<div class="col-md-6">
                    <div class="form-group">
                        <label for="vaccineDropdown">Select ID PROOF  <span style="color: red; margin-left: 4px">*</span></label>
                        <select class="form-control" name="ID_PROOF" required id="vaccineDropdown">
                            <option value="${ID_PROOF}" disabled selected>${ID_PROOF}</option>
                            
                        </select>
                    </div>
                </div>
         
                <div class="col-md-6">
                    <label class="form-label"> ID Proof Number <span style="color: red; margin-left: 4px">*</span></label>
                    <input class="form-control" type="text" name="ID_PROOF_NO" value="${ID_PROOF_NO}" required>
                </div>

                <div class="col-md-6">
    <div class="form-group">
        <label for="vaccineDropdown">Select Number of Vaccines: <span style="color: red; margin-left: 4px">*</span></label>
        <select class="form-control" name="No_OF_DOSE" required id="vaccineDropdown">
            <option value="1" ${No_OF_DOSE == 1 ? 'selected' : ''}>1st dose </option>
            <option value="2" ${No_OF_DOSE == 2 ? 'selected' : ''}>2nd dose </option>
            <option value="3" ${No_OF_DOSE == 3 ? 'selected' : ''}>3rd dose</option>
        </select>
    </div>
</div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="vaccineDropdown">Select Vaccine Name <span style="color: red; margin-left: 4px">*</span></label>
                        <select class="form-control" name="VACCINE_NAME" required id="vaccineDropdown">
                            <option value="${VACCINE_NAME}" disabled selected>${VACCINE_NAME}</option>
                            
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
                
                <input type="hidden" name="EMAIL_ID" value="${EMAIL_ID}">

                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Update</button>
                </div>
            </form>
            </div>
        </div>
			
			</div>
		
		<div style="height: 200px; width:100%; background-color: #232F3E " id="footer"></div>
		
	</div>

</body>
</html>