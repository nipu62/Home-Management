<%@page import="java.util.*"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/plugin-css/homepage.css">
        <link href="css/plugin-css/topbar.css" rel="stylesheet" type="text/css" />
        <link href="css/plugin-css/viewstudent.css" rel="stylesheet" type="text/css" />
        <link href=css/plugin-css/homepage.css" rel="stylesheet" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="css/plugin-css/validationEngine.jquery.css"/>" rel="stylesheet"/>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            if (session.getAttribute("name") == null) {
                out.println("<script>parent.location.href='login.jsp'</script>");
            }
        %>
        <title>Home Manager</title>


    </head>
    <body>
        <div id="wrapper">
            <div id="title">
                <div id="titleimagecontainer">
                    <a href="home.jsp">
                        <img id=titleimage src="css/images/title.png" alt="Home Manager">
                    </a>
                </div>
                <div id="userAccount">
                    <ul id="usermenu">
                        <li>
                            <a id="username" href="#"><%=session.getAttribute("name")%> &#9662;</a>
                            <ul id="accountlist">
                                <li><a class="usermenuitem" href="insertData.jsp">Insert Family Info</a></li>
                                <li><a class="usermenuitem" href="insertExpense.jsp">Insert Monthly Expense</a></li>
                                <li><a class="usermenuitem" href="Logout">Log out</a></li>

                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div id="topbar">
                <nav id="linkNav">
                    <ul id="pagelinks">
                        <li><a href="/HomeManagement/FamilyInfo">family_info</a></li>
                        <li><a href="/HomeManagement/MonthelyExpense">Monthly_Expenses</a></li>
                        <li><a href="/HomeManagement/EarningMember">Earning_Members</a></li>
                        <li><a href="insertReview.jsp">Monthly_Review</a></li>
                        <li><a href="/HomeManagement/EmergencyContacts">emergency_contacts</a></li>
                        <li><a href="/HomeManagement/PieChartServlet">Statistics</a></li>
                        <li><a href="insertbloodgroup.jsp">Blood Group</a></li>
                    </ul>
                </nav>
            </div>



            <!-- page start-->
            <div class="row" id="editlogin">
                <div class="col-lg-6">
                    <section class="panel">
                        <header class="panel-heading">
                            Edit Information
                        </header>
                        <div class="panel-body" >
                            <form class="loginform" role="form" action="/HomeManagement/EditedEmergency?emergency_id=${emergency.emergency_id}" method="POST">
                                <div class="form-group">
                                    <label for="emergency_criteria">Criteria</label>
                                    <input type="text" class="loginfield" id="emergency_criteria" name="emergency_criteria" value="${emergency.emergency_criteria}">
                                </div>
                                <div class="form-group">
                                    <label for="emergency_contact">Contact No.</label>
                                    <input type="text" class="loginfield" id="emergency_contact" name="emergency_contact" value="${emergency.emergency_contact}">
                                </div>
                                
                                
                       
                                <button type="submit" class="btn btn-info">Submit</button>
                            </form>

                        </div>
                    </section>
                </div>
                <!-- page end-->






            </div>
    </body>
</html>