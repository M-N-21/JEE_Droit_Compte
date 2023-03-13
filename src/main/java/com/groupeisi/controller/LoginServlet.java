package com.groupeisi.controller;

import com.groupeisi.dao.ICompte;  
import com.groupeisi.dao.CompteImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/Login", name = "login")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICompte cdao = new CompteImpl();
        if(cdao.login(req.getParameter("username"), req.getParameter("pass"))!=null) {
        	System.out.println("ok");
            req.setAttribute("success", "Bienvenue "+req.getParameter("username"));
            HttpSession session=req.getSession();
            session.setAttribute("user",cdao.login(req.getParameter("username"), req.getParameter("pass")));
            req.getRequestDispatcher("WEB-INF/views/home/index.jsp").forward(req, resp);
        }else {
        	System.out.println("nonok");
            //resp.getWriter().println("Login et ou mot de passe incorrect!");
            // req.setAttribute();
            req.setAttribute("error", "Login et/ou mot de pass incorrect!");
            doGet(req, resp);
        }
        //System.out.println(cdao.login(req.getParameter("username"), req.getParameter("pass")));

    }


}
