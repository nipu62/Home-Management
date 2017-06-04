<%@page import="java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/plugin-css/homepage.css">
        <link href="css/plugin-css/topbar.css" rel="stylesheet" type="text/css" />
        <link href="css/plugin-css/viewstudent.css" rel="stylesheet" type="text/css" />
        <link href="<c:url value="css/plugin-css/bootstrap.min.css"/>" rel="stylesheet"/>
        <link href=css/plugin-css/homepage.css" rel="stylesheet" />

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            if (session.getAttribute("name") == null) {
                out.println("<script>parent.location.href='login.jsp'</script>");
            }
        %>
        <title>Home Manager</title>
        
        <link href="<c:url value="css/plugin-css/validationEngine.jquery.css"/>" rel="stylesheet"/>
              

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
            <div id="login">
                <div class="container">
                    <div id="triangle"></div>
                    <form class="loginform form-horizontal" action="InsertExpense" method="POST" onsubmit="return myFunction()" style="padding: 20px 50px 35px 50px;">
                        <h3 class="text-center" style="margin-bottom: 30px;">Insert Your Monthly Expenses</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Month:</label>
                                    <input type="text" class="loginfield form-control" name="month_name" value=""/>
                                </div>
                                
                                 <div class="form-group">
                                     <label>Rent:</label>
                                     <input  type="text" class="loginfield form-control" name="rent_expense" value=""/>
                                 </div>
                                
                                 <div class="form-group">
                                      <label>Food:</label>
                                     <input  type="text" class="loginfield form-control" name="food_expense" value=""/>
                                 </div>
                                
                                <div class="form-group">
                                    <label>Electricity:</label>
                                    <input  type="text" class="loginfield form-control" name="electricity_expense" value=""/>
                                </div>
                                
                                <div class="form-group">
                                    <label>Gass:</label>
                                    <input  type="text" class="loginfield form-control" name="gass_expense" value=""/>
                                </div>
                                <div class="form-group">
                                    <label>Water:</label>
                                    <input  type="text" class="loginfield form-control" name="water_expense" value="" />
                                </div>
                                
                                <div class="form-group">
                                    <label>Transport:</label>
                                    <input  type="text" class="loginfield form-control" name="transport_expense" value="" />
                                </div>
                            </div>
                            
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Tution:</label>
                                    <input  type="text" class="loginfield form-control" name="tution_expense" value="" />
                                </div>
                                
                                <div class="form-group">
                                    <label>Phone:</label>
                                    <input  type="text" class="loginfield form-control" name="phone_expense" value="" />
                                </div>
                                
                                <div class="form-group">
                                    <label>Shopping:</label>
                                    <input  type="text" class="loginfield form-control" name="shopping_expense" value="" />
                                </div>
                                
                                <div class="form-group">
                                    <label>Cable:</label>
                                    <input  type="text" class="loginfield form-control" name="cable_expense" value="" />
                                </div>
                                
                                <div class="form-group">
                                    <label>Internet:</label>
                                    <input  type="text" class="loginfield form-control" name="internet_expense" value="" />
                                </div>
                                
                                <div class="form-group">
                                    <label>Utility:</label>
                                    <input  type="text" class="loginfield form-control" name="utility_expense" value="" />
                                </div>
                                
                                <div class="form-group">
                                    <label>Travelling:</label>
                                    <input  type="text" class="loginfield form-control" name="travelling_expense" value="" />
                                </div>
                            </div>
                            
                            <div class="col-md-4 col-md-offset-4">
                                <input type="submit" class="loginSubmit center-block" value="Submit" style="margin-top: 20px; width: 50%;" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>