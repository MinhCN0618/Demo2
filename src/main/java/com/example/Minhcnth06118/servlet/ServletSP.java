package com.example.Minhcnth06118.servlet;

import com.example.Minhcnth06118.entity.SanPham;
import com.example.Minhcnth06118.repository.repoLSP;
import com.example.Minhcnth06118.repository.repoSP;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletSP", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/sua",
        "/san-pham/tim-kiem",
        "/san-pham/phan-trang"
})
public class ServletSP extends HttpServlet {
    repoSP repoSP = new repoSP();
    repoLSP repoLSP = new repoLSP();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            req.setAttribute("listSP", repoSP.getAll());
            req.setAttribute("listLSP", repoLSP.getAll());
            req.getRequestDispatcher("/abc/hienthi.jsp").forward(req, resp);
        } else if (uri.contains("detail")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("sp", repoSP.getByID(id));
            req.setAttribute("listLSP", repoLSP.getAll());
            req.getRequestDispatcher("/abc/sua.jsp").forward(req, resp);
        } else if (uri.contains("tim-kiem")) {
            String ten = req.getParameter("ten");
            req.setAttribute("listSP", repoSP.timKiem(ten));
            req.setAttribute("listLSP", repoLSP.getAll());
            req.getRequestDispatcher("/abc/hienthi.jsp").forward(req, resp);
        } else if (uri.contains("phan-trang")) {
            int page = 0;
            int size = 5;
            if(req.getParameter("page") != null){
                page = Integer.parseInt(req.getParameter("page"));
            }

            req.setAttribute("listSP", repoSP.phanTrang(page, size));
            req.setAttribute("listLSP", repoLSP.getAll());
            req.getRequestDispatcher("/abc/hienthi.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String moTa = req.getParameter("moTa");
            int loai = Integer.parseInt(req.getParameter("loai"));

            SanPham sanPham = new SanPham(null, ma, ten, moTa, repoLSP.getByID(loai));
            repoSP.them(sanPham);
            resp.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("sua")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String moTa = req.getParameter("moTa");
            int loai = Integer.parseInt(req.getParameter("loai"));

            SanPham sanPham = new SanPham(id, ma, ten, moTa, repoLSP.getByID(loai));
            repoSP.sua(sanPham);
            resp.sendRedirect("/san-pham/hien-thi");
        }
    }
}
