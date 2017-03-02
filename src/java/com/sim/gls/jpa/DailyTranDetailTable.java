package com.sim.gls.jpa;
// Generated Apr 20, 2016 3:00:44 PM @author Stanley Mungai


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DailyTranDetailTable @author Stanley Mungai
 */
@Entity
@Table(name="DAILY_TRAN_DETAIL_TABLE"
    ,schema="GLS"
)
public class DailyTranDetailTable  implements java.io.Serializable {


     private int dtdId;
     private int tranId;
     private int acid;
     private String bankId;
     private int custId;
     private String delFlg;
     private int dthInitSolId;
     private Date entryDate;
     private String entryUserId;
     private String glSubHeadCode;
     private Date lchgTime;
     private String lchgUserId;
     private String partTranType;
     private Date pstdDate;
     private String pstdFlg;
     private String pstdUserId;
     private double rate;
     private String rateCode;
     private Date rcreTime;
     private String rcreUserId;
     private double refAmt;
     private String refCrncyCode;
     private int solId;
     private double tranAmt;
     private String tranCrncyCode;
     private Date tranDate;
     private String tranParticular;
     private String tranSubType;
     private String tranType;
     private Date valueDate;

    public DailyTranDetailTable() {
    }

    public DailyTranDetailTable(int tranId, int acid, String bankId, int custId, String delFlg, int dthInitSolId, Date entryDate, String entryUserId, String glSubHeadCode, Date lchgTime, String lchgUserId, String partTranType, Date pstdDate, String pstdFlg, String pstdUserId, double rate, String rateCode, Date rcreTime, String rcreUserId, double refAmt, String refCrncyCode, int solId, double tranAmt, String tranCrncyCode, Date tranDate, String tranParticular, String tranSubType, String tranType, Date valueDate) {
       this.tranId = tranId;
       this.acid = acid;
       this.bankId = bankId;
       this.custId = custId;
       this.delFlg = delFlg;
       this.dthInitSolId = dthInitSolId;
       this.entryDate = entryDate;
       this.entryUserId = entryUserId;
       this.glSubHeadCode = glSubHeadCode;
       this.lchgTime = lchgTime;
       this.lchgUserId = lchgUserId;
       this.partTranType = partTranType;
       this.pstdDate = pstdDate;
       this.pstdFlg = pstdFlg;
       this.pstdUserId = pstdUserId;
       this.rate = rate;
       this.rateCode = rateCode;
       this.rcreTime = rcreTime;
       this.rcreUserId = rcreUserId;
       this.refAmt = refAmt;
       this.refCrncyCode = refCrncyCode;
       this.solId = solId;
       this.tranAmt = tranAmt;
       this.tranCrncyCode = tranCrncyCode;
       this.tranDate = tranDate;
       this.tranParticular = tranParticular;
       this.tranSubType = tranSubType;
       this.tranType = tranType;
       this.valueDate = valueDate;
    }
   
     @Id 

    @GeneratedValue
    @Column(name="DTD_ID", unique=true, nullable=false, precision=10, scale=0)
    public int getDtdId() {
        return this.dtdId;
    }
    
    public void setDtdId(int dtdId) {
        this.dtdId = dtdId;
    }

    
    @Column(name="TRAN_ID", nullable=false, precision=10, scale=0)
    public int getTranId() {
        return this.tranId;
    }
    
    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    
    @Column(name="ACID", nullable=false, precision=10, scale=0)
    public int getAcid() {
        return this.acid;
    }
    
    public void setAcid(int acid) {
        this.acid = acid;
    }

    
    @Column(name="BANK_ID", nullable=false, length=8)
    public String getBankId() {
        return this.bankId;
    }
    
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    
    @Column(name="CUST_ID", nullable=false, precision=10, scale=0)
    public int getCustId() {
        return this.custId;
    }
    
    public void setCustId(int custId) {
        this.custId = custId;
    }

    
    @Column(name="DEL_FLG", nullable=false, length=1)
    public String getDelFlg() {
        return this.delFlg;
    }
    
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    
    @Column(name="DTH_INIT_SOL_ID", nullable=false, precision=10, scale=0)
    public int getDthInitSolId() {
        return this.dthInitSolId;
    }
    
