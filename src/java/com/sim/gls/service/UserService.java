/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.service;

import com.sim.gls.jpa.RoleProfileTable;
import com.sim.gls.jpa.UserCredsTbl;
import com.sim.gls.jpa.UserCredsTblMod;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Role;
import com.sim.gls.model.User;
import com.sim.gls.security.Encode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Levi
 */
public class UserService {

    HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getGLSHU());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.getDefault());
    static Encode enc;

    /*
    Checks if User exists
     */
    public boolean userExists(String userName, String userPw) {
        String qr = "from UserCredsTbl where userName like '%" + userName + "%'"
                + "or userPw like '%" + userPw + "%'";
        List userList = crud.getObject(qr);

        if (userList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public UserCredsTbl getUserByUName(String userName) {
        List userCredsTbl = crud.getObjectLazyLoad("from UserCredsTbl where userName =" + userName);
        return (UserCredsTbl) userCredsTbl.get(0);
    }

    public int getUserId(String userName) {
        long userId = 0;
        userId = getUserByUName(userName).getUserId();
        return (int) userId;
    }

    public RoleProfileTable getRole(String roleDesc) {
        List userRole = crud.getObjectLazyLoad("from RoleProfileTable where roleDesc =" + roleDesc);
        return (RoleProfileTable) userRole.get(0);
    }

    public int getRoleId(String userName) {
        int roleId = 0;
        roleId = (int) getRole(userName).getRoleId();
        return roleId;
    }

    public UserCredsTbl getuserDetails(int userId) {
        List users = crud.getObjectLazyLoad("from UserCredsTbl where userId =" + userId);
        return (UserCredsTbl) users.get(0);
    }

//shouldnt be  a list of users because userid is the primarykey 
    public UserCredsTblMod getuserModDetails(int userId) {
        List mod_users = crud.getObjectLazyLoad("from UserCredsTblMod where userId =" + userId);
        return (UserCredsTblMod) mod_users.get(0);
    }

    public int createUser(User user) {
        UserCredsTbl created = new UserCredsTbl(user.getAcctExpyDate(), user.getAcctInactiveDays(), user.getDisabledFromDate(),
                user.getDisabledUptoDate(), user.getLastAccessTime(), user.getNewUserFlg(), user.getNumPwdAttempts(),
                user.getNumPwdHistory(), user.getPwExpyDate(), user.getPwdHistory(), user.getRole().getRoleId(),
                user.getUserName(), EncodeUserPassword(user.getUserName(), user.getUserPw()), user.getUserStatus());

        return (int) crud.save(created);
    }

    public int createUserMod(int userId, User user) {
        RoleProfileTable roleProf = new RoleProfileTable(user.getRole().getBankId(), user.getRole().getDelFlg(), user.getRole().getEntityCreFlg(), user.getRole().getLchgTime(), user.getRole().getLchgUserId(), user.getRole().getRcreTime(), user.getRole().getRcreUserId(), user.getRole().getRoleDesc());
        UserCredsTblMod creatUserMod
                = new UserCredsTblMod(roleProf, user.getAcctExpyDate(), user.getAcctInactiveDays(), user.getDisabledFromDate(),
                        user.getDisabledUptoDate(), user.getLastAccessTime(), user.getLastOper(), user.getNewUserFlg(), user.getNumPwdAttempts(),
                        user.getNumPwdHistory(), user.getPwExpyDate(), user.getPwdHistory(), "U", userId, user.getUserName(), EncodeUserPassword(user.getUserName(), user.getUserPw()));
        crud.save(user);
        return 0;
    }

    public int addUserDetails(User user) {
        int userId = createUser(user);
        createUserMod(userId, user);
        return userId;
    }

    public static String generateUserKey(String username, String password) {
        return username.substring(0, 2) + password.substring(0, 4);
    }

    public static String generateUserIV(String username, String password) {
        return username.substring(0, 3) + password.substring(0, 5);
    }

    public static String EncodeUserPassword(String username, String password) {
        enc = new Encode(generateUserKey(username, password), generateUserIV(username, password));
        return enc.encrypt(password);
    }

    public String DecodeUserPassword(String username, String password, String encpass) {
        enc = new Encode(generateUserKey(username, password), generateUserIV(username, password));
        return enc.decrypt(encpass);
    }

}
