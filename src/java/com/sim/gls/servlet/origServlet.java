/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.servlet;

 
import com.sim.gls.controller.Accessw;
import com.sim.gls.controller.Categoryw;
import com.sim.gls.controller.Groupw;
import com.sim.gls.controller.Menuw;
import com.sim.gls.controller.Rolew;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Stanley Mungai
 */
public class origServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog("origlogger");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mod = request.getParameter("MOD");
        String act = request.getParameter("ACT");
        switch (mod) {
            case "BOK":
                switch (act) {
                    case "doLog":
                        Accessw.handleLogin(request, response);
                        break;
                    case "Login":
                        Accessw.handleLoginNav(request, response);
                        break;
                    case "Logout":
                        Accessw.handleLogout(request, response);
                        break;
                    case "menu":
                        Menuw.handleMenuOptions(request, response);
                        break;
                    case "gomrole":
                        Rolew.handleGoRole(request, response);
                        break;
                    case "gomgroup":
                        Groupw.handleGoGroup(request, response);
                        break;
                    case "domgroup":
                        Groupw.handleMaintainGroup(request, response);
                        break;
                    case "domsubgroup":
                        Groupw.handleMaintainSubGroup(request, response);
                        break;
                    case "domcat":
                        Categoryw.handleGoCategory(request, response);
                        break;
                    case "domcatsub":
                        Categoryw.handleMaintainCategory(request, response);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
