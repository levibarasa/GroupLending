package com.sim.gls.service;

import com.sim.gls.jpa.GeneralAcctMastTable;
import com.sim.gls.manager.HibernateUtil;
import com.sim.gls.prop.GlsProp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Levi
 */
public class TransactService {
     private static final Log log = LogFactory.getLog("origlogger");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());

    public static ArrayList getAllAccountsMappedtoSubGroup(String groupCode, String subgroupCode) {
        ArrayList arr = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<GeneralAcctMastTable> list;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(GeneralAcctMastTable.class);
            GlsProp pr = new GlsProp();
            String schm = pr.getDBProperty().getProperty("wholesale.schmecode");
            cr.add(Restrictions.eq("subGroupId", subgroupCode));
            cr.add(Restrictions.eq("groupId", groupCode));
            cr.add(Restrictions.ne("schmCode", schm));
            list = cr.list();
            for (GeneralAcctMastTable group : list) {
                ArrayList one = new ArrayList();
                one.add(group.getForacid());//0
                one.add(group.getAcctName());//1
                one.add(group.getGroupId());//2
                one.add(group.getSubGroupId());//3
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

    public static ArrayList getAccountMappedtoSubGroup(String groupCode, String subgroupCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList arr = new ArrayList();
        List<GeneralAcctMastTable> list;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(GeneralAcctMastTable.class);
            GlsProp pr = new GlsProp();
            String schm = pr.getDBProperty().getProperty("operative.schmecode");
            cr.add(Restrictions.eq("subGroupId", subgroupCode));
            cr.add(Restrictions.eq("groupId", groupCode));
            cr.add(Restrictions.ne("schmCode", schm));
            list = cr.list();
            for (GeneralAcctMastTable group : list) {
                ArrayList one = new ArrayList();
                one.add(group.getForacid());//0
                one.add(group.getAcctName());//1
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
    
}
