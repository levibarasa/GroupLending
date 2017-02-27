package com.sim.gls.service;

import com.sim.gls.jpa.LoggedInUser;
import com.sim.gls.jpa.RoleProfileTable;
import com.sim.gls.jpa.UserCredsTbl;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtil;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Role;
import com.sim.gls.model.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
                + "or userName like '%" + userName + "%'";
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
        User theUser = new User(user.getUserId(),new Role(user.getRoleProfileTable().getBankId(), user.getRoleProfileTable().getDelFlg(), user.getRoleProfileTable().getEntityCreFlg(), user.getRoleProfileTable().getLchgTime(),
                    user.getRoleProfileTable().getLchgUserId(), user.getRoleProfileTable().getRcreTime(), user.getRoleProfileTable().getRcreUserId(), user.getRoleProfileTable().getRoleDesc()),
                user.getAcctExpyDate(), user.getAcctInactiveDays(),
                user.getDisabledFromDate(), user.getDisabledUptoDate(), user.getSolId(), user.getLastAccessTime(), user.getLchgUserId(), user.getNewUserFlg(),
                user.getNumPwdAttempts(), user.getNumPwdHistory(), user.getPwExpyDate(), user.getPwdHistory(), user.getRoleProfileTable().getRoleId(),
                user.getUserName(), user.getUserPw(), user.getUserStatus());
        return theUser;
    }

    public void changePassword(String userName, String userPw) {
        User newUser = getUserByUserName(userName);
        UserCredsTbl updated = new UserCredsTbl();
        updated.setUserPw(newUser.getUserPw());
        updated.setNewUserFlg("N");
        crud.saveOrUpdate(updated);

        // return getUserByUserName(userName);
    }

    public UserCredsTbl getUserByID(long userId) {
        List userById = crud.getObjectLazyLoad("from UserCredsTbl where userId =" + userId);
        return (UserCredsTbl) userById.get(0);
    }

    private static Date getExpDate(int numberOfDays) {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, numberOfDays);
        return cal.getTime();
    }

    public void enableUser(int userId) {
        UserCredsTbl users = getUserByID(userId);
        users.setDisabledFromDate(getExpDate(1000));
        users.setDisabledUptoDate(getExpDate(1000));
        crud.saveOrUpdate(users);
    }

    public void disableUser(int userId) {
        UserCredsTbl users = getUserByID(userId);
        users.setDisabledFromDate(new Date());
        users.setDisabledUptoDate(getExpDate(1000));
        crud.saveOrUpdate(users);
    }

    
    public static void logoutUser(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(LoggedInUser.class);
            cr.add(Restrictions.eq("userName", userName));
            LoggedInUser users = (LoggedInUser) cr.uniqueResult();
            session.delete(users);
            tx.commit();
        } catch (Exception asd) {
            System.out.println(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void markWrongLoginAttempt(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(UserCredsTbl.class);
            cr.add(Restrictions.eq("userName", userName));
            UserCredsTbl users = (UserCredsTbl) cr.uniqueResult();
            users.setNumPwdAttempts(users.getNumPwdAttempts() + 1);
            tx.commit();
        } catch (Exception asd) {
            System.out.println(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void markNotNewUser(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(UserCredsTbl.class);
            cr.add(Restrictions.eq("userName", userName));
            UserCredsTbl users = (UserCredsTbl) cr.uniqueResult();
            users.setNewUserFlg("N");
            tx.commit();
        } catch (Exception asd) {
            System.out.println(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void markCorrectLoginAttempt(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(UserCredsTbl.class);
            cr.add(Restrictions.eq("userName", userName));
            UserCredsTbl users = (UserCredsTbl) cr.uniqueResult();
            users.setNumPwdAttempts(0);
            tx.commit();
        } catch (Exception asd) {
            System.out.println(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
    public static void loginUser(String userName, String solId, Date loggedInTime, String sessionId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            LoggedInUser users = new LoggedInUser(loggedInTime, sessionId, solId, userName);
            session.save(users);
            tx.commit();
        } catch (Exception asd) {
            System.out.println(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
