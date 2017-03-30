package com.buct.xdq.account.service;

import com.buct.xdq.account.beans.SysRolePermission;

import java.util.List;

/**
 * Created by acer on 2017/3/30.
 */
public interface SysRolePermissionService {

    /**
     * 根据角色id查找所有权限id
     * @param rids
     * @return
     */
    List<SysRolePermission> findAll(List<Integer> rids);

}
