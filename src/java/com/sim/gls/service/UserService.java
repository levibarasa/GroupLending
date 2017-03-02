package com.sim.gls.service;

import com.sim.gls.jpa.RoleProfileTable;
import com.sim.gls.jpa.UserCredsTbl;
import com.sim.gls.jpa.UserCredsTblMod;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtil;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Role;
import com.sim.gls.model.User;
import com.sim.gls.prop.GlsProp;
import com.sim.gls.security.Encode;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

    public List<User> getuserDetails(int userId) {
        List<User> userList = new LinkedList<>();
        User theUser = null;
        List<UserCredsTbl> existing = crud.findByPrimaryKey(userId, "FROM UserCredsTbl where userId =:pk");
        if (existing.size() > 0) {
            for (Object userObject : existing) {
                UserCredsTbl userProf = (UserCredsTbl) userObject;
                theUser = new User(
                        userProf.getUserId(),
                        new Role(userProf.getRoleProfileTable().getBankId(), userProf.getRoleProfileTable().getDelFlg(), userProf.getRoleProfileTable().getEntityCreFlg(), userProf.getRoleProfileTable().getLchgTime(),
                                userProf.getRoleProfileTable().getLchgUserId(), userProf.getRoleProfileTable().getRcreTime(), userProf.getRoleProfileTable().getRcreUserId(), userProf.getRoleProfileTable().getRoleDesc()), userProf.getAcctExpyDate(), userProf.getAcctInactiveDays(),
                        userProf.getDisabledFromDate(), userProf.getDisabledUptoDate(), userProf.getSolId(), userProf.getLastAccessTime(),
                        userProf.getLchgUserId(), userProf.getNewUserFlg(), userProf.getNumPwdAttempts(), userProf.getNumPwdHistory(), userProf.getPwExpyDate(),
                        userProf.getPwdHistory(), userProf.getRoleId(), userProf.getUserName(), userProf.getUserPw(), userProf.getUserStatus()
                );

                userList.add(theUser);

            }
        }
        return userList;

    }

