package com.sim.gls.service;

import com.sim.gls.jpa.RoleProfileTable;
import com.sim.gls.jpa.UserCredsTbl;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Role;
import com.sim.gls.model.User;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Levi
 */
public class AccessService {

    HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getGLSHU());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.getDefault());

    /*
    Checks if Role exists
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

    public RoleProfileTable getRoleProfileTableByID(long id) {
        List roleProfileTable = crud.getObjectLazyLoad("from RoleProfileTable where roleId =" + id);

        return (RoleProfileTable) roleProfileTable.get(0);
    }

    public User getUserByUserName(String userName) {

        UserCredsTbl user = getUserByUName(userName);
        User theUser = new User(user.getUserId(), getRoleProfileTableByID(user.getRoleProfileTable().getRoleId()),
                user.getAcctExpyDate(), user.getAcctInactiveDays(),
                user.getDisabledFromDate(), user.getDisabledUptoDate(), user.getSolId(), user.getLastAccessTime(), user.getLchgUserId(), user.getNewUserFlg(),
                user.getNumPwdAttempts(), user.getNumPwdHistory(), user.getPwExpyDate(), user.getPwdHistory(), user.getRoleProfileTable().getRoleId(),
                user.getUserName(), user.getUserPw(), user.getUserStatus());
        return theUser;
    }

    public void changePassword(String userName, String userPw) {

    }

}
