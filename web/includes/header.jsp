<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 16-May-17
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--<c:if test="${sessionScope.loginSession != null}">
    <c:redirect url = "/login.jsp"/>
</c:if>--%>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css" />
    <title>Title</title>
</head>
<body>
<%--    <c:if test="${sessionScope.loginSession != null}">
        <c:redirect url = "login.jsp"/>
    </c:if>--%>
    <header>
        <nav id="main_nav">
            <ul>
                <li><a href="../index.jsp">Home</a></li>
                <li><a href="../create_customers">Ny kunde</a></li>
                <li><a href="../show_customers">Alle kunder</a></li>
                <li><a href="../create_user.jsp">Ny bruger</a></li>
                <li><a href="../user.jsp">Alle brugere</a></li>
                <li><a href="../create_appointment.jsp">Ny tid </a></li>
                <li><a href="../show_appointment">Alle tider </a></li>
                <li><a href="../logout">Logud</a></li>

            </ul>
        </nav>
    </header>
</body>
</html>
