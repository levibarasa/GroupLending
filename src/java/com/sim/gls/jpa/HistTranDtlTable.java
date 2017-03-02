package com.sim.gls.jpa;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HistTranDtlTable @author Stanley Mungai
 */
@Entity
@Table(name="HIST_TRAN_DTL_TABLE"
    ,schema="GLS"
)
public class HistTranDtlTable  implements java.io.Serializable {


     private int histId;
     private int tranId;
     private Date tranDate;
     private String delFlg;
     private String tranType;
     private String tranSubType;
     private String partTranType;
     private String glSubHeadCode;
     private int acid;
     private Date valueDate;
     private double tranAmt;
     private String tranParticular;
     private String entryUserId;
     private String pstdUserId;
     private Date entryDate;
     private Date pstdDate;
     private String pstdFlg;
     private String lchgUserId;
     private Date lchgTime;
     private String rcreUserId;
     private Date rcreTime;
     private int custId;
     private String rateCode;
     private double rate;
     private String tranCrncyCode;
     private String refCrncyCode;
     private double refAmt;
     private int solId;
     private int dthInitSolId;
     private String bankId;

    public HistTranDtlTable() {
    }

	
    public HistTranDtlTable(int tranId, Date tranDate, String delFlg, String tranType, String tranSubType, String partTranType, String glSubHeadCode, int acid, Date valueDate, double tranAmt, String tranParticular, String entryUserId, String pstdUserId, Date entryDate, Date pstdDate, String pstdFlg, String lchgUserId, Date lchgTime, String rcreUserId, Date rcreTime, int custId, String rateCode, double rate, String tranCrncyCode, String refCrncyCode, double refAmt, int solId, int dthInitSolId) {
        this.tranId = tranId;
        this.tranDate = tranDate;
        this.delFlg = delFlg;
        this.tranType = tranType;
        this.tranSubType = tranSubType;
        this.partTranType = partTranType;
        this.glSubHeadCode = glSubHeadCode;
        this.acid = acid;
        this.valueDate = valueDate;
        this.tranAmt = tranAmt;
        this.tranParticular = tranParticular;
        this.entryUserId = entryUserId;
        this.pstdUserId = pstdUserId;
        this.entryDate = entryDate;
        this.pstdDate = pstdDate;
        this.pstdFlg = pstdFlg;
        this.lchgUserId = lchgUserId;
        this.lchgTime = lchgTime;
        this.rcreUserId = rcreUserId;
        this.rcreTime = rcreTime;
        this.custId = custId;
        this.rateCode = rateCode;
        this.rate = rate;
        this.tranCrncyCode = tranCrncyCode;
        this.refCrncyCode = refCrncyCode;
        this.refAmt = refAmt;
        this.solId = solId;
        this.dthInitSolId = dthInitSolId;
    }
    public HistTranDtlTable(int tranId, Date tranDate, String delFlg, String tranType, String tranSubType, String partTranType, String glSubHeadCode, int acid, Date valueDate, double tranAmt, String tranParticular, String entryUserId, String pstdUserId, Date entryDate, Date pstdDate, String pstdFlg, String lchgUserId, Date lchgTime, String rcreUserId, Date rcreTime, int custId, String rateCode, double rate, String tranCrncyCode, String refCrncyCode, double refAmt, int solId, int dthInitSolId, String bankId) {
       this.tranId = tranId;
       this.tranDate = tranDate;
       this.delFlg = delFlg;
       this.tranType = tranType;
       this.tranSubType = tranSubType;
       this.partTranType = partTranType;
       this.glSubHeadCode = glSubHeadCode;
       this.acid = acid;
       this.valueDate = valueDate;
       this.tranAmt = tranAmt;
       this.tranParticular = tranParticular;
       this.entryUserId = entryUserId;
       this.pstdUserId = pstdUserId;
       this.entryDate = entryDate;
       this.pstdDate = pstdDate;
       this.pstdFlg = pstdFlg;
       this.lchgUserId = lchgUserId;
       this.lchgTime = lchgTime;
       this.rcreUserId = rcreUserId;
       this.rcreTime = rcreTime;
       this.custId = custId;
       this.rateCode = rateCode;
       this.rate = rate;
       this.tranCrncyCode = tranCrncyCode;
       this.refCrncyCode = refCrncyCode;
       this.refAmt = refAmt;
       this.solId = solId;
       this.dthInitSolId = dthInitSolId;
       this.bankId = bankId;
    }
   
     @Id@GeneratedValue 

    
    @Column(name="HIST_ID", unique=true, nullable=false, precision=22, scale=0)
    public int getHistId() {
        return this.histId;
    }
    
    public void setHistId(int histId) {
        this.histId = histId;
    }

    
    @Column(name="TRAN_ID", nullable=false, precision=22, scale=0)
    public int getTranId() {
        return this.tranId;
    }
    
    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TRAN_DATE", nullable=false, length=7)
    public Date getTranDate() {
        return this.tranDate;
    }
    
    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    
    @Column(name="DEL_FLG", nullable=false, length=1)
    public String getDelFlg() {
        return this.delFlg;
    }
    
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    
    @Column(name="TRAN_TYPE", nullable=false, length=1)
    public String getTranType() {
        return this.tranType;
    }
    
    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    
    @Column(name="TRAN_SUB_TYPE", nullable=false, length=2)
    public String getTranSubType() {
        return this.tranSubType;
    }
    
