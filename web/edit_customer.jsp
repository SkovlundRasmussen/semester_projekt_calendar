<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    request.setAttribute("customer", session.getAttribute("customer"));
%>
<head>
    <title>Kunder</title>
</head>

<body>
<%@include file="includes/header.jsp" %>
</body>

<div id="wrapper">


    <h1>Rediger kunde</h1>
    <form action="/edit_customer" method="post"> <%-- Set action --%>

        <div>
            <input type="hidden" id="customerID" name="customerID" value="<c:out value="${customer.getCustomerID()}"/>"/>
            <label for="first-name" id="first-name-label">Fornavn:</label>
            <input type="text" name="firstName" width="30" placeholder="Fornavn" id="first-name" value="<c:out value="${customer.getCustomerName()}"/>"/>
        </div>

        <div>
            <label for="last-name" id="last-name-label">Efternavn:</label>
            <input type="text" name="lastName" width="30" placeholder="Efternavn" id="last-name" value="<c:out value="${customer.getCustomerLastname()}"/>"/>
        </div>

        <div>
            <label for="phone-number" id="phone-number-label">Telefon:</label>
            <input type="text" name="phoneNumber" id="phone-number" width="30" maxlength="8" minlength="8" placeholder="22446688" value="<c:out value="${customer.getCustomerPhoneNumber()}"/>"/>
        </div>

        <input type="submit" value="Rediger"/>
        <p style="color: red;">${errorMessage}</p>
    </form>

</div>

</html>
