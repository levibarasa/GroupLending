package com.sim.gls.service;

import com.sim.gls.jpa.SolGroupControlTable;
import com.sim.gls.jpa.SolGroupControlTableMod;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Bank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

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

     public List<Bank> getBankDetails(String bankId) {
        List<Bank> bankList = new LinkedList<>();
        Bank theBank = null;
        String query = "from SolGroupControlTable where bankId like '%" + bankId + "%'"
                + "or solGroupId like '%" + bankId + "%'";
        List<Object> existing = crud.getObject(query);
          if (existing.size() > 0) {
            for (Object bankObject : existing) {
                SolGroupControlTable groupControlTable = (SolGroupControlTable) bankObject;
                theBank = new Bank(groupControlTable.getSolGroupId(),groupControlTable.getBankId(), groupControlTable.getDbStatDate(),groupControlTable.getDcClsDate(),groupControlTable.getDcClsFlg(),groupControlTable.getDefNumOfDaysInMth(),groupControlTable.getDelFlg(), groupControlTable.getGroupDesc(),groupControlTable.getHomeCntryCode(),groupControlTable.getHomeCrncyCode(),groupControlTable.getLchgTime(),groupControlTable.getLchgUserId(),groupControlTable.getNumOfBackDaysAllowed(),groupControlTable.getNumOfFutureDaysAllowed(),groupControlTable.getRcreTime(),groupControlTable.getRcreUserId()
                      );
                 bankList.add(theBank);
            }
        }
        return bankList;

    }
    public int addbankEntity(Bank bank) {
        SolGroupControlTable saved = new SolGroupControlTable(bank.getBankId(), bank.getDbStatDate(), bank.getDcClsDate(), bank.getDcClsFlg(), 
                bank.getDefNumOfDaysInMth(), bank.getDelFlg(), bank.getGroupDesc(), bank.getHomeCntryCode(), bank.getHomeCrncyCode(), bank.getLchgTime(),
                bank.getLchgUserId(),
                bank.getNumOfBackDaysAllowed(), 
                bank.getNumOfFutureDaysAllowed(), 
                bank.getRcreTime(), bank.getRcreUserId());
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
