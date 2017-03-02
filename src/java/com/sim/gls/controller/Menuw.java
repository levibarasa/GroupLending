/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.controller;

 
import com.sim.gls.jpa.Resources;
import com.sim.gls.service.AccessService;
import com.sim.gls.service.MenuService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Stanley Mungai
 */
public class Menuw {

    private static final Log log = LogFactory.getLog("origlogger");

    public static void handleMenuOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute("nonexistencemenu", false);
        session.setAttribute("rolemenunone", false);
        session.setAttribute("gverified", false);
        session.setAttribute("gadded", false);
        session.setAttribute("gdeleted", false);
        session.setAttribute("sgexists", false);
        session.setAttribute("fatal", false);
        session.setAttribute("sgadded", false);
        session.setAttribute("sgverified", false);
        session.setAttribute("sgmodified", false);
        if ((String) session.getAttribute("uname") != null) {
            if (AccessService.userIsLoggedIn((String) session.getAttribute("uname"))) {
                String menuoption = request.getParameter("menu option").trim();
                if (!menuoption.equalsIgnoreCase("")) {
                    if (MenuService.menuExists(menuoption)) {
                        if (MenuService.roleHasMenu((String) session.getAttribute("role"), menuoption)) {
                            if (!MenuService.roleMenuIsUnverified((String) session.getAttribute("role"), menuoption)) {
                                List<Resources> reso = MenuService.getResourceDetails(menuoption);
                                String url = "";
                                for (Resources res : reso) {
                                    url = res.getMopUrl();
                                }
                                session.setAttribute("content_page", url);
                            } else {
                                session.setAttribute("rolemenunone", true);
                                session.setAttribute("content_page", "ucontent.jsp");
                            }
                        } else {
                            session.setAttribute("rolemenunone", true);
                            session.setAttribute("content_page", "ucontent.jsp");
                        }
                    } else {
                        session.setAttribute("nonexistencemenu", true);
                        session.setAttribute("content_page", "ucontent.jsp");
                    }
                }
            } else {
                session.setAttribute("content_page", "sessionexp");
            }
        } else {
            session.setAttribute("content_page", "sessionexp");
        }
        response.sendRedirect("index.jsp");
    }
}
