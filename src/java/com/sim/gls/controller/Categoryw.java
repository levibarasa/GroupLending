/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.controller;

 
 import com.sim.gls.model.Category;
import com.sim.gls.service.BankService;
import com.sim.gls.service.CategoryService;
import java.io.IOException;
import java.util.Date;
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
public class Categoryw {

    private static final Log log = LogFactory.getLog("origlogger");

    public static void handleGoCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ((String) session.getAttribute("uname") != null) {
            session.setAttribute("catfunc", request.getParameter("function"));
            session.setAttribute("categorytype", request.getParameter("categorytype"));
            session.setAttribute("content_page", "categories/mCategories_b.jsp");
        } else {
            session.setAttribute("content_page", "sessionexp.jsp");
        }
        response.sendRedirect("index.jsp");
    }

    public static void handleMaintainCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        CategoryService categoryService = new CategoryService();
        BankService bankService = new BankService();
        session.setAttribute("catadded", false);
        session.setAttribute("catexists", false);
        if ((String) session.getAttribute("uname") != null) {
            String function = request.getParameter("function");
            String categorytype = request.getParameter("categorytype");
            String categorycode = request.getParameter("categorycode");
            String categoryvalue = request.getParameter("categoryvalue");
             
              Category category = new Category();
              category.setBankId(bankService.getBankId());
              category.setBocreatedby((String) session.getAttribute("uname"));
              category.setBodatecreated(new Date() );
              category.setBomodifiedby((String) session.getAttribute("uname"));
              category.setCategoryvalue(categoryvalue);
              category.setCategorytype(categorytype);
              category.setCategorycode(categorycode);
              category.setBodatemodified(new Date());
            switch (function) {
                case "ADD":
                    if (!categoryService.categoryExists(categorycode, categorytype)) {
                        categoryService.addCategories(category);
                        session.setAttribute("catadded", true);
                        session.setAttribute("content_page", "categories/mCategories_a.jsp");
                    } else {
                        session.setAttribute("catexists", true);
                        session.setAttribute("content_page", "categories/mCategories_b.jsp");
                    }
                    break;
            }
        } else {
            session.setAttribute("content_page", "sessionexp.jsp");
        }
        response.sendRedirect("index.jsp");
    }
}
