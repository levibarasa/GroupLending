package com.sim.gls.jpa;
// Generated Feb 22, 2017 10:54:51 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GeneralAcctMastTableMod generated by hbm2java
 */
public class GeneralAcctMastTableMod implements java.io.Serializable {

    private String acid;
    private String acctCrncyCode;
    private String acctMgrUserId;
    private String acctName;
    private Date acctOpnDate;
    private String acctOwnership;
    private String bankId;
    private double clrBalAmt;
    private int custId;
    private String delFlg;
    private double drwngPower;
    private String entityCreFlg;
    private String foracid;
    private Date lastModifiedDate;
    private Date lchgTime;
    private String lchgUserId;
    private double lienAmt;
    private Date rcreTime;
    private String rcreUserId;
    private double sanctLim;
    private String schmCode;
    private String schmType;
    private String solId;
    private int modId;
    private String subGroupCode;
    private String lastOper;
    private String groupCode;

    public GeneralAcctMastTableMod() {
    }

    public GeneralAcctMastTableMod(int modId, String acctCrncyCode, String acctMgrUserId, String acctName, Date acctOpnDate, String acctOwnership, String acid, String bankId, double clrBalAmt, int custId, String delFlg, double drwngPower, String entityCreFlg, String foracid, String groupCode, Date lastModifiedDate, String lastOper, Date lchgTime, String lchgUserId, double lienAmt, Date rcreTime, String rcreUserId, double sanctLim, String schmCode, String schmType, String solId, String subGroupCode) {
        this.modId = modId;
        this.acctCrncyCode = acctCrncyCode;
        this.acctMgrUserId = acctMgrUserId;
        this.acctName = acctName;
        this.acctOpnDate = acctOpnDate;
        this.acctOwnership = acctOwnership;
        this.acid = acid;
        this.bankId = bankId;
        this.clrBalAmt = clrBalAmt;
        this.custId = custId;
        this.delFlg = delFlg;
        this.drwngPower = drwngPower;
        this.entityCreFlg = entityCreFlg;
        this.foracid = foracid;
        this.groupCode = groupCode;
        this.lastModifiedDate = lastModifiedDate;
        this.lastOper = lastOper;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.lienAmt = lienAmt;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.sanctLim = sanctLim;
        this.schmCode = schmCode;
        this.schmType = schmType;
        this.solId = solId;
        this.subGroupCode = subGroupCode;
    }

    public GeneralAcctMastTableMod(  String acctCrncyCode, String acctMgrUserId, String acctName, Date acctOpnDate, String acctOwnership, String acid, String bankId, double clrBalAmt, int custId, String delFlg, double drwngPower, String entityCreFlg, String foracid, String groupCode, Date lastModifiedDate, String lastOper, Date lchgTime, String lchgUserId, double lienAmt, Date rcreTime, String rcreUserId, double sanctLim, String schmCode, String schmType, String solId, String subGroupCode) {
         this.acctCrncyCode = acctCrncyCode;
        this.acctMgrUserId = acctMgrUserId;
        this.acctName = acctName;
        this.acctOpnDate = acctOpnDate;
        this.acctOwnership = acctOwnership;
        this.acid = acid;
        this.bankId = bankId;
        this.clrBalAmt = clrBalAmt;
        this.custId = custId;
        this.delFlg = delFlg;
        this.drwngPower = drwngPower;
        this.entityCreFlg = entityCreFlg;
        this.foracid = foracid;
        this.groupCode = groupCode;
        this.lastModifiedDate = lastModifiedDate;
        this.lastOper = lastOper;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.lienAmt = lienAmt;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.sanctLim = sanctLim;
        this.schmCode = schmCode;
        this.schmType = schmType;
        this.solId = solId;
        this.subGroupCode = subGroupCode;
    }

    
    public int getModId() {
        return this.modId;
    }

    public void setModId(int modId) {
        this.modId = modId;
    }

   
    public String getAcctCrncyCode() {
        return this.acctCrncyCode;
    }

    public void setAcctCrncyCode(String acctCrncyCode) {
        this.acctCrncyCode = acctCrncyCode;
    }

    
    public String getAcctMgrUserId() {
        return this.acctMgrUserId;
    }

    public void setAcctMgrUserId(String acctMgrUserId) {
        this.acctMgrUserId = acctMgrUserId;
    }

     
    public String getAcctName() {
        return this.acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

     public Date getAcctOpnDate() {
        return this.acctOpnDate;
    }

    public void setAcctOpnDate(Date acctOpnDate) {
        this.acctOpnDate = acctOpnDate;
    }

     public String getAcctOwnership() {
        return this.acctOwnership;
    }

    public void setAcctOwnership(String acctOwnership) {
        this.acctOwnership = acctOwnership;
    }

     public String getAcid() {
        return this.acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

     public String getBankId() {
        return this.bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

     public double getClrBalAmt() {
        return this.clrBalAmt;
    }

    public void setClrBalAmt(double clrBalAmt) {
        this.clrBalAmt = clrBalAmt;
    }

     public int getCustId() {
        return this.custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

     public String getDelFlg() {
        return this.delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

     public double getDrwngPower() {
        return this.drwngPower;
    }

    public void setDrwngPower(double drwngPower) {
        this.drwngPower = drwngPower;
    }

     public String getEntityCreFlg() {
        return this.entityCreFlg;
    }

    public void setEntityCreFlg(String entityCreFlg) {
        this.entityCreFlg = entityCreFlg;
    }

     public String getForacid() {
        return this.foracid;
    }

    public void setForacid(String foracid) {
        this.foracid = foracid;
    }

     public String getGroupCode() {
        return this.groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

     public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

     public String getLastOper() {
        return this.lastOper;
    }

    public void setLastOper(String lastOper) {
        this.lastOper = lastOper;
    }

     public Date getLchgTime() {
        return this.lchgTime;
    }

    public void setLchgTime(Date lchgTime) {
        this.lchgTime = lchgTime;
    }

     public String getLchgUserId() {
        return this.lchgUserId;
    }

    public void setLchgUserId(String lchgUserId) {
        this.lchgUserId = lchgUserId;
    }

     public double getLienAmt() {
        return this.lienAmt;
    }

    public void setLienAmt(double lienAmt) {
        this.lienAmt = lienAmt;
    }

     public Date getRcreTime() {
        return this.rcreTime;
    }

    public void setRcreTime(Date rcreTime) {
        this.rcreTime = rcreTime;
    }

     public String getRcreUserId() {
        return this.rcreUserId;
    }

    public void setRcreUserId(String rcreUserId) {
        this.rcreUserId = rcreUserId;
    }

     public double getSanctLim() {
        return this.sanctLim;
    }

    public void setSanctLim(double sanctLim) {
        this.sanctLim = sanctLim;
    }

     public String getSchmCode() {
        return this.schmCode;
    }

    public void setSchmCode(String schmCode) {
        this.schmCode = schmCode;
    }

     public String getSchmType() {
        return this.schmType;
    }

    public void setSchmType(String schmType) {
        this.schmType = schmType;
    }

     public String getSolId() {
        return this.solId;
    }

    public void setSolId(String solId) {
        this.solId = solId;
    }

     public String getSubGroupCode() {
        return this.subGroupCode;
    }

    public void setSubGroupCode(String subGroupCode) {
        this.subGroupCode = subGroupCode;
    }
}
