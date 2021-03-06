/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.controller;

import com.sim.gls.jpa.GroupsTableMod;
import com.sim.gls.jpa.SolGroupControlTable;
import com.sim.gls.jpa.SubGrpTableMod;
import com.sim.gls.model.Bank;
import com.sim.gls.service.BankService;
import com.sim.gls.service.GroupService;
import com.sim.gls.service.SubGroupService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Stanley Mungai
 */
public class Groupw {

    private static final Log log = LogFactory.getLog("origlogger");

    public static void handleGoGroup(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if ((String) session.getAttribute("uname") != null) {
            String function = request.getParameter("function");
            String grouptype = request.getParameter("grouptype");
            session.setAttribute("gfunction", function);
            switch (grouptype) {
                case "MAIN GROUP":
                    session.setAttribute("content_page", "group/mGroup_b.jsp");
                    break;
                case "SUB-GROUP":
                    session.setAttribute("content_page", "subgroup/msubGroup_b.jsp");
                    break;
            }
        } else {
            session.setAttribute("content_page", "sessionexp.jsp");
        }
        response.sendRedirect("index.jsp");
    }

    public static void handleMaintainGroup(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute("gverified", false);
        session.setAttribute("gadded", false);
        session.setAttribute("gdeleted", false);
        session.setAttribute("gcancelled", false);
        session.setAttribute("gmodified", false);
        session.setAttribute("fatal", false);
        if ((String) session.getAttribute("uname") != null) {
            BankService bankService = new BankService();
            String bankId = bankService.getBankId();
            List<Bank> banks = bankService.getBankDetails(bankId);
            String countryCode = "";
            String delFlg = "N";
            for (Bank bank : banks) {
                countryCode = bank.getHomeCntryCode();
            }
            String groupAddress = request.getParameter("groupaddress");
            int groupLoans = Integer.parseInt(request.getParameter("totalloanacs"));
            String groupName = request.getParameter("groupname");
            String groupPhone = request.getParameter("groupphone");
            String grpMgrId = request.getParameter("acctmgr");
            String grpRegNo = request.getParameter("regnumber");
            Date lchgDate = new Date();
            String lchgUserId = (String) session.getAttribute("uname");
            int maxAllowedMembers = Integer.parseInt(request.getParameter("maxmembers"));
            int maxAllowedSubGrps = Integer.parseInt(request.getParameter("maxsgroups"));
            int noOfMembers = 0;
            int noOfSubGrps = 0;
            double outstandingBal = Double.parseDouble(request.getParameter("totalloanbal"));
            double savingsAmt = Double.parseDouble(request.getParameter("totalsavingsbal"));
            Date rcreTime = new Date();
            String rcreUserId = (String) session.getAttribute("uname");
            String gpRegion = request.getParameter("region");
            String groupCode = request.getParameter("groupcode");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
            Date formationDate = new Date();
            String groupCenter = request.getParameter("groupcenter");
            String groupVillage = request.getParameter("groupvillage");
            Date firstMeetDate = new Date();
            Date nxtMeetDate = new Date();
            try {
                formationDate = sdf.parse(request.getParameter("formationdate"));
                firstMeetDate = sdf.parse(request.getParameter("firstmeetingdate"));
                nxtMeetDate = sdf.parse(request.getParameter("nextmeetingdate"));
            } catch (Exception asd) {
                log.debug(asd.getMessage());
            }
            String meetTime = request.getParameter("meetingtime");
            String meetPlace = request.getParameter("meetingplace");
            String gpChair = request.getParameter("chairperson");
            String gpTreasurer = request.getParameter("treasurer");
            String gpSecretary = request.getParameter("secretary");
            String gpStatus = request.getParameter("status");
            String gpStatusCode = request.getParameter("statusreason");
            int loanAccounts = Integer.parseInt(request.getParameter("totalloanacs"));
            int savingAccounts = Integer.parseInt(request.getParameter("totalsavingacs"));
            int solId = Integer.parseInt(request.getParameter("solid"));
            String branchName = request.getParameter("branchname");
            String meetFrequency = request.getParameter("meetingfrequency");
            String function = (String) session.getAttribute("gfunction");
            String lastOper = "";
            GroupService  groupService = new GroupService();
            
            switch (function) {
                case "ADD":
                    if (!groupService.groupExists(groupCode, groupName)) {
                        lastOper = "A";
                        if (groupService.executeaddGroup(bankId, countryCode, delFlg, groupAddress, groupLoans, groupName, groupPhone, grpMgrId, grpRegNo, lchgDate, lchgUserId, maxAllowedMembers, maxAllowedSubGrps, noOfMembers, noOfSubGrps, outstandingBal, savingsAmt, rcreTime, rcreUserId, gpRegion, groupCode, formationDate, groupCenter, groupVillage, firstMeetDate, nxtMeetDate, meetTime, meetPlace, gpChair, gpTreasurer, gpSecretary, gpStatus, gpStatusCode, loanAccounts, savingAccounts, solId, branchName, meetFrequency, lastOper)) {
                            session.setAttribute("gadded", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                        } else {
                            session.setAttribute("fatal", true);
                            session.setAttribute("content_page", "group/mGroup_b.jsp");
                        }
                    } else {
                        session.setAttribute("gexists", true);
                        session.setAttribute("content_page", "group/mGroup_b.jsp");
                    }
                    break;
                case "VERIFY":
                    int groupId = groupService.getGroupId(groupCode, groupName);
                    List<GroupsTableMod> groups = GroupService.getgroupModDetails(groupId);
                    for (GroupsTableMod group : groups) {
                        lastOper = group.getLastOper();
                    }
                    switch (lastOper) {
                        case "A":
                            GroupService.verifyGroup(groupId);
                            session.setAttribute("gverified", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                            break;
                        case "D":
                            GroupService.deleteGroup(groupId, (String) session.getAttribute("uname"));
                            GroupService.verifyGroup(groupId);
                            session.setAttribute("gverified", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                            break;
                        case "M":
                            GroupService.modifyGroup(groupId, (String) session.getAttribute("uname"));
                            GroupService.verifyGroup(groupId);
                            session.setAttribute("gverified", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                            break;
                    }
                    break;
                case "MODIFY":
                    groupId = GroupService.getGroupId(groupCode, groupName);
                    lastOper = "M";
                    if (GroupService.addGroupModDetails(groupId, bankId, countryCode, delFlg, groupAddress, groupLoans, groupName, groupPhone, grpMgrId, grpRegNo, lchgDate, lchgUserId, maxAllowedMembers, maxAllowedSubGrps, noOfMembers, noOfSubGrps, outstandingBal, savingsAmt, rcreTime, rcreUserId, gpRegion, groupCode, formationDate, groupCenter, groupVillage, firstMeetDate, nxtMeetDate, meetTime, meetPlace, gpChair, gpTreasurer, gpSecretary, gpStatus, gpStatusCode, loanAccounts, savingAccounts, solId, branchName, meetFrequency, lastOper)) {
                        session.setAttribute("gmodified", true);
                        session.setAttribute("content_page", "group/mGroup_a.jsp");
                    }
                    break;
                case "DELETE":
                    groupId = GroupService.getGroupId(groupCode, groupName);
                    lastOper = "D";
                    if (GroupService.addGroupModDetails(groupId, bankId, countryCode, delFlg, groupAddress, groupLoans, groupName, groupPhone, grpMgrId, grpRegNo, lchgDate, lchgUserId, maxAllowedMembers, maxAllowedSubGrps, noOfMembers, noOfSubGrps, outstandingBal, savingsAmt, rcreTime, rcreUserId, gpRegion, groupCode, formationDate, groupCenter, groupVillage, firstMeetDate, nxtMeetDate, meetTime, meetPlace, gpChair, gpTreasurer, gpSecretary, gpStatus, gpStatusCode, loanAccounts, savingAccounts, solId, branchName, meetFrequency, lastOper)) {
                        session.setAttribute("gdeleted", true);
                        session.setAttribute("content_page", "group/mGroup_a.jsp");
                    }
                    break;
                case "CANCEL":
                    groupId = GroupService.getGroupId(groupCode, groupName);
                    GroupService.verifyGroup(groupId);
                    session.setAttribute("gcancelled", true);
                    session.setAttribute("content_page", "group/mGroup_a.jsp");
                    break;
            }
        } else {
            session.setAttribute("content_page", "sessionexp.jsp");
        }
        response.sendRedirect("index.jsp");
    }

    public static void handleMaintainSubGroup(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute("sgexists", false);
        session.setAttribute("fatal", false);
        session.setAttribute("sgadded", false);
        session.setAttribute("sgverified", false);
        session.setAttribute("sgmodified", false);
        session.setAttribute("sgdeleted", false);
        session.setAttribute("sgcancelled", false);
        BankService bankService = new BankService();
        if ((String) session.getAttribute("uname") != null) {
            String bankId = bankService.getBankId();
            List<Bank> banks = bankService.getBankDetails(bankId);
            String countryCode = "";
            String delFlg = "N";
            for (Bank bank : banks) {
                countryCode = bank.getHomeCntryCode();
            }
            String groupAddress = request.getParameter("groupaddress");
            int groupLoans = Integer.parseInt(request.getParameter("totalloanacs"));
            String groupName = request.getParameter("groupname");
            String subgroupName = request.getParameter("subgroupname");
            String groupPhone = request.getParameter("groupphone");
            String grpMgrId = request.getParameter("acctmgr");
            String grpRegNo = request.getParameter("regnumber");
            Date lchgDate = new Date();
            String lchgUserId = (String) session.getAttribute("uname");
            int maxAllowedMembers = Integer.parseInt(request.getParameter("maxmembers"));
            int noOfMembers = 0;
            double outstandingBal = Double.parseDouble(request.getParameter("totalloanbal"));
            double savingsAmt = Double.parseDouble(request.getParameter("totalsavingsbal"));
            Date rcreTime = new Date();
            String rcreUserId = (String) session.getAttribute("uname");
            String gpRegion = request.getParameter("region");
            String groupCode = request.getParameter("groupcode");
            String subgroupCode = request.getParameter("subgroupcode");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
            Date formationDate = new Date();
            String groupCenter = request.getParameter("groupcenter");
            String groupVillage = request.getParameter("groupvillage");
            Date firstMeetDate = new Date();
            Date nxtMeetDate = new Date();
            try {
                formationDate = sdf.parse(request.getParameter("formationdate"));
                firstMeetDate = sdf.parse(request.getParameter("firstmeetingdate"));
                nxtMeetDate = sdf.parse(request.getParameter("nextmeetingdate"));
            } catch (Exception asd) {
                log.debug(asd.getMessage());
            }
            String meetTime = request.getParameter("meetingtime");
            String meetPlace = request.getParameter("meetingplace");
            String gpChair = request.getParameter("chairperson");
            String gpTreasurer = request.getParameter("treasurer");
            String gpSecretary = request.getParameter("secretary");
            String gpStatus = request.getParameter("status");
            String gpStatusCode = request.getParameter("statusreason");
            int loanAccounts = Integer.parseInt(request.getParameter("totalloanacs"));
            int savingAccounts = Integer.parseInt(request.getParameter("totalsavingacs"));
            int solId = Integer.parseInt(request.getParameter("solid"));
            String branchName = request.getParameter("branchname");
            String meetFrequency = request.getParameter("meetingfrequency");
            String function = (String) session.getAttribute("gfunction");
            String lastOper = "";
            int groupId = GroupService.getGroupId(groupCode, groupName);
            switch (function) {
                case "ADD":
                    if (!SubGroupService.subgroupExists(subgroupCode, subgroupName)) {
                        lastOper = "A";
                        if (SubGroupService.executeaddSubGroup(bankId, countryCode, delFlg, groupAddress, groupLoans, subgroupName, groupPhone, grpMgrId, grpRegNo, lchgDate, lchgUserId, maxAllowedMembers, groupId, noOfMembers, outstandingBal, savingsAmt, rcreTime, rcreUserId, gpRegion, subgroupCode, formationDate, groupCenter, groupVillage, firstMeetDate, nxtMeetDate, meetTime, meetPlace, gpChair, gpTreasurer, gpSecretary, gpStatus, gpStatusCode, loanAccounts, savingAccounts, solId, branchName, meetFrequency, lastOper)) {
                            session.setAttribute("sgadded", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                        } else {
                            session.setAttribute("fatal", true);
                            session.setAttribute("content_page", "subgroup/msubGroup_b.jsp");
                        }
                    } else {
                        session.setAttribute("sgexists", true);
                        session.setAttribute("content_page", "subgroup/msubGroup_b.jsp");
                    }
                    break;
                case "VERIFY":
                    int subgroupId = SubGroupService.getsubGroupId(subgroupCode, subgroupName);
                    List<SubGrpTableMod> groups = SubGroupService.getsubgroupModDetails(subgroupId);
                    for (SubGrpTableMod group : groups) {
                        lastOper = group.getLastOper();
                    }
                    switch (lastOper) {
                        case "A":
                            SubGroupService.verifySubGroup(subgroupId);
                            GroupService.addSubgroup(groupId, (String) session.getAttribute("uname"));
                            session.setAttribute("sgverified", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                            break;
                        case "D":
                            SubGroupService.deleteSubGroup(subgroupId, (String) session.getAttribute("uname"));
                            SubGroupService.verifySubGroup(subgroupId);
                            GroupService.removeSubgroup(groupId, (String) session.getAttribute("uname"));
                            session.setAttribute("sgverified", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                            break;
                        case "M":
                            SubGroupService.modifySubGroup(subgroupId, (String) session.getAttribute("uname"));
                            SubGroupService.verifySubGroup(subgroupId);
                            session.setAttribute("sgverified", true);
                            session.setAttribute("content_page", "group/mGroup_a.jsp");
                            break;
                    }
                    break;
                case "MODIFY":
                    subgroupId = SubGroupService.getsubGroupId(subgroupCode, subgroupName);
                    lastOper = "M";
                    if (SubGroupService.addSubGroupModDetails(subgroupId, bankId, countryCode, delFlg, groupAddress, groupLoans, subgroupName, groupPhone, grpMgrId, grpRegNo, lchgDate, lchgUserId, maxAllowedMembers, groupId, noOfMembers, outstandingBal, savingsAmt, rcreTime, rcreUserId, gpRegion, subgroupCode, formationDate, groupCenter, groupVillage, firstMeetDate, nxtMeetDate, meetTime, meetPlace, gpChair, gpTreasurer, gpSecretary, gpStatus, gpStatusCode, loanAccounts, savingAccounts, solId, branchName, meetFrequency, lastOper)) {
                        session.setAttribute("sgmodified", true);
                        session.setAttribute("content_page", "group/mGroup_a.jsp");
                    } else {
                        session.setAttribute("fatal", true);
                        session.setAttribute("content_page", "group/mGroup_a.jsp");
                    }
                    break;
                case "DELETE":
                    subgroupId = SubGroupService.getsubGroupId(subgroupCode, subgroupName);
                    lastOper = "D";
                    if (SubGroupService.addSubGroupModDetails(subgroupId, bankId, countryCode, delFlg, groupAddress, groupLoans, subgroupName, groupPhone, grpMgrId, grpRegNo, lchgDate, lchgUserId, maxAllowedMembers, groupId, noOfMembers, outstandingBal, savingsAmt, rcreTime, rcreUserId, gpRegion, subgroupCode, formationDate, groupCenter, groupVillage, firstMeetDate, nxtMeetDate, meetTime, meetPlace, gpChair, gpTreasurer, gpSecretary, gpStatus, gpStatusCode, loanAccounts, savingAccounts, solId, branchName, meetFrequency, lastOper)) {
                        session.setAttribute("sgdeleted", true);
                        session.setAttribute("content_page", "group/mGroup_a.jsp");
                    }
                    break;
                case "CANCEL":
                    subgroupId = SubGroupService.getsubGroupId(subgroupCode, subgroupName);
                    SubGroupService.verifySubGroup(subgroupId);
                    session.setAttribute("sgcancelled", true);
                    session.setAttribute("content_page", "group/mGroup_a.jsp");
                    break;
            }
        } else {
            session.setAttribute("content_page", "sessionexp.jsp");
        }
        response.sendRedirect("index.jsp");
    }
}
