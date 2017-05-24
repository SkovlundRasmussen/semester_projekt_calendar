<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    request.setAttribute("appointment", session.getAttribute("appointment"));
%>
<head>
    <title>Tider</title>
</head>

<body>
<%@include file="includes/header.jsp" %>
</body>

<div id="wrapper">


    <h1>Rediger tid</h1>
    <form action="/edit_appointment" method="post"> <%-- Set action --%>

        <div>
            <input type="hidden" id="appointmentID" name="app_id" value="<c:out value="${appointment.getAppointmentID()}"/>"/>

            <label for="appointment-start-date" id="appointment-start-date-label">Appointment start date:</label>
            <input type="text" min="16" max="16" name="app_start_date" width="30" placeholder="Appointment start date"
                   id="appointment-start-date" value="<c:out value="${appointment.getAppointmentDate()}"/>"/>
        </div>

        <div>
            <label for="appointment-session-length" id="appointment-session-length-label">Appointment session length:</label>
            <input type="number" step="any" name="app_session_length" min="0" max="24" width="30" id="appointment-session-length"
                   value="<c:out value="${appointment.getAppointmentLength()}"/>"/>
        </div>

        <div>
            <label for="appointment-note-label">Appointment note:</label>
            <input type="text" name="app_note" width="30" id="appointment-note-label"value="<c:out value="${appointment.getAppointmentNote()}"/>"/>
        </div>

        <input type="submit" value="Rediger"/>
        <p style="color: red;">${errorMessage}</p>

    </form>

</div>

</html>
