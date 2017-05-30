<%--
User: Kristian
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>

<body>
<%@include file="includes/header.jsp" %>


<div id="wrapper">

    <h1>Nyt password</h1>

    <form action="/edit_user" method="post">

        <div>
            <label name="current-user">Skift password for: <c:out value="${user_name}"/></label>
        </div>
        <br>
        <div>
            <input type="hidden" id="userID" name="userID" value="<c:out value="${user_id}"/>"/>
            <label for="new-password-label">Indtast nyt password:</label>
            <input type="password" name="userPass" width="30" id="new-password-label"/>
        </div>

        <div>
            <label for="reenter-new-password-label">Gentag nyt password:</label>
            <input type="password" name="userPass2" width="30" id="reenter-new-password-label"/>
        </div>

        <div>
            <input type="submit" value="Skift password"/>
        </div>

        <p style="color: red;">${errorMessage}</p>

    </form>
    <%@include file="includes/footer.jsp" %>
</div>
</body>
</html>