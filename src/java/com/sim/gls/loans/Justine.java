/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.loans;

 
import com.sim.gls.jpa.Justinewachira;
import com.sim.gls.manager.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class Justine {

    private static final Log log = LogFactory.getLog("origlogger");

    public static int getJustineAge(String justId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int justineage = 0;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Justinewachira.class);
            cr.add(Restrictions.eq("justId", justId));
            justineage = (Integer) cr.setProjection(Projections.property("justAge")).uniqueResult();
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return justineage;
    }

    public static boolean addJustine(String justName, int justAge, double accountBalance) {
        int insert = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Justinewachira justine = new Justinewachira(justName, justAge, accountBalance);
            insert = (Integer) session.save(justine);
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return insert > 0;
    }

    public static int getJustineAge(int justId) {
        List<Justinewachira> wachira = getJustinedetails(justId);
        int age = 0;
        double bal = 0.00;
        for (Justinewachira wach : wachira) {
            age = wach.getJustAge();
        }
        return age;
    }

    public static ArrayList getJustineDetails() {
        ArrayList arr = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Justinewachira> list;
        try {
          tx = session.beginTransaction();
          Criteria cr = session.createCriteria(Justinewachira.class);
          list = cr.list();
          for(Justinewachira wach: list){
              ArrayList one = new ArrayList();
              one.add(wach.getJustName());
              one.add(wach.getJustAge());
              one.add(wach.getAccountBalance());
              arr.add(one);
          }
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return arr;
    }

    public static List<Justinewachira> getJustinedetails(int justId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Justinewachira> list = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Justinewachira.class);
            cr.add(Restrictions.eq("justId", justId));
            list = cr.list();
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return list;
    }

}
