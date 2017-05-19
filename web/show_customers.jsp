<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 18-May-17
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                <td>${customer.customerID}/></td>
                <td>${customer.customerName}/></td>
                <td>${customer.customerLastName}/></td>
                <td>${customer.customerPhoneNumber}/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
