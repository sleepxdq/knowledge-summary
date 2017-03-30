package com.buct.xdq.account.service;

import com.buct.xdq.account.beans.SysUserRole;

import java.util.List;

/**
 * Created by acer on 2017/3/30.
 */
public interface SysUserRoleService {

    /**
     * 根据用户id获得角色
     * @param uid
     * @return
     */
    List<SysUserRole> findByUid(Integer uid);

}
