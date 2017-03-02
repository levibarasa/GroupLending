/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.eod.branch;


import com.sim.gls.eod.dc.DcEod;
import com.sim.gls.jpa.DailyTranDetailTable;
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
 * @author Stanley Mungai
 */
public class ValidateUnpostedTransactions {

    private static final Log log = LogFactory.getLog("origlogger");

    public static boolean unpostedTransactions(int solId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        long count = 0;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranDate", BranchEod.getSystemDate(solId)));
            cr.add(Restrictions.eq("pstdFlg", "N"));
            cr.add(Restrictions.eq("delFlg", "N"));
            cr.add(Restrictions.eq("dthInitSolId", solId));
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
        return count > 0;
    }
    
     public static boolean unpostedTransactions() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        long count = 0;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranDate", DcEod.getSystemDate()));
            cr.add(Restrictions.eq("pstdFlg", "N"));
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
        return count > 0;
    }

    
    public static ArrayList getUnpostedTransactions(int solId) {
        ArrayList arr = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<DailyTranDetailTable> trans;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranDate", BranchEod.getSystemDate(solId)));
            cr.add(Restrictions.eq("pstdFlg", "N"));
            cr.add(Restrictions.eq("delFlg", "N"));
            cr.add(Restrictions.eq("dthInitSolId", solId));
            cr.setProjection(Projections.projectionList()
                    .add(Projections.property("tranId"))
                    .add(Projections.property("dthInitSolId")));
            trans = cr.list();
            for (DailyTranDetailTable dtd : trans) {
                ArrayList one = new ArrayList();
                one.add(dtd.getTranId() + ":" + dtd.getDthInitSolId());
                arr.add(one);
            }
            tx.commit();
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

    public static String checkUnpostedTransactions(int solId) {
        String status = "";
        if (!unpostedTransactions(solId)) {
            status = "SUCCESS";
        } else {
            ArrayList tranArray = getUnpostedTransactions(solId);
            for (Object tranArray1 : tranArray) {
                ArrayList one = (ArrayList) tranArray1;
                status = "Unposted Transactions: " + (String) one.get(0);
                log.debug(status);
                throw new OrigAfricException("Unposted Transactions: ", (String) one.get(0));
            }
        }
        return status;
    }
}
