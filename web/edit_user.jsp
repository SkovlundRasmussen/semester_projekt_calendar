<%--
  Created by IntelliJ IDEA.
  User: Peter
  Date: 22-05-2017
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>User</title>
</head>

<body>
<%@include file="includes/header.jsp" %>
</body>

<div id="wrapper">

    <h1>Nyt password</h1>

    <form action="/users" method="post">

        <div>
            <label name="current-user">Ændre password for:</label>
        </div>

        <div>
            <label for="password-label">Password:</label>
            <input type="password" name="userPass" width="30" id="password-label"/>
        </div>

        <div>
            <label for="new-password-label">Indtast nyt password:</label>
            <input type="password" name="userPass" width="30" id="new-password-label"/>
        </div>

        <div>
            <label for="reenter-new-password-label">Gentag nyt password:</label>
            <input type="password" name="userPass2" width="30" id="reenter-new-password-label"/>
        </div>

        <div>
            <input type="submit" value="Ændre password"/>
        </div>

        <p style="color: red;">${errorMessage}</p>

    </form>

</div>
</html>