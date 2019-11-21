package com.vvzorichev;

import com.vvzorichev.dao.DAOLoginHash;
import com.vvzorichev.dao.DAOLoginPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DAOLoginPassword daoLoginPassword = new DAOLoginPassword();
        boolean isContainLoginPassword = daoLoginPassword.IsContainLoginPassword(login, password);
        if(isContainLoginPassword) {
            String uuid = UUID.randomUUID().toString();
            DAOLoginHash daoLoginHash = new DAOLoginHash();
            daoLoginHash.AddLoginHash(login, uuid);
            Cookie cookie = new Cookie("sessionId", uuid);
            response.addCookie(cookie);
            request.getRequestDispatcher("list_of_users_page.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg", "Incorrect login or password.");
            request.getRequestDispatcher("sign_in_page.jsp").forward(request, response);
        }
    }
}
