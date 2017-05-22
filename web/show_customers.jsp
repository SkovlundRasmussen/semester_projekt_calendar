<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<%
    ArrayList customersList = (ArrayList) session.getAttribute("customers");
    request.setAttribute("customers", customersList);
%>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="includes/header.jsp" %>
<div id="wrapper">
    <table>
        <thead>
        <tr><th>ID</th><th>Name</th><th>Phone</th></tr>
        </thead>

        <tbody>

        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><c:out value="${customer.getCustomerID()}"/></td>
                <td><c:out value="${customer.getCustomerName()}"/> <c:out value="${customer.getCustomerLastname()}"/></td>
                <td><c:out value="${customer.getCustomerPhoneNumber()}"/></td>
                <td>
                    <c:url var="id_url" value="${customer.getCustomerID()}"/>
                    <a href="edit_customer?customer_id=${customer.getCustomerID()}">Rediger</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
<%--Kristain--%>
