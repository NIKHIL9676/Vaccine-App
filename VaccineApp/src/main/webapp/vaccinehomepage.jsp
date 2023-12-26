<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Vaccine page</title>
    <!-- Include Bootstrap and Font Awesome -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div style="height: 100px; width: 100%; background-color: #F01F25;" id="header" >
        <div class="d-flex justify-content-end" style="padding-top: 50px; margin-right: 15px;">
            <p style="padding-botton:30px">${email}</p>
            <form id="logoutForm" action="logout" method="post">
                <input class="btn btn-secondary" type="submit" value="Logout">
            </form>
        </div>

        <h1>${response}</h1>
        <div class="d-flex justify-content-start" style="padding-top: 50px; margin-right: 15px;">
            <form style="margin-left:40px" action="addmember" method="POST" >
                <input name="email" value="${email}" type="hidden">
                <input  class="btn btn-secondary" type="submit" value="Add">
            </form>
            <br>
        </div>
        <span style="color:${response_color}">${response}</span>
        
        <br>    

        <div class="container">
            <% try { %>
                <div class="row">
                    <c:if test="${not empty members}">
                        <c:forEach var="member" items="${members}">
                            <div class="col-md-4">
                                <div class="card-body">
                                    <h5 class="card-title">${member.getMEMBER_Name()}</h5>
                                    <p class="card-text">${member.getGENDER()}</p>
                                    <p class="card-text">${member.getVACCINE_NAME()}</p>
                                    <p class="card-text">No Of Doses: ${member.getNo_OF_DOSE()}</p>
                                    
                                    <table>
                                        <tr>
                                            <td>
                                                <form action="editMemberEntity" method="POST">
                                                    <input type="hidden" name="EMAIL_ID" value="${email}">
                                                    <input type="hidden" name="MEMBER_ID" value="${member.getMEMBER_ID()}">
                                                    <input type="hidden" name="MEMBER_Name" value="${member.getMEMBER_Name()}">
                                                    <input type="hidden" name="VACCINE_NAME" value="${member.getVACCINE_NAME()}">
                                                    <input type="hidden" name="NO_OF_DOSE" value="${member.getNo_OF_DOSE()}">
                                                    <input type="hidden" name="ID_PROOF" value="${member.getID_PROOF()}">
                                                    <input type="hidden" name="ID_PROOF_NO" value="${member.getID_PROOF_NO()}">
                                                    
                                                    <input type="submit" class="btn btn-warning" value="Edit">
                                                </form>
                                            </td>
                                            <td>
                                                <form action="deleteMemberEntity" method="POST">
                                                    <input type="hidden" name="id" value="${member.getID()}">
                                                    <input type="hidden" name="EMAIL_ID" value="${email}">
                                                    <input type="hidden" name="MEMBER_ID" value="${member.getMEMBER_ID()}">
                                                    <input type="submit" class="btn btn-danger" value="Delete">
                                                </form>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            <%  %>
            <%}catch(Exception e){ %>
                <p style="color:#B31312"> You Have not added any one of your Family Members</p>
            <%} %>
        </div>
    </div>

   <script>
    document.getElementById('logoutForm').addEventListener('submit', function (event) {
        // Prevent the default form submission
        event.preventDefault();

        // Perform any logout-related logic here

        // Clear browser history
        window.location.replace('/VaccineApp/login');
        
        // Disable back navigation
        window.history.pushState(null, null, '/VaccineApp/login');
        window.onpopstate = function () {
            window.history.pushState(null, null, '/VaccineApp/login');
        };
    });
</script>
       


</div>
</body>
</html>
