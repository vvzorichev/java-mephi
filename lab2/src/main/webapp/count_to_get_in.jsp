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

        <h3>
            <%
                try {
                    int num1 = (int) request.getAttribute("num1");
                    int num2 = (int) request.getAttribute("num2");
                    out.println(num1 + " + " + num2 + " =  ?");
                }
                catch (NullPointerException e) {
                    response.sendRedirect("http://localhost:8080/lab2_war_exploded/");
                }
            %>
        </h3>

        <form method="post">
            Your answer <br /> <br />
            <input type="text" name="answer"/>
            <input type="submit" name="submit" value="Submit"/>
            <%
                String hash = (String) request.getAttribute("hash");
            %>
            <input type="hidden" name="hash" value="<%=hash%>" />
        </form>

    </body>

</html>