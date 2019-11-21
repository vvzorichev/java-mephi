package com.vvzorichev;

import com.vvzorichev.dao.DAOLoginPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign_up_page.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DAOLoginPassword daoLoginPassword = new DAOLoginPassword();
        boolean isContainLogin = daoLoginPassword.IsContainLogin(login);
        if(!isContainLogin) {
            daoLoginPassword.AddLoginPassword(login, password);
            request.setAttribute("msg", "You have successfully registered. Enter your login and password");
            request.getRequestDispatcher("sign_in_page.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg", "Login " + login + " is not available.");
            request.getRequestDispatcher("sign_up_page.jsp").forward(request, response);
        }
    }
}
