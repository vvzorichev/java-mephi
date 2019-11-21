<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.09.2019
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Captcha</title>
    </head>

    <body>

        <h2>Count sum</h2>
        <form method="post">
            <%
                String hash = (String) request.getAttribute("hash");

                int num1 = (int) request.getAttribute("num1");
                int num2 = (int) request.getAttribute("num2");
                String param =  num1 + " + " + num2 + " =  ?";

                String msg = "";
                if(!(request.getAttribute("msg") == null)){
                    msg = (String) request.getAttribute("msg");
                }
            %>
            <%=msg%><br>
            <%=param%><br>
            Your answer <br>
            <input type="text" name="answer" required placeholder="Enter your answer"/>
            <input type="submit" name="submit" value="Submit" formaction="/lab2_war_exploded/"/>
            <input type="hidden" name="hash" value="<%=hash%>" />
        </form>

    </body>

</html>