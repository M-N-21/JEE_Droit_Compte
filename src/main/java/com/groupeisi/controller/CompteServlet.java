package com.groupeisi.controller;

import com.groupeisi.dto.DroitDto;
import com.groupeisi.entities.Compte;
import com.groupeisi.dao.CompteImpl;
import com.groupeisi.dao.ICompte;
import com.groupeisi.dto.CompteDto;
import com.groupeisi.service.IDroitDto;
import com.groupeisi.service.ICompteDto;
import com.groupeisi.service.DroitDtoImpl;
import com.groupeisi.service.CompteDtoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Compte", name = "compte")
public class CompteServlet extends HttpServlet {
	ICompteDto cdto = new CompteDtoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDroitDto ddto = new DroitDtoImpl();
        DroitDto r = new DroitDto();
        List<DroitDto> list = ddto.list();
        req.setAttribute("droits", list);
        HttpSession session=req.getSession();
        if(session.getAttribute("user")==null) {
            req.setAttribute("error", "Vous devez vous connecter d'abord!");
            req.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(req, resp);
        }else {
            if (req.getParameter("page") != null) {
                String page = req.getParameter("page");
                if (page.equals("add")) {
                    req.getRequestDispatcher("WEB-INF/views/compte/add.jsp").forward(req, resp);
                } else if (page.equals("liste")) {
                    
                    List<CompteDto> comptes = cdto.list();

                    req.setAttribute("comptes", comptes);
                    req.getRequestDispatcher("WEB-INF/views/compte/list.jsp").forward(req, resp);
                }else if (page.equals("delete")) {
                	int id = Integer.parseInt(req.getParameter("id"));
                	ICompte cdao = new CompteImpl();
                	CompteDto compte = cdao.CompteEntityToCompteDto((Compte) session.getAttribute("user"));
                	if(compte.getId() != id) {
	                	try {
							if (cdto.delete(id)==1)
								req.setAttribute("success", "Compte Supprimé avec succès");
						} catch (Exception e) {
							req.setAttribute("error", "Impossible de Supprimé ce Compte");
						}
                	}else
                		req.setAttribute("error", "Vous ne pouvez pas vous supprimer vous meme");
                	List<CompteDto> comptes = cdto.list();

                    req.setAttribute("comptes", comptes);
                    req.getRequestDispatcher("WEB-INF/views/compte/list.jsp").forward(req, resp);
                }
            }else{
                ICompteDto cdto = new CompteDtoImpl();
                List<CompteDto> comptes = cdto.list();

                req.setAttribute("comptes", comptes);
                req.getRequestDispatcher("WEB-INF/views/compte/list.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICompteDto cdto = new CompteDtoImpl();
        CompteDto u = new CompteDto();
        u.setUsername(req.getParameter("username"));
        u.setPassword(req.getParameter("pass"));
        List<DroitDto> droitsList = new ArrayList<>();
        IDroitDto ddto = new DroitDtoImpl();
        DroitDto r = new DroitDto();
        List<DroitDto> droits = ddto.list();
        String result  = req.getParameter("droits");
        for (DroitDto newd: droits) {
            if (newd.getId() == Integer.parseInt(result)){
                droitsList.add(newd);
                break;
            }
        }
        /*String result  = req.getParameter("droits");
        String[] tab = result.split(",");
        System.out.println(result);
        System.exit(0);
        for (String s: tab) {
            IDroit ddao = new DroitImpl();
            Droit r = new Droit();
            List<Droit> droits = ddao.list(r);
            for (Droit newd: droits) {
                if (newd.getId() == Integer.parseInt(result)){
                    droitsList.add(newd);
                    break;
                }
            }
        //}
        u.setDroits(droitsList);*/
        u.setDroits(droitsList);

        if (cdto.add(u)==1){
            req.setAttribute("success", "Compte ajouté avec succes!");
            //req.getRequestDispatcher("WEB-INF/vue/user/add.jsp").forward(req, resp);
            doGet(req, resp);
        }

    }

}

