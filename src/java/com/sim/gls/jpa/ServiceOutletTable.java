package com.sim.gls.jpa;
// Generated Feb 22, 2017 10:54:51 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ServiceOutletTable generated by hbm2java
 */
public class ServiceOutletTable  implements java.io.Serializable {


     private long solId;
     private String addr1;
     private String bankId;
     private String cntryCode;
     private String delFlg;
     private String homeCrncyCode;
     private Date lchgTime;
     private String lchgUserId;
     private Date rcreTime;
     private String rcreUserId;
     private Date solBodDate;
     private Date solClsDate;
     private String solClsFlg;
     private String solDesc;
     private String solEodStatus;

    public ServiceOutletTable() {
    }

	
    public ServiceOutletTable(long solId, String bankId, String delFlg, String homeCrncyCode, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, String solEodStatus) {
        this.solId = solId;
        this.bankId = bankId;
        this.delFlg = delFlg;
        this.homeCrncyCode = homeCrncyCode;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.solEodStatus = solEodStatus;
    }
    public ServiceOutletTable(long solId, String addr1, String bankId, String cntryCode, String delFlg, String homeCrncyCode, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, Date solBodDate, Date solClsDate, String solClsFlg, String solDesc, String solEodStatus) {
       this.solId = solId;
       this.addr1 = addr1;
       this.bankId = bankId;
       this.cntryCode = cntryCode;
       this.delFlg = delFlg;
       this.homeCrncyCode = homeCrncyCode;
       this.lchgTime = lchgTime;
       this.lchgUserId = lchgUserId;
       this.rcreTime = rcreTime;
       this.rcreUserId = rcreUserId;
       this.solBodDate = solBodDate;
       this.solClsDate = solClsDate;
       this.solClsFlg = solClsFlg;
       this.solDesc = solDesc;
       this.solEodStatus = solEodStatus;
    }
   
    public long getSolId() {
        return this.solId;
    }
    
    public void setSolId(long solId) {
        this.solId = solId;
    }
    public String getAddr1() {
        return this.addr1;
    }
    
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }
    public String getBankId() {
        return this.bankId;
    }
    
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
    public String getCntryCode() {
        return this.cntryCode;
    }
    
    public void setCntryCode(String cntryCode) {
        this.cntryCode = cntryCode;
    }
    public String getDelFlg() {
        return this.delFlg;
    }
    
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }
    public String getHomeCrncyCode() {
        return this.homeCrncyCode;
    }
    
    public void setHomeCrncyCode(String homeCrncyCode) {
        this.homeCrncyCode = homeCrncyCode;
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
    public Date getSolBodDate() {
        return this.solBodDate;
    }
    
    public void setSolBodDate(Date solBodDate) {
        this.solBodDate = solBodDate;
    }
    public Date getSolClsDate() {
        return this.solClsDate;
    }
    
    public void setSolClsDate(Date solClsDate) {
        this.solClsDate = solClsDate;
    }
    public String getSolClsFlg() {
        return this.solClsFlg;
    }
    
    public void setSolClsFlg(String solClsFlg) {
        this.solClsFlg = solClsFlg;
    }
    public String getSolDesc() {
        return this.solDesc;
    }
    
    public void setSolDesc(String solDesc) {
        this.solDesc = solDesc;
    }
    public String getSolEodStatus() {
        return this.solEodStatus;
    }
    
    public void setSolEodStatus(String solEodStatus) {
        this.solEodStatus = solEodStatus;
    }




}


