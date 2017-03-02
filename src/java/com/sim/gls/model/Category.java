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
public class Category {
    private int categoryid =0;
     private String bankId ="";
     private String bocreatedby="";
     private Date bodatecreated=new Date();
     private Date bodatemodified= new Date();
     private String bomodifiedby="";
     private String categorycode="";
     private String categorytype="";
     private String categoryvalue="";

    public Category() {
    }
     
     public Category(String bankId, String bocreatedby, Date bodatecreated, Date bodatemodified, String bomodifiedby, String categorycode, String categorytype, String categoryvalue) {
        this.bankId = bankId;
        this.bocreatedby = bocreatedby;
        this.bodatecreated = bodatecreated;
        this.bodatemodified = bodatemodified;
        this.bomodifiedby = bomodifiedby;
        this.categorycode = categorycode;
        this.categorytype = categorytype;
        this.categoryvalue = categoryvalue;
    }
     public Category(int categoryid, String bankId, String bocreatedby, Date bodatecreated, Date bodatemodified, String bomodifiedby, String categorycode, String categorytype, String categoryvalue) {
        this.categoryid = categoryid;
        this.bankId = bankId;
        this.bocreatedby = bocreatedby;
        this.bodatecreated = bodatecreated;
        this.bodatemodified = bodatemodified;
        this.bomodifiedby = bomodifiedby;
        this.categorycode = categorycode;
        this.categorytype = categorytype;
        this.categoryvalue = categoryvalue;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBocreatedby() {
        return bocreatedby;
    }

    public void setBocreatedby(String bocreatedby) {
        this.bocreatedby = bocreatedby;
    }

    public Date getBodatecreated() {
        return bodatecreated;
    }

    public void setBodatecreated(Date bodatecreated) {
        this.bodatecreated = bodatecreated;
    }

    public Date getBodatemodified() {
        return bodatemodified;
    }

    public void setBodatemodified(Date bodatemodified) {
        this.bodatemodified = bodatemodified;
    }

    public String getBomodifiedby() {
        return bomodifiedby;
    }

    public void setBomodifiedby(String bomodifiedby) {
        this.bomodifiedby = bomodifiedby;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    public String getCategoryvalue() {
        return categoryvalue;
    }

    public void setCategoryvalue(String categoryvalue) {
        this.categoryvalue = categoryvalue;
    }
     
     
}
