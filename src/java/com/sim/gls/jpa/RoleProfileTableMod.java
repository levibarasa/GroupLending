package com.sim.gls.jpa;
// Generated Feb 22, 2017 10:54:51 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * RoleProfileTableMod generated by hbm2java
 */
public class RoleProfileTableMod  implements java.io.Serializable {


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

    public RoleProfileTableMod() {
    }

    public RoleProfileTableMod(  String bankId, String delFlg, String entityCreFlg, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, String roleDesc, long roleId) {
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
    public RoleProfileTableMod(long modId, String bankId, String delFlg, String entityCreFlg, Date lchgTime, String lchgUserId, Date rcreTime, String rcreUserId, String roleDesc, long roleId) {
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
        return this.modId;
    }
    
    public void setModId(long modId) {
        this.modId = modId;
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
    public String getRoleDesc() {
        return this.roleDesc;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    public long getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }




}


