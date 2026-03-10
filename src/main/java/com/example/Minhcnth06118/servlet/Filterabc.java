package com.example.Minhcnth06118.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "Filterabc", value = {
        "/san-pham/*"
})
public class Filterabc implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String abc = (String) session.getAttribute("abc");
        if (abc == null) {
            req.getRequestDispatcher("/abc/login.jsp").forward(req, resp);
        } else {
            chain.doFilter(request, response);
        }
    }
}
