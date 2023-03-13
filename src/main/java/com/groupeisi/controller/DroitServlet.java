package com.groupeisi.controller;

import com.groupeisi.dto.DroitDto;
import com.groupeisi.service.IDroitDto;
import com.groupeisi.service.DroitDtoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Droit", name = "droit")
public class DroitServlet extends HttpServlet {
	IDroitDto ddto = new DroitDtoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(session.getAttribute("user")==null) {
            req.setAttribute("error", "Vous devez vous connecter d'abord!");
            req.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(req, resp);
        }else {

            if (req.getParameter("page") != null){
                String page = req.getParameter("page");
                if (page.equals("add")){
                	req.setAttribute("droit", new DroitDto());
                    req.getRequestDispatcher("WEB-INF/views/droit/add.jsp").forward(req, resp);
                } else if (page.equals("liste")) {
                    
                    List<DroitDto> droits = ddto.list();

                    req.setAttribute("droits", droits);
                    req.getRequestDispatcher("WEB-INF/views/droit/list.jsp").forward(req, resp);
                } else if(page.equals("edit")) {
                	int id = Integer.parseInt(req.getParameter("id"));
                	req.setAttribute("droit", ddto.get(id));
                	req.getRequestDispatcher("WEB-INF/views/droit/add.jsp").forward(req, resp);
                } else if(page.equals("delete")) {
                	int id = Integer.parseInt(req.getParameter("id"));
                	try {
						if (ddto.delete(id)==1)
							req.setAttribute("success", "Droit Supprimé avec succès");
					} catch (Exception e) {
						req.setAttribute("error", "Impossible de Supprimé ce droit");
					}
                	List<DroitDto> droits = ddto.list();

                    req.setAttribute("droits", droits);
                    req.getRequestDispatcher("WEB-INF/views/droit/list.jsp").forward(req, resp);
                }
            }else {
                IDroitDto ddto = new DroitDtoImpl();
                List<DroitDto> liste_droits = ddto.list();

                req.setAttribute("droits", liste_droits);
                req.getRequestDispatcher("WEB-INF/views/droit/list.jsp").forward(req, resp);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDroitDto rdto = new DroitDtoImpl();
        DroitDto r = new DroitDto();
        r.setName(req.getParameter("name"));
        r.setId(Integer.parseInt(req.getParameter("id")));
        if(r.getId()==0) {
	        if (rdto.add(r)==1) {
	            req.setAttribute("success", "Droit ajouté avec succes!");
	            //req.getRequestDispatcher("WEB-INF/views/droit/list.jsp").forward(req, resp);
	            
	        }
	     } else if (rdto.update(r)==1) {
            req.setAttribute("success", "Droit modifié avec succes!");
            //req.getRequestDispatcher("WEB-INF/views/droit/list.jsp").forward(req, resp);
            
	     }
        doGet(req, resp);
    }
}
