package com.sim.gls.jpa;
// Generated Feb 22, 2017 10:54:51 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * UserCredsTbl generated by hbm2java
 */
public class UserCredsTbl  implements java.io.Serializable {


     private long userId;
     private RoleProfileTable roleProfileTable;
     private Date acctExpyDate;
     private long acctInactiveDays;
     private Date disabledFromDate;
     private Date disabledUptoDate;
     private String solId;
     private Date lastAccessTime;
     private String lchgUserId;
     private String newUserFlg;
     private long numPwdAttempts;
     private long numPwdHistory;
     private Date pwExpyDate;
     private String pwdHistory;
     private long roleId;
     private String userName;
     private String userPw;
     private String userStatus;

    public UserCredsTbl() {
    }

	
    public UserCredsTbl(RoleProfileTable roleProfileTable, Date acctExpyDate, long acctInactiveDays, Date disabledFromDate, Date disabledUptoDate, Date lastAccessTime, String newUserFlg, long numPwdAttempts, long numPwdHistory, Date pwExpyDate, String pwdHistory, long roleId, String userName, String userPw, String userStatus) {
        this.roleProfileTable = roleProfileTable;
        this.acctExpyDate = acctExpyDate;
        this.acctInactiveDays = acctInactiveDays;
        this.disabledFromDate = disabledFromDate;
        this.disabledUptoDate = disabledUptoDate;
        this.lastAccessTime = lastAccessTime;
        this.newUserFlg = newUserFlg;
        this.numPwdAttempts = numPwdAttempts;
        this.numPwdHistory = numPwdHistory;
        this.pwExpyDate = pwExpyDate;
        this.pwdHistory = pwdHistory;
        this.roleId = roleId;
        this.userName = userName;
        this.userPw = userPw;
        this.userStatus = userStatus;
    }
    public UserCredsTbl(RoleProfileTable roleProfileTable, Date acctExpyDate, long acctInactiveDays, Date disabledFromDate, Date disabledUptoDate, String solId, Date lastAccessTime, String lchgUserId, String newUserFlg, long numPwdAttempts, long numPwdHistory, Date pwExpyDate, String pwdHistory, long roleId, String userName, String userPw, String userStatus) {
       this.roleProfileTable = roleProfileTable;
       this.acctExpyDate = acctExpyDate;
       this.acctInactiveDays = acctInactiveDays;
       this.disabledFromDate = disabledFromDate;
       this.disabledUptoDate = disabledUptoDate;
       this.solId = solId;
       this.lastAccessTime = lastAccessTime;
       this.lchgUserId = lchgUserId;
       this.newUserFlg = newUserFlg;
       this.numPwdAttempts = numPwdAttempts;
       this.numPwdHistory = numPwdHistory;
       this.pwExpyDate = pwExpyDate;
       this.pwdHistory = pwdHistory;
       this.roleId = roleId;
       this.userName = userName;
       this.userPw = userPw;
       this.userStatus = userStatus;
    }
   
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public RoleProfileTable getRoleProfileTable() {
        return this.roleProfileTable;
    }
    
    public void setRoleProfileTable(RoleProfileTable roleProfileTable) {
        this.roleProfileTable = roleProfileTable;
    }
    public Date getAcctExpyDate() {
        return this.acctExpyDate;
    }
    
    public void setAcctExpyDate(Date acctExpyDate) {
        this.acctExpyDate = acctExpyDate;
    }
    public long getAcctInactiveDays() {
        return this.acctInactiveDays;
    }
    
    public void setAcctInactiveDays(long acctInactiveDays) {
        this.acctInactiveDays = acctInactiveDays;
    }
    public Date getDisabledFromDate() {
        return this.disabledFromDate;
    }
    
    public void setDisabledFromDate(Date disabledFromDate) {
        this.disabledFromDate = disabledFromDate;
    }
    public Date getDisabledUptoDate() {
        return this.disabledUptoDate;
    }
    
    public void setDisabledUptoDate(Date disabledUptoDate) {
        this.disabledUptoDate = disabledUptoDate;
    }
    public String getSolId() {
        return this.solId;
    }
    
    public void setSolId(String solId) {
        this.solId = solId;
    }
    public Date getLastAccessTime() {
        return this.lastAccessTime;
    }
    
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
    public String getLchgUserId() {
        return this.lchgUserId;
    }
    
    public void setLchgUserId(String lchgUserId) {
        this.lchgUserId = lchgUserId;
    }
    public String getNewUserFlg() {
        return this.newUserFlg;
    }
    
    public void setNewUserFlg(String newUserFlg) {
        this.newUserFlg = newUserFlg;
    }
    public long getNumPwdAttempts() {
        return this.numPwdAttempts;
    }
    
    public void setNumPwdAttempts(long numPwdAttempts) {
        this.numPwdAttempts = numPwdAttempts;
    }
    public long getNumPwdHistory() {
        return this.numPwdHistory;
    }
    
    public void setNumPwdHistory(long numPwdHistory) {
        this.numPwdHistory = numPwdHistory;
    }
    public Date getPwExpyDate() {
        return this.pwExpyDate;
    }
    
    public void setPwExpyDate(Date pwExpyDate) {
        this.pwExpyDate = pwExpyDate;
    }
    public String getPwdHistory() {
        return this.pwdHistory;
    }
    
    public void setPwdHistory(String pwdHistory) {
        this.pwdHistory = pwdHistory;
    }
    public long getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPw() {
        return this.userPw;
    }
    
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public String getUserStatus() {
        return this.userStatus;
    }
    
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }




}

