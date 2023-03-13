package com.groupeisi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/Home", name = "home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("Hello everybody!");


        HttpSession session=req.getSession();
        if(session.getAttribute("user")==null) {
            req.setAttribute("error", "Vous devez vous connecter d'abord!");
            req.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("WEB-INF/views/home/index.jsp").forward(req, resp);
        }
    }
}
