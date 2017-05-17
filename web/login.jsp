<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 16-May-17
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome. Please login</h1>

<form action="/login" method="post">

    login-name: <input type="text" name="loginname" width="30"/>
    password: <input type="password" name="password" width="10"/>
    <input type="submit" value="login"/>
</form>

<p style="color:red;">${errorMessage}</p>

</body>
</html>
