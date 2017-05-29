<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="includes/header.jsp" %>

<div class="wrapper">
    <table>
        <thead>
        <tr><%--<th>ID</th>--%><th>Navn</th><th>Tlf</th><th>Rediger kunde</th><th>Opret tid</th></tr>
        </thead>

        <tbody><%--
        <input type="text" name="userId" value="<c:out value="${user_id.getUserID()}"/>"/>--%>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><c:out value="${customer.getCustomerName()}"/> <c:out value="${customer.getCustomerLastname()}"/></td>
                <td><c:out value="${customer.getCustomerPhoneNumber()}"/></td>
                <td>
                    <c:url var="id_url" value="${customer.getCustomerID()}"/>
                    <a href="edit_customer?customer_id=${customer.getCustomerID()}">Rediger</a>
                </td>
                <td>
                    <c:url var="id_url" value="${customer.getCustomerID()}"/>
                    <a href="appointment?customer_id=${customer.getCustomerID()}">Ny tid</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
<%--Kristain--%>
