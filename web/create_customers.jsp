<%--
  Created by IntelliJ IDEA.
  User: Toldam
  Date: 16-May-17
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Kunder</title>
</head>

<body>
    <%@include file="includes/header.jsp" %>
</body>

<div id="wrapper">

<h1>Opret ny kunde</h1>
<form action="/customers" method="post"> <%-- Set action --%>

    <%--
    <div>
        <label for="customerID" id="customerID-label">Kunde ID:</label>
        <label type="text" name="userID" width="30" id="customerID"/>
    </div>
    --%>

    <div>
        <label for="first-name" id="first-name-label">Fornavn:</label>
        <input type="text" name="firstName" width="30" placeholder="Fornavn" id="first-name"/>
    </div>

    <div>
        <label for="last-name" id="last-name-label">Efternavn:</label>
        <input type="text" name="lastName" width="30" placeholder="Efternavn" id="last-name"/>
    </div>

    <div>
        <label for="phone-number" id="phone-number-label">Telefon:</label>
        <input type="text" name="phoneNumber" id="phone-number" width="30" maxlength="8" minlength="8" placeholder="22446688"/>
    </div>

    <input type="submit" value="Opret"/>
    <p style="color: red;">${errorMessage}</p>
</form>

</div>

</html>
