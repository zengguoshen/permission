package com.qf.dto;

/**
 * Created by DELL on 2019/5/21.
 */
public class InsertUserRoleDto {
    int userId;
    int[] roleIds;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds) {
        this.roleIds = roleIds;
    }
}
