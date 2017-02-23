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
public class Role {
     private int roleId;
     private String bankId;
     private String delFlg;
     private String entityCreFlg;
     private Date lchgTime;
     private String lchgUserId;
     private Date rcreTime;
     private String rcreUserId;
     private String roleDesc;

    public Role() {
    }
     public Role( String bankId, String delFlg, String entityCreFlg, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, String roleDesc) {
        this.bankId = bankId;
        this.delFlg = delFlg;
        this.entityCreFlg = entityCreFlg;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.roleDesc = roleDesc;
    }

    public Role(int roleId, String bankId, String delFlg, String entityCreFlg, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, String roleDesc) {
        this.roleId = roleId;
        this.bankId = bankId;
        this.delFlg = delFlg;
        this.entityCreFlg = entityCreFlg;
        this.lchgTime = lchgTime;
        this.lchgUserId = lchgUserId;
        this.rcreTime = rcreTime;
        this.rcreUserId = rcreUserId;
        this.roleDesc = roleDesc;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
     
}