    public void setTranSubType(String tranSubType) {
        this.tranSubType = tranSubType;
    }

    
    @Column(name="PART_TRAN_TYPE", nullable=false, length=1)
    public String getPartTranType() {
        return this.partTranType;
    }
    
    public void setPartTranType(String partTranType) {
        this.partTranType = partTranType;
    }

    
    @Column(name="GL_SUB_HEAD_CODE", nullable=false, length=5)
    public String getGlSubHeadCode() {
        return this.glSubHeadCode;
    }
    
    public void setGlSubHeadCode(String glSubHeadCode) {
        this.glSubHeadCode = glSubHeadCode;
    }

    
    @Column(name="ACID", nullable=false, precision=22, scale=0)
    public int getAcid() {
        return this.acid;
    }
    
    public void setAcid(int acid) {
        this.acid = acid;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VALUE_DATE", nullable=false, length=7)
    public Date getValueDate() {
        return this.valueDate;
    }
    
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    
    @Column(name="TRAN_AMT", nullable=false, precision=126, scale=0)
    public double getTranAmt() {
        return this.tranAmt;
    }
    
    public void setTranAmt(double tranAmt) {
        this.tranAmt = tranAmt;
    }

    
    @Column(name="TRAN_PARTICULAR", nullable=false, length=100)
    public String getTranParticular() {
        return this.tranParticular;
    }
    
    public void setTranParticular(String tranParticular) {
        this.tranParticular = tranParticular;
    }

    
    @Column(name="ENTRY_USER_ID", nullable=false, length=30)
    public String getEntryUserId() {
        return this.entryUserId;
    }
    
    public void setEntryUserId(String entryUserId) {
        this.entryUserId = entryUserId;
    }

    
    @Column(name="PSTD_USER_ID", nullable=false, length=30)
    public String getPstdUserId() {
        return this.pstdUserId;
    }
    
    public void setPstdUserId(String pstdUserId) {
        this.pstdUserId = pstdUserId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ENTRY_DATE", nullable=false, length=7)
    public Date getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
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

    
    @Column(name="LCHG_USER_ID", nullable=false, length=30)
    public String getLchgUserId() {
        return this.lchgUserId;
    }
    
    public void setLchgUserId(String lchgUserId) {
        this.lchgUserId = lchgUserId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LCHG_TIME", nullable=false, length=7)
    public Date getLchgTime() {
        return this.lchgTime;
    }
    
    public void setLchgTime(Date lchgTime) {
        this.lchgTime = lchgTime;
    }

    
    @Column(name="RCRE_USER_ID", nullable=false, length=30)
    public String getRcreUserId() {
        return this.rcreUserId;
    }
    
    public void setRcreUserId(String rcreUserId) {
        this.rcreUserId = rcreUserId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RCRE_TIME", nullable=false, length=7)
    public Date getRcreTime() {
        return this.rcreTime;
    }
    
    public void setRcreTime(Date rcreTime) {
        this.rcreTime = rcreTime;
    }

    
    @Column(name="CUST_ID", nullable=false, precision=22, scale=0)
    public int getCustId() {
        return this.custId;
    }
    
    public void setCustId(int custId) {
        this.custId = custId;
    }

    
    @Column(name="RATE_CODE", nullable=false, length=5)
    public String getRateCode() {
        return this.rateCode;
    }
    
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    
    @Column(name="RATE", nullable=false, precision=126, scale=0)
    public double getRate() {
        return this.rate;
    }
    
    public void setRate(double rate) {
        this.rate = rate;
    }

    
    @Column(name="TRAN_CRNCY_CODE", nullable=false, length=3)
    public String getTranCrncyCode() {
        return this.tranCrncyCode;
    }
    
    public void setTranCrncyCode(String tranCrncyCode) {
        this.tranCrncyCode = tranCrncyCode;
    }

    
    @Column(name="REF_CRNCY_CODE", nullable=false, length=3)
    public String getRefCrncyCode() {
        return this.refCrncyCode;
    }
    
    public void setRefCrncyCode(String refCrncyCode) {
        this.refCrncyCode = refCrncyCode;
    }

    
    @Column(name="REF_AMT", nullable=false, precision=126, scale=0)
    public double getRefAmt() {
        return this.refAmt;
    }
    
    public void setRefAmt(double refAmt) {
        this.refAmt = refAmt;
    }

    
    @Column(name="SOL_ID", nullable=false, precision=22, scale=0)
    public int getSolId() {
        return this.solId;
    }
    
    public void setSolId(int solId) {
        this.solId = solId;
    }

    
    @Column(name="DTH_INIT_SOL_ID", nullable=false, precision=22, scale=0)
    public int getDthInitSolId() {
        return this.dthInitSolId;
    }
    
    public void setDthInitSolId(int dthInitSolId) {
        this.dthInitSolId = dthInitSolId;
    }

    
    @Column(name="BANK_ID", length=8)
    public String getBankId() {
        return this.bankId;
    }
    
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }




}


