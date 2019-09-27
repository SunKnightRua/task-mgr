package cn.sun.tasks.permission.dao;

import java.util.List;

import cn.sun.tasks.permission.domain.Permission;

public interface PermissionDao {
    public List<Permission> listPermissions(String userId);
}
