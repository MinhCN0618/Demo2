package com.example.Minhcnth06118.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", value = {
        "/login"
})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("login")) {
            req.getRequestDispatcher("/abc/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String us = req.getParameter("us");
        String pw = req.getParameter("pw");
        HttpSession session = req.getSession();
        if (us.equalsIgnoreCase("huynv") && pw.equalsIgnoreCase("123456")){
            session.setAttribute("abc", "123");
            resp.sendRedirect("/san-pham/hien-thi");
        }
    }
}
