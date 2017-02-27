package com.sim.gls.service;

import com.sim.gls.jpa.SolGroupControlTable;
import com.sim.gls.jpa.SolGroupControlTableMod;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Bank;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Levi
 */
public class BankService {

    private static final Log log = LogFactory.getLog("simlogger");
    private static int solgroupId;
    HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getGLSHU());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.getDefault());

    public boolean bankEntityExists() {
        String qr = "from SolGroupControlTable ";
        List bank = crud.getObject(qr);

        if (bank.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getBankId() {
        List<Object> bankObject = crud.getObjectLazyLoad("FROM SolGroupControlTable");
        SolGroupControlTable bank = (SolGroupControlTable) bankObject.get(0);
        Bank b = new Bank();
        b.setBankId(bank.getBankId());
        return b.getBankId();
    }

    public SolGroupControlTable getBankDetails(String bankId) {
        List solGroup = crud.getObjectLazyLoad("from SolGroupControlTable where bankId =" + bankId);
        return (SolGroupControlTable) solGroup.get(0);
    }

    public int addbankEntity(Bank bank) {
        SolGroupControlTable saved = new SolGroupControlTable(bank.getBankId(), bank.getDbStatDate(), bank.getDcClsDate(), bank.getDcClsFlg(), bank.getDefNumOfDaysInMth(), bank.getDelFlg(), bank.getGroupDesc(), bank.getHomeCntryCode(), bank.getHomeCrncyCode(), bank.getLchgTime(), bank.getLchgUserId(), bank.getNumOfBackDaysAllowed(), bank.getNumOfFutureDaysAllowed(), bank.getRcreTime(), bank.getRcreUserId());
        int solgroupId = (int) crud.save(saved);
        return solgroupId;
    }

    public void addbankEntityMod(Bank bank, int solGroupId) {
        SolGroupControlTableMod saved = new SolGroupControlTableMod(bank.getBankId(), bank.getDbStatDate(), bank.getDcClsDate(), bank.getDcClsFlg(), bank.getDefNumOfDaysInMth(), bank.getDelFlg(), bank.getGroupDesc(), bank.getHomeCntryCode(), bank.getHomeCrncyCode(), bank.getLchgTime(), bank.getLchgUserId(), bank.getNumOfBackDaysAllowed(), bank.getNumOfFutureDaysAllowed(), bank.getRcreTime(), bank.getRcreUserId(), solGroupId);
        crud.save(saved);
    }

    public void executeaddEntity(Bank bank) {
        int solGroupId = addbankEntity(bank);
        addbankEntityMod(bank, solGroupId);

    }
}
