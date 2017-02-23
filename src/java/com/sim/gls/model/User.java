/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.model;

import com.sim.gls.jpa.RoleProfileTable;
import java.util.Date;

/**
 *
 * @author Levi
 */
public class User {
      private long userId;
     private Role role ;
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
     String lastOper;
    public User() {
    }

    public User(long userId, Role role, Date acctExpyDate, long acctInactiveDays, Date disabledFromDate, Date disabledUptoDate, String solId, Date lastAccessTime, String lchgUserId, String newUserFlg, long numPwdAttempts, long numPwdHistory, Date pwExpyDate, String pwdHistory, long roleId, String userName, String userPw, String userStatus) {
        this.userId = userId;
        this.role = role;
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
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getAcctExpyDate() {
        return acctExpyDate;
    }

    public void setAcctExpyDate(Date acctExpyDate) {
        this.acctExpyDate = acctExpyDate;
    }

    public long getAcctInactiveDays() {
        return acctInactiveDays;
    }

    public void setAcctInactiveDays(long acctInactiveDays) {
        this.acctInactiveDays = acctInactiveDays;
    }

    public Date getDisabledFromDate() {
        return disabledFromDate;
    }

    public void setDisabledFromDate(Date disabledFromDate) {
        this.disabledFromDate = disabledFromDate;
    }

    public Date getDisabledUptoDate() {
        return disabledUptoDate;
    }

    public void setDisabledUptoDate(Date disabledUptoDate) {
        this.disabledUptoDate = disabledUptoDate;
    }

    public String getSolId() {
        return solId;
    }

    public void setSolId(String solId) {
        this.solId = solId;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getLchgUserId() {
        return lchgUserId;
    }

    public void setLchgUserId(String lchgUserId) {
        this.lchgUserId = lchgUserId;
    }

    public String getNewUserFlg() {
        return newUserFlg;
    }

    public void setNewUserFlg(String newUserFlg) {
        this.newUserFlg = newUserFlg;
    }

    public long getNumPwdAttempts() {
        return numPwdAttempts;
    }

    public void setNumPwdAttempts(long numPwdAttempts) {
        this.numPwdAttempts = numPwdAttempts;
    }

    public long getNumPwdHistory() {
        return numPwdHistory;
    }

    public void setNumPwdHistory(long numPwdHistory) {
        this.numPwdHistory = numPwdHistory;
    }

    public Date getPwExpyDate() {
        return pwExpyDate;
    }

    public void setPwExpyDate(Date pwExpyDate) {
        this.pwExpyDate = pwExpyDate;
    }

    public String getPwdHistory() {
        return pwdHistory;
    }

    public void setPwdHistory(String pwdHistory) {
        this.pwdHistory = pwdHistory;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getLastOper() {
        return lastOper;
    }

    public void setLastOper(String lastOper) {
        this.lastOper = lastOper;
    }

        
}
