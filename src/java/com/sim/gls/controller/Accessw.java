/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.controller;

 
import com.sim.gls.model.Role;
import com.sim.gls.model.User;
import com.sim.gls.security.Encode;
import com.sim.gls.service.AccessService;
import com.sim.gls.service.RoleService;
import com.sim.gls.service.UserService;
import java.io.IOException;
import java.util.Date;
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
public class Accessw {

    private static final Log log = LogFactory.getLog("origlogger");

    public static void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute("userdnexists", false);
        session.setAttribute("usernotverified", false);
        session.setAttribute("userlocked", false);
        session.setAttribute("pwdexpired", false);
        session.setAttribute("acctexpired", false);
        session.setAttribute("usrdisabled", false);
        session.setAttribute("userlogged", false);
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        int userId;
        UserService userService = new UserService();
        if (userService.userExists(username)) {
            
            userId = userService.getUserId(username);
             List<User> users =  userService.getUserDetails(userId);
            Encode enc = new Encode(Encode.generateUserKey(username, password), Encode.generateUserIV(username, password));
            Date currdate = new Date();
            int logattempts = 0;
            Date pwdexpyDate = new Date();
            Date acctexpyDate = new Date();
            Date disabledFromDate = new Date();
            Date disableUptoDate = new Date();
            String newUsrFlg = "";
            int roleid = 0;
            String roleName = "";
            for (User us : users) {
                logattempts = (int) us.getNumPwdAttempts();
                pwdexpyDate = us.getPwExpyDate();
                acctexpyDate = us.getAcctExpyDate();
                disabledFromDate = us.getDisabledFromDate();
                disableUptoDate = us.getDisabledUptoDate();
                newUsrFlg = us.getNewUserFlg();
                roleid = (int) us.getRoleId();
            }
            RoleService roleService = new RoleService();
            List<Role> roles = roleService.getProfileDetails(roleid);
            for (Role ro : roles) {
                roleName = ro.getRoleDesc();
            }
            AccessService acccessService = new  AccessService();
            if (!roleService.userExistsInMod(username)) {
                if (logattempts <= 3) {
                    if (!currdate.after(pwdexpyDate)) {
                        if (!currdate.after(acctexpyDate)) {
                            if ((disabledFromDate.before(currdate) && disableUptoDate.before(currdate)) || (disabledFromDate.after(currdate) && disableUptoDate.after(currdate))) {
                                if (!AccessService.userIsLoggedIn(username)) {
                                    if (acccessService.userExists(username, enc.encrypt(password))) {
                                        if (!newUsrFlg.equalsIgnoreCase("Y")) {
                                            session.setAttribute("uname", username.toUpperCase());
                                            session.setAttribute("role", roleName);
                                            acccessService.loginUser(username, "0", new Date(), session.getId());
                                            acccessService.enableUser(userId);
                                            acccessService.markCorrectLoginAttempt(username);
                                            session.setAttribute("content_page", "ucontent.jsp");
                                            response.sendRedirect("index.jsp");
                                        } else {
                                            session.setAttribute("content_page", "user/chCreds.jsp");
                                            response.sendRedirect("index.jsp");
                                        }
                                    } else {
                                        session.setAttribute("userdnexists", true);
                                        acccessService.markWrongLoginAttempt(username);
                                        session.setAttribute("content_page", "login.jsp");
                                        response.sendRedirect("login.jsp");
                                    }
                                } else {
                                    session.setAttribute("userlogged", true);
                                    session.setAttribute("content_page", "login.jsp");
                                    response.sendRedirect("login.jsp");
                                }
                            } else {
                                session.setAttribute("usrdisabled", true);
                                session.setAttribute("content_page", "login.jsp");
                                response.sendRedirect("login.jsp");
                            }

                        } else {
                            session.setAttribute("acctexpired", true);
                            session.setAttribute("content_page", "login.jsp");
                            response.sendRedirect("login.jsp");
                        }
                    } else {
                        session.setAttribute("pwdexpired", true);
                        session.setAttribute("content_page", "user/chCreds.jsp");
                        response.sendRedirect("index.jsp");
                    }

                } else {
                    session.setAttribute("userlocked", true);
                    session.setAttribute("content_page", "login.jsp");
                    response.sendRedirect("login.jsp");
                }

            } else {
                session.setAttribute("usernotverified", true);
                session.setAttribute("content_page", "login.jsp");
                response.sendRedirect("login.jsp");
            }

        } else {
            session.setAttribute("userdnexists", true);
            session.setAttribute("content_page", "login.jsp");
            response.sendRedirect("login.jsp");
        }
    }

    public static void handleLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccessService acccessService = new  AccessService();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("uname") != null) {
            acccessService.logoutUser((String) session.getAttribute("uname"));
            session.setAttribute("content_page", "login.jsp");
            response.sendRedirect("login.jsp");
            session.invalidate();
        } else {
            session.setAttribute("content_page", "sessionexp.jsp");
            response.sendRedirect("index.jsp");
        }
    }

    public static void handleLoginNav(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("content_page", "login.jsp");
        response.sendRedirect("login.jsp");
    }
}
