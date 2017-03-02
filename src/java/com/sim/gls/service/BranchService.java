/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.service;

import com.sim.gls.jpa.ServiceOutletTable;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Branch;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Levi
 */
public class BranchService {

    HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getGLSHU());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.getDefault());

    public List<Branch> getAllBranches() {
        List<Branch> allBranches = new LinkedList<>();
        String query = "";
        List<Object> branches = crud.getObject("FROM ServiceOutletTable");

        for (Object branchObject : branches) {
            ServiceOutletTable outletTable = (ServiceOutletTable) branchObject;
            Branch branch = new Branch(outletTable.getSolId(), outletTable.getAddr1(), outletTable.getBankId(), outletTable.getCntryCode(), outletTable.getDelFlg(), outletTable.getHomeCrncyCode(), outletTable.getLchgTime(), outletTable.getLchgUserId(), outletTable.getRcreTime(), outletTable.getRcreUserId(), outletTable.getSolBodDate(), outletTable.getSolClsDate(), outletTable.getSolClsFlg(), outletTable.getSolDesc(), outletTable.getSolEodStatus());
            allBranches.add(branch);
        }
        return allBranches;
    }
}