////shouldnt be  a list of users because userid is the primarykey 
//    public UserCredsTblMod getuserModDetails(int userId) {
//        List mod_users = crud.getObjectLazyLoad("from UserCredsTblMod where userId =" + userId);
//        return (UserCredsTblMod) mod_users.get(0);
//    }
 public List<User> getuserModDetails(int userId) {
        List<User> userList = new LinkedList<>();
        User theUser = null;
        List<UserCredsTblMod> existing = crud.findByPrimaryKey(userId, "FROM UserCredsTblMod where userId =:pk");
        if (existing.size() > 0) {
            for (Object userObject : existing) {
                UserCredsTblMod userProf = (UserCredsTblMod) userObject;
                theUser = new User(
                        userProf.getUserId(),
                        new Role(userProf.getRoleProfileTable().getBankId(), userProf.getRoleProfileTable().getDelFlg(), userProf.getRoleProfileTable().getEntityCreFlg(), userProf.getRoleProfileTable().getLchgTime(),
                                userProf.getRoleProfileTable().getLchgUserId(), userProf.getRoleProfileTable().getRcreTime(), userProf.getRoleProfileTable().getRcreUserId(), userProf.getRoleProfileTable().getRoleDesc()), userProf.getAcctExpyDate(), userProf.getAcctInactiveDays(),
                        userProf.getDisabledFromDate(), userProf.getDisabledUptoDate(), userProf.getRoleProfileTable().getBankId(), userProf.getLastAccessTime(),
                        userProf.getRoleProfileTable().getLchgUserId(), userProf.getNewUserFlg(), userProf.getNumPwdAttempts(), userProf.getNumPwdHistory(), userProf.getPwExpyDate(),
                        userProf.getPwdHistory(), userProf.getRoleProfileTable().getRoleId(), userProf.getUserName(), userProf.getUserPw(), userProf.getRoleProfileTable().getUserCredsTbl().getUserStatus()
                );

                userList.add(theUser);

            }
        }
        return userList;

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
                        user.getNumPwdHistory(), user.getPwExpyDate(), user.getPwdHistory(), "U", userId, user.getUserName(), EncodeUserPassword(user.getUserName(), user.getUserPw()), true);
        crud.save(creatUserMod);
        return 0;
    }

    public int addUserDetails(User user) {
        int userId = createUser(user);
        createUserMod(userId, user);
        return userId;
    }

    public List<User> getAllVerifiedUsers() {
        List<User> allVerifiedUsers = new LinkedList<>();
        String query = "";
        List userCredsTblMod = crud.getObjectLazyLoad("from UserCredsTblMod where active =" + true);
        for (Object userObject : userCredsTblMod) {
            UserCredsTblMod userProf = (UserCredsTblMod) userObject;

            User user = new User(
                    userProf.getUserId(),
                    new Role(userProf.getRoleProfileTable().getBankId(), userProf.getRoleProfileTable().getDelFlg(), userProf.getRoleProfileTable().getEntityCreFlg(), userProf.getRoleProfileTable().getLchgTime(),
                            userProf.getRoleProfileTable().getLchgUserId(), userProf.getRoleProfileTable().getRcreTime(), userProf.getRoleProfileTable().getRcreUserId(), userProf.getRoleProfileTable().getRoleDesc()), userProf.getAcctExpyDate(), userProf.getAcctInactiveDays(),
                    userProf.getDisabledFromDate(), userProf.getDisabledUptoDate(), userProf.getRoleProfileTable().getBankId(), userProf.getLastAccessTime(),
                    userProf.getUserId(), userProf.getNewUserFlg(), userProf.getNumPwdAttempts(), userProf.getNumPwdHistory(), userProf.getPwExpyDate(),
                    userProf.getPwdHistory(), userProf.getRoleProfileTable().getRoleId(), userProf.getUserName(), userProf.getUserPw()
            );
            allVerifiedUsers.add(user);

        }
        return allVerifiedUsers;
    }

    public List<User> getAllUsers(String uname) {
        List<User> allUsers = new LinkedList<>();
        String query = "from UserCredsTbl where userName like '%" + uname + "%'"
                + "or userStatus like '%" + "A" + "%'";
        List<Object> users = crud.getObject(query);
        for (Object userObject : users) {
            UserCredsTbl userProf = (UserCredsTbl) userObject;

            User user = new User(
                    userProf.getUserId(),
                    new Role(userProf.getRoleProfileTable().getBankId(), userProf.getRoleProfileTable().getDelFlg(), userProf.getRoleProfileTable().getEntityCreFlg(), userProf.getRoleProfileTable().getLchgTime(),
                            userProf.getRoleProfileTable().getLchgUserId(), userProf.getRoleProfileTable().getRcreTime(), userProf.getRoleProfileTable().getRcreUserId(), userProf.getRoleProfileTable().getRoleDesc()), userProf.getAcctExpyDate(), userProf.getAcctInactiveDays(),
                    userProf.getDisabledFromDate(), userProf.getDisabledUptoDate(), userProf.getSolId(), userProf.getLastAccessTime(),
                    userProf.getLchgUserId(), userProf.getNewUserFlg(), userProf.getNumPwdAttempts(), userProf.getNumPwdHistory(), userProf.getPwExpyDate(),
                    userProf.getPwdHistory(), userProf.getRoleId(), userProf.getUserName(), userProf.getUserPw(), userProf.getUserStatus()
            );
            allUsers.add(user);

        }
        return allUsers;
    }

    public List<User> getUnverifiedUsers(String username) {
        List<User> allVerifiedUsers = new LinkedList<>();

        String query = "from UserCredsTblMod where userName like '%" + username + "%'"
                + "or active like '%" + false + "%'";

        List userCredsTblMod = crud.getObjectLazyLoad(query);
        for (Object userObject : userCredsTblMod) {
            UserCredsTblMod userProf = (UserCredsTblMod) userObject;

            User user = new User(
                    userProf.getUserId(),
                    new Role(userProf.getRoleProfileTable().getBankId(), userProf.getRoleProfileTable().getDelFlg(), userProf.getRoleProfileTable().getEntityCreFlg(), userProf.getRoleProfileTable().getLchgTime(),
                            userProf.getRoleProfileTable().getLchgUserId(), userProf.getRoleProfileTable().getRcreTime(), userProf.getRoleProfileTable().getRcreUserId(), userProf.getRoleProfileTable().getRoleDesc()), userProf.getAcctExpyDate(), userProf.getAcctInactiveDays(),
                    userProf.getDisabledFromDate(), userProf.getDisabledUptoDate(), userProf.getRoleProfileTable().getBankId(), userProf.getLastAccessTime(),
                    userProf.getUserId(), userProf.getNewUserFlg(), userProf.getNumPwdAttempts(), userProf.getNumPwdHistory(), userProf.getPwExpyDate(),
                    userProf.getPwdHistory(), userProf.getRoleProfileTable().getRoleId(), userProf.getUserName(), userProf.getUserPw()
            );
            allVerifiedUsers.add(user);

        }
        return allVerifiedUsers;
    }

    public List<User> getUnverifiedUsers() {
        List<User> allVerifiedUsers = new LinkedList<>();
        List userCredsTblMod = crud.getObjectLazyLoad("from UserCredsTblMod where active =" + false);
        for (Object userObject : userCredsTblMod) {
            UserCredsTblMod userProf = (UserCredsTblMod) userObject;

            User user = new User(
                    userProf.getUserId(),
                    new Role(userProf.getRoleProfileTable().getBankId(), userProf.getRoleProfileTable().getDelFlg(), userProf.getRoleProfileTable().getEntityCreFlg(), userProf.getRoleProfileTable().getLchgTime(),
                            userProf.getRoleProfileTable().getLchgUserId(), userProf.getRoleProfileTable().getRcreTime(), userProf.getRoleProfileTable().getRcreUserId(), userProf.getRoleProfileTable().getRoleDesc()), userProf.getAcctExpyDate(), userProf.getAcctInactiveDays(),
                    userProf.getDisabledFromDate(), userProf.getDisabledUptoDate(), userProf.getRoleProfileTable().getBankId(), userProf.getLastAccessTime(),
                    userProf.getUserId(), userProf.getNewUserFlg(), userProf.getNumPwdAttempts(), userProf.getNumPwdHistory(), userProf.getPwExpyDate(),
                    userProf.getPwdHistory(), userProf.getRoleProfileTable().getRoleId(), userProf.getUserName(), userProf.getUserPw()
            );
            allVerifiedUsers.add(user);

        }
        return allVerifiedUsers;
    }

    public User getUserDetails(String in) {
        int userid = Integer.parseInt(in);
        List<UserCredsTbl> existing = crud.findByPrimaryKey(userid, "FROM UserCredsTbl where id =:pk");

        User userDetail = null;
        if (existing.size() > 0) {
            UserCredsTbl userProf = existing.get(0);
            userDetail = new User(
                    userProf.getUserId(),
                    new Role(userProf.getRoleProfileTable().getBankId(), userProf.getRoleProfileTable().getDelFlg(), userProf.getRoleProfileTable().getEntityCreFlg(), userProf.getRoleProfileTable().getLchgTime(),
                            userProf.getRoleProfileTable().getLchgUserId(), userProf.getRoleProfileTable().getRcreTime(), userProf.getRoleProfileTable().getRcreUserId(), userProf.getRoleProfileTable().getRoleDesc()), userProf.getAcctExpyDate(), userProf.getAcctInactiveDays(),
                    userProf.getDisabledFromDate(), userProf.getDisabledUptoDate(), userProf.getRoleProfileTable().getBankId(), userProf.getLastAccessTime(),
                    userProf.getUserId(), userProf.getNewUserFlg(), userProf.getNumPwdAttempts(), userProf.getNumPwdHistory(), userProf.getPwExpyDate(),
                    userProf.getPwdHistory(), userProf.getRoleProfileTable().getRoleId(), userProf.getUserName(), userProf.getUserPw()
            );
        }
        return userDetail;
    }

    public String lastOper(String in) {
        int userid = Integer.parseInt(in);
        String res = "";
        User user = getUserDetails(in);

        res = user.getLastOper();

        // UserCredsTblMod list = getuserModDetails(userid);
        // res = list.getLastOper();
        return res;
    }

    public static void verifyUser(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(UserCredsTblMod.class);
            cr.add(Restrictions.eq("userId", userId));
            int count = 0;
            ScrollableResults items = cr.scroll();
            while (items.next()) {
                UserCredsTblMod user = (UserCredsTblMod) items.get(0);
                session.delete(user);
                if (++count % 100 == 0) {
                    session.flush();
                    session.clear();
                }
            }
            tx.commit();
        } catch (Exception asd) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

    public static ArrayList getUsersList() {
        ArrayList arr = new ArrayList();
        GlsProp pr = new GlsProp();
        String uploadFilepath = pr.getDBProperty().getProperty("user.file");
        String line;
        try {
            FileInputStream fs = new FileInputStream(uploadFilepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String[] split;
            while ((line = br.readLine()) != null) {
                split = line.split("\\|");
                ArrayList one = new ArrayList();
                one.add(split[0]);
                one.add(split[1]);
                one.add(split[2]);
                arr.add(one);
            }
            fs.close();
            br.close();
        } catch (Exception asd) {
        }
        return arr;
    }

    public static void deleteUser(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(UserCredsTbl.class);
            cr.add(Restrictions.eq("userId", userId));
            UserCredsTbl user = (UserCredsTbl) cr.uniqueResult();
            user.setUserStatus("D");
            tx.commit();
        } catch (Exception asd) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void modifyUser(User user) {
        List<UserCredsTbl> existing = crud.findByPrimaryKey(user.getUserId(), "from UserCredsTbl where id =:pk ");
        UserCredsTbl updated = new UserCredsTbl(user.getAcctExpyDate(), user.getAcctInactiveDays(), user.getDisabledFromDate(),
                user.getDisabledUptoDate(), user.getLastAccessTime(), user.getNewUserFlg(), user.getNumPwdAttempts(),
                user.getNumPwdHistory(), user.getPwExpyDate(), user.getPwdHistory(), user.getRole().getRoleId(),
                user.getUserName(), EncodeUserPassword(user.getUserName(), user.getUserPw()), user.getUserStatus());
        crud.saveOrUpdate(user);

    }

    public static void markUserUnverified(int userName, String userStatus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(UserCredsTbl.class);
            cr.add(Restrictions.eq("userId", userName));
            UserCredsTbl user = (UserCredsTbl) cr.uniqueResult();
            user.setUserStatus(userStatus);
            user.setNewUserFlg("Y");
            tx.commit();
        } catch (Exception asd) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static boolean userExistsInMod(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        long count = 0;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(UserCredsTblMod.class);
            cr.add(Restrictions.eq("userName", userName));
            count = (long) cr.setProjection(Projections.rowCount()).uniqueResult();
            tx.commit();
        } catch (Exception asd) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return count > 0;
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

    public static void main(String[] args) {
        UserService roleService = new UserService();
        for (Object userObject : roleService.getAllVerifiedUsers()) {
            User tlUser = (User) userObject;
            System.out.println(tlUser.getUserId() + " " + tlUser.getUserName() + " " + tlUser.getPwdHistory() + " " + tlUser.getNumPwdAttempts());
        }
    }
}
