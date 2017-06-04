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
                            <form class="loginform" role="form" action="/HomeManagement/EditedMember?member_id=${member.member_id}" method="POST">
                                <div class="form-group">
                                    <label for="member_name">Member Name</label>
                                    <input type="text" class="loginfield" id="member_name" name="member_name" value="${member.member_name}">
                                </div>
                                <div class="form-group">
                                    <label for="member_gender">Member Gender</label>
                                    <input type="text" class="loginfield" id="member_gender" name="member_gender" value="${member.member_gender}">
                                </div>
                                <div class="form-group">
                                    <label for="member_age">Member Age</label>
                                    <input type="text" class="loginfield" id="member_age" name="member_age" value="${member.member_age}">
                                </div>
                                <div class="form-group">
                                    <label for="member_occupation">Member Occupation</label>
                                    <input type="text" class="loginfield" id="member_occupation" name="member_occupation" value="${member.member_occupation}">
                                </div>
                                <div class="form-group">
                                    <label for="member_income">Member Income</label>
                                    <input type="text" class="loginfield" id="member_income" name="member_income" value="${member.member_income}">
                                </div>
                                <div class="form-group">
                                    <label for="member_blood_group">Member Blood Group</label>
                                    <input type="text" class="loginfield" id="member_blood_group" name="member_blood_group" value="${member.member_blood_group}">
                                </div>
                                <div class="form-group">
                                    <label for="member_contact_no">Member Contact No.</label>
                                    <input type="text" class="loginfield" id="member_contact_no" name="member_contact_no" value="${member.member_contact_no}">
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