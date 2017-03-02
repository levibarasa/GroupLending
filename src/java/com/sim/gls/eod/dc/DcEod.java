/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.eod.dc;


import com.sim.gls.eod.branch.OrigAfricException;
import com.sim.gls.eod.branch.ValidateUnpostedTransactions;
import com.sim.gls.jpa.DailyTranDetailTable;
import com.sim.gls.jpa.HistTranDtlTable;
import com.sim.gls.jpa.SolGroupControlTable;
import com.sim.gls.manager.HibernateUtil;
import java.util.Date;
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
public class DcEod {

    private static final Log log = LogFactory.getLog("origlogger");

    public static Date getSystemDate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Date date = new Date();
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(SolGroupControlTable.class);
            date = (Date) cr.setProjection(Projections.property("dbStatDate")).uniqueResult();
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

    public static void dtdHtdMovement() {
        if (!ValidateUnpostedTransactions.unpostedTransactions()) {
            List<DailyTranDetailTable> list = getAllTransactionRecords();
            for (DailyTranDetailTable dtd : list) {
                addHtdRecords(dtd.getTranId(), dtd.getTranDate(), dtd.getDelFlg(), dtd.getTranType(), dtd.getTranSubType(), dtd.getPartTranType(), dtd.getGlSubHeadCode(), dtd.getAcid(), dtd.getValueDate(), dtd.getTranAmt(), dtd.getTranParticular(), dtd.getEntryUserId(), dtd.getPstdUserId(), dtd.getEntryDate(), dtd.getPstdDate(), dtd.getPstdFlg(), dtd.getLchgUserId(), dtd.getLchgTime(), dtd.getRcreUserId(), dtd.getRcreTime(), dtd.getCustId(), dtd.getRateCode(), dtd.getRate(), dtd.getTranCrncyCode(), dtd.getRefCrncyCode(), dtd.getRefAmt(), dtd.getSolId(), dtd.getDthInitSolId(), dtd.getBankId());
            }
        } else {
            throw new OrigAfricException("Unposted Transactions", "");
        }
    }

    public static List<DailyTranDetailTable> getAllTransactionRecords() {
        List<DailyTranDetailTable> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(DailyTranDetailTable.class);
            cr.add(Restrictions.eq("tranDate", getSystemDate()));
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

    public static void addHtdRecords(int tranId, Date tranDate, String delFlg, String tranType, String tranSubType, String partTranType, String glSubHeadCode, int acid, Date valueDate, double tranAmt, String tranParticular, String entryUserId, String pstdUserId, Date entryDate, Date pstdDate, String pstdFlg, String lchgUserId, Date lchgTime, String rcreUserId, Date rcreTime, int custId, String rateCode, double rate, String tranCrncyCode, String refCrncyCode, double refAmt, int solId, int dthInitSolId, String bankId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            HistTranDtlTable htd = new HistTranDtlTable(tranId, tranDate, delFlg, tranType, tranSubType, partTranType, glSubHeadCode, acid, valueDate, tranAmt, tranParticular, entryUserId, pstdUserId, entryDate, pstdDate, pstdFlg, lchgUserId, lchgTime, rcreUserId, rcreTime, custId, rateCode, rate, tranCrncyCode, refCrncyCode, refAmt, solId, dthInitSolId, bankId);
            session.save(htd);
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
