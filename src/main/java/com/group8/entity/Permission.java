package com.group8.entity;

import java.util.List;

/**
 * className:Permission
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-13 20:51
 */
public class Permission {
    private Integer permissionId;
    private String permissionName;
    private String url;

    private List<Role> roles;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
