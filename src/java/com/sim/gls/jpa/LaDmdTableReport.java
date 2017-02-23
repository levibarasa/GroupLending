package com.sim.gls.jpa;
// Generated Feb 22, 2017 10:54:51 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LaDmdTableReport generated by hbm2java
 */
public class LaDmdTableReport  implements java.io.Serializable {


     private String acid;
     private String bankId;
     private String delFlg;
     private BigDecimal dmdAmt;
     private Date dmdDate;
     private Date dmdEffDate;
     private String dmdFlowId;
     private BigDecimal dmdId;
     private Date dmdOvduDate;
     private Date lastAdjDate;
     private Date lchgTime;
     private String lchgUserId;
     private String ldFreqType;
     private Date rcreTime;
     private String rcreUserId;
     private BigDecimal totAdjAmt;

    public LaDmdTableReport() {
    }

    public LaDmdTableReport(String acid, String bankId, String delFlg, BigDecimal dmdAmt, Date dmdDate, Date dmdEffDate, String dmdFlowId, BigDecimal dmdId, Date dmdOvduDate, Date lastAdjDate, Date lchgTime, String lchgUserId, String ldFreqType, Date rcreTime, String rcreUserId, BigDecimal totAdjAmt) {
       this.acid = acid;
       this.bankId = bankId;
       this.delFlg = delFlg;
       this.dmdAmt = dmdAmt;
       this.dmdDate = dmdDate;
       this.dmdEffDate = dmdEffDate;
       this.dmdFlowId = dmdFlowId;
       this.dmdId = dmdId;
       this.dmdOvduDate = dmdOvduDate;
       this.lastAdjDate = lastAdjDate;
       this.lchgTime = lchgTime;
       this.lchgUserId = lchgUserId;
       this.ldFreqType = ldFreqType;
       this.rcreTime = rcreTime;
       this.rcreUserId = rcreUserId;
       this.totAdjAmt = totAdjAmt;
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
    public String getDelFlg() {
        return this.delFlg;
    }
    
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }
    public BigDecimal getDmdAmt() {
        return this.dmdAmt;
    }
    
    public void setDmdAmt(BigDecimal dmdAmt) {
        this.dmdAmt = dmdAmt;
    }
    public Date getDmdDate() {
        return this.dmdDate;
    }
    
    public void setDmdDate(Date dmdDate) {
        this.dmdDate = dmdDate;
    }
    public Date getDmdEffDate() {
        return this.dmdEffDate;
    }
    
    public void setDmdEffDate(Date dmdEffDate) {
        this.dmdEffDate = dmdEffDate;
    }
    public String getDmdFlowId() {
        return this.dmdFlowId;
    }
    
    public void setDmdFlowId(String dmdFlowId) {
        this.dmdFlowId = dmdFlowId;
    }
    public BigDecimal getDmdId() {
        return this.dmdId;
    }
    
    public void setDmdId(BigDecimal dmdId) {
        this.dmdId = dmdId;
    }
    public Date getDmdOvduDate() {
        return this.dmdOvduDate;
    }
    
    public void setDmdOvduDate(Date dmdOvduDate) {
        this.dmdOvduDate = dmdOvduDate;
    }
    public Date getLastAdjDate() {
        return this.lastAdjDate;
    }
    
    public void setLastAdjDate(Date lastAdjDate) {
        this.lastAdjDate = lastAdjDate;
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
    public String getLdFreqType() {
        return this.ldFreqType;
    }
    
    public void setLdFreqType(String ldFreqType) {
        this.ldFreqType = ldFreqType;
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
    public BigDecimal getTotAdjAmt() {
        return this.totAdjAmt;
    }
    
    public void setTotAdjAmt(BigDecimal totAdjAmt) {
        this.totAdjAmt = totAdjAmt;
    }




}

