package com.vvzorichev;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.vvzorichev.dao.DAOLoginHash;


@WebFilter("/FilterCookie")
public class FilterCookie implements Filter {

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Cookie[] cookies = request.getCookies();
        if (!(cookies == null)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    String sessionId = cookie.getValue();
                    DAOLoginHash daoLoginHash = new DAOLoginHash();
                    boolean isContain = daoLoginHash.IsContainHash(sessionId);
                    if (isContain)
                        request.getRequestDispatcher("list_of_users_page.jsp").forward(request, response);
                    }
                }
            }
        if(request.getRequestURI().equals("/lab3_war_exploded/list_of_users_page.jsp"))
            request.getRequestDispatcher("sign_in_page.jsp").forward(request, response);
        chain.doFilter(req, res);
    }
}
