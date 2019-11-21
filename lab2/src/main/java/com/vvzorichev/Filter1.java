package com.vvzorichev;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/Filter1")
public class Filter1 implements Filter {

    private Singltone1 SetId;

    public void init(FilterConfig config) throws ServletException {
        SetId = Singltone1.getInstance();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Cookie[] cookies = request.getCookies();
        if (!(cookies == null)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    if (SetId.containsSessionId(cookie.getValue())) {
                        request.getRequestDispatcher("hello_inside.jsp").forward(request, response);
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }
}
