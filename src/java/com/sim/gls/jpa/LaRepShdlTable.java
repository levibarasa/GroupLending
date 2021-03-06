package com.sim.gls.jpa;
// Generated Feb 22, 2017 10:54:51 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LaRepShdlTable generated by hbm2java
 */
public class LaRepShdlTable  implements java.io.Serializable {


     private String acid;
     private String bankId;
     private String delFlg;
     private String entityCreFlg;
     private BigDecimal flowAmt;
     private Date flowStartDate;
     private Date lchgTime;
     private String lchgUserId;
     private Date nextDmdDate;
     private BigDecimal numOfFlows;
     private Date rcreTime;
     private String rcreUserId;
     private BigDecimal shdlId;
     private BigDecimal solId;

    public LaRepShdlTable() {
    }

	
    public LaRepShdlTable(String acid) {
        this.acid = acid;
    }
    public LaRepShdlTable(String acid, String bankId, String delFlg, String entityCreFlg, BigDecimal flowAmt, Date flowStartDate, Date lchgTime, String lchgUserId, Date nextDmdDate, BigDecimal numOfFlows, Date rcreTime, String rcreUserId, BigDecimal shdlId, BigDecimal solId) {
       this.acid = acid;
       this.bankId = bankId;
       this.delFlg = delFlg;
       this.entityCreFlg = entityCreFlg;
       this.flowAmt = flowAmt;
       this.flowStartDate = flowStartDate;
       this.lchgTime = lchgTime;
       this.lchgUserId = lchgUserId;
       this.nextDmdDate = nextDmdDate;
       this.numOfFlows = numOfFlows;
       this.rcreTime = rcreTime;
       this.rcreUserId = rcreUserId;
       this.shdlId = shdlId;
       this.solId = solId;
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
    public String getEntityCreFlg() {
        return this.entityCreFlg;
    }
    
    public void setEntityCreFlg(String entityCreFlg) {
        this.entityCreFlg = entityCreFlg;
    }
    public BigDecimal getFlowAmt() {
        return this.flowAmt;
    }
    
    public void setFlowAmt(BigDecimal flowAmt) {
        this.flowAmt = flowAmt;
    }
    public Date getFlowStartDate() {
        return this.flowStartDate;
    }
    
    public void setFlowStartDate(Date flowStartDate) {
        this.flowStartDate = flowStartDate;
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
    public Date getNextDmdDate() {
        return this.nextDmdDate;
    }
    
    public void setNextDmdDate(Date nextDmdDate) {
        this.nextDmdDate = nextDmdDate;
    }
    public BigDecimal getNumOfFlows() {
        return this.numOfFlows;
    }
    
    public void setNumOfFlows(BigDecimal numOfFlows) {
        this.numOfFlows = numOfFlows;
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
    public BigDecimal getShdlId() {
        return this.shdlId;
    }
    
    public void setShdlId(BigDecimal shdlId) {
        this.shdlId = shdlId;
    }
    public BigDecimal getSolId() {
        return this.solId;
    }
    
    public void setSolId(BigDecimal solId) {
        this.solId = solId;
    }




}


