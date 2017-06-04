<%@page import="java.util.*"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/plugin-css/homepage.css">
        <link href="css/plugin-css/topbar.css" rel="stylesheet" type="text/css" />
        <link href="css/plugin-css/viewstudent.css" rel="stylesheet" type="text/css" />
        <link href="<c:url value="css/plugin-css/bootstrap.min.css"/>" rel="stylesheet"/>
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
            <div class="container" id="editlogin">
                <form class="loginform" role="form" action="/HomeManagement/EditedExpense?month_id=${expense.month_id}" method="POST" style="padding: 20px 50px 35px 50px;">
                    <div class="row">
                        <h3 class="text-center" style="margin-bottom: 30px;">Edit Information</h3>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="month_name">Month </label>
                                <input type="text" class="loginfield form-control" id="month_name" name="month_name" value="${expense.month_name}">
                            </div>                             
                            <div class="form-group">
                                <label for="rent_expense">Rent </label>
                                <input type="text" class="loginfield form-control" id="rent_expense" name="rent_expense" value="${expense.rent_expense}">
                            </div>
                            <div class="form-group">
                                <label for="food_expense">Food</label>
                                <input type="text" class="loginfield form-control" id="food_expense" name="food_expense" value="${expense.food_expense}">
                            </div>
                            <div class="form-group">
                                <label for="electricity_expense">Electricity </label>
                                <input type="text" class="loginfield form-control" id="electricity_expense" name="electricity_expense" value="${expense.electricity_expense}">
                            </div>
                            <div class="form-group">
                                <label for="gass_expense">Gass </label>
                                <input type="text" class="loginfield form-control" id="gass_expense" name="gass_expense" value="${expense.gass_expense}">
                            </div>
                            <div class="form-group">
                                <label for="water_expense">Water </label>
                                <input type="text" class="loginfield form-control" id="water_expense" name="water_expense" value="${expense.water_expense}">
                            </div>
                            <div class="form-group">
                                <label for="transport_expense">Transport </label>
                                <input type="text" class="loginfield form-control" id="transport_expense" name="transport_expense" value="${expense.transport_expense}">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="tution_expense">Tution </label>
                                <input type="text" class="loginfield form-control" id="tution_expense" name="tution_expense" value="${expense.tution_expense}">
                            </div>
                            <div class="form-group">
                                <label for="phone_expense">Phone </label>
                                <input type="text" class="loginfield form-control" id="phone_expense" name="phone_expense" value="${expense.phone_expense}">
                            </div>
                            <div class="form-group">
                                <label for="shopping_expense">Shopping </label>
                                <input type="text" class="loginfield form-control" id="shopping_expense" name="shopping_expense" value="${expense.shopping_expense}">
                            </div>
                            <div class="form-group">
                                <label for="cable_expense">Cable </label>
                                <input type="text" class="loginfield form-control" id="cable_expense" name="cable_expense" value="${expense.cable_expense}">
                            </div>
                            <div class="form-group">
                                <label for="internet_expense">Internet </label>
                                <input type="text" class="loginfield form-control" id="internet_expense" name="internet_expense" value="${expense.internet_expense}">
                            </div>
                            <div class="form-group">
                                <label for="utility_expense">Utility </label>
                                <input type="text" class="loginfield form-control" id="utility_expense" name="utility_expense" value="${expense.utility_expense}">
                            </div>
                            <div class="form-group">
                                <label for="travelling_expense">Travelling </label>
                                <input type="text" class="loginfield form-control" id="travelling_expense" name="travelling_expense" value="${expense.travelling_expense}">
                            </div> 
                        </div>
                        
                        <div class="col-md-4 col-md-offset-4">
                            <button type="submit" class="btn btn-info center-block">Submit</button>
                        </div>
                    </div>   
                </form>
            </div>
        </div>
    </body>
</html>