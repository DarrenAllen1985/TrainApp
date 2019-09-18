package com.darren.factories;


import com.darren.domain.Permission;

public class PermissionFactory {

    public static Permission createPermission(String permissionId, String permissionRole, String permissionTitle) {
        return new Permission.Builder()
                .permissionId(permissionId)
                .permissionRole(permissionRole)
                .permissionTitle(permissionTitle)
                .build();
    }
}