    public void setDthInitSolId(int dthInitSolId) {
        this.dthInitSolId = dthInitSolId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ENTRY_DATE", nullable=false, length=7)
    public Date getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    
    @Column(name="ENTRY_USER_ID", nullable=false, length=30)
    public String getEntryUserId() {
        return this.entryUserId;
    }
    
    public void setEntryUserId(String entryUserId) {
        this.entryUserId = entryUserId;
    }

    
    @Column(name="GL_SUB_HEAD_CODE", nullable=false, length=5)
    public String getGlSubHeadCode() {
        return this.glSubHeadCode;
    }
    
    public void setGlSubHeadCode(String glSubHeadCode) {
        this.glSubHeadCode = glSubHeadCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LCHG_TIME", nullable=false, length=7)
    public Date getLchgTime() {
        return this.lchgTime;
    }
    
    public void setLchgTime(Date lchgTime) {
        this.lchgTime = lchgTime;
    }

    
    @Column(name="LCHG_USER_ID", nullable=false, length=30)
    public String getLchgUserId() {
        return this.lchgUserId;
    }
    
    public void setLchgUserId(String lchgUserId) {
        this.lchgUserId = lchgUserId;
    }

    
    @Column(name="PART_TRAN_TYPE", nullable=false, length=1)
    public String getPartTranType() {
        return this.partTranType;
    }
    
    public void setPartTranType(String partTranType) {
        this.partTranType = partTranType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PSTD_DATE", nullable=false, length=7)
    public Date getPstdDate() {
        return this.pstdDate;
    }
    
    public void setPstdDate(Date pstdDate) {
        this.pstdDate = pstdDate;
    }

    
    @Column(name="PSTD_FLG", nullable=false, length=1)
    public String getPstdFlg() {
        return this.pstdFlg;
    }
    
    public void setPstdFlg(String pstdFlg) {
        this.pstdFlg = pstdFlg;
    }

    
    @Column(name="PSTD_USER_ID", nullable=false, length=30)
    public String getPstdUserId() {
        return this.pstdUserId;
    }
    
    public void setPstdUserId(String pstdUserId) {
        this.pstdUserId = pstdUserId;
    }

    
    @Column(name="RATE", nullable=false, precision=126, scale=0)
    public double getRate() {
        return this.rate;
    }
    
    public void setRate(double rate) {
        this.rate = rate;
    }

    
    @Column(name="RATE_CODE", nullable=false, length=5)
    public String getRateCode() {
        return this.rateCode;
    }
    
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RCRE_TIME", nullable=false, length=7)
    public Date getRcreTime() {
        return this.rcreTime;
    }
    
    public void setRcreTime(Date rcreTime) {
        this.rcreTime = rcreTime;
    }

    
    @Column(name="RCRE_USER_ID", nullable=false, length=30)
    public String getRcreUserId() {
        return this.rcreUserId;
    }
    
    public void setRcreUserId(String rcreUserId) {
        this.rcreUserId = rcreUserId;
    }

    
    @Column(name="REF_AMT", nullable=false, precision=126, scale=0)
    public double getRefAmt() {
        return this.refAmt;
    }
    
    public void setRefAmt(double refAmt) {
        this.refAmt = refAmt;
    }

    
    @Column(name="REF_CRNCY_CODE", nullable=false, length=3)
    public String getRefCrncyCode() {
        return this.refCrncyCode;
    }
    
    public void setRefCrncyCode(String refCrncyCode) {
        this.refCrncyCode = refCrncyCode;
    }

    
    @Column(name="SOL_ID", nullable=false, precision=10, scale=0)
    public int getSolId() {
        return this.solId;
    }
    
    public void setSolId(int solId) {
        this.solId = solId;
    }

    
    @Column(name="TRAN_AMT", nullable=false, precision=126, scale=0)
    public double getTranAmt() {
        return this.tranAmt;
    }
    
    public void setTranAmt(double tranAmt) {
        this.tranAmt = tranAmt;
    }

    
    @Column(name="TRAN_CRNCY_CODE", nullable=false, length=3)
    public String getTranCrncyCode() {
        return this.tranCrncyCode;
    }
    
    public void setTranCrncyCode(String tranCrncyCode) {
        this.tranCrncyCode = tranCrncyCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TRAN_DATE", nullable=false, length=7)
    public Date getTranDate() {
        return this.tranDate;
    }
    
    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    
    @Column(name="TRAN_PARTICULAR", nullable=false, length=100)
    public String getTranParticular() {
        return this.tranParticular;
    }
    
    public void setTranParticular(String tranParticular) {
        this.tranParticular = tranParticular;
    }

    
    @Column(name="TRAN_SUB_TYPE", nullable=false, length=2)
    public String getTranSubType() {
        return this.tranSubType;
    }
    
    public void setTranSubType(String tranSubType) {
        this.tranSubType = tranSubType;
    }

    
    @Column(name="TRAN_TYPE", nullable=false, length=1)
    public String getTranType() {
        return this.tranType;
    }
    
    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VALUE_DATE", nullable=false, length=7)
    public Date getValueDate() {
        return this.valueDate;
    }
    
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }




}


