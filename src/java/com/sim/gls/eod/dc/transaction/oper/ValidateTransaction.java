/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.eod.dc.transaction.oper;

 
import com.sim.gls.eod.dc.DcEod;
import com.sim.gls.jpa.DailyTranDetailTable;
import com.sim.gls.manager.HibernateUtil;
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
public class ValidateTransaction {

    private static final Log log = LogFactory.getLog("origlogger");

    public static boolean transactionHasAllLegs(int tranId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        long count = 0;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranId", tranId));
            cr.add(Restrictions.eq("tranDate", DcEod.getSystemDate()));
            cr.add(Restrictions.eq("delFlg", "N"));
            count = (Long) cr.setProjection(Projections.rowCount()).uniqueResult();
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return count > 1;
    }

    public static double getTranDebitSum(int tranId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        double sum = 0;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranId", tranId));
            cr.add(Restrictions.eq("tranDate", DcEod.getSystemDate()));
            cr.add(Restrictions.eq("delFlg", "N"));
            cr.add(Restrictions.eq("partTranType", "D"));
            sum = (Double) cr.setProjection(Projections.sum("tranAmt")).uniqueResult();
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return sum;
    }

    public static double getTranCreditSum(int tranId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        double sum = 0;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranId", tranId));
            cr.add(Restrictions.eq("tranDate", DcEod.getSystemDate()));
            cr.add(Restrictions.eq("delFlg", "N"));
            cr.add(Restrictions.eq("partTranType", "C"));
            sum = (Double) cr.setProjection(Projections.sum("tranAmt")).uniqueResult();
            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return sum;
    }

    public static boolean transactionIsBalanced(int tranId) {
        return getTranCreditSum(tranId) == getTranDebitSum(tranId);
    }

}
