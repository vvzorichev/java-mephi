<%@ page import="com.vvzorichev.Singltone1" %>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.09.2019
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
     <%
        Singltone1 setId = Singltone1.getInstance();
        Cookie[] cookies = request.getCookies();
        if (!(cookies == null)) {
            boolean enableToAccess = false;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    if (setId.containsSessionId(cookie.getValue())) {
                        enableToAccess = true;
                    }
                }
            }
            if (!enableToAccess)
                response.sendRedirect("http://localhost:8080/lab2_war_exploded/");
        }
        else {
            response.sendRedirect("http://localhost:8080/lab2_war_exploded/");
        }
    %>

    <head>
        <title>Nice to see you</title>
    </head>
</html>
