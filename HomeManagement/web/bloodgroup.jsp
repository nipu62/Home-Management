<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/plugin-css/homepage.css">
        <link href="css/plugin-css/topbar.css" rel="stylesheet" type="text/css" />
        <link href="css/plugin-css/viewstudent.css" rel="stylesheet" type="text/css" />
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
            }
            td{
                text-align:center; 
                vertical-align:middle;
            }
        </style>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            if (session.getAttribute("name") == null) {
                out.println("<script>parent.location.href='login.jsp'</script>");
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <title>Home Manager - View Student</title>
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
                            <a id="username" href="#"><%=session.getAttribute("name")%></a>
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
                        <li><a href="/HomeManagement/EmergencyContacts">Emergency_Contacts</a></li>
                        <li><a href="/HomeManagement/PieChartServlet">Statistics</a></li>
                        <li><a class="selected" href="insertbloodgroup.jsp">Blood Group</a></li>
                    </ul>
                </nav>

                <table style="width:100%">
                    <thead>
                        <tr>              


                            <th> Name  </th>
                            <th>Blood Group </th>
                            <th>Location </th>
                            <th>Contact </th>


                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${GroupList}" var="group">
                            <tr>


                                <td><c:out value="${group.member_name}" /></td>
                                <td><c:out value="${group.member_blood_group}" /></td>
                                <td><c:out value="${group.member_location}" /></td>
                                <td><c:out value="${group.member_contact_no}" /></td>


                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>

    </body>
</html>