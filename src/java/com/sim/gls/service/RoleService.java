package com.sim.gls.service;

import com.sim.gls.jpa.RoleProfileTable;
import com.sim.gls.jpa.RoleProfileTableMod;
import com.sim.gls.manager.CRUD;
import com.sim.gls.manager.HibernateUtilHelper;
import com.sim.gls.model.Role;
import com.sim.gls.model.UnVerifiedRole;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Levi
 */
public class RoleService {

    HibernateUtilHelper hibernateUtilHelper = new HibernateUtilHelper();
    CRUD crud = new CRUD(hibernateUtilHelper.getGLSHU());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.getDefault());

    /*
     Checks if Role exists
     */
    public boolean roleExists(String roleDesc) {
        List roleProfileTable = crud.getObject("from RoleProfileTable where roleDesc =" + roleDesc);
        if (roleProfileTable.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     Retrieves all Roles
     */
    public List<Role> getAllRoles() {
        List<Role> allRoles = new LinkedList<>();
        String query = "";
        List<Object> roles = crud.getObject("FROM RoleProfileTable");
        if (roles.size() > 0) {
            for (Object roleObject : roles) {
                RoleProfileTable roleProf = (RoleProfileTable) roleObject;
                Role role = new Role(roleProf.getBankId(), roleProf.getDelFlg(), roleProf.getEntityCreFlg(), roleProf.getLchgTime(),
                        roleProf.getLchgUserId(), roleProf.getRcreTime(), roleProf.getRcreUserId(), roleProf.getRoleDesc());
                allRoles.add(role);

            }
        }
        return allRoles;
    }

    /*
     Retrieves Unverified Roles
     */
    public List<UnVerifiedRole> getUnverifiedRoles() {
        List<UnVerifiedRole> unVerifiedRoles = new LinkedList<>();
        String query = "";
        List<Object> uRoles = crud.getObject("FROM RoleProfileTableMod");
        if (uRoles.size() > 0) {
            for (Object uRoleObject : uRoles) {
                RoleProfileTableMod uRoleProf = (RoleProfileTableMod) uRoleObject;
                UnVerifiedRole uRole = new UnVerifiedRole(uRoleProf.getModId(), uRoleProf.getBankId(), uRoleProf.getDelFlg(), uRoleProf.getEntityCreFlg(), uRoleProf.getLchgTime(), uRoleProf.getLchgUserId(), uRoleProf.getRcreTime(), uRoleProf.getRcreUserId(), uRoleProf.getRoleDesc(), uRoleProf.getRoleId());
                unVerifiedRoles.add(uRole);

            }
        }
        return unVerifiedRoles;
    }

    /*
         Retrives Role By ID
     */
    public Role getRole(int id) {
        List<RoleProfileTable> existing = crud.findByPrimaryKey(id, "FROM RoleProfileTable where id =:pk");

        Role theRole = null;
        if (existing.size() > 0) {
            RoleProfileTable roleProf = existing.get(0);
            theRole = new Role(roleProf.getBankId(), roleProf.getDelFlg(), roleProf.getEntityCreFlg(), roleProf.getLchgTime(),
                    roleProf.getLchgUserId(), roleProf.getRcreTime(), roleProf.getRcreUserId(), roleProf.getRoleDesc());
        }
        return theRole;
    }

    /*
     Retrievs Unverified Role By Id
     */
    public UnVerifiedRole getModRole(int id) {
        List<RoleProfileTableMod> existing = crud.findByPrimaryKey(id, "FROM RoleProfileTableMod where id =:pk");

        UnVerifiedRole uRole = null;
        if (existing.size() > 0) {
            RoleProfileTableMod uRoleProf = existing.get(0);
            uRole = new UnVerifiedRole(uRoleProf.getModId(), uRoleProf.getBankId(), uRoleProf.getDelFlg(), uRoleProf.getEntityCreFlg(), uRoleProf.getLchgTime(), uRoleProf.getLchgUserId(), uRoleProf.getRcreTime(), uRoleProf.getRcreUserId(), uRoleProf.getRoleDesc(), uRoleProf.getRoleId());
        }
        return uRole;
    }

    /*
     Deletes Role
     */
    public void deleteRole(int roleId) {
        Role role = getRole(roleId);
        crud.delete(role);
    }

    /*
     Deletes Unverified Role
     */
    public void deleteModRole(int roleId) {
        UnVerifiedRole role = getModRole(roleId);
        crud.delete(role);
    }

    /*
     Creates a New Role
     */
    public int addRole(Role roles) {
        RoleProfileTable created = new RoleProfileTable(roles.getBankId(), roles.getDelFlg(), roles.getEntityCreFlg(), roles.getLchgTime(), roles.getLchgUserId(), roles.getRcreTime(), roles.getRcreUserId(), roles.getRoleDesc());
        crud.saveOrUpdate(created);
        int roleId = (int) crud.save(created);
        return roleId;
    }

    /*
     Creates A new Unverified Role
     */
    public UnVerifiedRole addModRole(Role uRole, int roleId) {
        RoleProfileTableMod created
                = new RoleProfileTableMod(
                        uRole.getBankId(), uRole.getDelFlg(), uRole.getEntityCreFlg(), uRole.getLchgTime(),
                        uRole.getLchgUserId(), uRole.getRcreTime(), uRole.getRcreUserId(), uRole.getRoleDesc(), roleId);
        crud.saveOrUpdate(created);
        return getModRole((int) crud.save(created));
    }

    public void executeAddRole(Role role) {
        int roleId = addRole(role);
        addModRole(role, roleId);
    }

    public List<Role> getProfileDetails(int roleId) {
        List<Role> roleList = new LinkedList<>();
        Role theRole = null;
        List<RoleProfileTable> existing = crud.findByPrimaryKey(roleId, "FROM RoleProfileTable where roleId =:pk");
        if (existing.size() > 0) {
            for (Object roleObject : existing) {
                RoleProfileTable roleProf = (RoleProfileTable) roleObject;
                theRole = new Role(roleProf.getBankId(), roleProf.getDelFlg(), roleProf.getEntityCreFlg(), roleProf.getLchgTime(),
                        roleProf.getLchgUserId(), roleProf.getRcreTime(), roleProf.getRcreUserId(), roleProf.getRoleDesc());
                roleList.add(theRole);

            }
        }
        return roleList;

    }

    public RoleProfileTableMod getModProfileDetails(int roleId) {
        List profModList = crud.getObjectLazyLoad("from RoleProfileTableMod where roleId =" + roleId);
        return (RoleProfileTableMod) profModList.get(0);
    }

    public int getRoleId(String roleDesc) {
        int roleId = 0;
        String qr = "from RoleProfileTable where roleDesc like '%" + roleDesc + "%'"
                + "or roleDesc like '%" + roleDesc + "%'";
        List<Object> roleIdList = crud.getObject(qr);
        for (Object rol : roleIdList) {
            RoleProfileTable rPf = (RoleProfileTable) rol;
            roleId = (int) rPf.getRoleId();
        }
        return (int) roleId;
    }

    public boolean roleIsModified(String roleDesc) {
        String query = "from RoleProfileTableMod where roleDesc like '%" + roleDesc + "%'"
                + "or roleDesc like '%" + roleDesc + "%'";
        List<Object> roleIdList = crud.getObject(query);
        if (roleIdList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        RoleService roleService = new RoleService();
        for (Object userObject : roleService.getAllRoles()) {
            Role tlUser = (Role) userObject;
            System.out.println(tlUser.getBankId() + " " + tlUser.getDelFlg() + " " + tlUser.getRoleId() + " " + tlUser.getRoleDesc());
        }
    }

}
