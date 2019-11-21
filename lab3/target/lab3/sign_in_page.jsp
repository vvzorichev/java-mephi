<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.09.2019
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sign in</title>
    </head>

    <body>

        <form method="post">
            <h2>Sign in</h2>
            <%
                String msg = "";
                if(!(request.getAttribute("msg") == null)) {
                    msg = (String) request.getAttribute("msg");
                }
            %>
            <%=msg%><br>
            Login<br>
            <input type="text" name="login" required placeholder="Enter your login"/><br><br>
            Password<br>
            <input type="text" name="password" required placeholder="Enter your password"/>
            <input type="submit" name="sign_in" value="Sign in" formaction="/lab3_war_exploded/sign_in"/><br><br>
        </form>

        <form method="get">
            <input type="submit" name="sign_up" value="Sign up" formaction="/lab3_war_exploded/sign_up"/>
        </form>

    </body>

</html>
