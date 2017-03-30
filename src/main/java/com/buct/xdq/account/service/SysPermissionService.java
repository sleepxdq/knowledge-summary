package com.buct.xdq.account.service;

import com.buct.xdq.account.beans.SysPermission;

import java.util.List;

/**
 * Created by acer on 2017/3/30.
 */
public interface SysPermissionService {

    /**
     * 根据ids获取所有的权限
     * @param uid
     * @return
     */
    List<SysPermission> findPermissionByUid(Integer uid);

}
