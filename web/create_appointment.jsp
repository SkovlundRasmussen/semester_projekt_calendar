<%--
Jamie
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appointment</title>
</head>
<body>
<%@include file="includes/header.jsp" %>

<div id="wrapper">

    <h1>Opret ny tid</h1>

    <form action="/appointment" method="post">

        <div>
            <input type="hidden" name="customer_id" value="<c:out value="${customer_id}"/>"/>
            <input type="hidden" name="user_id" value="<c:out value="${user_id}"/>" />
            <label for="appointment-start-date-label">Appointment start date:</label>
            <input type="datetime-local" name="app_start_date" width="30" placeholder="Appointment start date"
                   id="appointment-start-date-label" maxlength="19" minlength="19" placeholder="2017-05-17 13:38:49"/>
        </div>
        <div>
            <div>
                <label for="appointment-session-length-label">Appointment session length:</label>
            </div>
            <div>
                <input type="number" step="any" name="app_session_length" min="0" max="24" width="30" id="appointment-session-length-label"/>
            </div>
        </div>
        <div>
            <label for="appointment-note-label">Appointment note:</label>
            <input type="text" name="app_note" width="30" id="appointment-note-label"/>
        </div>

            <input class="btn" type="submit" value="Opret"/>
            <p style="color: red;">${errorMessage}</p>
    </form>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
