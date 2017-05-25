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

        <form action="/users" method="post">

           <div>
                   <label for="user-name-label">Brugernavn:</label>
                   <input type="text" name="userName" width="30" placeholder="Brugernavn" id="user-name-label" required/>
           </div>

           <div>
                   <label for="password-label">Password:</label>
                   <input type="password" name="userPass" width="30" id="password-label" required/>
           </div>

           <div>
               <label for="second-password-label">Gentag password:</label>
               <input type="password" name="userPass2" width="30" id="second-password-label" required/>
           </div>

            <div>
                <input class="btn" type="submit" value="Opret"/>
            </div>

            <p style="color: red;">${errorMessage}</p>

        </form>

    </div>
    <%@include file="includes/footer.jsp" %>

</html>
