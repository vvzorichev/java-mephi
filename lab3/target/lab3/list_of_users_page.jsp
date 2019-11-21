<%@ page import="com.vvzorichev.dao.DAOLoginPassword" %>
<%@ page import="com.vvzorichev.entities.LoginPassword" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.09.2019
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>List of registerd users</title>
    </head>
<body>

    <h2>List of registred users</h2>

    <%
        DAOLoginPassword daoLoginPassword = new DAOLoginPassword();
        List<LoginPassword> lpList =daoLoginPassword.FindAll();
        int i=1;
        for(LoginPassword lp : lpList){
            out.println(i++ + ". " + lp + "<br/>");
        }
    %>

</body>
</html>
