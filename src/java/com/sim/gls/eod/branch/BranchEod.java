/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.eod.branch;


import com.sim.gls.jpa.ServiceOutletTable;
import com.sim.gls.manager.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Stanley Mungai
 */
public class BranchEod {

    private static final Log log = LogFactory.getLog("origlogger");
    static SimpleDateFormat sdfday = new SimpleDateFormat("EE", Locale.getDefault());

    public static Date getSystemDate(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Date date = new Date();
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ServiceOutletTable.class);
            cr.add(Restrictions.eq("solId", solId));
            date = (Date) cr.setProjection(Projections.property("solBodDate")).uniqueResult();
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return date;
    }
   

    public static String getDayOftheWeek(Date date) {
        return sdfday.format(date);
    }

    private static Date getNextDate(Date today, int numberOfDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, numberOfDays);
        return cal.getTime();
    }

    public static Date getNextWorkingDate(int solId) {
        Date today = getSystemDate(solId);
        Date nextWorkingDate;
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        nextWorkingDate = cal.getTime();
        if (getDayOftheWeek(nextWorkingDate).equalsIgnoreCase("SUN")) {
            nextWorkingDate = getNextDate(nextWorkingDate, 1);
        }
        return nextWorkingDate;
    }

    public static void updatesolClosureDate(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ServiceOutletTable.class);
            cr.add(Restrictions.eq("solId", solId));
            ServiceOutletTable sol = (ServiceOutletTable) cr.uniqueResult();
            sol.setSolClsDate(getSystemDate(solId));
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void updatenextWorkingDate(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ServiceOutletTable.class);
            cr.add(Restrictions.eq("solId", solId));
            ServiceOutletTable sol = (ServiceOutletTable) cr.uniqueResult();
            sol.setSolBodDate(getNextWorkingDate(solId));
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void markSolClosed(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ServiceOutletTable.class);
            cr.add(Restrictions.eq("solId", solId));
            ServiceOutletTable sol = (ServiceOutletTable) cr.uniqueResult();
            sol.setSolClsFlg("Y");
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void markSolOpened(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ServiceOutletTable.class);
            cr.add(Restrictions.eq("solId", solId));
            ServiceOutletTable sol = (ServiceOutletTable) cr.uniqueResult();
            sol.setSolClsFlg("N");
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void markSolInitialized(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ServiceOutletTable.class);
            cr.add(Restrictions.eq("solId", solId));
            ServiceOutletTable sol = (ServiceOutletTable) cr.uniqueResult();
            sol.setSolClsFlg("I");
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public static void markSolProcessed(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ServiceOutletTable.class);
            cr.add(Restrictions.eq("solId", solId));
            ServiceOutletTable sol = (ServiceOutletTable) cr.uniqueResult();
            sol.setSolClsFlg("P");
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
