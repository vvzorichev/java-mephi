package com.vvzorichev;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Random;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

    private HashMap<Integer, Set<String>> Storage;
    private Singltone1 SetId;

    public void init() throws ServletException {
        Storage = new HashMap<Integer, Set<String>>();
        SetId = Singltone1.getInstance();
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random random = new Random();
        int num1 = -125 + random.nextInt(347 + 125 + 1);;
        int num2 = -125 + random.nextInt(347 + 125 + 1);;
        int sum =  num1 + num2;

        String hash = Integer.toString(Integer.toString(sum).hashCode()) + System.currentTimeMillis();
        if (Storage.containsKey(sum)) {
            Storage.get(sum).add(hash);
        }
        else {
            Set<String> set = new HashSet<String>();
            set.add(hash);
            Storage.put(sum, set);
        }

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("hash", hash);

        String msg = request.getParameter("msg");
        if (msg != null){
            request.setAttribute("msg", msg);
        }

        request.getRequestDispatcher("count_to_get_in.jsp").forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int answer = Integer.parseInt(request.getParameter("answer"));
        String hash = request.getParameter("hash");
        if (Storage.containsKey(answer)) {
            if (Storage.get(answer).contains(hash)) {
                String uuid = UUID.randomUUID().toString();
                SetId.addSessionId(uuid);
                Cookie cookie = new Cookie("sessionId", uuid);
                response.addCookie(cookie);
                request.getRequestDispatcher("hello_inside.jsp").forward(request, response);
            }
        }
        else{
            response.sendRedirect("http://localhost:8080/lab2_war_exploded/?msg=Wrong answer! Try again");
        }
    }
}