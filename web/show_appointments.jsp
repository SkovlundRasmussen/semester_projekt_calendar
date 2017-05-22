<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    ArrayList appointmentsList = (ArrayList) session.getAttribute("appointments");
    request.setAttribute("appointments", appointmentsList);
%>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="includes/header.jsp" %>


<div id="wrapper">
    <table>
        <thead>
        <tr>
            <th>
                ID
            </th>
            <th>
                Start
            </th>
            <th>
                Length
            </th>
            <th>
                Note
            </th>
        </tr>

        </thead>
        <tbody>

        <c:forEach items="${appointments}" var="appointment">
            <tr>
                <td><c:out value="${appointment.getAppointmentID()}"/></td>
                <td><c:out value="${appointment.getAppointmentDate()}"/></td>
                <td><c:out value="${appointment.getAppointmentLength()}"/></td>
                <td><c:out value="${appointment.getAppointmentNote()}"/></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>