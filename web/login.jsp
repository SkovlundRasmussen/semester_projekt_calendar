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
    <meta charset="utf-8"/>
    <title>Login</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>

    <body>

    <div class="bigWrapper">

        <h1 class="header">Login</h1>

        <div class="imgcontainer">
            <img src="img/avatar2.png" alt="Avatar" class="avatar">
        </div>
        <form action="/login" method="post" id="loginform">
            <div class="LoginContainer">
                <label><b>Brugernavn:</b></label>
                <input type="text" placeholder="Indtast Brugernavn" name="loginname"/>

                <label><b>Password:</b></label>
                <input type="password" placeholder="Indtast Password" name="password"/>
                <div class="loginBut">
                    <input type="submit" value="login" />
                </div>
            </div>
        </form>

        <p style="color:red;">${errorMessage}</p>

    </div>


    </body>

</html>
