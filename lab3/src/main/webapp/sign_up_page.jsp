<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.09.2019
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sign up</title>
    </head>

    <body>

        <form method="post">
            <h2>Create your personal account</h2>
            <%
                String msg = "";
                if(!(request.getAttribute("msg") == null)) {
                    msg = (String) request.getAttribute("msg");
                }
            %>
            <%=msg%><br>
            Login<br>
            <input type="text" name="login" required placeholder="Enter new login"/><br><br>
            Password<br>
            <input type="password" name="password" required placeholder="Enter new password"/>
            <input type="submit" name="sign_up" value="Sign up" formaction="/lab3_war_exploded/sign_up"/><br><br>
        </form>

        <form method="get">
            <input type="submit" name="sign_in" value="Sign in" formaction="/lab3_war_exploded/sign_in"/>
        </form>

    </body>

</html>
