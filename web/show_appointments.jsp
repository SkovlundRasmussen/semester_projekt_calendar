<%--
User: Jamie
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Se tider</title>
</head>
<body>
<%@include file="includes/header.jsp" %>

<div id="wrapper">

    <h1>Se tid</h1>
    <form action="/show_appointment" method="post"> <%-- Set action --%>

    <table>
        <thead>
        <tr>
            <th>Startstid</th><th>Antal timer</th><th>Note</th><th>Rediger aftale</th>
        </tr>

        </thead>
        <tbody>

        <c:forEach items="${appointments}" var="appointment">
            <tr>
                <%--<td><c:out value="${appointment.getAppointmentID()}"/></td>--%>
                <td><c:out value="${appointment.getAppointmentDate()}"/></td>
                <td><c:out value="${appointment.getAppointmentLength()}"/></td>
                <td><c:out value="${appointment.getAppointmentNote()}"/></td>
                <td><c:url var="id_url" value="${appointment.getAppointmentID()}"/>
                    <a href="edit_appointment?appointment_id=${appointment.getAppointmentID()}">Rediger</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

        <%@include file="includes/footer.jsp" %>
</div>


</body>
</html>