package com.qf.dto;

/**
 * Created by DELL on 2019/5/20.
 */
public class RoleDto {
    int isnull;
    int roleId;
    String roleName;
    String shortName;

    public int getIsnull() {
        return isnull;
    }

    public void setIsnull(int isnull) {
        this.isnull = isnull;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "isnull=" + isnull +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
