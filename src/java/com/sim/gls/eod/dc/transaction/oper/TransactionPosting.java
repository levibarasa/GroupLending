/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.eod.dc.transaction.oper;

 
import com.sim.gls.eod.branch.OrigAfricException;
import com.sim.gls.eod.dc.DcEod;
import com.sim.gls.jpa.DailyTranDetailTable;
import com.sim.gls.jpa.GeneralAcctMastTable;
import com.sim.gls.manager.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Stanley Mungai
 */
public class TransactionPosting {

    private static final Log log = LogFactory.getLog("origlogger");

    public static void postTransaction(int tranId, String username) {
        if (ValidateTransaction.transactionHasAllLegs(tranId)) {
            if (ValidateTransaction.transactionIsBalanced(tranId)) {
                postTran(tranId, username);
                List<DailyTranDetailTable> tranList = getTranAcidAmtDetails(tranId);
                for (DailyTranDetailTable dtd : tranList) {
                    updateClrBalanceAmt(dtd.getAcid(), dtd.getTranAmt(), dtd.getPartTranType());
                }
                log.debug("Transaction Id: " + tranId + " Posted Successfully!");
            } else {
                throw new OrigAfricException("Transaction is Not Balance", "");
            }
        } else {
            throw new OrigAfricException("Transaction is Not Balance", "");
        }
    }

    public static void enterTransaction(int tranId, int acid, String bankId, int custId, String delFlg, int dthInitSolId, Date entryDate, String entryUserId, String glSubHeadCode, Date lchgTime, String lchgUserId, String partTranType, Date pstdDate, String pstdFlg, String pstdUserId, double rate, String rateCode, Date rcreTime, String rcreUserId, double refAmt, String refCrncyCode, int solId, double tranAmt, String tranCrncyCode, Date tranDate, String tranParticular, String tranSubType, String tranType, Date valueDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            DailyTranDetailTable dtd = new DailyTranDetailTable(tranId, acid, bankId, custId, delFlg, dthInitSolId, entryDate, entryUserId, glSubHeadCode, lchgTime, lchgUserId, partTranType, pstdDate, pstdFlg, pstdUserId, rate, rateCode, rcreTime, rcreUserId, refAmt, refCrncyCode, solId, tranAmt, tranCrncyCode, tranDate, tranParticular, tranSubType, tranType, valueDate);
            session.save(dtd);
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

    public static void postTran(int tranId, String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranId", tranId));
            cr.add(Restrictions.eq("delFlg", "N"));
            cr.add(Restrictions.eq("tranDate", DcEod.getSystemDate()));
            ScrollableResults items = cr.scroll();
            int count = 0;
            while (items.next()) {
                DailyTranDetailTable dtd = (DailyTranDetailTable) items.get(0);
                dtd.setLchgTime(new Date());
                dtd.setLchgUserId(username);
                dtd.setPstdDate(new Date());
                dtd.setPstdUserId(username);
                dtd.setPstdFlg("Y");
                session.saveOrUpdate(dtd);
                if (++count % 100 == 0) {
                    session.flush();
                    session.clear();
                }
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
    }

    public static List<DailyTranDetailTable> getTranAcidAmtDetails(int tranId) {
        List<DailyTranDetailTable> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranId", tranId));
            cr.add(Restrictions.eq("delFlg", "N"));
            cr.add(Restrictions.eq("tranDate", DcEod.getSystemDate()));
            cr.setProjection(Projections.projectionList()
                    .add(Projections.property("acid"))
                    .add(Projections.property("tranAmt"))
                    .add(Projections.property("partTranType")));
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

    public static void updateClrBalanceAmt(int acid, double tranAmt, String partTranType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(GeneralAcctMastTable.class);
            cr.add(Restrictions.eq("acid", acid));
            GeneralAcctMastTable gam = (GeneralAcctMastTable) cr.uniqueResult();
            if (partTranType.equalsIgnoreCase("C")) {
                gam.setClrBalAmt(gam.getClrBalAmt() + tranAmt);
            } else if (partTranType.equalsIgnoreCase("D")) {
                gam.setClrBalAmt(gam.getClrBalAmt() - tranAmt);
            }
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
