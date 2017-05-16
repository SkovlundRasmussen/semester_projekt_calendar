<%--
  Created by IntelliJ IDEA.
  User: Toldam
  Date: 16-May-17
  Time: 13:34
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
<h1>Opret ny bruger</h1>
<form> <%-- Set action --%>
        <div>
        <label for="userID">Bruger ID:</label>
        <label type="text" name="userID" width="30" id="userID"/> <%-- value="AI ID" --%>
        </div>
<div>
        <label for="user-name-label">Brugernavn:</label>
        <input type="text" name="userName" width="30" placeholder="Brugernavn" id="user-name-label"/>
</div>
<div>
        <label for="password-label">Password:</label>
        <input type="password" name="password" width="30" id="password-label"/>
</div>
<div>
        <label for="second-password-label">Gentag password:</label>
        <input type="password" name="repeatPassword" width="30" id="second-password-label"/>
</div>
    <div>

        <label for="admin">Admin</label>
        <input type="radio" name="usertype" id="admin" value="admin"><br>
    </div>
<div>
        <label for="user">Bruger</label>
        <input type="radio" name="usertype" id="user" value="female"><br>
</div>
<div>
        <label for="other">Other</label>
        <input type="radio" name="usertype" id="other" value="other"><br><br>
</div>
<div>
        <input type="submit" value="Opret bruger"/>
</div>
</form>
</div>
</html>
