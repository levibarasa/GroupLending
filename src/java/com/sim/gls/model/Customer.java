package com.sim.gls.model;

import java.util.Date;

/**
 *
 * @author Levi
 */
public class Customer {
    private String acid ="";
    private String acctCrncyCode="";
    private String acctMgrUserId="";
    private String acctName="";
    private Date acctOpnDate = new Date();
    private String acctOwnership="";
    private String bankId="";
    private double clrBalAmt =0.00;
    private int custId =0;
    private String delFlg="";
    private double drwngPower=0.00;
    private String entityCreFlg="";
    private String foracid="";
    private String groupId="";
    private Date lastModifiedDate= new Date();
    private Date lchgTime =new Date();
    private String lchgUserId="";
    private double lienAmt=0.00;
    private String mappedFlg ="";
    private Date rcreTime = new Date();
    private String rcreUserId="";
    private double sanctLim=0.00;
    private String schmCode="";
    private String schmType="";
    private String solId="";
    private String subGroupId="";

    public Customer() {
    }
 public Customer(String acid, String acctClassificationFlg, String acctClsFlg, String acctCrncyCode, String acctName, Date acctOpnDate, String acctOwnership, double clrBalAmt, double cumCrAmt, double cumDrAmt, int custId, String delFlg, double drwngPower, String entityCreFlg, String foracid, String frezCode, String glSubHeadCode, Date lastModifiedDate, Date lchgTime, String lchgUserId, double lienAmt, Date rcreTime, String rcreUserId, double sanctLim, String schmCode, String schmType, String solId, String systemOnlyAcctFlg, double wtaxPcnt) {
        this.acid = acid;
        this.acctCrncyCode = acctCrncyCode;
        this.acctName = acctName;
        this.acctOpnDate = acctOpnDate;
        this.acctOwnership = acctOwnership;
        this.clrBalAmt = clrBalAmt;
        this.custId = custId;
        this.delFlg = delFlg;
        this.drwngPower = drwngPower;
        this.entityCreFlg = entityCreFlg;
        this.foracid = foracid;
        this.lastModifiedDate = lastModifiedDate;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.lienAmt = lienAmt;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.sanctLim = sanctLim;
        this.schmCode = schmCode;
        this.schmType = schmType;
        this.solId = solId;
    }
    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    public String getAcctCrncyCode() {
        return acctCrncyCode;
    }

    public void setAcctCrncyCode(String acctCrncyCode) {
        this.acctCrncyCode = acctCrncyCode;
    }

    public String getAcctMgrUserId() {
        return acctMgrUserId;
    }

    public void setAcctMgrUserId(String acctMgrUserId) {
        this.acctMgrUserId = acctMgrUserId;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public Date getAcctOpnDate() {
        return acctOpnDate;
    }

    public void setAcctOpnDate(Date acctOpnDate) {
        this.acctOpnDate = acctOpnDate;
    }

    public String getAcctOwnership() {
        return acctOwnership;
    }

    public void setAcctOwnership(String acctOwnership) {
        this.acctOwnership = acctOwnership;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public double getClrBalAmt() {
        return clrBalAmt;
    }

    public void setClrBalAmt(double clrBalAmt) {
        this.clrBalAmt = clrBalAmt;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public double getDrwngPower() {
        return drwngPower;
    }

    public void setDrwngPower(double drwngPower) {
        this.drwngPower = drwngPower;
    }

    public String getEntityCreFlg() {
        return entityCreFlg;
    }

    public void setEntityCreFlg(String entityCreFlg) {
        this.entityCreFlg = entityCreFlg;
    }

    public String getForacid() {
        return foracid;
    }

    public void setForacid(String foracid) {
        this.foracid = foracid;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getLchgTime() {
        return lchgTime;
    }

    public void setLchgTime(Date lchgTime) {
        this.lchgTime = lchgTime;
    }

    public String getLchgUserId() {
        return lchgUserId;
    }

    public void setLchgUserId(String lchgUserId) {
        this.lchgUserId = lchgUserId;
    }

    public double getLienAmt() {
        return lienAmt;
    }

    public void setLienAmt(double lienAmt) {
        this.lienAmt = lienAmt;
    }

    public String getMappedFlg() {
        return mappedFlg;
    }

    public void setMappedFlg(String mappedFlg) {
        this.mappedFlg = mappedFlg;
    }

    public Date getRcreTime() {
        return rcreTime;
    }

    public void setRcreTime(Date rcreTime) {
        this.rcreTime = rcreTime;
    }

    public String getRcreUserId() {
        return rcreUserId;
    }

    public void setRcreUserId(String rcreUserId) {
        this.rcreUserId = rcreUserId;
    }

    public double getSanctLim() {
        return sanctLim;
    }

    public void setSanctLim(double sanctLim) {
        this.sanctLim = sanctLim;
    }

    public String getSchmCode() {
        return schmCode;
    }

    public void setSchmCode(String schmCode) {
        this.schmCode = schmCode;
    }

    public String getSchmType() {
        return schmType;
    }

    public void setSchmType(String schmType) {
        this.schmType = schmType;
    }

    public String getSolId() {
        return solId;
    }

    public void setSolId(String solId) {
        this.solId = solId;
    }

    public String getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(String subGroupId) {
        this.subGroupId = subGroupId;
    }
    
    
    
}
