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

<h1>Opret ny kunde</h1>
<form> <%-- Set action --%>
    <p>
        <label for="customerID" id="customerID-label">Kunde ID:</label>
        <label type="text" name="userID" width="30" id="customerID"/> <%-- value="AI ID" --%>
    </p>
    <p>
        <label for="first-name" id="first-name-label">Fornavn:</label>
        <input type="text" name="firstname" width="30" placeholder="Fornavn" id="first-name"/>
    </p>
    <p>
        <label for="last-name" id="last-name-label">Efternavn:</label>
        <input type="text" name="lastName" width="30" placeholder="Efternavn" id="last-name"/>
    </p>
    <p>
        <label for="phone-number" id="phone-number-label">Telefon:</label>
        <input type="text" name="loginname" id="phone-number" width="30" maxlength="8" minlength="8" placeholder="22446688"/>
    </p>

    <input type="submit" value="Opret kunde"/>
</form>


</html>
