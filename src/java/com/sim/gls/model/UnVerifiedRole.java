package com.sim.gls.model;

import java.util.Date;

/**
 *
 * @author Levi
 */
public class UnVerifiedRole {
     private long modId;
    private String bankId;
    private String delFlg;
    private String entityCreFlg;
    private Date lchgTime;
    private String lchgUserId;
    private Date rcreTime;
    private String rcreUserId;
    private String roleDesc;
    private long roleId;

    public UnVerifiedRole() {
    }
    public UnVerifiedRole(  String bankId, String delFlg, String entityCreFlg, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, String roleDesc, long roleId) {
        this.bankId = bankId;
        this.delFlg = delFlg;
        this.entityCreFlg = entityCreFlg;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.roleDesc = roleDesc;
        this.roleId = roleId;
    }

    public UnVerifiedRole(long modId, String bankId, String delFlg, String entityCreFlg, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, String roleDesc, long roleId) {
        this.modId = modId;
        this.bankId = bankId;
        this.delFlg = delFlg;
        this.entityCreFlg = entityCreFlg;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.roleDesc = roleDesc;
        this.roleId = roleId;
    }

    public long getModId() {
        return modId;
    }

    public void setModId(long modId) {
        this.modId = modId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public String getEntityCreFlg() {
        return entityCreFlg;
    }

    public void setEntityCreFlg(String entityCreFlg) {
        this.entityCreFlg = entityCreFlg;
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

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    
    
}
