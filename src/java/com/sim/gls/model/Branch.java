package com.sim.gls.model;

import java.util.Date;

/**
 *
 * @author Levi
 */
public class Branch {
    
    private long solId=0;
     private String addr1="";
     private String bankId="";
     private String cntryCode="";
     private String delFlg="";
     private String homeCrncyCode="";
     private Date lchgTime= new Date();
     private String lchgUserId="";
     private Date rcreTime= new Date();
     private String rcreUserId="";
     private Date solBodDate=new Date();
     private Date solClsDate= new Date();
     private String solClsFlg="";
     private String solDesc="";
     private String solEodStatus="";

    public Branch() {
    }

    public Branch(long solId, String addr1, String bankId, String cntryCode, String delFlg, String homeCrncyCode, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, Date solBodDate, Date solClsDate, String solClsFlg, String solDesc, String solEodStatus) {
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
        return solId;
    }

    public void setSolId(long solId) {
        this.solId = solId;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getCntryCode() {
        return cntryCode;
    }

    public void setCntryCode(String cntryCode) {
        this.cntryCode = cntryCode;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public String getHomeCrncyCode() {
        return homeCrncyCode;
    }

    public void setHomeCrncyCode(String homeCrncyCode) {
        this.homeCrncyCode = homeCrncyCode;
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

    public Date getSolBodDate() {
        return solBodDate;
    }

    public void setSolBodDate(Date solBodDate) {
        this.solBodDate = solBodDate;
    }

    public Date getSolClsDate() {
        return solClsDate;
    }

    public void setSolClsDate(Date solClsDate) {
        this.solClsDate = solClsDate;
    }

    public String getSolClsFlg() {
        return solClsFlg;
    }

    public void setSolClsFlg(String solClsFlg) {
        this.solClsFlg = solClsFlg;
    }

    public String getSolDesc() {
        return solDesc;
    }

    public void setSolDesc(String solDesc) {
        this.solDesc = solDesc;
    }

    public String getSolEodStatus() {
        return solEodStatus;
    }

    public void setSolEodStatus(String solEodStatus) {
        this.solEodStatus = solEodStatus;
    }
     
     
}
