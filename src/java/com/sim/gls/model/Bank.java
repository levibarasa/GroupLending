/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.model;

import java.util.Date;

/**
 *
 * @author Levi
 */
public class Bank {

     private int solGroupId =0;
     private String bankId ="";
     private Date dbStatDate = new Date();
     private Date dcClsDate = new Date();
     private String dcClsFlg = "";
     private int defNumOfDaysInMth =0;
     private String delFlg ="";
     private String groupDesc ="";
     private String homeCntryCode ="";
     private String homeCrncyCode ="";
     private Date lchgTime = new Date();
     private String lchgUserId ="";
     private int numOfBackDaysAllowed =0;
     private int numOfFutureDaysAllowed =0;
     private Date rcreTime = new Date();
     private String rcreUserId =""; 

     public Bank(){}
     public Bank(int solGroupId, String bankId, Date dbStatDate, Date dcClsDate, String dcClsFlg, int defNumOfDaysInMth, String delFlg, String groupDesc, String homeCntryCode, String homeCrncyCode, Date lchgTime, String lchgUserId, int numOfBackDaysAllowed, int numOfFutureDaysAllowed, Date rcreTime, String rcreUserId) {
       this.solGroupId = solGroupId;
       this.bankId = bankId;
       this.dbStatDate = dbStatDate;
       this.dcClsDate = dcClsDate;
       this.dcClsFlg = dcClsFlg;
       this.defNumOfDaysInMth = defNumOfDaysInMth;
       this.delFlg = delFlg;
       this.groupDesc = groupDesc;
       this.homeCntryCode = homeCntryCode;
       this.homeCrncyCode = homeCrncyCode;
       this.lchgTime = lchgTime;
       this.lchgUserId = lchgUserId;
       this.numOfBackDaysAllowed = numOfBackDaysAllowed;
       this.numOfFutureDaysAllowed = numOfFutureDaysAllowed;
       this.rcreTime = rcreTime;
       this.rcreUserId = rcreUserId;
    }
     public void setSolGroupId() {
       
    }
 
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public Date getDbStatDate() {
        return dbStatDate;
    }

    public void setDbStatDate(Date dbStatDate) {
        this.dbStatDate = dbStatDate;
    }

    public Date getDcClsDate() {
        return dcClsDate;
    }

    public void setDcClsDate(Date dcClsDate) {
        this.dcClsDate = dcClsDate;
    }

    public String getDcClsFlg() {
        return dcClsFlg;
    }

    public void setDcClsFlg(String dcClsFlg) {
        this.dcClsFlg = dcClsFlg;
    }

    public int getDefNumOfDaysInMth() {
        return defNumOfDaysInMth;
    }

    public void setDefNumOfDaysInMth(int defNumOfDaysInMth) {
        this.defNumOfDaysInMth = defNumOfDaysInMth;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getHomeCntryCode() {
        return homeCntryCode;
    }

    public void setHomeCntryCode(String homeCntryCode) {
        this.homeCntryCode = homeCntryCode;
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

    public int getNumOfBackDaysAllowed() {
        return numOfBackDaysAllowed;
    }

    public void setNumOfBackDaysAllowed(int numOfBackDaysAllowed) {
        this.numOfBackDaysAllowed = numOfBackDaysAllowed;
    }

    public int getNumOfFutureDaysAllowed() {
        return numOfFutureDaysAllowed;
    }

    public void setNumOfFutureDaysAllowed(int numOfFutureDaysAllowed) {
        this.numOfFutureDaysAllowed = numOfFutureDaysAllowed;
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
     
}
