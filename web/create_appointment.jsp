<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 16-May-17
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appointment</title>
</head>
<body>
<%@include file="includes/header.jsp" %>
</body>
<div id="wrapper">

    <h1>Opret ny tid</h1>

    <form action="/appointment" method="post">

        <div>
            <label for="appointment-start-date-label">Appointment start date:</label>
            <input type="date" name="app_start_date" width="30" placeholder="Appointment start date" id="appointment-start-date-label"/>
        </div>

        <div>
            <label for="appointment-session-length-label">Appointment session length:</label>
            <input type="text" name="app_session_length" width="30" id="appointment-session-length-label"/>
        </div>


        <div>
            <label for="appointment-note-label">Appointment note:</label>
            <input type="text" name="app_note" width="30" id="appointment-note-label"/>
        </div>

        <div>
            <input type="submit" value="Opret"/>
        </div>
    </form>
</div>
</html>
